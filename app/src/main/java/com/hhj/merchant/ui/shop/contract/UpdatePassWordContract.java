package com.hhj.merchant.ui.shop.contract;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BaseView;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.shop.contract
 * @ClassName: UpdatePassWordContract
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/19 17:50
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/19 17:50
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface UpdatePassWordContract extends BaseView {
    void updateSellerPassword(BaseBean bean);
    void modify(BaseBean bean);
}
