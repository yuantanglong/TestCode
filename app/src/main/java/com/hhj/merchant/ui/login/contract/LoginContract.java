package com.hhj.merchant.ui.login.contract;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BaseView;
import com.hhj.merchant.bean.LoginBean;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.login.contract
 * @ClassName: LoginContract
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/10 18:19
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/10 18:19
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface LoginContract extends BaseView {
    void login(LoginBean bean);

    void getVerifyCode(BaseBean bean);
}
