package com.hhj.hhj_android_merchant.ui.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.blankj.utilcode.util.SPUtils;
import com.hhj.hhj_android_merchant.R;
import com.hhj.hhj_android_merchant.app.Config;
import com.hhj.hhj_android_merchant.ui.login.activity.LoginActivity;

public class SplashActivity extends BaseActivity {


    @Override
    protected IToolbar getIToolbar() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
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
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }
        enterLogin();
    }

    public void enterLogin() {
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                startNextActivity();
            }
        }, 2000);
    }

    private void startNextActivity() {
        boolean mGuideFirst = SPUtils.getInstance().getBoolean(Config.GUIDEFIRST, true);
        if (mGuideFirst) {
            SPUtils.getInstance().put(Config.GUIDEFIRST, false);
            startActivity(GuideActivity.class);
        } else {
            boolean isSuccess = SPUtils.getInstance().getBoolean(Config.ISSUCCESS, false);
            if (isSuccess) {
                startActivity(MainActivity.class);
            } else {
                startActivity(LoginActivity.class);
            }
        }
    }
}
