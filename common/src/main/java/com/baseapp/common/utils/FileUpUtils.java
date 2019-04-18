package com.baseapp.common.utils;


import android.content.Context;
import android.util.Log;

import com.baseapp.common.app.PublicService;
import com.baseapp.common.base.BasePresenter;
import com.baseapp.common.baserx.RxSchedulers;
import com.baseapp.common.baserx.RxSubscriber;
import com.baseapp.common.bean.UpLoadBean;
import com.baseapp.common.http.Api;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.http.mode.RequestMode;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.RequestBody;


/**
 * Created by Android-Dev05 on 2017/11/6.图片上传
 */

public class FileUpUtils {


    public static void FileUp(RequestBody filedata, final CallBackGlobal<UpLoadBean> callBackGlobal) {
        Api
                .getService(PublicService.class)
                .getImage(filedata)
                .compose(RxSchedulers.<UpLoadBean>io_main())
                .subscribe(new Observer<UpLoadBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UpLoadBean upLoadBean) {
                        if (upLoadBean != null) {
                            callBackGlobal.returnSuccess(upLoadBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public static void FileUpCertificate(BasePresenter basePresenter, Context mcontext, RequestBody filedata, final CallBackGlobal<UpLoadBean.DataBean> callBackGlobal) {

        Api
                .observable(Api.getService(PublicService.class).getImageCertificate(filedata))
                .presenter(basePresenter)
                .requestMode(RequestMode.SINGLE)
                .showLoading(true)
                .doRequest(new RxSubscriber<UpLoadBean.DataBean, UpLoadBean>() {
                    @Override
                    protected void _onSuccess(UpLoadBean.DataBean dataBean, String successMessage) {
                        if (dataBean != null) {
                            callBackGlobal.returnSuccess(dataBean);
                        }
                    }

                    @Override
                    protected void _onError(ErrorType errorType, int errorCode, String message, UpLoadBean.DataBean data) {
                        Log.e("TAG", "");
                    }
                });
    }

}
