package com.surplus.http;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.surplus.App;
import com.surplus.data.UserFacade;
import com.surplus.http.entity.BaseEntity;
import com.surplus.util.ChannelUtil;
import com.surplus.util.LocalUtil;
import com.surplus.util.MD5Util;
import com.surplus.util.NetWorkUtils;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    //真实使用的URL
    private static String baseUrl = "http://test.uyujf.com:8080/http/HttpService";
    //拦截时用的URL
    private static String Url = "http://test.uyujf.com:8080/";
    //读超时长，单位：毫秒
    private static final int READ_TIME_OUT = 7676;
    //连接时长，单位：毫秒
    private static final int CONNECT_TIME_OUT = 7676;


    private static ApiService apiService;

    public static ApiService getApiService() {
        if (apiService == null) {
            synchronized (Api.class) {
                if (apiService == null) {
                    new Api();
                }
            }
        }
        return apiService;
    }

    private Api() {
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();

        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //缓存
        File cacheFile = new File(App.getContext().getCacheDir(), "cache");

        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb

        //创建一个OkHttpClient并设置超时时间
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .addInterceptor(mRewriteCacheControlInterceptor)
                .addNetworkInterceptor(mRewriteCacheControlInterceptor)
                .addInterceptor(new EncryptInterceptor())
                .addInterceptor(logInterceptor)
                .cache(cache)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())//请求的结果转为实体类
                //适配RxJava2.0,RxJava1.x则为RxJavaCallAdapterFactory.create()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }


    /**
     * 设缓存有效期为两天
     */
    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 2;

    /**
     * 云端响应头拦截器，用来配置缓存策略
     * Dangerous interceptor that rewrites the server's cache-control header.
     */
    private final Interceptor mRewriteCacheControlInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            String cacheControl = request.cacheControl().toString();
            if (!NetWorkUtils.isNetConnected(App.getContext())) {
                request = request.newBuilder()
                        .cacheControl(TextUtils.isEmpty(cacheControl) ? CacheControl
                                .FORCE_NETWORK : CacheControl.FORCE_CACHE)
                        .build();
            }
            Response originalResponse = chain.proceed(request);
            if (NetWorkUtils.isNetConnected(App.getContext())) {
                return originalResponse.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .removeHeader("Pragma")
                        .build();
            } else {
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" +
                                CACHE_STALE_SEC)
                        .removeHeader("Pragma")
                        .build();
            }
        }
    };

    public class EncryptInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            //这个是请求方法
            return chain.proceed(encrypt(chain.request()));
        }
    }

    //加密
    private Request encrypt(Request request) throws IOException {
        //获取请求body，只有@Body 参数的requestBody 才不会为 null
        BaseEntity baseEntiy = null;
        RequestBody requestBody = request.body();
        if (requestBody != null) {
            okio.Buffer buffer = new okio.Buffer();
            requestBody.writeTo(buffer);
            Charset charset = Charset.forName("UTF-8");
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(charset);
            }
            String string = buffer.readString(charset);
            Object o = new Gson().fromJson(string, Object.class);
            baseEntiy = new BaseEntity();
            String action =request.url().encodedPath();
            if (!action.equals("")) {
                action = action.substring(1, action.length());
            }

            baseEntiy.setRequest(new BaseEntity.RequestBean(
                    new BaseEntity.RequestBean.CommonBean(
                            "android",
                            InetAddress.getLocalHost().getHostAddress(),
                            System.currentTimeMillis() / 1000,
                            ChannelUtil.getChannel(),
                            LocalUtil.getLocalVersionName(App.getContext()),
                            action), o));

            String sign = MD5Util.getInstance().getMD5( new Gson().toJson(baseEntiy));
            sign = MD5Util.getInstance()
                    .getMD5(sign + UserFacade.getIns().getAccessKey());
            RequestBody requestBody1=  RequestBody.create(request.body().contentType(), new Gson().toJson(baseEntiy));
            return request.newBuilder()
                    .post(requestBody1)
                    .url(baseUrl)
                    .addHeader("accept", "*/*")
                    .addHeader("connection", "Keep-Alive")
                    .addHeader("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)")
                    .addHeader("Accept-Charset", "UTF-8")
                    .addHeader("Referer", "http://www.youyu.com")
                    .addHeader("format", "json")
                    .addHeader("reqlength", String.valueOf(requestBody1.contentLength()))
                    .addHeader("sign", sign)
                    .build();
        }else {
            return request;
        }
    }
}
