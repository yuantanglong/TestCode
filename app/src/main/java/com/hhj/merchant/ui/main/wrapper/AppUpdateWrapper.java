package com.hhj.merchant.ui.main.wrapper;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BasePresenter;
import com.baseapp.common.base.BaseView;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.base.ui.BaseFragment;
import com.baseapp.common.baserx.RxClickTransformer;
import com.baseapp.common.baserx.RxSubscriber;
import com.baseapp.common.http.Api;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.http.mode.RequestMode;
import com.baseapp.common.utility.ActivityManager;
import com.baseapp.common.utils.AlerterUtils;
import com.baseapp.common.utils.PackageUtils;
import com.baseapp.common.utils.PathUitls;
import com.baseapp.common.utils.PermissionTipUtils;
import com.baseapp.common.view.CustomDialog;
import com.baseapp.common.view.DialogWrapper;
import com.baseapp.common.view.Global;
import com.baseapp.common.view.PermissionRationalDialog;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.hhj.merchant.R;
import com.hhj.merchant.api.AppService;
import com.hhj.merchant.bean.SysNewVersionBean;
import com.hhj.merchant.ui.main.activity.SplashActivity;
import com.jakewharton.rxbinding2.view.RxView;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.SettingService;

import java.io.File;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import zlc.season.rxdownload2.RxDownload;
import zlc.season.rxdownload2.entity.DownloadStatus;

/**
 * @company: 哈哈镜商户
 * created by {Android-Dev01} on 2018/4/14 0014 下午 8:25
 * @desc: App更新封装类，启动页和设置页面通用
 */

public class AppUpdateWrapper {

    private static final String UPDATE_TIP = "0"; //提示升级
    private static final String UPDATE_FORCE = "1"; //强制升级

    private Context mContext;
    private BaseActivity mActivity;
    private BaseFragment mFragment;
    private BasePresenter mPresenter;
    private OnGetVersionListener mOnGetVersionListener;
    private CustomDialog mUpdateAppDialog;
    private Dialog mDownloadAppDialog;
    private RxDownload mRxDownload;
    private Disposable mDownloadDisposable;

    private boolean shouldUpdate = false;
    private Dialog mPermissionSettingDialog;

    private boolean needRecheckVersion = false;
    private Disposable mDeleteDisposable;

    public interface OnGetVersionListener {
        void onGetVersion(String version, boolean onUpdateState);
    }

    public AppUpdateWrapper(BaseActivity activity) {
        this.mActivity = activity;
        mContext = activity;
        mPresenter = new BasePresenter() {
            @Override
            public void setVM(BaseView v) {
                super.setVM(v);
            }
        };

        mPresenter.setActivity(activity);
        mPresenter.setFragment(null);
    }

    public AppUpdateWrapper(BaseFragment fragment) {
        this.mFragment = fragment;
        mContext = fragment.getActivity();
        mPresenter = new BasePresenter() {
            @Override
            public void setVM(BaseView v) {
                super.setVM(v);
            }
        };

        mPresenter.setActivity(null);
        mPresenter.setFragment(fragment);
    }

    /**
     * 显示Alterer类型消息
     *
     * @param message
     */
    private void showAlerter(String message) {
        if (mActivity != null) {
            AlerterUtils.showErrorAlerter(mActivity, message);
        } else {
            AlerterUtils.showErrorAlerter(mFragment.getActivity(), message);
        }

    }

    public void setOnGetVersionListener(OnGetVersionListener listener) {
        this.mOnGetVersionListener = listener;
    }

    public void checkAppServerVersion(final boolean isShowDialog, final boolean isShowLading, Map<String, String> map) {
        needRecheckVersion = false;
        LogUtils.e("Update---开始请求");
        Api.
                observable(Api.getService(AppService.class).getSysNewVersion(map)).
                presenter(mPresenter).
                requestMode(RequestMode.SINGLE).
                showLoading(isShowLading).
                doRequest(new RxSubscriber<SysNewVersionBean, BaseBean<SysNewVersionBean>>() {

                    @Override
                    protected void _onSuccess(SysNewVersionBean data, String successMessage) {
                        LogUtils.e("Update---success");
                        String versionName = PackageUtils.getVersionName(mContext).replaceAll("\\.", "");
//                        if (BuildConfig.DEBUG) {
//                            versionName = versionName.substring(0, versionName.indexOf("-"));
//                        }
                        String number = data.getNumber();
                        if (StringUtils.isEmpty(number)) {
                            number = "0";
                        }
                        if (Integer.parseInt(number) <= Integer.parseInt(versionName)) {
                            if (mOnGetVersionListener != null) {
                                mOnGetVersionListener.onGetVersion(data.getNumber(), false);
                            }
                            delayToNext();
                        } else {
                            //检测到版本更新
                            if (mOnGetVersionListener != null) {
                                mOnGetVersionListener.onGetVersion(data.getNumber(), true);
                            }
                            if (isShowDialog) {
                                showUpdateAppDialog(data);
                            }
                        }
                        needRecheckVersion = false;

                    }

                    @Override
                    protected void _onError(ErrorType errorType, String errorCode, String message, SysNewVersionBean data) {
                        LogUtils.e("Update---failure");
                        needRecheckVersion = true;
                        if (mActivity instanceof SplashActivity) {
                            SplashActivity mSplashActivity = (SplashActivity) mActivity;
                            mSplashActivity.showRetryRequestDialog();
                        }
                    }
                });

    }


