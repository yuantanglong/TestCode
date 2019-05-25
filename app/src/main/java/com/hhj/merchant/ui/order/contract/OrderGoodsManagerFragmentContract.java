package com.hhj.merchant.ui.order.contract;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BaseView;
import com.hhj.merchant.bean.UnfinishedSellerOrdersBean;

import java.util.List;

public interface OrderGoodsManagerFragmentContract extends BaseView {
    void getUnfinishedSellerOrders(List<UnfinishedSellerOrdersBean> list);
    void getSellerHis(List<UnfinishedSellerOrdersBean> list);

    void rejectOder(BaseBean bean);
    void cancelOrder(BaseBean bean);
}
