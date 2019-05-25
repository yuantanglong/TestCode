package com.hhj.merchant.ui.order.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.adapter.BaseRecyclerViewAdapter;
import com.baseapp.common.base.ui.BaseFragment;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.utility.MultiItemPlaceHolder;
import com.baseapp.common.utils.FormatUtil;
import com.baseapp.common.view.DialogWrapper;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.SellerGoodsBean;
import com.hhj.merchant.bean.SellerOrderConditionList;
import com.hhj.merchant.bean.SubmitOrderBean;
import com.hhj.merchant.bean.UnfinishedSellerOrdersBean;
import com.hhj.merchant.ui.order.activity.ConfirmGoodsActivity;
import com.hhj.merchant.ui.order.activity.OrderGoodsManagerActivity;
import com.hhj.merchant.ui.order.adapter.OrderGoodsManagerAdapter;
import com.hhj.merchant.ui.order.contract.OrderGoodsManagerFragmentContract;
import com.hhj.merchant.ui.order.presenter.OrderGoodsManagerFragmentPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

import static com.baseapp.common.view.DialogWrapper.BUTTON_DOUBLE;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.order.fragment
 * @ClassName: OrderGoodsManagerFragment
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/21 20:33
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/21 20:33
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderGoodsManagerFragment extends BaseFragment<OrderGoodsManagerFragmentPresenter, MultiItemPlaceHolder> implements BaseQuickAdapter.RequestLoadMoreListener, OrderGoodsManagerFragmentContract {
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    OrderGoodsManagerAdapter mAdapter;
    private Map<String, String> map;
    private Dialog dialog;
    private String sellerOrderId = "";
    private Intent intent;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order_goods_manager;
    }

    @Override
    protected SmartRefreshLayout getSmartRefreshLayout() {
        return null;
    }

    @Override
    protected RecyclerView getRecyclerView() {
        return null;
    }

    @Override
    protected BaseRecyclerViewAdapter getRecyclerViewAdapter() {
        return null;
    }

    @Override
    protected boolean enableAdapterLoadMore() {
        return false;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this);
    }

    @Override
    protected void initView() {
        initAdapter();
    }

    private void initAdapter() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new OrderGoodsManagerAdapter(new OrderGoodsManagerAdapter.ViewClick() {
            @Override
            public void onClick(UnfinishedSellerOrdersBean bean, String message) {
                sellerOrderId = bean.getId();
                switch (message) {
                    case "取消订单":
                        showDialog(1, "确认取消订单?");
                        break;
                    case "确认补货":
                        intent = new Intent(mContext, ConfirmGoodsActivity.class);
                        intent.putExtra("bean", bean);
                        startActivity(intent);
                        break;
                    case "确认拒单":
                        showDialog(2, "拒单确认?");
                        break;
                }
            }
        });
        View emptyView = mActivity.getLayoutInflater().inflate(R.layout.order_empty, (ViewGroup) mRecyclerView.getParent(), false);
        mAdapter.setEmptyView(emptyView);
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void lazyLoad() {
        initNetWork(pageIndex);
    }

    @Override
    protected void initNetWork(int pageIndex) {
        map = new HashMap<>();
        map.put("pageIndex", pageIndex + "");
        map.put("pageSize", pageSize + "");
        int position = getArguments().getInt("position");
        if (position == 1) {
            mPresenter.getUnfinishedSellerOrders(map);
        } else if (position == 2) {
            mPresenter.getSellerHis(map);
        }
    }

    @Override
    public void onLoadMoreRequested() {
        pageIndex++;
        initNetWork(pageIndex);
    }

    @Override
    public void getUnfinishedSellerOrders(List<UnfinishedSellerOrdersBean> list) {
        initData(list);
    }

    private void initData(List<UnfinishedSellerOrdersBean> list) {
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
    public void getSellerHis(List<UnfinishedSellerOrdersBean> list) {
        initData(list);
    }

    @Override
    public void rejectOder(BaseBean bean) {
        int selectedTabPosition = OrderGoodsManagerActivity.tabLayout.getSelectedTabPosition();
        OrderGoodsManagerActivity.orderGoodsManagerActivity.refreshView(selectedTabPosition);
        ToastUtils.showShort("确认拒单成功");
    }

    @Override
    public void cancelOrder(BaseBean bean) {
        int selectedTabPosition = OrderGoodsManagerActivity.tabLayout.getSelectedTabPosition();
        OrderGoodsManagerActivity.orderGoodsManagerActivity.refreshView(selectedTabPosition);
        ToastUtils.showShort("订单取消成功");
    }

    private void showDialog(final int type, String message) {
        dialog = DialogWrapper.
                tipDialog().
                context(getContext()).
                title("提示").
                message(message).
                buttonType(BUTTON_DOUBLE).
                leftButtonText("取消").
                rightButtonText("确定").
                singleButtonText("").
                closeImageVisible(false).
                cancelable(true, true).
                buttonClickListener(new DialogWrapper.TipTypeButtonClickListener() {
                    @Override
                    public void onLeftButtonClicked(TextView view) {
                        dialog.dismiss();
                    }

                    @Override
                    public void onSingleButtonClicked(TextView view) {
                        dialog.dismiss();
                    }

                    @Override
                    public void onRightButtonClicked(TextView view) {
                        dialog.dismiss();
                        map = new HashMap<>();
                        map.put("sellerOrderId", sellerOrderId);
                        if (type == 1) {
                            mPresenter.cancelOrder(map);
                        } else if (type == 2) {
                            mPresenter.rejectOder(map);
                        }

                    }
                }).build();
        dialog.show();
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }
}
