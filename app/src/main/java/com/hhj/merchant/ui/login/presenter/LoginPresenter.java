package com.hhj.merchant.ui.login.presenter;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BasePresenter;
import com.baseapp.common.baserx.RxSubscriber;
import com.baseapp.common.http.Api;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.http.mode.RequestMode;
import com.blankj.utilcode.util.LogUtils;
import com.hhj.merchant.api.AppService;
import com.hhj.merchant.bean.LoginBean;
import com.hhj.merchant.ui.login.contract.LoginContract;

import java.util.Map;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.login.presenter
 * @ClassName: LoginPresenter
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/10 18:25
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/10 18:25
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class LoginPresenter extends BasePresenter<LoginContract> {
    public void login(Map<String,String> map){
        Api.
                observable(Api.getService(AppService.class).login(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<LoginBean, BaseBean<LoginBean>>() {
                    @Override
                    protected void _onSuccess(LoginBean loginBean, String successMessage) {
                        mView.login(loginBean);
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, LoginBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);


                    }
                });
    }
    /**
     * 发验证码
     */
    public void getVerifyCode(Map<String,String> map) {
        Api.
                observable(Api.getService(AppService.class).getVerifyCode(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<BaseBean, BaseBean<BaseBean>>() {
                    @Override
                    protected void _onSuccess(BaseBean bean, String successMessage) {
                        mView.getVerifyCode(bean);
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, BaseBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });

    }
}
