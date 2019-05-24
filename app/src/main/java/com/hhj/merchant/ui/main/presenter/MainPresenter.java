package com.hhj.merchant.ui.main.presenter;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BasePresenter;
import com.baseapp.common.baserx.RxSubscriber;
import com.baseapp.common.http.Api;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.http.mode.RequestMode;
import com.blankj.utilcode.util.LogUtils;
import com.hhj.merchant.api.AppService;
import com.hhj.merchant.bean.SellernInfoBean;
import com.hhj.merchant.ui.main.contract.MainContract;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.main.presenter
 * @ClassName: MainPresenter
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/14 18:57
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/14 18:57
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MainPresenter extends BasePresenter<MainContract> {
    public void getSellerInfo() {
        Api.
                observable(Api.getService(AppService.class).getSellerInfo()).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<SellernInfoBean, BaseBean<SellernInfoBean>>() {
                    @Override
                    protected void _onSuccess(SellernInfoBean bean, String successMessage) {
                        mView.getSellerInfo(bean);
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, SellernInfoBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }
}
