package com.caoguofeng.djqmusic.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import com.caoguofeng.djqmusic.util.Consts;


class BaseActivity extends AppCompatActivity {
    private ProgressDialog mProgressDialog;
    /**
     * 初始化控件
     */
    protected void initViews() {

    }

    /**
     * 绑定数据
     */
    protected void initDatas() {

    }

    /**
     * 绑定监听器
     */
    protected void initListener() {

    }

    public void init() {
        initViews();
        initDatas();
        initListener();
    }

    /**
     * 绑定view的时候就初始化
     * @param layoutResID
     */
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        init();
    }

    /**
     * 绑定view的时候就初始化
     * @param view
     */
    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        init();
    }

    /**
     * 绑定view的时候就初始化
     * @param view
     * @param params
     */
    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        init();
    }

    protected void startActivity(Class<?> clazz) {
        startActivity(new Intent(getActivity(), clazz));
    }

    protected void startActivityAfterFinishThis(Class<?> clazz) {
        startActivity(new Intent(getActivity(), clazz));
        finish();
    }

    protected void startActivityExtraId(Class<?> clazz, String id) {
        Intent intent = new Intent(getActivity(), clazz);
        intent.putExtra(Consts.ID, id);
    }

    protected void startActivityExtraString(Class<?> clazz, String string) {
        Intent intent = new Intent(getActivity(), clazz);
        intent.putExtra(Consts.STRING, string);
    }

    protected BaseActivity getActivity() {
        return this;
    }

    public void showLoding() {
        showLoding("加载中");
    }

    public void showLoding(String string) {
        if(getActivity() != null && !getActivity().isFinishing()) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setTitle("提示");
            mProgressDialog.setMessage(string);
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }
    }

    public void showLoding(int resId) {
        showLoding(getResources().getString(resId));
    }

    public void hideLoding() {
        if(mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
}
