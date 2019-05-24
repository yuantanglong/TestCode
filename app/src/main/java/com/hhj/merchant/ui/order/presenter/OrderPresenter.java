package com.hhj.merchant.ui.order.presenter;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BasePresenter;
import com.baseapp.common.baserx.RxSubscriber;
import com.baseapp.common.http.Api;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.http.mode.RequestMode;
import com.blankj.utilcode.util.LogUtils;
import com.hhj.merchant.api.AppService;
import com.hhj.merchant.bean.QueryCountBean;
import com.hhj.merchant.ui.order.contract.OrderContract;

import java.util.List;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.main.presenter
 * @ClassName: OrderPresenter
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/13 13:58
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/13 13:58
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderPresenter extends BasePresenter<OrderContract> {
    public void getQueryCount() {
        Api.
                observable(Api.getService(AppService.class).getQueryCount()).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<List<QueryCountBean>, BaseBean<List<QueryCountBean>>>() {
                    @Override
                    protected void _onSuccess(List<QueryCountBean> bean, String successMessage) {
                        mView.getQueryCount(bean);
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, List<QueryCountBean> bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }
}
