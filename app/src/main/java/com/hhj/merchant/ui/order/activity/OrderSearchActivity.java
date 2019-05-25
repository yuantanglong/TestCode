package com.hhj.merchant.ui.order.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.utility.ToolbarBackTitle;
import com.baseapp.common.utils.CommonPopupWindow;
import com.baseapp.common.utils.UIUtils;
import com.baseapp.common.view.DialogWrapper;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.GetListBean;
import com.hhj.merchant.bean.OrdersBean;
import com.hhj.merchant.bean.QueryCountBean;
import com.hhj.merchant.ui.order.adapter.DialogListAdapter;
import com.hhj.merchant.ui.order.adapter.NativePeopleAdapter;
import com.hhj.merchant.ui.order.adapter.OrderListAdapter;
import com.hhj.merchant.ui.order.adapter.ViewListAdapter;
import com.hhj.merchant.ui.order.contract.OrderListContract;
import com.hhj.merchant.ui.order.presenter.OrderListPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class OrderSearchActivity extends BaseActivity<OrderListPresenter> implements OrderListContract,BaseQuickAdapter.RequestLoadMoreListener{
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_status)
    TextView tv_status;
    @BindView(R.id.et_search)
    EditText et_search;
    OrderListAdapter mAdapter;
    private HashMap<String, String> map;
    private String stateId = "2";
    public String date = "";
    private String buttonStatus = "1";
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
    private String condition = "";
    private String status = "0";
    private CommonPopupWindow popupWindow;
    private ViewListAdapter viewListAdapter;

    @Override
    protected IToolbar getIToolbar() {
        return new ToolbarBackTitle(this, "订单搜索");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_search;
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
        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                condition=s.toString().trim();
                pageIndex=1;
                getOrders(condition, status);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        initAdapter();


    }

    @Override
    protected void initNetWork(int pageIndex) {
        getOrders(condition, status);
    }
    private void getOrders(String condition, String status) {
        map = new HashMap<>();
        map.put("condition", condition);
        map.put("status", status);
        map.put("pageIndex", pageIndex+"");
        map.put("pageSize", pageSize);
        mPresenter.getOrders(map);
    }

    private void initAdapter() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new OrderListAdapter(new OrderListAdapter.ViewClick() {
            @Override
            public void onClick(OrdersBean.OrdersListBean bean, String message, int position) {
                orderSn = bean.getOrderSn();
                isSelfLifting = bean.getIsSelfLifting();
                buttonStatus = "";
                switch (message) {
                    case "拒单":
                        buttonStatus = "1";
                        View view = View.inflate(mActivity, R.layout.dialog_refuse, null);
                        RadioGroup radioGroup = view.findViewById(R.id.radiogroup);
                        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                                int id = radioGroup.getCheckedRadioButtonId();
                                switch (id) {
                                    case R.id.radioButton1:
                                        refuseOrderReason = "3";
                                        break;
                                    case R.id.radioButton2:
                                        refuseOrderReason = "1";
                                        break;
                                    case R.id.radioButton3:
                                        refuseOrderReason = "2";
                                        break;
                                    case R.id.radioButton4:
                                        refuseOrderReason = "4";
                                        break;

                                }
                            }
                        });
                        showDialog(view, "拒绝原因", DialogWrapper.BUTTON_DOUBLE, "", false);
                        break;
                    case "接单":
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
                        view = View.inflate(mActivity, R.layout.dialog_list, null);
                        RecyclerView mRecyclerView1 = view.findViewById(R.id.mRecyclerView1);
                        mRecyclerView1.setLayoutManager(new LinearLayoutManager(mContext));
                        dialogListAdapter = new DialogListAdapter();
                        dialogListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                dialogListAdapter.position = position;
                                dialogListAdapter.notifyDataSetChanged();
                            }
                        });
                        mRecyclerView1.setAdapter(dialogListAdapter);
                        List<String> list = new ArrayList<>();
                        list.add("重新分配");
                        list.add("美团接单不来");
                        list.add("客户更改配送时间");
                        list.add("客户联系不上");
                        dialogListAdapter.setNewData(list);
                        showDialog(view, "", DialogWrapper.BUTTON_DOUBLE, "", false);
                        break;

                }
            }
        });
        View emptyView = mActivity.getLayoutInflater().inflate(R.layout.order_empty, (ViewGroup) mRecyclerView.getParent(), false);
        mAdapter.setEmptyView(emptyView);
        mAdapter.setOnLoadMoreListener(this,mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void showDialog(View view, String title, int buttonType, String singleButton, boolean closeImageVisible) {

        dialog = DialogWrapper.
                tipDialog().
                context(mContext).
                title(title).
                contentView(view).
                buttonType(buttonType).
                leftButtonText("取消").
                rightButtonText("确定").
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
                        if (buttonStatus.equals("4")) {
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
                                map.put("deliveryNo", id);
                                map.put("deliveryType", type);
                                mPresenter.deliverGoods(map);
                            }
                        } else if (buttonStatus.equals("3")) {
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
                        }
                    }

                    @Override
                    public void onRightButtonClicked(TextView view) {
                        dialog.dismiss();
                        if (buttonStatus.equals("4")) {
                            map = new HashMap<>();
                            map.put("buttonStatus", buttonStatus);
                            map.put("refuseOrderReason", refuseOrderReason);
                            map.put("desc", refuseOrderReason);
                            map.put("orderId", orderSn);
                            mPresenter.changeOrdersStatus(map);
                        } else {
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
                    }
                }).build();
        dialog.show();
    }

    @Override
    public void query(OrdersBean bean) {

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
                break;
            case "3":
                ToastUtils.showShort("成功添加备注");
                break;
        }
        initNetWork(pageIndex);
    }

    @Override
    public void getList(final GetListBean bean) {
        view = View.inflate(mActivity, R.layout.dialog_list, null);
        RecyclerView mRecyclerView1 = view.findViewById(R.id.mRecyclerView1);
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
        initNetWork(pageIndex);
    }

    @Override
    public void cancelDeliverGoods(BaseBean bean) {
        ToastUtils.showShort(bean.getResult().toString());
        initNetWork(pageIndex);
    }

    @Override
    public void getOrders(OrdersBean bean) {
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
    public void ordercount(QueryCountBean bean) {

    }

    @Override
    public void changestatus(BaseBean bean) {

    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @OnClick({R.id.tv_status, R.id.tv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_status:
                if (popupWindow != null && popupWindow.isShowing()) {
                    return;
                }
                View myView = View.inflate(mActivity, R.layout.view_list, null);
                RecyclerView mRecyclerView = myView.findViewById(R.id.mRecyclerView);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                viewListAdapter = new ViewListAdapter();
                viewListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        popupWindow.dismiss();
                        status = UIUtils.getIntArray(R.array.order_search_status_id)[position] + "";
                        pageIndex=1;
                        getOrders(condition, status);
                    }
                });
                mRecyclerView.setAdapter(viewListAdapter);
                List<String> list = new ArrayList<>();
                for (String s : UIUtils.getStringArray(R.array.order_status)) {
                    list.add(s);
                }

                viewListAdapter.setNewData(list);
                popupWindow = new CommonPopupWindow.Builder(mActivity)
                        .setView(myView)
                        .setWidthAndHeight(UIUtils.getDimen(R.dimen.x150), ViewGroup.LayoutParams.WRAP_CONTENT
                        )
                        .setBackGroundLevel(1.0f)
                        .create();
                popupWindow.showAsDropDown(tv_status);
                break;
            case R.id.tv_search:
                condition=et_search.getText().toString().trim();
                pageIndex=1;
                getOrders(condition,status);
                break;
        }
    }

    @Override
    public void onLoadMoreRequested() {
        pageIndex++;
        initNetWork(pageIndex);
    }
}
