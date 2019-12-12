package com.caoguofeng.djqmusic.activity;

import android.content.Context;

import com.caoguofeng.djqmusic.util.SharedPreferencesUtil;

class BaseCommonActivity extends BaseActivity{
    protected SharedPreferencesUtil sp;

    @Override
    protected void initViews() {
        super.initViews();
        sp = SharedPreferencesUtil.getInstance(getApplicationContext());
    }
}