    private void showUpdateAppDialog(final SysNewVersionBean data) {

        String mUpdateContent = data.getUpdateContent();
        String mUpdateDesc = mUpdateContent.replace(",", "\n");

        boolean isOptional = true; //是否是非强制更新标志位，默认非强制更新

        if (UPDATE_FORCE == data.getIsForce()) {
            isOptional = false;
        } else {
            isOptional = true;
        }

        if (mUpdateAppDialog == null) {

            View mUpdateAppDialogView = View.inflate(mActivity, R.layout.dialog_update_app_layout, null);

            ImageView mCloseImage = mUpdateAppDialogView.findViewById(R.id.dialog_update_app_layout_close);
            TextView mMessageText = mUpdateAppDialogView.findViewById(R.id.dialog_update_app_layout_message);
            TextView mUpdateText = mUpdateAppDialogView.findViewById(R.id.dialog_update_app_layout_single_button);

            mMessageText.setText(mUpdateDesc);

            mCloseImage.setVisibility(isOptional ? View.VISIBLE : View.INVISIBLE);

            RxView.
                    clicks(mCloseImage).
                    compose(RxClickTransformer.getClickTransformer()).
                    subscribe(new Consumer<Object>() {
                        @Override
                        public void accept(Object o) throws Exception {
                            mUpdateAppDialog.dismiss();
                            delayToNext();
                        }
                    });

            RxView.
                    clicks(mUpdateText).
                    compose(RxClickTransformer.getClickTransformer()).
                    subscribe(new Consumer<Object>() {
                        @Override
                        public void accept(Object o) throws Exception {
                            mUpdateAppDialog.dismiss();

                            requestPermissionAndDownloadApp(data.getDownloadUrl());
                        }
                    });

            mUpdateAppDialog = (CustomDialog) DialogWrapper.
                    customViewDialog().
                    context(mContext).
                    contentView(mUpdateAppDialogView).
                    cancelable(false, false).
                    build();

//            mUpdateAppDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
//                @Override
//                public void onDismiss(DialogInterface dialog) {
//                    if (isUpdateOptional){
//                        delayToNext();
//                    }
//                }
//            });
        }

        mUpdateAppDialog.show();

    }

