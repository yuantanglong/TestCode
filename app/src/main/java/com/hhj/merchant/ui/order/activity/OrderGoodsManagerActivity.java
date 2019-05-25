package com.hhj.merchant.ui.order.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BaseFragmentAdapter;
import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.utility.ToolbarBackTitle;
import com.baseapp.common.utils.UIUtils;
import com.hhj.merchant.R;
import com.hhj.merchant.ui.order.contract.OrderGoodsManagerContract;
import com.hhj.merchant.ui.order.fragment.OrderGoodsManagerFragment;
import com.hhj.merchant.ui.order.presenter.OrderGoodsManagerPresenter;
import com.hhj.merchant.ui.shop.fragment.SelectGoodsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class OrderGoodsManagerActivity extends BaseActivity<OrderGoodsManagerPresenter> implements OrderGoodsManagerContract {
    public static TabLayout tabLayout;
    public static OrderGoodsManagerActivity orderGoodsManagerActivity;
    @BindView(R.id.mViewPager)
    ViewPager mViewPager;
    private List<Fragment> fragments;
    private List<String> mTitles = null;
    public BaseFragmentAdapter adapter;
    private int position = 0;
    private Fragment fragment;
    private String tag;

    @Override
    protected IToolbar getIToolbar() {
        return new ToolbarBackTitle(this, "订单管理");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_goods;
    }

    @Override
    protected boolean enableSwipeBack() {
        return false;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this);
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        orderGoodsManagerActivity = this;
    }

    @Override
    protected void initNetWork(int pageIndex) {
        position = 0;
        refreshView(position);
    }

    private void initTabLayout(Double num) {
        fragments = new ArrayList<>();
        mTitles = new ArrayList<>();
        if ("OrderGoodsManager".equals(tag)) {
            mTitles.add("选择商品");
            mTitles.add("未完成(" + new Double(num).intValue() + ")");
            mTitles.add("历史订货");
        } else if ("GoodsManager".equals(tag)) {
            mTitles.add("全部商品");
            mTitles.add("已上架");
            mTitles.add("未上架");
        }
        for (int i = 0; i < mTitles.size(); i++) {
            fragments.add(createListFragment(i));
        }
        if (adapter == null) {
            adapter = new BaseFragmentAdapter(getSupportFragmentManager(), fragments, mTitles);
        } else {
            adapter.setFragments(getSupportFragmentManager(), fragments, mTitles);
        }
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(position);
        mViewPager.setOffscreenPageLimit(5);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    private Fragment createListFragment(int position) {
        if ("OrderGoodsManager".equals(tag)) {
            if (position == 0) {
                fragment = new SelectGoodsFragment();
            } else {
                fragment = new OrderGoodsManagerFragment();
            }
        } else if ("GoodsManager".equals(tag)) {
            fragment = new SelectGoodsFragment();
        }
        int[] intArray = UIUtils.getIntArray(R.array.productGoodList_state);
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putString("tag", tag);
        bundle.putInt("state", intArray[position]);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void getSellerOrdersCount(BaseBean bean) {
        Double num = (Double) bean.getResult();
        initTabLayout(num);
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    public void refreshView(int position) {
        this.position = position;
        tabLayout = findViewById(R.id.mTabLayout);
        tag = getIntent().getStringExtra("tag");
        if ("OrderGoodsManager".equals(tag)) {
            mPresenter.getSellerOrdersCount();
        } else if ("GoodsManager".equals(tag)) {
            initTabLayout(0.0);
        }
    }
}
