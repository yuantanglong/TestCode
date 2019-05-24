package com.hhj.merchant.ui.order.presenter;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BasePresenter;
import com.baseapp.common.baserx.RxSubscriber;
import com.baseapp.common.http.Api;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.http.mode.RequestMode;
import com.blankj.utilcode.util.LogUtils;
import com.hhj.merchant.api.AppService;
import com.hhj.merchant.ui.order.contract.OrderGoodsManagerContract;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.order.presenter
 * @ClassName: OrderGoodsManagerPresenter
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/21 20:23
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/21 20:23
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderGoodsManagerPresenter extends BasePresenter<OrderGoodsManagerContract> {
    public void getSellerOrdersCount() {
        Api.
                observable(Api.getService(AppService.class).getSellerOrdersCount()).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<BaseBean, BaseBean<BaseBean>>() {
                    @Override
                    protected void _onSuccess(BaseBean bean, String successMessage) {
                        mView.getSellerOrdersCount(bean);
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, BaseBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }
}
