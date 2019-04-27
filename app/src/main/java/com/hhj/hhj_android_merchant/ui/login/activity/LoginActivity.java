package com.hhj.hhj_android_merchant.ui.login.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.hhj.hhj_android_merchant.R;

public class LoginActivity extends BaseActivity {
    @Override
    protected IToolbar getIToolbar() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected boolean enableSwipeBack() {
        return false;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {

    }
}
