package com.hhj.merchant.ui.shop.presenter;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BasePresenter;
import com.baseapp.common.baserx.RxSubscriber;
import com.baseapp.common.http.Api;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.http.mode.RequestMode;
import com.blankj.utilcode.util.LogUtils;
import com.hhj.merchant.api.AppService;
import com.hhj.merchant.bean.SysNewVersionBean;
import com.hhj.merchant.ui.shop.contract.SetContract;

import java.util.Map;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.shop.presenter
 * @ClassName: SetPresenter
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/19 18:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/19 18:26
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SetPresenter extends BasePresenter<SetContract> {
    public void getSysNewVersion(Map<String, String> map) {
        Api.
                observable(Api.getService(AppService.class).getSysNewVersion(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<SysNewVersionBean, BaseBean<SysNewVersionBean>>() {
                    @Override
                    protected void _onSuccess(SysNewVersionBean bean, String successMessage) {
                        mView.getSysNewVersion(bean);
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, SysNewVersionBean bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }
}
