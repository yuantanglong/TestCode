package com.hhj.merchant.ui.order.presenter;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BasePresenter;
import com.baseapp.common.baserx.RxSubscriber;
import com.baseapp.common.http.Api;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.http.mode.RequestMode;
import com.blankj.utilcode.util.LogUtils;
import com.hhj.merchant.api.AppService;
import com.hhj.merchant.bean.OrdersBean;
import com.hhj.merchant.ui.order.contract.OrderFinishContract;

import java.util.Map;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.order.presenter
 * @ClassName: FinishOrderPresenter
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/21 17:11
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/21 17:11
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderFinishPresenter extends BasePresenter<OrderFinishContract> {
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
}
