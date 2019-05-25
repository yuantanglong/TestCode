package com.hhj.merchant.ui.order.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.utility.ToolbarBackTitle;
import com.blankj.utilcode.util.ToastUtils;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.SellerOrderConditionList;
import com.hhj.merchant.bean.UnfinishedSellerOrdersBean;
import com.hhj.merchant.ui.order.adapter.ConfirmGoodsAdapter;
import com.hhj.merchant.ui.order.contract.ConfirmGoodsContract;
import com.hhj.merchant.ui.order.presenter.ConfirmGoodsPresenter;
import com.hhj.merchant.ui.shop.activity.UpdatePhoneActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class ConfirmGoodsActivity extends BaseActivity<ConfirmGoodsPresenter> implements ConfirmGoodsContract {
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    ConfirmGoodsAdapter mAdapter;
    private String sellerOrderId;
    private Map map;
    private List<SellerOrderConditionList> list = null;

    @Override
    protected IToolbar getIToolbar() {
        return new ToolbarBackTitle(this, "我要补货");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_confirm_goods;
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
        mAdapter = new ConfirmGoodsAdapter();
        mRecyclerView.setAdapter(mAdapter);
        UnfinishedSellerOrdersBean bean = (UnfinishedSellerOrdersBean) getIntent().getSerializableExtra("bean");
        sellerOrderId = bean.getId();
        mAdapter.setNewData(bean.getSellerOrderProducts());
    }

    @OnClick({R.id.tv_confirm_goods})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_confirm_goods:
                list = new ArrayList<>();
                map = new HashMap<>();
                for (UnfinishedSellerOrdersBean.SellerOrderProductsBean datum : mAdapter.getData()) {
                    SellerOrderConditionList bean = new SellerOrderConditionList();
                    bean.setCount(datum.getCount());
                    bean.setSellerProductGoodsId(datum.getSellerProductGoodsId());
                    list.add(bean);
                }
                map.put("sellerOrderId", sellerOrderId);
                map.put("sellerOrderConditionList", list);
                mPresenter.confirmGoods(map);
                break;
        }
    }

    @Override
    public void confirmGoods(BaseBean bean) {
        ToastUtils.showShort("补货成功");
        finish();
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }
}
