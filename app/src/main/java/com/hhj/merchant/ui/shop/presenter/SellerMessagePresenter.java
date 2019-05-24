package com.hhj.merchant.ui.shop.presenter;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BasePresenter;
import com.baseapp.common.baserx.RxSubscriber;
import com.baseapp.common.http.Api;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.http.mode.RequestMode;
import com.blankj.utilcode.util.LogUtils;
import com.hhj.merchant.api.AppService;
import com.hhj.merchant.bean.SellerMessageBean;
import com.hhj.merchant.ui.shop.contract.SellerMessageContract;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.shop.presenter
 * @ClassName: SellerMessagePresenter
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/18 17:13
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/18 17:13
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SellerMessagePresenter extends BasePresenter<SellerMessageContract> {
    public void getSellerMessage(Map<String, String> map) {
        Api.
                observable(Api.getService(AppService.class).getSellerMessage(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<List<SellerMessageBean>, BaseBean<List<SellerMessageBean>>>() {
                    @Override
                    protected void _onSuccess(List<SellerMessageBean> bean, String successMessage) {
                        mView.getSellerMessage(bean);
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, List<SellerMessageBean> bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }
}
