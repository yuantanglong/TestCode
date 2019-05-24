package com.hhj.merchant.ui.order.contract;

import com.baseapp.common.base.BaseView;
import com.hhj.merchant.bean.OrdersBean;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.order.contract
 * @ClassName: FinishOrderContract
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/21 17:11
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/21 17:11
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface OrderFinishContract extends BaseView {
    void query(OrdersBean bean);
}
