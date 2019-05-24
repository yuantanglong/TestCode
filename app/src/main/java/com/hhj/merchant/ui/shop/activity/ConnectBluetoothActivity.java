package com.hhj.merchant.ui.shop.activity;

import android.support.annotation.Nullable;
import android.os.Bundle;

import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.utility.ToolbarBackTitle;
import com.hhj.merchant.R;

public class ConnectBluetoothActivity extends BaseActivity {

    private ToolbarBackTitle toolbarBackTitle;

    @Override
    protected IToolbar getIToolbar() {
        toolbarBackTitle = new ToolbarBackTitle(this, "");
        return toolbarBackTitle;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_connect_bluetooth;
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

    @Override
    protected void initNetWork(int pageIndex) {

    }
}
