package com.hhj.merchant.ui.main.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.config.BaseConfig;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.utility.ActivityManager;
import com.baseapp.common.utils.UIUtils;
import com.baseapp.common.view.CustomDialog;
import com.baseapp.common.view.DialogWrapper;
import com.baseapp.common.view.Global;
import com.blankj.utilcode.util.SPUtils;
import com.hhj.merchant.R;
import com.hhj.merchant.ui.login.activity.LoginActivity;
import com.hhj.merchant.ui.main.wrapper.AppUpdateWrapper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class SplashActivity extends BaseActivity {
    private AppUpdateWrapper mAppUpdateWrapper;
    private Map<String, String> map;
    private Disposable mDelayDisposable;
    private CustomDialog mRetryDialog;

    @Override
    protected IToolbar getIToolbar() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected boolean enableSwipeBack() {
        return false;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        setCheckBackgroundState(false);
        mAppUpdateWrapper = new AppUpdateWrapper(this);
        initCheckAppServerVersion();
    }

    private void initCheckAppServerVersion() {
        map = new HashMap<>();
        map.put("source", "3");
        mAppUpdateWrapper.checkAppServerVersion(true, true, map);
    }

    @Override
    protected void initBeforeSetContentView() {
        super.initBeforeSetContentView();
        if (!isTaskRoot()) {
            //解决点击home键，app进入后台，再点击icon，app重新启动的问题。（只是重新实例化了启动页添加到了任务栈，此处直接finish掉）
            ActivityManager.getInstance().finishSpecificActivity(this);
        }

        SPUtils.getInstance().put(BaseConfig.RebackConfig.APP_TO_BACKGROUND_TIME, -1L);
    }

    public void showRetryRequestDialog() {
        delayNavigateToNext();
//        if (mRetryDialog == null) {
//            mRetryDialog = (CustomDialog) DialogWrapper.
//                    tipDialog().
//                    context(this).
//                    title(UIUtils.getString(R.string.tip)).
//                    closeImageVisible(false).
//                    message(UIUtils.getString(R.string.app_download_retry)).
//                    buttonType(DialogWrapper.BUTTON_SINGLE).
//                    singleButtonText(UIUtils.getString(R.string.retry)).
//                    buttonClickListener(new DialogWrapper.TipTypeButtonClickListener() {
//                        @Override
//                        public void onLeftButtonClicked(TextView view) {
//
//                        }
//
//                        @Override
//                        public void onSingleButtonClicked(TextView view) {
//                            mRetryDialog.dismiss();
//                            initCheckAppServerVersion();
//                        }
//
//                        @Override
//                        public void onRightButtonClicked(TextView view) {
//
//                        }
//                    }).
//                    build();
//        }
//
//        mRetryDialog.show();
    }

    public void delayNavigateToNext() {

        Observable.
                empty().
                delay(200, TimeUnit.MILLISECONDS).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDelayDisposable = d;
                    }

                    @Override
                    public void onNext(Object o) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        startNextActivity();
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAppUpdateWrapper.onDestroy();
        if (mDelayDisposable != null && !mDelayDisposable.isDisposed()) {
            mDelayDisposable.dispose();
        }
    }

    private void startNextActivity() {
        boolean mGuideFirst = SPUtils.getInstance().getBoolean(Global.GUIDEFIRST, true);
        if (mGuideFirst) {
            SPUtils.getInstance().put(Global.GUIDEFIRST, false);
            startActivity(GuideActivity.class);
        } else {
            boolean isSuccess = SPUtils.getInstance().getBoolean(Global.ISLOGIN, false);
            if (isSuccess) {
                startActivity(MainActivity.class);
            } else {
                startActivity(LoginActivity.class);
            }
        }
        finish();
    }
}
