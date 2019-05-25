package com.hhj.merchant.ui.order.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseapp.common.utils.UIUtils;
import com.blankj.utilcode.util.StringUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.UnfinishedSellerOrdersBean;

public class OrderGoodsManagerAdapter extends BaseQuickAdapter<UnfinishedSellerOrdersBean, BaseViewHolder> {

    private SellerOrderProductsAdapter mAdapter;

    public interface ViewClick {
        void onClick(UnfinishedSellerOrdersBean bean, String message);
    }

    private static ViewClick viewClick;

    public OrderGoodsManagerAdapter(ViewClick viewClick) {
        super(R.layout.item_orderlist);
        this.viewClick = viewClick;
    }

    @Override
    protected void convert(BaseViewHolder helper, final UnfinishedSellerOrdersBean item) {
        LinearLayout ll_view = helper.getView(R.id.ll_view);
        LinearLayout ll_view1 = helper.getView(R.id.ll_view1);
        ll_view1.setVisibility(View.GONE);
        LinearLayout ll_view2 = helper.getView(R.id.ll_view2);
        ll_view2.setVisibility(View.GONE);
        TextView tv_address = helper.getView(R.id.tv_address);
        tv_address.setVisibility(View.GONE);
        LinearLayout ll_view3 = helper.getView(R.id.ll_view3);
        ll_view3.setVisibility(View.GONE);
        TextView tv_numberCount = helper.getView(R.id.tv_numberCount);
        tv_numberCount.setVisibility(View.GONE);
        TextView tv_moneyOrder = helper.getView(R.id.tv_moneyOrder);
        tv_moneyOrder.setVisibility(View.GONE);
        TextView tv_str1 = helper.getView(R.id.tv_str1);
        tv_str1.setVisibility(View.GONE);
        View line1 = helper.getView(R.id.line1);
        line1.setVisibility(View.GONE);
        View line2 = helper.getView(R.id.line2);
        line2.setVisibility(View.GONE);
        TextView tv_orderState = helper.getView(R.id.tv_orderState);
        tv_orderState.setVisibility(View.GONE);
        final TextView tv_str2 = helper.getView(R.id.tv_str2);
        helper.setText(R.id.textView1, "订货数量");
        helper.setText(R.id.textView1, "应付金额");
        helper.setText(R.id.textView1, "抵扣金币");
        helper.setText(R.id.textView1, "实付");
        helper.setText(R.id.tv_orderState, "订单完成");
        RecyclerView mRecyclerView = helper.getView(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new SellerOrderProductsAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setNewData(item.getSellerOrderProducts());
        String orderState = item.getOrderState();
        String[] order_goods_status = UIUtils.getStringArray(R.array.order_goods_status);
        String[] tv_str = UIUtils.getStringArray(R.array.tv_str);
        if (!StringUtils.isEmpty(orderState)) {
            ll_view.setVisibility(View.VISIBLE);
            if ("1".equals(orderState) || "2".equals(orderState) || "3".equals(orderState) || "4".equals(orderState)) {
                helper.setText(R.id.tv_payStatus, order_goods_status[Integer.parseInt(orderState)]);
                tv_str2.setVisibility(View.VISIBLE);
                helper.setText(R.id.tv_str2, tv_str[Integer.parseInt(orderState)]);
            } else {
                tv_str2.setVisibility(View.GONE);
            }
        } else {
            ll_view.setVisibility(View.GONE);
            tv_str2.setVisibility(View.GONE);
        }
        helper.setText(R.id.tv_moneyProduct, item.getProductCount());
        helper.setText(R.id.tv_moneyDiscount, "￥" + item.getProductAmount());
        helper.setText(R.id.tv_moneyLogistics, "￥" + item.getPrincipalGolds());
        helper.setText(R.id.tv_moneyOrder, "￥" + item.getRemainPayment());
        helper.setText(R.id.tv_orderSn, item.getOrderSn());
        helper.setText(R.id.tv_createTime, item.getCreateTime());
        helper.setText(R.id.tv_orderSn, item.getOrderSn());
        tv_str2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewClick.onClick(item,tv_str2.getText().toString().trim());
            }
        });
    }
}
