package com.hhj.merchant.ui.shop.presenter;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BasePresenter;
import com.baseapp.common.baserx.RxSubscriber;
import com.baseapp.common.http.Api;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.http.mode.RequestMode;
import com.blankj.utilcode.util.LogUtils;
import com.hhj.merchant.api.AppService;
import com.hhj.merchant.ui.shop.contract.AddDeliveryClerkAndDetailsContract;

import java.util.Map;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.shop.presenter
 * @ClassName: AddDeliveryClerkAndDetailsPresenter
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/20 13:35
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/20 13:35
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class AddDeliveryClerkAndDetailsPresenter extends BasePresenter<AddDeliveryClerkAndDetailsContract> {
    public void getDeliveryVerifyCode(Map<String, String> map) {
        Api.
                observable(Api.getService(AppService.class).getDeliveryVerifyCode(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<BaseBean, BaseBean<BaseBean>>() {
                    @Override
                    protected void _onSuccess(BaseBean bean, String successMessage) {
                        mView.getDeliveryVerifyCode(bean);
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, BaseBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }

    public void create(Map<String, String> map) {
        Api.
                observable(Api.getService(AppService.class).create(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<BaseBean, BaseBean<BaseBean>>() {
                    @Override
                    protected void _onSuccess(BaseBean bean, String successMessage) {
                        mView.create(bean);
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, BaseBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }
}
