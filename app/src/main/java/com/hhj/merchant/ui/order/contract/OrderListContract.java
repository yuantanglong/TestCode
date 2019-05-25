package com.hhj.merchant.ui.order.contract;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BaseView;
import com.hhj.merchant.bean.GetListBean;
import com.hhj.merchant.bean.OrdersBean;
import com.hhj.merchant.bean.QueryCountBean;

import java.util.List;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.order.contract
 * @ClassName: OrderListContract
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/13 16:56
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/13 16:56
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface OrderListContract extends BaseView {
    void query(OrdersBean bean);
    void changeOrdersStatus(BaseBean bean);
    void getList(GetListBean bean);
    void deliverGoods(BaseBean bean);
    void cancelDeliverGoods(BaseBean bean);
    void getOrders(OrdersBean bean);
    void ordercount(QueryCountBean bean);
    void changestatus(BaseBean bean);
}
