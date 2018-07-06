package com.surplus.web;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.surplus.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BaseWebActivity extends AppCompatActivity {

    @BindView(R.id.base_wv)
    WebView webView;

    @BindView(R.id.base_web_progress)
    ProgressBar progressBar;

    @BindView(R.id.title_tv)
    TextView titleTv;

    private Intent intent;
    private String title ="";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baseweb_layout);
        ButterKnife.bind(this);
        init();
    }


    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void init() {
        intent = getIntent();
        title = intent.getStringExtra("title");
        if (title != null&&!title.equals("")) {
            titleTv.setText(intent.getStringExtra("title"));
        }
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);//设置支持Javascript
        settings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        settings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        settings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        settings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        settings.setDisplayZoomControls(false); //隐藏原生的缩放控件
        settings.setCacheMode(WebSettings.LOAD_DEFAULT); //webview缓存模式
        settings.setAllowFileAccess(true); //设置可以访问文件
        settings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        settings.setLoadsImagesAutomatically(true); //支持自动加载图片
        settings.setBlockNetworkImage(false);//解决图片不显示
        settings.setDefaultTextEncodingName("utf-8");//设置编码格式



        // 点击连接禁止跳到系统的浏览器
        webView.setWebViewClient(new WebViewClient() {

            @Override

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        webView.addJavascriptInterface(new JavaScriptinterface(), "app");

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // TODO Auto-generated method stub
                if (newProgress == 100) {
                    // 网页加载完成
                    progressBar.setVisibility(View.INVISIBLE);//加载完网页进度条消失
                } else {
                    // 加载中
                    progressBar.setVisibility(View.VISIBLE);//开始加载网页时显示进度条
                    progressBar.setProgress(newProgress);//设置进度值
                }

            }
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                if (BaseWebActivity.this.title != null&&BaseWebActivity.this.title .equals("")) {
                    titleTv.setText(intent.getStringExtra("title"));
                    if (title != null) {
                        titleTv.setText(title);
                    }
                }
            }
        });
        String url = intent.getStringExtra("url");
        if (url != null) {
            webView.loadUrl(url);
        }

    }

    @OnClick(R.id.back_iv)
    public void onclick(View v) {
        switch (v.getId()) {
            case R.id.back_iv:
                finish();
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (webView.canGoBack()) {  //表示按返回键 时的操作
                webView.goBack();   //后退
                return true;    //已处理
            }else {
                finish();
                return true;
            }
        }else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
