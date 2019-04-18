package com.hhj.hhj_android_merchant.app;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.baseapp.common.BuildConfig;
import com.baseapp.common.base.BaseApplication;
import com.baseapp.common.http.Api;
import com.baseapp.common.http.config.ApiConfig;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.hhj_android_merchant.app
 * @ClassName: MyApplication
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/4/18 16:45
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/4/18 16:45
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MyApplication extends BaseApplication {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ApiConfig mApiConfig = new ApiConfig();
        mApiConfig.setHostServer(BuildConfig.HOST_SERVER);
//        mApiConfig.setReadTimeOut(BuildConfig.READ_TIME_OUT);
//        mApiConfig.setConnectTimeOut(BuildConfig.CONNECT_TIME_OUT);
        Api.setConfig(mApiConfig);
    }
}
