package com.hhj.merchant.ui.shop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.utility.ToolbarBackTitle;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.GetListBean;
import com.hhj.merchant.ui.shop.adapter.DeliveryClerkManagerAdapter;
import com.hhj.merchant.ui.shop.contract.DeliveryClerkManagerContract;
import com.hhj.merchant.ui.shop.presenter.DeliveryClerkManagerPresenter;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class DeliveryClerkManagerActivity extends BaseActivity<DeliveryClerkManagerPresenter> implements DeliveryClerkManagerContract, BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.OnItemLongClickListener {
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    DeliveryClerkManagerAdapter mAdapter;
    private Intent intent;
    private boolean isOnCreate = false;
    private Map<String, String> map;

    @Override
    protected IToolbar getIToolbar() {
        return new ToolbarBackTitle(this, "配送员管理");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_delivery_clerk_manager;
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
        isOnCreate = true;
        initAdapter();
    }

    private void initAdapter() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new DeliveryClerkManagerAdapter();
        mAdapter.setOnItemClickListener(this);
        mAdapter.setOnItemLongClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initNetWork(int pageIndex) {
        mPresenter.getList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!isOnCreate) {
            initNetWork(pageIndex);
        }
    }

    @Override
    public void getList(GetListBean bean) {
        isOnCreate = false;
        mAdapter.setNewData(bean.getNativePeople());
    }

    @Override
    public void remove(BaseBean bean) {
        ToastUtils.showShort("删除成功");
        pageIndex = 1;
        initNetWork(pageIndex);
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @OnClick({R.id.tv_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_add:
                intent = new Intent(mContext, AddDeliveryClerkAndDetailsActivity.class);
                intent.putExtra("type", "add");
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        GetListBean.NativePeopleBean nativePeopleBean = mAdapter.getItem(position);
        intent = new Intent(mContext, AddDeliveryClerkAndDetailsActivity.class);
        intent.putExtra("type", "details");
        intent.putExtra("nativePeopleBean", nativePeopleBean);
        startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(final BaseQuickAdapter adapter, View view, final int position) {
        final GetListBean.NativePeopleBean item = mAdapter.getItem(position);
        final FrameLayout fl_del = (FrameLayout) view.findViewById(R.id.fl_del);
        fl_del.setVisibility(View.VISIBLE);
        fl_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fl_del.setVisibility(View.GONE);
                map = new HashMap<>();
                map.put("id", item.getId());
                mPresenter.remove(map);
            }
        });
        return true;
    }
}
