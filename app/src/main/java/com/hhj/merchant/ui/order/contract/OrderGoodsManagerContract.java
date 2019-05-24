package com.hhj.merchant.ui.order.contract;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BaseView;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.order.contract
 * @ClassName: OrderGoodsManagerContract
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/21 20:17
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/21 20:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface OrderGoodsManagerContract extends BaseView {
    void getSellerOrdersCount(BaseBean bean);
}
