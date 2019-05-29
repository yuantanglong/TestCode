package com.hhj.merchant.ui.order.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.adapter.BaseRecyclerViewAdapter;
import com.baseapp.common.base.ui.BaseFragment;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.utility.MultiItemPlaceHolder;
import com.baseapp.common.utils.UIUtils;
import com.baseapp.common.view.DialogWrapper;
import com.baseapp.common.view.Global;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.hhj.merchant.R;
import com.hhj.merchant.app.BTPrinter;
import com.hhj.merchant.bean.GetListBean;
import com.hhj.merchant.bean.OrdersBean;
import com.hhj.merchant.bean.QueryCountBean;
import com.hhj.merchant.ui.main.activity.MainActivity;
import com.hhj.merchant.ui.order.activity.DistributionListActivity;
import com.hhj.merchant.ui.order.adapter.DialogListAdapter;
import com.hhj.merchant.ui.order.adapter.NativePeopleAdapter;
import com.hhj.merchant.ui.order.adapter.OrderListAdapter;
import com.hhj.merchant.ui.order.contract.OrderListContract;
import com.hhj.merchant.ui.order.presenter.OrderListPresenter;
import com.hhj.merchant.ui.order.activity.OrderRefundActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.shop.fragment
 * @ClassName: OrderFragment
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/13 10:34
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/13 10:34
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderListFragment extends BaseFragment<OrderListPresenter, MultiItemPlaceHolder> implements OrderListContract, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.mSegmentTabLayout)
    SegmentTabLayout mSegmentTabLayout;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    OrderListAdapter mAdapter;
    private String[] mTitles = new String[4];
    private HashMap<String, String> map;
    private String stateId = "2";
    public String date = "";
    private String buttonStatus = "";
    private Dialog dialog;
    String refuseOrderReason = "3";
    private String isSelfLifting = "";
    private String orderSn;
    NativePeopleAdapter nativePeopleAdapter1;
    NativePeopleAdapter nativePeopleAdapter2;
    DialogListAdapter dialogListAdapter;
    String type = "";
    String id = "";
    private EditText et_remark;
    private View view;
    private String tag;
    private RecyclerView mRecyclerView1;
    private List<String> list;
    private String desc;
    private OrdersBean.OrdersListBean ordersListBean = null;
    private BTPrinter btPrinter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_orderlist;
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
        tag = getArguments().getString("tag");
        if ("RefundActivity".equals(tag)) {
            stateId = "7";
        } else if ("OrderDetailActivity".equals(tag)) {
            mSegmentTabLayout.setVisibility(View.GONE);
            ordersListBean = (OrdersBean.OrdersListBean) getArguments().getSerializable("ordersListBean");
        } else if ("MainActivity".equals(tag)) {
            stateId = "3";
        }

        mSegmentTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                if ("OrderFragment".equals(tag)) {
                    int[] order_status_id = UIUtils.getIntArray(R.array.order_status_id);
                    stateId = order_status_id[position] + "";
                } else if ("RefundActivity".equals(tag)) {
                    int[] order_refund_status_id = UIUtils.getIntArray(R.array.order_refund_status_id);
                    stateId = order_refund_status_id[position] + "";
                } else if ("MainActivity".equals(tag)) {
                    int[] doujiang_order_status_id = UIUtils.getIntArray(R.array.doujiang_order_status_id);
                    stateId = doujiang_order_status_id[position] + "";
                }
                pageIndex = 1;
                query();
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
        initAdapter();
    }

    private void query() {
        if ("OrderDetailActivity".equals(tag)) {
            List<OrdersBean.OrdersListBean> listBeans = new ArrayList<>();
            listBeans.add(ordersListBean);
            mAdapter.setNewData(listBeans);
            mAdapter.disableLoadMoreIfNotFullPage(mRecyclerView);
            mAdapter.setEnableLoadMore(false);
            mAdapter.loadMoreEnd();
        } else if ("MainActivity".equals(tag)) {
            mPresenter.ordercount();
            map = new HashMap<>();
            map.put("pageIndex", pageIndex + "");
            map.put("pageSize", pageSize);
            map.put("stateId", stateId);
            map.put("orderType", "4");
            mPresenter.query(map);
        } else {
            if ("OrderFragment".equals(tag)) {
                int selectedTabPosition = OrderFragment.tabLayout.getSelectedTabPosition();
                if (-1 == selectedTabPosition) {
                    selectedTabPosition = 0;
                }
                if (null!=OrderFragment.list&&OrderFragment.list.size()>0){
                    QueryCountBean queryCountBean = OrderFragment.list.get(selectedTabPosition);
                    mTitles[0] = "待接单(" + queryCountBean.getPendingCount() + ")";
                    mTitles[1] = "待发货(" + queryCountBean.getDeliverGoodStateCount() + ")";
                    mTitles[2] = "待取货(" + queryCountBean.getTakeGoodStateCount() + ")";
                    mTitles[3] = "配送中(" + queryCountBean.getDispatchingStateCount() + ")";
                    date = queryCountBean.getDate();
                    mSegmentTabLayout.setTabData(mTitles);
                }

            } else if ("RefundActivity".equals(tag)) {
                String[] refund_status = UIUtils.getStringArray(R.array.refund_status);
                mSegmentTabLayout.setTabData(refund_status);
            }
            map = new HashMap<>();
            map.put("pageIndex", pageIndex + "");
            map.put("pageSize", pageSize);
            map.put("stateId", stateId);
            map.put("useDate", date);
            mPresenter.query(map);
        }
    }

    private void initAdapter() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new OrderListAdapter(new OrderListAdapter.ViewClick() {
            @Override
            public void onClick(OrdersBean.OrdersListBean bean, String message, int position) {
                ordersListBean = bean;
                orderSn = bean.getOrderSn();
                isSelfLifting = bean.getIsSelfLifting();
                buttonStatus = "";
                switch (message) {
                    case "拒单":
                        buttonStatus = "1";
                        list = new ArrayList<>();
                        list.add("无法配送");
                        list.add("客户定位不准超配送范围");
                        list.add("其他原因");
                        list.add("因长时间未接单，自动转单");
                        showListDialog("拒绝原因", list);

                        break;
                    case "接单":
                        if (StringUtils.isEmpty(SPUtils.getInstance().getString(Global.PRINT_SONGHUO_NUM))) {
                            SPUtils.getInstance().put(Global.PRINT_SONGHUO_NUM, "1");
                        }
                        if (StringUtils.isEmpty(SPUtils.getInstance().getString(Global.PRINT_DAODIAN_NUM))) {
                            SPUtils.getInstance().put(Global.PRINT_DAODIAN_NUM, "1");
                        }
                        buttonStatus = "2";
                        map = new HashMap<>();
                        map.put("buttonStatus", buttonStatus);
                        map.put("orderId", orderSn);
                        mPresenter.changeOrdersStatus(map);
                        break;
                    case "添加备注":
                        buttonStatus = "3";
                        view = View.inflate(mActivity, R.layout.view_add_remark, null);
                        et_remark = view.findViewById(R.id.et_remark);
                        final TextView tv_remark_length = view.findViewById(R.id.tv_remark_length);
                        et_remark.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {
                                tv_remark_length.setText(s.length() + "/50");
                            }

                            @Override
                            public void afterTextChanged(Editable s) {

                            }
                        });
                        showDialog(view, "添加备注", DialogWrapper.BUTTON_SINGLE, "确认添加", true);
                        break;
                    case "发货":
                        buttonStatus = "4";
                        mPresenter.getList();
                        break;
                    case "取消发货":
                        list = new ArrayList<>();
                        list.add("重新分配");
                        list.add("美团接单不来");
                        list.add("客户更改配送时间");
                        list.add("客户联系不上");
                        showListDialog("", list);
                        break;
                    case "同意退款":
                        buttonStatus = "5";
                        map = new HashMap<>();
                        map.put("buttonStatus", buttonStatus);
                        map.put("orderId", orderSn);
                        mPresenter.changeOrdersStatus(map);
                        break;
                    case "拒绝":
                        buttonStatus = "6";
                        list = new ArrayList<>();
                        list.add("已发货");
                        list.add("客户误操作");
                        list.add("与客户再协商");
                        showListDialog("拒退款原因", list);
                        break;
                    case "查看详情":
                        Intent intent = new Intent(mContext, DistributionListActivity.class);
                        intent.putExtra("orderSn", orderSn);
                        intent.putExtra("orderState", bean.getOrderState());
                        startActivity(intent);
                        break;
                    case "确认发货":
                        buttonStatus = "4";
                        showDialog(null, "确认是否发货", DialogWrapper.BUTTON_DOUBLE, "", false);
                        break;
                    case "小票重打":
                        //自动打印业务
                        MainActivity.btPrinter.setDataBean(ordersListBean);
                        btPrinter.print();
                        break;

                }
            }
        });
        View emptyView = mActivity.getLayoutInflater().inflate(R.layout.order_empty, (ViewGroup) mRecyclerView.getParent(), false);
        mAdapter.setEmptyView(emptyView);
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void showListDialog(String title, List<String> list) {
        view = View.inflate(mActivity, R.layout.dialog_list, null);
        mRecyclerView1 = view.findViewById(R.id.mRecyclerView1);
        mRecyclerView1.setLayoutManager(new LinearLayoutManager(mContext));
        dialogListAdapter = new DialogListAdapter();
        dialogListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                dialogListAdapter.position = position;
                switch (buttonStatus) {
                    case "1":
                        int[] refuseOrderReason_array = UIUtils.getIntArray(R.array.refuseOrderReason_array);
                        refuseOrderReason = refuseOrderReason_array[position] + "";
                        break;
                    case "6":
                        int[] refusalRefundReasons_array = UIUtils.getIntArray(R.array.refusalRefundReasons_array);
                        desc = refusalRefundReasons_array[position] + "";
                        break;
                }
                dialogListAdapter.notifyDataSetChanged();
            }
        });
        mRecyclerView1.setAdapter(dialogListAdapter);
        dialogListAdapter.setNewData(list);
        showDialog(view, title, DialogWrapper.BUTTON_DOUBLE, "", false);
    }

    private void showDialog(View view, String title, int buttonType, String singleButton, boolean closeImageVisible) {
        String rightButtonText = "确定";
        if (buttonStatus.equals("6")) {
            rightButtonText = "拒绝退款";
        }
        dialog = DialogWrapper.
                tipDialog().
                context(getContext()).
                title(title).
                contentView(view).
                buttonType(buttonType).
                leftButtonText("取消").
                rightButtonText(rightButtonText).
                singleButtonText(singleButton).
                closeImageVisible(closeImageVisible).
                cancelable(true, true).
                buttonClickListener(new DialogWrapper.TipTypeButtonClickListener() {
                    @Override
                    public void onLeftButtonClicked(TextView view) {
                        dialog.dismiss();
                    }

                    @Override
                    public void onSingleButtonClicked(TextView view) {
                        dialog.dismiss();
                        switch (buttonStatus) {
                            case "3":
                                String remark = et_remark.getText().toString().trim();
                                if (StringUtils.isEmpty(remark)) {
                                    ToastUtils.showShort("请输入备注");
                                } else {
                                    buttonStatus = "3";
                                    map = new HashMap<>();
                                    map.put("buttonStatus", buttonStatus);
                                    map.put("orderId", orderSn);
                                    map.put("desc", remark);
                                    mPresenter.changeOrdersStatus(map);
                                }
                                break;
                            case "4":
                                if (nativePeopleAdapter1.position == -1 && nativePeopleAdapter2.position == -1) {
                                    ToastUtils.showShort("请选择配送员");
                                } else {
                                    if (nativePeopleAdapter1.position == -1) {
                                        type = nativePeopleAdapter2.type;
                                        id = nativePeopleAdapter2.id;
                                    } else if (nativePeopleAdapter2.position == -1) {
                                        type = nativePeopleAdapter1.type;
                                        id = nativePeopleAdapter1.id;
                                    }
                                    map = new HashMap<>();
                                    map.put("buttonStatus", buttonStatus);
                                    map.put("orderId", orderSn);
                                    if (null == view) {
                                        mPresenter.changestatus(map);
                                    } else {
                                        map.put("deliveryNo", id);
                                        map.put("deliveryType", type);
                                        mPresenter.deliverGoods(map);
                                    }
                                }
                                break;
                        }
                    }

                    @Override
                    public void onRightButtonClicked(TextView view) {
                        dialog.dismiss();
                        switch (buttonStatus) {
                            case "1":
                                map = new HashMap<>();
                                map.put("buttonStatus", buttonStatus);
                                map.put("refuseOrderReason", refuseOrderReason);
                                map.put("desc", refuseOrderReason);
                                map.put("orderId", orderSn);
                                mPresenter.changeOrdersStatus(map);
                                break;
                            case "6":
                                map = new HashMap<>();
                                map.put("buttonStatus", buttonStatus);
                                map.put("orderId", orderSn);
                                map.put("desc", desc);
                                mPresenter.changeOrdersStatus(map);
                                break;
                        }
                        String sellerCancelReason = dialogListAdapter.sellerCancelReason;
                        if (StringUtils.isEmpty(sellerCancelReason)) {
                            ToastUtils.showShort("请选择取消发货原因");
                        } else {
                            map = new HashMap<>();
                            map.put("sellerCancelReason", sellerCancelReason);
                            map.put("orderSn", orderSn);
                            mPresenter.cancelDeliverGoods(map);
                        }
                    }
                }).build();
        dialog.show();
    }

    @Override
    protected void lazyLoad() {
        query();
    }

    @Override
    protected void initNetWork(int pageIndex) {
        query();
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
    public void changeOrdersStatus(BaseBean bean) {
        switch (buttonStatus) {
            case "1":
                if (isSelfLifting.equals("0")) {
                    ToastUtils.showShort("该订单已转至自建站");
                } else if (isSelfLifting.equals("1")) {
                    ToastUtils.showShort("该订单已转退款");
                } else {
                    ToastUtils.showShort("该订单成功转至经销商");
                }
                break;
            case "2":
                ToastUtils.showShort("成功接单");
                //根据订单业务类型：1及时送订单 2次日达订单
                //自动打印业务
                MainActivity.btPrinter.setDataBean(ordersListBean);
                btPrinter.print();
                break;
            case "3":
                ToastUtils.showShort("成功添加备注");
                break;
            case "5":
                ToastUtils.showShort("订单已退款");
                break;
            case "6":
                ToastUtils.showShort("订单已拒绝退款");
                break;
        }
        if ("OrderFragment".equals(tag)) {
            OrderFragment.orderFragment.onHiddenChanged(false);
        } else if ("RefundActivity".equals(tag)) {
            OrderRefundActivity.refundActivity.initFragment();
        }
    }

    @Override
    public void getList(final GetListBean bean) {
        view = View.inflate(mActivity, R.layout.dialog_list, null);
        mRecyclerView1 = view.findViewById(R.id.mRecyclerView1);
        mRecyclerView1.setLayoutManager(new LinearLayoutManager(mContext));
        nativePeopleAdapter1 = new NativePeopleAdapter();
        nativePeopleAdapter1.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                nativePeopleAdapter1.position = position;
                nativePeopleAdapter1.notifyDataSetChanged();
                nativePeopleAdapter2.position = -1;
                nativePeopleAdapter2.notifyDataSetChanged();
            }
        });
        mRecyclerView1.setAdapter(nativePeopleAdapter1);
        nativePeopleAdapter1.setNewData(bean.getNativePeople());
        RecyclerView mRecyclerView2 = view.findViewById(R.id.mRecyclerView2);
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(mContext));
        nativePeopleAdapter2 = new NativePeopleAdapter();
        nativePeopleAdapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                nativePeopleAdapter2.position = position;
                nativePeopleAdapter2.notifyDataSetChanged();
                nativePeopleAdapter1.position = -1;
                nativePeopleAdapter1.notifyDataSetChanged();
            }
        });
        mRecyclerView2.setAdapter(nativePeopleAdapter2);
        List<GetListBean.NativePeopleBean> list = new ArrayList<>();
        for (GetListBean.ThirdListBean thirdListBean : bean.getThirdList()) {
            GetListBean.NativePeopleBean nativePeopleBean = new GetListBean.NativePeopleBean();
            nativePeopleBean.setName(thirdListBean.getName());
            nativePeopleBean.setId(thirdListBean.getId());
            nativePeopleBean.setType(thirdListBean.getType());
            list.add(nativePeopleBean);
        }
        nativePeopleAdapter2.setNewData(list);
        showDialog(view, "选择配送员", DialogWrapper.BUTTON_SINGLE, "确认发货", false);
    }

    @Override
    public void deliverGoods(BaseBean bean) {
        ToastUtils.showShort(bean.getResult().toString());
        OrderFragment.orderFragment.onHiddenChanged(false);
    }

    @Override
    public void cancelDeliverGoods(BaseBean bean) {
        ToastUtils.showShort(bean.getResult().toString());
        OrderFragment.orderFragment.onHiddenChanged(false);
    }

    @Override
    public void getOrders(OrdersBean bean) {

    }

    @Override
    public void ordercount(QueryCountBean queryCountBean) {
        mTitles = new String[3];
        mTitles[0] = "待发货(" + queryCountBean.getDeliverGoodStateCount() + ")";
        mTitles[1] = "配送中(" + queryCountBean.getDispatchingStateCount() + ")";
        mTitles[2] = "配送完成(" + queryCountBean.getDoneStateCount() + ")";
        date = queryCountBean.getDate();
        mSegmentTabLayout.setTabData(mTitles);
    }

    @Override
    public void changestatus(BaseBean bean) {
        ToastUtils.showShort("发货成功");
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @Override
    public void onLoadMoreRequested() {
        pageIndex++;
        query();
    }
}
