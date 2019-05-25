package com.hhj.merchant.ui.order.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.utility.ToolbarBackTitle;
import com.blankj.utilcode.util.ToastUtils;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.DistributionListBean;
import com.hhj.merchant.ui.order.adapter.DistributionListAdapter;
import com.hhj.merchant.ui.order.contract.DistributionListContract;
import com.hhj.merchant.ui.order.presenter.DistributionListPresenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class DistributionListActivity extends BaseActivity<DistributionListPresenter> implements DistributionListContract {
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_Confirm_delivery)
    TextView tv_Confirm_delivery;
    DistributionListAdapter mAdapter;
    private String orderId;
    String ids = "";
    private String orderState;
    private Map<String, String> map;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_distribution_list;
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
        orderId = getIntent().getStringExtra("orderSn");
        orderState = getIntent().getStringExtra("orderState");
        initAdapter();
        if ("3".equals(orderState) || "5".equals(orderState)) {
            tv_Confirm_delivery.setVisibility(View.GONE);
        }
    }

    @Override
    protected IToolbar getIToolbar() {
        return new ToolbarBackTitle(this, "配送列表");
    }

    @Override
    protected void initNetWork(int pageIndex) {
        super.initNetWork(pageIndex);
        map = new HashMap<>();
        map.put("orderId", orderId);
        mPresenter.doujiangList(map);
    }

    private void initAdapter() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new DistributionListAdapter();
        mAdapter.orderState = orderState;
        mRecyclerView.setAdapter(mAdapter);
    }


    @OnClick({R.id.tv_Confirm_delivery})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_Confirm_delivery:
                ids = "";
                mAdapter.notifyDataSetChanged();
                for (DistributionListBean datum : mAdapter.getData()) {
                    if (datum.isChecked() && "2".equals(datum.getDeliveryStatus())) {
                        if ("".equals(ids)) {
                            ids = datum.getId() + "";
                        } else {
                            ids += "," + datum.getId();
                        }
                    }
                }
                if ("".equals(ids)) {
                    ToastUtils.showShort("请选择配送时间");
                } else {
                    map = new HashMap<>();
                    map.put("orderId", orderId);
                    map.put("ids", ids);
                    mPresenter.delivery(map);
                }
                break;
        }
    }


    @Override
    public void doujiangList(List<DistributionListBean> list) {
        mAdapter.setNewData(list);
    }

    @Override
    public void delivery(BaseBean bean) {
        ToastUtils.showShort("配送成功");
        initNetWork(pageIndex);
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }
}
