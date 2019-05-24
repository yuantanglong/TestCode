package com.hhj.merchant.ui.order.activity;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.utility.ToolbarBackTitle;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.OrdersBean;
import com.hhj.merchant.ui.order.fragment.OrderListFragment;

public class OrderDetailActivity extends BaseActivity {
    private OrderListFragment fragment;
    private OrdersBean.OrdersListBean ordersListBean;

    @Override
    protected IToolbar getIToolbar() {
        return new ToolbarBackTitle(this, "订单详情");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_detail;
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
        initFragment();
    }

    private Fragment createListFragment() {
        ordersListBean = (OrdersBean.OrdersListBean) getIntent().getSerializableExtra("ordersListBean");
        fragment = new OrderListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tag", "OrderDetailActivity");
        bundle.putSerializable("ordersListBean", ordersListBean);
        fragment.setArguments(bundle);
        return fragment;
    }

    public void initFragment() {
        //必需继承FragmentActivity,嵌套fragment只需要这行代码
        getSupportFragmentManager().beginTransaction().replace(R.id.container, createListFragment()).commitAllowingStateLoss();
    }

}
