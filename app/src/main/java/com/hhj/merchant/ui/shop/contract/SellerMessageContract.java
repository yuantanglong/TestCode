package com.hhj.merchant.ui.shop.contract;

import com.baseapp.common.base.BaseView;
import com.hhj.merchant.bean.SellerMessageBean;

import java.util.List;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.shop.contract
 * @ClassName: SellerMessageContract
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/18 17:12
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/18 17:12
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface SellerMessageContract extends BaseView {
    void getSellerMessage(List<SellerMessageBean> list);
}
