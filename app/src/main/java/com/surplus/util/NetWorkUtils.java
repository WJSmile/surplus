package com.surplus.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetWorkUtils {

    public static boolean isNetConnected(Context mContext) {
        if (mContext!=null){
            ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            boolean connected = networkInfo.isConnected();
            if (networkInfo!=null&&connected){
                if (networkInfo.getState()== NetworkInfo.State.CONNECTED){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

}
