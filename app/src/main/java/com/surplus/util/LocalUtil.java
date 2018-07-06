package com.surplus.util;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;

import com.surplus.App;

import static android.text.TextUtils.isEmpty;

public class LocalUtil {


    public static int getLocalVersion(Context ctx) {
        int localVersion = 0;
        try {
            PackageInfo packageInfo = ctx.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(ctx.getPackageName(), 0);
            localVersion = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersion;
    }


    /**
     * 获取本地软件版本号名称
     */
    public static String getLocalVersionName(Context ctx) {
        String localVersion = "";
        try {
            PackageInfo packageInfo = ctx.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(ctx.getPackageName(), 0);
            localVersion = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersion;
    }


    @SuppressLint("HardwareIds")
    public static String getDeviceId(Context context) {
        StringBuilder deviceId = new StringBuilder();
        // 渠道标志
        try {
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (ActivityCompat.checkSelfPermission(App.getContext(), Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                //wifi mac地址
                WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                assert wifi != null;
                WifiInfo info = wifi.getConnectionInfo();
                String wifiMac = info.getMacAddress();
                if(!isEmpty(wifiMac)){
                    deviceId.append("wifi");
                    deviceId.append(wifiMac);
                    return deviceId.toString();
                }
            }
            //IMEI（imei）
            assert tm != null;
            String imei = tm.getDeviceId();
            if(!isEmpty(imei)){
                deviceId.append("imei");
                deviceId.append(imei);
                return deviceId.toString();
            }

            //序列号（sn）
            String sn = tm.getSimSerialNumber();
            if(!isEmpty(sn)){
                deviceId.append("sn");
                deviceId.append(sn);
                return deviceId.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deviceId.toString();

    }

}
