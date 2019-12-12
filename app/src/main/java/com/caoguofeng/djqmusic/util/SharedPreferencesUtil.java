package com.caoguofeng.djqmusic.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 一个处理数据的类
 */
public class SharedPreferencesUtil {
    public static final String TAG = "SharedPreferencesUtil";
    private static SharedPreferences mPreferences;
    private static SharedPreferencesUtil mSharedPreferencesUtil;
    private static SharedPreferences.Editor mEditor;
    private final Context context;

    public  SharedPreferencesUtil(Context context) {
        this.context = context;
        mPreferences = this.context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();
    }

    public static SharedPreferencesUtil getInstance(Context context) {
        if (mSharedPreferencesUtil == null) {
            mSharedPreferencesUtil = new SharedPreferencesUtil(context);
        }
        return mSharedPreferencesUtil;
    }

    public void put(String key, String value) {
        mEditor.putString(key, value);
        mEditor.commit();
    }
    public void putBoolean(String key, boolean value) {
        mEditor.putBoolean(key, value);
        mEditor.commit();
    }

    public String get(String key) {
        return mPreferences.getString(key, "");
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return mPreferences.getBoolean(key, defaultValue);
    }

    public boolean isLogin() {
        return true;
    }
}
