package com.hhj.merchant.ui.order.adapter;

import android.widget.TextView;

import com.baseapp.common.utils.UIUtils;
import com.blankj.utilcode.util.StringUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.OrdersBean;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.order.adapter
 * @ClassName: FinishOrderAdapter
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/21 17:06
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/21 17:06
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderFinishAdapter extends BaseQuickAdapter<OrdersBean.OrdersListBean, BaseViewHolder> {
    public OrderFinishAdapter() {
        super(R.layout.item_order_finish);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrdersBean.OrdersListBean item) {
        TextView tv_payStatus=helper.getView(R.id.tv_payStatus);
        TextView tv_time=helper.getView(R.id.tv_time);
        TextView tv_bookTime=helper.getView(R.id.tv_bookTime);
        TextView tv_numberCount=helper.getView(R.id.tv_numberCount);
        TextView tv_name=helper.getView(R.id.tv_name);
        TextView tv_mobile=helper.getView(R.id.tv_mobile);
        TextView tv_moneyOrder=helper.getView(R.id.tv_moneyOrder);
        String[] payStatus = UIUtils.getStringArray(R.array.payStatus);
        String isSelfLifting = item.getIsSelfLifting();
        if (StringUtils.isEmpty(isSelfLifting)) {
            isSelfLifting = "0";
        }
        tv_payStatus.setText(payStatus[Integer.parseInt(isSelfLifting)]);
        String[] time = UIUtils.getStringArray(R.array.time);
        tv_time.setText(time[Integer.parseInt(isSelfLifting)]);
        tv_bookTime.setText(item.getBookTime());
        tv_numberCount.setText( "(" + item.getNumberCount() + ")");
        tv_name.setText( item.getName());
        tv_mobile.setText(item.getMobile());
        tv_moneyOrder.setText(item.getMoneyOrder()+"元");
    }
}
