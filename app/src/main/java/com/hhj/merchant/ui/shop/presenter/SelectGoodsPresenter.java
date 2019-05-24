package com.hhj.merchant.ui.shop.presenter;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BasePresenter;
import com.baseapp.common.baserx.RxSubscriber;
import com.baseapp.common.http.Api;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.http.mode.RequestMode;
import com.blankj.utilcode.util.LogUtils;
import com.hhj.merchant.api.AppService;
import com.hhj.merchant.bean.ProductTypeBean;
import com.hhj.merchant.bean.SellerGoodsBean;
import com.hhj.merchant.ui.shop.contract.SelectGoodsContract;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.shop.presenter
 * @ClassName: SelectGoodsPresenter
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/22 13:43
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/22 13:43
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SelectGoodsPresenter extends BasePresenter<SelectGoodsContract> {
    public void getProductType() {
        Api.
                observable(Api.getService(AppService.class).getProductType()).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<List<ProductTypeBean>, BaseBean<List<ProductTypeBean>>>() {
                    @Override
                    protected void _onSuccess(List<ProductTypeBean> bean, String successMessage) {
                        mView.getProductType(bean);
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, List<ProductTypeBean> bean) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + bean);
                    }
                });
    }

    public void getSellerGoods(Map<String, String> map) {
        Api.
                observable(Api.getService(AppService.class).getSellerGoods(map)).
                presenter(this).
                requestMode(RequestMode.SINGLE).
                showLoading(true).
                doRequest(new RxSubscriber<List<SellerGoodsBean>, BaseBean<List<SellerGoodsBean>>>() {
                    @Override
                    protected void _onSuccess(List<SellerGoodsBean> list, String successMessage) {
                        mView.getSellerGoods(list);
                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, List<SellerGoodsBean> list) {
                        LogUtils.e("errorType==" + errorType + "==errorCode==" + errorCode + "==tokenBean==" + list);
                    }
                });
    }
}