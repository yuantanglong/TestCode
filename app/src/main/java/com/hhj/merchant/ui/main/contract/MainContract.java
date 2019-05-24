package com.hhj.merchant.ui.main.contract;

import com.baseapp.common.base.BaseView;
import com.hhj.merchant.bean.SellernInfoBean;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.main.contract
 * @ClassName: MainContract
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/14 18:55
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/14 18:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface MainContract extends BaseView {
    void getSellerInfo(SellernInfoBean bean);
}
