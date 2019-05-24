package com.hhj.merchant.ui.shop.contract;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BaseView;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.shop.contract
 * @ClassName: AddDeliveryClerkAndDetailsContract
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/20 13:34
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/20 13:34
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface AddDeliveryClerkAndDetailsContract extends BaseView {
    void getDeliveryVerifyCode(BaseBean bean);
    void create(BaseBean bean);
}
