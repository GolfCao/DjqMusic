package com.caoguofeng.djqmusic.util;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * 工具类，用于对package的一些处理
 */
public class PackageUtil {
    public static int getVersionCode(Context context) {
        PackageManager mPackageManager = context.getPackageManager();
        try {
            return mPackageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
