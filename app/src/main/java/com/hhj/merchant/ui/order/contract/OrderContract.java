package com.hhj.merchant.ui.order.contract;

import com.baseapp.common.base.BaseView;
import com.hhj.merchant.bean.QueryCountBean;

import java.util.List;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.main.contract
 * @ClassName: OrderContract
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/13 13:56
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/13 13:56
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface OrderContract extends BaseView {
    void getQueryCount(List<QueryCountBean> list);
}
