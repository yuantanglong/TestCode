package com.hhj.merchant.ui.order.presenter;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BasePresenter;
import com.baseapp.common.baserx.RxSubscriber;
import com.baseapp.common.http.Api;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.http.mode.RequestMode;
import com.blankj.utilcode.util.LogUtils;
import com.hhj.merchant.api.AppService;
import com.hhj.merchant.bean.UnfinishedSellerOrdersBean;
import com.hhj.merchant.ui.order.contract.OrderGoodsManagerFragmentContract;

import java.util.List;
import java.util.Map;

public class OrderGoodsManagerFragmentPresenter extends BasePresenter<OrderGoodsManagerFragmentContract> {
    public void getUnfinishedSellerOrders(Map<String, String> map) {
        Api.
                observable(Api.getService(AppService.class).getUnfinishedSellerOrders(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<List<UnfinishedSellerOrdersBean>, BaseBean<List<UnfinishedSellerOrdersBean>>>() {
                    @Override
                    protected void _onSuccess(List<UnfinishedSellerOrdersBean> bean, String successMessage) {
                        if (null != bean) {
                            mView.getUnfinishedSellerOrders(bean);
                        }
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, List<UnfinishedSellerOrdersBean> bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }
    public void getSellerHis(Map<String, String> map) {
        Api.
                observable(Api.getService(AppService.class).getSellerHis(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<List<UnfinishedSellerOrdersBean>, BaseBean<List<UnfinishedSellerOrdersBean>>>() {
                    @Override
                    protected void _onSuccess(List<UnfinishedSellerOrdersBean> bean, String successMessage) {
                        if (null != bean) {
                            mView.getSellerHis(bean);
                        }
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, List<UnfinishedSellerOrdersBean> bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }
    public void rejectOder(Map<String, String> map) {
        Api.
                observable(Api.getService(AppService.class).rejectOder(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<BaseBean, BaseBean<BaseBean>>() {
                    @Override
                    protected void _onSuccess(BaseBean bean, String successMessage) {
                        mView.rejectOder(bean);
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, BaseBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }
    public void cancelOrder(Map<String, String> map) {
        Api.
                observable(Api.getService(AppService.class).cancelOrder(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<BaseBean, BaseBean<BaseBean>>() {
                    @Override
                    protected void _onSuccess(BaseBean bean, String successMessage) {
                        mView.cancelOrder(bean);
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, BaseBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }

}
