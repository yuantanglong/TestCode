package com.hhj.merchant.ui.order.activity;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.utility.ToolbarBackTitle;
import com.hhj.merchant.R;
import com.hhj.merchant.ui.order.fragment.OrderListFragment;

public class OrderRefundActivity extends BaseActivity {
    public static OrderRefundActivity refundActivity;
    private OrderListFragment fragment;

    @Override
    protected IToolbar getIToolbar() {
        return new ToolbarBackTitle(this, "退款");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_refund;
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
        refundActivity=this;
    }
    private Fragment createListFragment() {
        fragment = new OrderListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tag", "RefundActivity");
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    protected void initNetWork(int pageIndex) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        initFragment();
    }

    public void initFragment() {
        //必需继承FragmentActivity,嵌套fragment只需要这行代码
        getSupportFragmentManager().beginTransaction().replace(R.id.container, createListFragment()).commitAllowingStateLoss();
    }
}
