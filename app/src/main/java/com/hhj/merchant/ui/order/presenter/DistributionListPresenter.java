package com.hhj.merchant.ui.order.presenter;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BasePresenter;
import com.baseapp.common.baserx.RxSubscriber;
import com.baseapp.common.http.Api;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.http.mode.RequestMode;
import com.blankj.utilcode.util.LogUtils;
import com.hhj.merchant.api.AppService;
import com.hhj.merchant.bean.DistributionListBean;
import com.hhj.merchant.ui.order.contract.DistributionListContract;

import java.util.List;
import java.util.Map;

public class DistributionListPresenter extends BasePresenter<DistributionListContract> {
    public void doujiangList(Map<String, String> map) {
        Api.
                observable(Api.getService(AppService.class).doujiangList(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<List<DistributionListBean>, BaseBean<List<DistributionListBean>>>() {
                    @Override
                    protected void _onSuccess(List<DistributionListBean> bean, String successMessage) {
                        mView.doujiangList(bean);
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, List<DistributionListBean> bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }
    public void delivery(Map<String, String> map) {
        Api.
                observable(Api.getService(AppService.class).delivery(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<BaseBean, BaseBean<BaseBean>>() {
                    @Override
                    protected void _onSuccess(BaseBean bean, String successMessage) {
                        mView.delivery(bean);
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, BaseBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }
}
