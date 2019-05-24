package com.hhj.merchant.ui.wallet.presenter;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BasePresenter;
import com.baseapp.common.baserx.RxSubscriber;
import com.baseapp.common.http.Api;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.http.mode.RequestMode;
import com.blankj.utilcode.util.LogUtils;
import com.hhj.merchant.api.AppService;
import com.hhj.merchant.bean.WalletFlowBean;
import com.hhj.merchant.bean.WalletInfoBean;
import com.hhj.merchant.ui.wallet.contract.WalletContract;

import java.util.Map;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.wallet.presenter
 * @ClassName: WalletPresenter
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/18 13:27
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/18 13:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class WalletPresenter extends BasePresenter<WalletContract> {

    public void getWalletInfo() {
        Api.
                observable(Api.getService(AppService.class).getWalletInfo()).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<WalletInfoBean, BaseBean<WalletInfoBean>>() {
                    @Override
                    protected void _onSuccess(WalletInfoBean bean, String successMessage) {
                        if (null != bean) {
                            mView.getWalletInfo(bean);
                        }
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, WalletInfoBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }

    public void getWalletFlow(Map<String, String> map) {
        Api.
                observable(Api.getService(AppService.class).getWalletFlow(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<WalletFlowBean, BaseBean<WalletFlowBean>>() {
                    @Override
                    protected void _onSuccess(WalletFlowBean bean, String successMessage) {
                        if (null != bean) {
                            mView.getWalletFlow(bean);
                        }
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, WalletFlowBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }
}
