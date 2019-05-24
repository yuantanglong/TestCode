package com.hhj.merchant.ui.shop.activity;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.utility.ToolbarBackTitle;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.SellerMessageBean;
import com.hhj.merchant.ui.shop.adapter.SellerMessageAdapter;
import com.hhj.merchant.ui.shop.contract.SellerMessageContract;
import com.hhj.merchant.ui.shop.presenter.SellerMessagePresenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class SellerMessageActivity extends BaseActivity<SellerMessagePresenter> implements SellerMessageContract, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    SellerMessageAdapter mAdapter;
    private Map<String, String> map;

    @Override
    protected IToolbar getIToolbar() {
        return new ToolbarBackTitle(this, "消息");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_seller_message;
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
        initAdapter();
    }

    private void initAdapter() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new SellerMessageAdapter();
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initNetWork(int pageIndex) {
        map = new HashMap<>();
        map.put("pageIndex", pageIndex + "");
        map.put("pageSize", pageSize);
        mPresenter.getSellerMessage(map);
    }

    @Override
    public void getSellerMessage(List<SellerMessageBean> list) {
        if (pageIndex == 1) {
            mAdapter.setNewData(list);
            mAdapter.disableLoadMoreIfNotFullPage(mRecyclerView);
        } else {
            if (list == null || list.size() == 0) {
                mAdapter.loadMoreEnd();
            } else {
                mAdapter.addData(list);
                mAdapter.loadMoreComplete();
            }
        }
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @Override
    public void onLoadMoreRequested() {
        pageIndex++;
        initNetWork(pageIndex);
    }
}
