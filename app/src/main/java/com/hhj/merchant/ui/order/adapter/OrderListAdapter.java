package com.hhj.merchant.ui.order.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseapp.common.utils.UIUtils;
import com.baseapp.common.view.Global;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.OrdersBean;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.order.adapter
 * @ClassName: OrderListAdapter
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/13 14:35
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/13 14:35
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderListAdapter extends BaseQuickAdapter<OrdersBean.OrdersListBean, BaseViewHolder> {
    OrderProductListAdapter mAdapter;
    private int adapterPosition;

    public interface ViewClick {
        void onClick(OrdersBean.OrdersListBean bean, String message, int position);
    }

    private static ViewClick viewClick;

    public OrderListAdapter(ViewClick viewClick) {
        super(R.layout.item_orderlist);
        this.viewClick = viewClick;
    }

    @Override
    protected void convert(BaseViewHolder helper, OrdersBean.OrdersListBean item) {
        adapterPosition = helper.getAdapterPosition();
        TextView tv_payStatus = helper.getView(R.id.tv_payStatus);
        TextView tv_time = helper.getView(R.id.tv_time);
        TextView tv_bookTime = helper.getView(R.id.tv_bookTime);
        TextView tv_address = helper.getView(R.id.tv_address);
        TextView tv_name = helper.getView(R.id.tv_name);
        TextView tv_mobile = helper.getView(R.id.tv_mobile);
        TextView tv_numberCount = helper.getView(R.id.tv_numberCount);
        TextView tv_isTransferOrder = helper.getView(R.id.tv_isTransferOrder);
        TextView tv_memberRemark = helper.getView(R.id.tv_memberRemark);
        TextView tv_adminRemark = helper.getView(R.id.tv_adminRemark);
        TextView tv_sellerRemark = helper.getView(R.id.tv_sellerRemark);
        TextView tv_riderRemark = helper.getView(R.id.tv_riderRemark);
        TextView tv_moneyProduct = helper.getView(R.id.tv_moneyProduct);
        TextView tv_moneyDiscount = helper.getView(R.id.tv_moneyDiscount);
        TextView tv_moneyLogistics = helper.getView(R.id.tv_moneyLogistics);
        TextView tv_moneyOrder = helper.getView(R.id.tv_moneyOrder);
        LinearLayout ll_view = helper.getView(R.id.ll_view);
        LinearLayout ll_print = helper.getView(R.id.ll_print);
        LinearLayout ll_orderDiliverContent = helper.getView(R.id.ll_orderDiliverContent);
        LinearLayout ll_reason = helper.getView(R.id.ll_reason);
        TextView tv_str1 = helper.getView(R.id.tv_str1);
        TextView tv_str2 = helper.getView(R.id.tv_str2);
        TextView tv_cancel_deliver = helper.getView(R.id.tv_cancel_deliver);
        TextView tv_again_print_ticket = helper.getView(R.id.tv_again_print_ticket);
        TextView tv_orderState = helper.getView(R.id.tv_orderState);
        TextView tv_orderDiliverContent = helper.getView(R.id.tv_orderDiliverContent);
        TextView tv_moneyPaidReality = helper.getView(R.id.tv_moneyPaidReality);
        TextView tv_reason_str = helper.getView(R.id.tv_reason_str);
        TextView tv_reason = helper.getView(R.id.tv_reason);
        TextView tv_orderSn = helper.getView(R.id.tv_orderSn);
        TextView tv_createTime = helper.getView(R.id.tv_createTime);
        RecyclerView mRecyclerView = helper.getView(R.id.mRecyclerView);
        String isSelfLifting = item.getIsSelfLifting();
        if (StringUtils.isEmpty(isSelfLifting)) {
            isSelfLifting = "0";
        }
        String[] payStatus = UIUtils.getStringArray(R.array.payStatus);
        tv_payStatus.setText(payStatus[Integer.parseInt(isSelfLifting)]);
        if (item.getIsTransferOrder().equals("1")) {
            tv_isTransferOrder.setVisibility(View.VISIBLE);
        } else {
            tv_isTransferOrder.setVisibility(View.GONE);
        }
        String[] time = UIUtils.getStringArray(R.array.time);
        tv_time.setText(time[Integer.parseInt(isSelfLifting)]);
        tv_bookTime.setText(item.getBookTime());
        tv_address.setText(item.getAddressAll() + item.getAddressInfo());
        tv_name.setText(item.getName());
        tv_mobile.setText(item.getMobile());
        tv_numberCount.setText("商品件数(" + item.getNumberCount() + ")");
        if (!StringUtils.isEmpty(item.getMemberRemark())) {
            tv_memberRemark.setVisibility(View.VISIBLE);
            tv_memberRemark.setText("备注:" + item.getMemberRemark());
        }
        if (!StringUtils.isEmpty(item.getAdminRemark())) {
            tv_adminRemark.setVisibility(View.VISIBLE);
            tv_adminRemark.setText("备注:" + item.getAdminRemark());
        }
        if (!StringUtils.isEmpty(item.getSellerRemark())) {
            tv_sellerRemark.setVisibility(View.VISIBLE);
            tv_sellerRemark.setText("备注:" + item.getSellerRemark());
        }
        if (!StringUtils.isEmpty(item.getRiderRemark())) {
            tv_riderRemark.setVisibility(View.VISIBLE);
            tv_riderRemark.setText("备注:" + item.getRiderRemark());
        }
        tv_moneyProduct.setText("+ ¥ " + item.getMoneyProduct());
        tv_moneyDiscount.setText("- ¥ " + item.getMoneyDiscount());
        tv_moneyLogistics.setText("+ ¥ " + item.getMoneyLogistics());
        tv_moneyOrder.setText("实收:￥" + item.getMoneyOrder() + "元");
        String orderState = item.getOrderState();
        switch (orderState) {
            case "2":
                tv_str1.setText("拒单");
                tv_str2.setText("接单");
                String isDealer = SPUtils.getInstance().getString(Global.ISDEALER);
                if (!StringUtils.isEmpty(isDealer) && "1".equals(isDealer)) {
                    tv_str1.setVisibility(View.GONE);
                }
                ll_print.setVisibility(View.GONE);
                tv_orderState.setVisibility(View.GONE);
                ll_view.setVisibility(View.VISIBLE);
                ll_orderDiliverContent.setVisibility(View.GONE);
                break;
            case "3":
                if (isSelfLifting.equals("1")) {
                    tv_orderState.setVisibility(View.VISIBLE);
                    tv_orderState.setText("【待取货】");
                    ll_view.setVisibility(View.GONE);
                } else {
                    if (SPUtils.getInstance().getString(Global.ACCOUNTTYPE, "0").equals("3")) {
                        tv_str1.setText("查看详情");
                        tv_str2.setText("确认发货");
                    } else {
                        tv_str1.setText("添加备注");
                        tv_str2.setText("发货");
                    }
                    ll_view.setVisibility(View.VISIBLE);
                }
                ll_print.setVisibility(View.VISIBLE);
                tv_cancel_deliver.setVisibility(View.GONE);
                break;
            case "4":
                if (SPUtils.getInstance().getString(Global.ACCOUNTTYPE, "0").equals("3")) {
                    ll_view.setVisibility(View.VISIBLE);
                    tv_str1.setVisibility(View.GONE);
                    tv_str2.setText("确认发货");
                }else {
                    ll_view.setVisibility(View.GONE);
                }
                tv_orderState.setVisibility(View.VISIBLE);
                tv_orderState.setText("【配送中】");
                ll_orderDiliverContent.setVisibility(View.VISIBLE);
                tv_orderDiliverContent.setText(item.getOrderDiliverContent());
                //tv_times.setText(UserCache.printOrderTimes(context, order.orderSn) + "");
                ll_print.setVisibility(View.VISIBLE);
                ll_reason.setVisibility(View.GONE);
                tv_cancel_deliver.setVisibility(View.VISIBLE);
                break;
            case "5":
                tv_orderState.setVisibility(View.VISIBLE);
                tv_orderState.setText("【已完成】");
                //tv_times.setText(UserCache.printOrderTimes(context, order.orderSn) + "");
                tv_cancel_deliver.setVisibility(View.GONE);
                ll_reason.setVisibility(View.GONE);
                if (SPUtils.getInstance().getString(Global.ACCOUNTTYPE, "0").equals("3")) {
                    ll_view.setVisibility(View.VISIBLE);
                    tv_str1.setVisibility(View.GONE);
                    tv_str2.setText("查看详情");
                    ll_print.setVisibility(View.GONE);
                    ll_orderDiliverContent.setVisibility(View.GONE);
                }else {
                    ll_view.setVisibility(View.GONE);
                    ll_print.setVisibility(View.VISIBLE);
                    ll_orderDiliverContent.setVisibility(View.VISIBLE);
                    tv_orderDiliverContent.setText(item.getOrderDiliverContent());
                }
                break;
            case "7":
                ll_view.setVisibility(View.VISIBLE);
                ll_print.setVisibility(View.VISIBLE);
                tv_cancel_deliver.setVisibility(View.GONE);
                tv_moneyPaidReality.setVisibility(View.VISIBLE);
                tv_moneyPaidReality.setText(item.getMoneyPaidReality());
                ll_reason.setVisibility(View.VISIBLE);
                tv_reason_str.setText("退款原因:");
                tv_reason.setText(item.getBackRemark());
                tv_str1.setText("拒绝");
                tv_str2.setText("同意退款");
                break;
            case "8":
            case "9":
                tv_cancel_deliver.setVisibility(View.GONE);
                ll_view.setVisibility(View.GONE);
                ll_print.setVisibility(View.VISIBLE);
                tv_moneyPaidReality.setVisibility(View.VISIBLE);
                tv_moneyPaidReality.setText(item.getMoneyPaidReality());
                ll_reason.setVisibility(View.VISIBLE);
                tv_reason_str.setText("退款原因:");
                tv_reason.setText(item.getBackRemark());
                break;
            default:
                break;
        }
        if (!StringUtils.isEmpty(item.getRefuseOrderReason())) {
            ll_reason.setVisibility(View.VISIBLE);
            String[] refuseOrderReason = UIUtils.getStringArray(R.array.refuseOrderReason);
            tv_reason.setText(refuseOrderReason[Integer.parseInt(item.getRefuseOrderReason())]);
        }
        tv_orderSn.setText(item.getOrderSn());
        tv_createTime.setText(item.getCreateTime());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new OrderProductListAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setNewData(item.getOrderProductList());
        setOnClickListener(tv_str1, item, adapterPosition);
        setOnClickListener(tv_str2, item, adapterPosition);
        setOnClickListener(tv_cancel_deliver, item, adapterPosition);
        setOnClickListener(tv_again_print_ticket, item, adapterPosition);

    }

    private void setOnClickListener(final TextView view, final OrdersBean.OrdersListBean bean, final int adapterPosition) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewClick.onClick(bean, view.getText().toString().trim(), adapterPosition);
            }
        });
    }
}
