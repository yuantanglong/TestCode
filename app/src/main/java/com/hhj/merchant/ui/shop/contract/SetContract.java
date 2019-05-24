package com.hhj.merchant.ui.shop.contract;

import com.baseapp.common.base.BaseView;
import com.hhj.merchant.bean.SysNewVersionBean;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.shop.contract
 * @ClassName: SetContract
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/19 18:19
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/19 18:19
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface SetContract extends BaseView {
    void getSysNewVersion(SysNewVersionBean bean);
}
