package com.hhj.merchant.ui.shop.presenter;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BasePresenter;
import com.baseapp.common.baserx.RxSubscriber;
import com.baseapp.common.http.Api;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.http.mode.RequestMode;
import com.blankj.utilcode.util.LogUtils;
import com.hhj.merchant.api.AppService;
import com.hhj.merchant.bean.GetListBean;
import com.hhj.merchant.ui.shop.contract.DeliveryClerkManagerContract;

import java.util.Map;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.shop.presenter
 * @ClassName: DeliveryClerkManagerPresenter
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/20 10:07
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/20 10:07
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DeliveryClerkManagerPresenter extends BasePresenter<DeliveryClerkManagerContract> {
    public void getList() {
        Api.
                observable(Api.getService(AppService.class).getList()).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<GetListBean, BaseBean<GetListBean>>() {
                    @Override
                    protected void _onSuccess(GetListBean bean, String successMessage) {
                        if (null != bean) {
                            mView.getList(bean);
                        }
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, GetListBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }

    public void remove(Map<String,String> map) {
        Api.
                observable(Api.getService(AppService.class).remove(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<BaseBean, BaseBean<BaseBean>>() {
                    @Override
                    protected void _onSuccess(BaseBean bean, String successMessage) {
                        if (null != bean) {
                            mView.remove(bean);
                        }
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, BaseBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }
}
