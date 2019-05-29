package com.hhj.merchant.ui.zxing.presenter;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BasePresenter;
import com.baseapp.common.baserx.RxSubscriber;
import com.baseapp.common.http.Api;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.http.mode.RequestMode;
import com.blankj.utilcode.util.LogUtils;
import com.hhj.merchant.api.AppService;
import com.hhj.merchant.bean.GoodsInfoBean;
import com.hhj.merchant.ui.zxing.contract.CaptureContract;

import java.util.List;
import java.util.Map;

public class CapturePresenter extends BasePresenter<CaptureContract> {
    public void getGoodsInfo(Map<String, String> map) {
        Api.
                observable(Api.getService(AppService.class).getGoodsInfo(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<GoodsInfoBean, BaseBean<GoodsInfoBean>>() {
                    @Override
                    protected void _onSuccess(GoodsInfoBean bean, String successMessage) {
                        mView.getGoodsInfo(bean);
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, GoodsInfoBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }

    public void saleRecord(List<Map<String,String>> mapList) {
        Api.
                observable(Api.getService(AppService.class).saleRecord(mapList)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<BaseBean, BaseBean<BaseBean>>() {
                    @Override
                    protected void _onSuccess(BaseBean bean, String successMessage) {
                        mView.saleRecord(bean);
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, BaseBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }

    public void verifyOrder(Map<String, String> map) {
        Api.
                observable(Api.getService(AppService.class).verifyOrder(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<BaseBean, BaseBean<BaseBean>>() {
                    @Override
                    protected void _onSuccess(BaseBean bean, String successMessage) {
                        mView.verifyOrder(bean);
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, BaseBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }
}
