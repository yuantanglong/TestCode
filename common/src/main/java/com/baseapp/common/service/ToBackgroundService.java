package com.baseapp.common.service;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.baseapp.common.R;
import com.baseapp.common.base.BaseApplication;
import com.baseapp.common.base.config.BaseConfig;
import com.baseapp.common.utility.ActivityManager;
import com.baseapp.common.utils.EncryptSPUtils;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/3/15 0015.
 *
 * @Desc: 监听App是否进入后台运行，如果进入后台，则给用户提示，出于安全设计如此做
 */
@Deprecated
public class ToBackgroundService extends Service {

    private boolean hasShowBackgroundTip = false;  //是否已经显示App进入后台的用户提示
    private Disposable mDisposable;
    private long mToBackGroundTime;
    /**
     * <p>是否启动验证页面，当app不可见时（退出在桌面、切换到其他app）<p/>
     * <p>-1：不启动<p/>
     * <p>0：启动手势验证<p/>
     * <p>1：启动登录验证<p/>
     */
//    private int isLaunchVerifyActivity = -1;

    @Override
    public void onCreate() {
        super.onCreate();
        hasShowBackgroundTip = false;
        observeWhetherAppIsOnBackground();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        releaseRxJava();
    }

    /**
     * 监听App是否在后台运行
     */
    private void observeWhetherAppIsOnBackground() {

        mDisposable = Observable.
                interval(300, TimeUnit.MILLISECONDS).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if (AppUtils.isAppForeground()) {
                            //App前台运行
                            hasShowBackgroundTip = false;
//                            if (isLaunchVerifyActivity == -1) {
//                                //do nothing
//                            } else if (isLaunchVerifyActivity == 0) {
//                                //使用ProxyActivity类时，可避免被外部App调用
////                                Intent intent = new Intent(getBaseContext(), ProxyActivity.class);
////                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////                                intent.putExtra(ProxyActivity.PROXY_FRAGMENT_NAME, "com.coolbit.wallet.ui.mine.fragment.AuthorizeLoginFragment");
////                                startActivity(intent);
//
//                                //配置文件已加入exported属性，允许外部App调用此AuthorizeLoginActivity
//                                Intent intent = new Intent();
//                                intent.setComponent(new ComponentName("com.coolbit.wallet", "com.coolbit.wallet.ui.mine.activity.AuthorizeLoginActivity"));
//                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                startActivity(intent);
//
//                                isLaunchVerifyActivity = -1;
//                            } else if (isLaunchVerifyActivity == 1) {
//                                //配置文件已加入exported属性，允许外部App调用此LoginActivity
//
//                                ActivityManager.getInstance().finishAllActivity();
//                                Intent intent = new Intent();
//                                intent.setComponent(new ComponentName("com.coolbit.wallet", "com.coolbit.wallet.ui.login.activity.LoginActivity"));
//                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                startActivity(intent);
//                                isLaunchVerifyActivity = -1;
//                            }
                        } else {
                            //App后台运行
                            if (!hasShowBackgroundTip) {
                                mToBackGroundTime = System.currentTimeMillis();
                                hasShowBackgroundTip = true;
                                LogUtils.e("CoolBit进入后台运行");
                                ToastUtils.showLong(BaseApplication.getAppContext().getResources().getString(R.string.app_run_into_background));
                            } else {
                                backgroundJudgeFunc();
                            }
                        }
                    }
                });

    }

    /**
     * 判断运行在后台，是否在打开时弹出验证页面
     */
    private void backgroundJudgeFunc() {
        long mTimeInterval = System.currentTimeMillis() - mToBackGroundTime;
        int hour3 = 10800000;
        int minute5 = 300000;
//        int minute5 = 5000;
        //如果小于5分钟
        if (mTimeInterval <= minute5) {
            //do nothing
        } else if (mTimeInterval > minute5 && mTimeInterval <= hour3) {
            String token = EncryptSPUtils.getSharedStringData(BaseApplication.getAppContext(),BaseConfig.BaseSPKey.TOKEN);
            if (!TextUtils.isEmpty(token)) {
                String activityName = null;
                //如果没有绑定过资金密码，况且还没有设置过手势密码
                if (ActivityManager.getInstance().getActivityStack() != null && ActivityManager.getInstance().getActivityStack().size() > 0) {
                    Activity mActivity = ActivityManager.getInstance().getActivityStack().get(ActivityManager.getInstance().getActivityStack().size() - 1);
                    if (mActivity != null){
                        activityName = mActivity.getClass().getSimpleName();
                    }else {
                        SPUtils.getInstance().put(BaseConfig.RebackConfig.APP_IS_NEED_TO_VERIFY_WHEN_RESTART_NEXT, 1);
                    }
                }else {
                    SPUtils.getInstance().put(BaseConfig.RebackConfig.APP_IS_NEED_TO_VERIFY_WHEN_RESTART_NEXT, 1);
                }
                //如果当前顶层Activity是如下几个之一，那么不做操作
                if ("ProxyActivity".equals(activityName)
                        ||
                        "LoginActivity".equals(activityName)
                        ||
                        "LaunchActivity".equals(activityName)
                        ||
                        "VerifyActivity".equals(activityName)
                        ||
                        "GlobalLoginOutActivity".equals(activityName)
                        ||
                        "AuthorizeLoginActivity".equals(activityName)
                        ||
                        "GuideActivity".equals(activityName)) {
//                    isLaunchVerifyActivity = -1;
                    SPUtils.getInstance().put(BaseConfig.RebackConfig.APP_IS_NEED_TO_VERIFY_WHEN_RESTART_NEXT, -1);

                } else {
                    //否则，判断是否有手势密码，如果有手势密码，则跳转到手势验证。否则跳转到重新登录
                    if (SPUtils.getInstance().getInt(BaseConfig.BaseSPKey.USER_GESTURE_STATE) == 1
                            &&
                        SPUtils.getInstance().getInt(BaseConfig.BaseSPKey.USER_GESTURE_BIND_STATE) == 1) {
                        //已绑定了手势密码并启用
//                        isLaunchVerifyActivity = 0;
                        SPUtils.getInstance().put(BaseConfig.RebackConfig.APP_IS_NEED_TO_VERIFY_WHEN_RESTART_NEXT, 0);
                    } else {
//                        isLaunchVerifyActivity = 1;
                        SPUtils.getInstance().put(BaseConfig.RebackConfig.APP_IS_NEED_TO_VERIFY_WHEN_RESTART_NEXT, 1);
                    }
                }
            } else {
                //没有登录
//                isLaunchVerifyActivity = -1;
                SPUtils.getInstance().put(BaseConfig.RebackConfig.APP_IS_NEED_TO_VERIFY_WHEN_RESTART_NEXT, -1);

            }
        } else if (mTimeInterval > hour3) {
//            isLaunchVerifyActivity = 1;
            SPUtils.getInstance().put(BaseConfig.RebackConfig.APP_IS_NEED_TO_VERIFY_WHEN_RESTART_NEXT, 1);

        }


    }

    /**
     * RxJava解除订阅
     */
    private void releaseRxJava() {
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }


}
