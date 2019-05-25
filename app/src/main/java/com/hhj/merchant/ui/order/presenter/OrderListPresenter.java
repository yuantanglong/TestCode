package com.hhj.merchant.ui.order.presenter;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BasePresenter;
import com.baseapp.common.baserx.RxSubscriber;
import com.baseapp.common.http.Api;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.http.mode.RequestMode;
import com.blankj.utilcode.util.LogUtils;
import com.hhj.merchant.api.AppService;
import com.hhj.merchant.bean.GetListBean;
import com.hhj.merchant.bean.OrdersBean;
import com.hhj.merchant.bean.QueryCountBean;
import com.hhj.merchant.ui.order.contract.OrderListContract;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.order.presenter
 * @ClassName: OrderListPresenter
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/13 17:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/13 17:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderListPresenter extends BasePresenter<OrderListContract> {
    public void query(Map<String, String> map) {
        Api.
                observable(Api.getService(AppService.class).query(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<OrdersBean, BaseBean<OrdersBean>>() {
                    @Override
                    protected void _onSuccess(OrdersBean bean, String successMessage) {
                        if (null != bean) {
                            mView.query(bean);
                        }
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, OrdersBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }

    public void changeOrdersStatus(final Map<String, String> map) {
        Api.
                observable(Api.getService(AppService.class).changeOrdersStatus(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<BaseBean, BaseBean<BaseBean>>() {
                    @Override
                    protected void _onSuccess(BaseBean bean, String successMessage) {
                        if (null != bean) {
                            mView.changeOrdersStatus(bean);
                        }
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, BaseBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }

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

    public void deliverGoods(Map<String, String> map) {
        Api.
                observable(Api.getService(AppService.class).deliverGoods(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<BaseBean, BaseBean<BaseBean>>() {
                    @Override
                    protected void _onSuccess(BaseBean bean, String successMessage) {
                        if (null != bean) {
                            mView.deliverGoods(bean);
                        }
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, BaseBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }

    public void cancelDeliverGoods(Map<String, String> map) {
        Api.
                observable(Api.getService(AppService.class).cancelDeliverGoods(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<BaseBean, BaseBean<BaseBean>>() {
                    @Override
                    protected void _onSuccess(BaseBean bean, String successMessage) {
                        if (null != bean) {
                            mView.cancelDeliverGoods(bean);
                        }
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, BaseBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }

    public void getOrders(Map<String, String> map) {
        Api.
                observable(Api.getService(AppService.class).getOrders(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<OrdersBean, BaseBean<OrdersBean>>() {
                    @Override
                    protected void _onSuccess(OrdersBean bean, String successMessage) {
                        if (null != bean) {
                            mView.getOrders(bean);
                        }
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, OrdersBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }

    public void ordercount() {
        Api.
                observable(Api.getService(AppService.class).ordercount()).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<QueryCountBean, BaseBean<QueryCountBean>>() {
                    @Override
                    protected void _onSuccess(QueryCountBean bean, String successMessage) {
                        mView.ordercount(bean);
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, QueryCountBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }

    public void changestatus(Map<String, String> map) {
        Api.
                observable(Api.getService(AppService.class).changestatus(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<BaseBean, BaseBean<BaseBean>>() {
                    @Override
                    protected void _onSuccess(BaseBean bean, String successMessage) {
                        mView.changestatus(bean);
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, BaseBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }
}