    /**
     * 请求权限进行App更新
     */
    private void requestPermissionAndDownloadApp(final String url) {

        AndPermission.
                with(mContext).
                permission(Permission.WRITE_EXTERNAL_STORAGE, Permission.READ_EXTERNAL_STORAGE).
                rationale(new PermissionRationalDialog()).
                onDenied(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {

                        if (AndPermission.hasAlwaysDeniedPermission(mContext, permissions)) {
                            List<String> permissionNames = Permission.transformText(mContext, permissions);
                            LogUtils.e("Permission---未通过" + permissionNames.get(0));

                            final SettingService mSettingService = AndPermission.permissionSetting(mContext);
                            mPermissionSettingDialog = DialogWrapper.
                                    tipDialog().
                                    context(mContext).
                                    buttonType(DialogWrapper.BUTTON_DOUBLE).
                                    title("权限提示").
                                    message(PermissionTipUtils.getTipMessage(permissionNames)).
                                    leftButtonText("放弃").
                                    rightButtonText("立即开启").
                                    buttonClickListener(new DialogWrapper.TipTypeButtonClickListener() {
                                        @Override
                                        public void onLeftButtonClicked(TextView view) {

                                            if (mPermissionSettingDialog != null) {
                                                mPermissionSettingDialog.dismiss();
                                            }

                                            mSettingService.cancel();
                                        }

                                        @Override
                                        public void onSingleButtonClicked(TextView view) {

                                        }

                                        @Override
                                        public void onRightButtonClicked(TextView view) {
                                            if (mPermissionSettingDialog != null) {
                                                mPermissionSettingDialog.dismiss();
                                            }
                                            mSettingService.execute();
                                        }
                                    }).
                                    build();

                            mPermissionSettingDialog.show();
                        } else {
                            ActivityManager.getInstance().AppExit();
                        }
                    }
                }).
                onGranted(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        LogUtils.e("Permission---授权通过");
                        if (mPermissionSettingDialog != null) {
                            mPermissionSettingDialog.dismiss();
                        }

                        deletePreviousApk(url);
                    }
                }).
                start();

    }


    private void deletePreviousApk(final String url) {
        //删除下载的安装包
        mActivity.showLoadingView();
        Observable.
                create(new ObservableOnSubscribe<Boolean>() {
                    @Override
                    public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
                        LogUtils.e("DeleteApk---" + "开始删除");
                        FileUtils.deleteAllInDir(PathUitls.getApkStorageDir());
//                        File mStorageFile = new File(PathUitls.getApkStorageDir());
//                        FileUtils.deleteAllInDir(mStorageFile);
                        emitter.onComplete();
                    }
                }).
                subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDeleteDisposable = d;
                    }

                    @Override
                    public void onNext(Boolean aBoolean) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        LogUtils.e("DeleteApk---" + "删除完成");
                        mActivity.dismissLoadingView();
                        showDownloadApkDialog(url);

                    }
                });
    }

    private void showDownloadApkDialog(String url) {

        View mDialogView = View.inflate(mContext, R.layout.dialog_download_app, null);
        ProgressBar mProgressBar = mDialogView.findViewById(R.id.dialog_download_app_progressbar);
        TextView mProgressText = mDialogView.findViewById(R.id.dialog_download_app_percent_text);
        TextView mValueText = mDialogView.findViewById(R.id.dialog_download_app_value_text);

        mDownloadAppDialog = DialogWrapper.
                customViewDialog().
                context(mContext).
                contentView(mDialogView).
                contentViewGravity(Gravity.CENTER).
                cancelable(false, false).
                build();

        LogUtils.e("Permission---" + "准备显示");
        mDownloadAppDialog.show();

        startDownloadApk(url, mProgressBar, mProgressText, mValueText);
    }


    private void startDownloadApk(final String url, final ProgressBar progressBar, final TextView progressText, final TextView valueText) {

        if (mRxDownload == null) {
            mRxDownload = RxDownload.getInstance(mContext).defaultSavePath(PathUitls.getApkStorageDir());
        }

        mDownloadDisposable = mRxDownload.
                download(url).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Consumer<DownloadStatus>() {  //下载进度
                    @Override
                    public void accept(@NonNull DownloadStatus downloadStatus) throws Exception {
                        progressBar.setMax((int) downloadStatus.getTotalSize());
                        progressBar.setProgress((int) downloadStatus.getDownloadSize());
                        progressText.setText(downloadStatus.getPercent());
                        valueText.setText(downloadStatus.getFormatDownloadSize() + "/" + downloadStatus.getFormatTotalSize());
                    }
                }, new Consumer<Throwable>() {  //下载失败
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mDownloadAppDialog.dismiss();
                    }
                }, new io.reactivex.functions.Action() {  //下载成功
                    @Override
                    public void run() throws Exception {
                        installApk(url);
                    }
                });

    }


    private void installApk(String url) {

        mDownloadAppDialog.dismiss();

        File[] files = mRxDownload.getRealFiles(url);
        if (files != null) {

            AppUtils.installApp(files[0], Global.FILE_PROVIDER_PATH);

//            Uri uri = null;
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                uri = FileProvider.getUriForFile(mContext, Config.FILE_PROVIDER_PATH, files[0]);
//            } else {
//                uri = Uri.fromFile(files[0]);
//            }
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            intent.setDataAndType(uri, "application/vnd.android.package-archive");
//            mContext.startActivity(intent);
        } else {
            showAlerter("哈哈镜商户更新失败");
        }
    }


    private void delayToNext() {
        if (mActivity instanceof SplashActivity) {
            SplashActivity mSplashActivity = (SplashActivity) mActivity;
            mSplashActivity.delayNavigateToNext();
        }
    }

    public boolean needRecheckVersion() {
        return needRecheckVersion;
    }

    public void onDestroy() {
        mPresenter.onDestroy();
        mContext = null;
        mActivity = null;
        mFragment = null;
        mPresenter = null;

        if (mDownloadDisposable != null && !mDownloadDisposable.isDisposed()) {
            mDownloadDisposable.dispose();
        }

        if (mDeleteDisposable != null && !mDeleteDisposable.isDisposed()) {
            mDeleteDisposable.dispose();
        }
    }
}
