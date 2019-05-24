package com.hhj.merchant.ui.shop.activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.utility.ActivityManager;
import com.baseapp.common.utility.ToolbarBackTitle;
import com.baseapp.common.utils.PackageUtils;
import com.baseapp.common.utils.UIUtils;
import com.baseapp.common.view.DialogWrapper;
import com.baseapp.common.view.Global;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.hhj.merchant.BuildConfig;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.SysNewVersionBean;
import com.hhj.merchant.ui.login.activity.LoginActivity;
import com.hhj.merchant.ui.main.wrapper.AppUpdateWrapper;
import com.hhj.merchant.ui.shop.contract.SetContract;
import com.hhj.merchant.ui.shop.presenter.SetPresenter;
import com.hhj.merchant.view.DrawableResizableTextView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;


public class SetActivity extends BaseActivity<SetPresenter> implements SetContract, AppUpdateWrapper.OnGetVersionListener {
    @BindView(R.id.tv_businessTime)
    TextView tv_businessTime;
    @BindView(R.id.tv_deliveryTime)
    TextView tv_deliveryTime;
    @BindView(R.id.tv_versionName)
    DrawableResizableTextView tv_versionName;
    @BindView(R.id.tv_versionInfo)
    TextView tv_versionInfo;
    private String versionName;
    private AppUpdateWrapper mAppUpdateWrapper;
    private Map<String, String> map;
    private Intent intent;
    private Dialog mDialog;
    private DialogWrapper.TipDialogBuilder mPermissionSettingDialogBuilder;

    @Override
    protected IToolbar getIToolbar() {
        return new ToolbarBackTitle(this, "设置");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set;
    }

    @Override
    protected boolean enableSwipeBack() {
        return false;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this);
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        tv_businessTime.setText(SPUtils.getInstance().getString(Global.BUSINESSTIME));
        tv_deliveryTime.setText(SPUtils.getInstance().getString(Global.DELIVERYTIME));
        versionName = PackageUtils.getVersionName(mContext);
        tv_versionName.setText("版本号V" + versionName);
    }

    @Override
    protected void initNetWork(int pageIndex) {
        checkAppVersion(false);
//        mPresenter.getSysNewVersion(map);
    }

    @OnClick({R.id.ll_UpdatePhone, R.id.ll_UpdatePassWord, R.id.ll_checkAppVersion, R.id.tv_exit_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_UpdatePhone:
                startActivity(UpdatePhoneActivity.class);
                break;
            case R.id.ll_UpdatePassWord:
                intent = new Intent(mContext, UpdatePassWordActivity.class);
                intent.putExtra("source", "SetActivity");
                startActivity(intent);
                break;
            case R.id.ll_checkAppVersion:
                checkAppVersion(true);
                break;
            case R.id.tv_exit_login:
                exitLogin();
                break;
        }
    }

    private void exitLogin() {
        //极光推送停止
        mPermissionSettingDialogBuilder = DialogWrapper.
                tipDialog().
                context(mContext).
                cancelable(false, false).
                buttonType(DialogWrapper.BUTTON_DOUBLE).
                title(UIUtils.getString(R.string.tip_logout_title)).
                message(UIUtils.getString(R.string.tip_logout_tip)).
                leftButtonText(UIUtils.getString(R.string.action_cancel)).
                rightButtonText(UIUtils.getString(R.string.action_ok)).
                buttonClickListener(new DialogWrapper.TipTypeButtonClickListener() {
                    @Override
                    public void onLeftButtonClicked(TextView view) {
                        if (mDialog != null) {
                            mDialog.dismiss();
                        }
                    }

                    @Override
                    public void onSingleButtonClicked(TextView view) {
                    }

                    @Override
                    public void onRightButtonClicked(TextView view) {
                        if (mDialog != null) {
                            mDialog.dismiss();
                        }
                        //极光推送停止
                        JPushInterface.stopPush(SetActivity.this);
                        SPUtils.getInstance().clear();
                        SPUtils.getInstance().put(Global.GUIDEFIRST, false);
                        SPUtils.getInstance().put(Global.ISLOGIN, false);
                        ActivityManager.getInstance().finishAllActivity();
                        startActivity(LoginActivity.class);
                    }
                });
        mDialog = mPermissionSettingDialogBuilder.build();
        mDialog.show();
    }

    @Override
    public void getSysNewVersion(SysNewVersionBean bean) {
        versionName = versionName.replaceAll("\\.", "");
        if (BuildConfig.DEBUG) {
            versionName = versionName.substring(0, versionName.indexOf("-"));
        }
        String number = bean.getNumber();
        if (StringUtils.isEmpty(number)) {
            number = "0";
        }
        if (Integer.parseInt(number) <= Integer.parseInt(versionName)) {
            tv_versionInfo.setText("已是最新版本");
        } else {
            tv_versionInfo.setText("有更新版本");
        }
    }

    /**
     * 检测版本信息
     */
    private void checkAppVersion(boolean isShowUpdateDialog) {
        map = new HashMap<>();
        map.put("source", "3");
        mAppUpdateWrapper = new AppUpdateWrapper(this);
        mAppUpdateWrapper.setOnGetVersionListener(this);
        mAppUpdateWrapper.checkAppServerVersion(isShowUpdateDialog, false, map);
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @Override
    public void onGetVersion(String version, boolean onUpdateState) {
        if (onUpdateState) {
            tv_versionInfo.setText("有更新版本");
        } else {
            tv_versionInfo.setText("已是最新版本");
        }
    }
}
