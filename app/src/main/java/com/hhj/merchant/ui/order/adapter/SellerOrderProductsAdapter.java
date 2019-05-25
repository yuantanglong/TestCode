package com.hhj.merchant.ui.order.adapter;

import com.baseapp.common.utils.UIUtils;
import com.blankj.utilcode.util.StringUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.OrdersBean;
import com.hhj.merchant.bean.UnfinishedSellerOrdersBean;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.order.adapter
 * @ClassName: OrderProductListBean
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/14 20:17
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/14 20:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SellerOrderProductsAdapter extends BaseQuickAdapter<UnfinishedSellerOrdersBean.SellerOrderProductsBean, BaseViewHolder> {
    public SellerOrderProductsAdapter() {
        super(R.layout.item_orderproductlist);
    }

    @Override
    protected void convert(BaseViewHolder helper, UnfinishedSellerOrdersBean.SellerOrderProductsBean item) {
        helper.setText(R.id.tv_productName, item.getProductName() + "(" + item.getNormNames() + ")");
        helper.setText(R.id.tv_number, "×" + item.getCount());
        if (Integer.parseInt(item.getCount()) > 1) {
            helper.setTextColor(R.id.tv_number, UIUtils.getColor(R.color.color_fd9426));
        } else {
            helper.setTextColor(R.id.tv_number, UIUtils.getColor(R.color.color_666666));
        }
        helper.setText(R.id.tv_moneyAmount, "¥" + item.getProductsPrice());
    }
}
