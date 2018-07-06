package com.surplus.util;

import android.content.Context;
import android.text.TextUtils;

import com.surplus.App;

import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 渠道获取
 * Created by Administrator on 2016.11.09.
 */
public class ChannelUtil {
    private static String channelCached;

    public static String getChannel() {
        if (TextUtils.isEmpty(channelCached)) {
            channelCached = getChannel(App.getContext());
        }
        channelCached = TextUtils.isEmpty(channelCached) ? "Android" : channelCached;
        return channelCached;
    }

    public static String getChannel(Context context) {
        String sourceDir = context.getApplicationInfo().sourceDir;
        String ret = "";
        ZipFile zipfile = null;
        try {
            zipfile = new ZipFile(sourceDir);
            Enumeration<?> entries = zipfile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = ((ZipEntry) entries.nextElement());
                String entryName = entry.getName();
                if (entryName.startsWith("META-INF/channel_")) {
                    ret = entryName;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (zipfile != null) {
                try {
                    zipfile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (!TextUtils.isEmpty(ret)) {
            ret = ret.replace("META-INF/channel_", "").replace("-",":");
        }
        return ret;
    }
}
