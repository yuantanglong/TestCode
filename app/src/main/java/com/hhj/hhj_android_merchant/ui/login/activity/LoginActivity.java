package com.hhj.hhj_android_merchant.ui.login.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.baseapp.common.BuildConfig;
import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.blankj.utilcode.util.ToastUtils;
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
        TextView tv_mobile_login=findViewById(R.id.tv_mobile_login);
        tv_mobile_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort(BuildConfig.baseUrl);
            }
        });
    }
}
