package com.hhj.merchant.ui.shop.contract;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BaseView;
import com.hhj.merchant.bean.GetListBean;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.shop.contract
 * @ClassName: DeliveryClerkManagerContract
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/20 10:06
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/20 10:06
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface DeliveryClerkManagerContract extends BaseView {
    void getList(GetListBean bean);
    void remove(BaseBean bean);
}
