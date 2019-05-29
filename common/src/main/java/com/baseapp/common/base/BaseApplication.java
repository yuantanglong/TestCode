package com.baseapp.common.base;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;

import com.baseapp.common.base.config.BaseConfig;
import com.baseapp.common.utils.PackageUtils;
import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.Utils;
import com.tencent.bugly.crashreport.CrashReport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * APPLICATION
 */
public class BaseApplication extends Application {

    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
        Utils.init(this);
        SPUtils.getInstance().put(BaseConfig.STATUS_BAR_HEIGHT, BarUtils.getStatusBarHeight());
        setBugly();
    }
    /**
     * Bugly相关配置
     */
    private void setBugly() {
        String packageName = getAppContext().getPackageName();
        String processName = getProcessName(android.os.Process.myPid());
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(getAppContext());
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
        strategy.setAppVersion(PackageUtils.getVersionName(getAppContext()) + "." + PackageUtils.getVersionCode(getAppContext()));
        CrashReport.initCrashReport(getAppContext(), "b40c32789d", false, strategy);
    }
    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    private static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }
    public static Context getAppContext() {
        return baseApplication;
    }
    public static Resources getAppResources() {
        return baseApplication.getResources();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }


    /**
     * 判断App是否是Debug版本
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isAppDebug() {
        if (TextUtils.isEmpty(getAppContext().getPackageName())) {
            return false;
        }
        try {
            PackageManager pm = getAppContext().getPackageManager();
            ApplicationInfo ai = pm.getApplicationInfo(getAppContext().getPackageName(), 0);
            return ai != null && (ai.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
