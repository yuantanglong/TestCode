package com.hhj.merchant.ui.order.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.TextView;

import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.utility.ToolbarBackTitle;
import com.baseapp.common.utils.TimeUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.OrdersBean;
import com.hhj.merchant.ui.order.adapter.OrderFinishAdapter;
import com.hhj.merchant.ui.order.contract.OrderFinishContract;
import com.hhj.merchant.ui.order.presenter.OrderFinishPresenter;

import java.util.Calendar;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

public class OrderFinishActivity extends BaseActivity<OrderFinishPresenter> implements OrderFinishContract, BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.tv_date)
    TextView tv_date;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    OrderFinishAdapter mAdapter;
    private String stateId = "5";
    public String date = "";
    private HashMap<String, String> map;
    private DatePickerDialog datePickerDialog;

    @Override
    protected IToolbar getIToolbar() {
        return new ToolbarBackTitle(this, "已完成");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_finish;
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
        String currentDate = TimeUtil.getCurrentDate("yyyy-MM-dd");
        tv_date.setText(currentDate);
        date = currentDate + " 00:00:00";
        initAdapter();
    }

    private void initAdapter() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new OrderFinishAdapter();
        View emptyView = mActivity.getLayoutInflater().inflate(R.layout.order_empty, (ViewGroup) mRecyclerView.getParent(), false);
        mAdapter.setEmptyView(emptyView);
        mAdapter.setOnItemClickListener(this);
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initNetWork(int pageIndex) {
        map = new HashMap<>();
        map.put("pageIndex", pageIndex + "");
        map.put("pageSize", pageSize);
        map.put("stateId", stateId);
        map.put("useDate", date);
        mPresenter.query(map);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        OrdersBean.OrdersListBean ordersListBean = mAdapter.getItem(position);
        Intent intent = new Intent(mContext, OrderDetailActivity.class);
        intent.putExtra("ordersListBean", ordersListBean);
        startActivity(intent);
    }

    @Override
    public void onLoadMoreRequested() {
        pageIndex++;
        initNetWork(pageIndex);
    }

    @Override
    public void query(OrdersBean bean) {
        if (pageIndex == 1) {
            mAdapter.setNewData(bean.getOrdersList());
            mAdapter.disableLoadMoreIfNotFullPage(mRecyclerView);
        } else {
            if (bean.getOrdersList() == null || bean.getOrdersList().size() == 0) {
                mAdapter.loadMoreEnd();
            } else {
                mAdapter.addData(bean.getOrdersList());
                mAdapter.loadMoreComplete();
            }
        }
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @OnClick({R.id.ll_date})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_date:
                Calendar calendar = Calendar.getInstance();
                datePickerDialog = new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String thisDate = year + "-" + (month + 1) + "-" + dayOfMonth;
                        tv_date.setText(thisDate);
                        date = thisDate + " 00:00:00";
                        pageIndex = 1;
                        initNetWork(pageIndex);
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickerDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                break;
        }
    }
}
