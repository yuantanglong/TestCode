package com.hhj.merchant.ui.login.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.utility.ToolbarBackTitle;
import com.baseapp.common.utils.TimeCountDownHelper;
import com.baseapp.common.utils.UIUtils;
import com.baseapp.common.view.Global;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.LoginBean;
import com.hhj.merchant.ui.login.contract.LoginContract;
import com.hhj.merchant.ui.login.presenter.LoginPresenter;
import com.hhj.merchant.ui.main.activity.MainActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract {
    @BindView(R.id.strut)
    View strut;
    @BindView(R.id.tv_mobile_login)
    TextView tvMobileLogin;
    @BindView(R.id.line_view1)
    View lineView1;
    @BindView(R.id.line_view2)
    View lineView2;
    @BindView(R.id.tv_shop_code_login)
    TextView tv_shop_code_login;
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.iv_account_delete)
    ImageView ivAccountDelete;
    @BindView(R.id.ed_login_verification_code)
    EditText edLoginVerificationCode;
    @BindView(R.id.iv_delete_code)
    ImageView ivDeleteCode;
    @BindView(R.id.tv_getVerifyCode)
    TextView tvGetVerifyCode;
    @BindView(R.id.rl_code_view)
    RelativeLayout rlCodeView;
    @BindView(R.id.tv_str)
    TextView tvStr;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.iv_password_delete)
    ImageView ivPasswordDelete;
    @BindView(R.id.rl_password)
    RelativeLayout rlPassword;
    @BindView(R.id.cb_Remember_account)
    CheckBox cbRememberAccount;
    @BindView(R.id.cb_login_checkBox_agreement)
    CheckBox cbLoginCheckBoxAgreement;
    @BindView(R.id.tv_login_checkBox_agreement)
    TextView tvLoginCheckBoxAgreement;
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    String type = "2";
    boolean isSendCode = false;
    private Map<String, String> map;
    private TimeCountDownHelper mTimeCountDownHelper;
    private long mTime;
    private String sellerCode;

    @Override
    protected IToolbar getIToolbar() {
        return new ToolbarBackTitle(this, "登陆");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
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
        cbRememberAccount.setChecked(SPUtils.getInstance().getBoolean(Global.REMEMBER_ACCOUNT));
        type = SPUtils.getInstance().getString(Global.TYPE, "2");
        if (cbRememberAccount.isChecked()) {
            if (type.equals("1")) {
                initType(tv_shop_code_login, tvMobileLogin, "请输入本店编号(登陆账号)", View.GONE, View.VISIBLE);
                etAccount.setText(SPUtils.getInstance().getString(Global.ACCOUNT));
                etPassword.setText(SPUtils.getInstance().getString(Global.PASSWORD));
            } else if (type.equals("2")) {
                initType(tvMobileLogin, tv_shop_code_login, "请输入要绑定的登陆手机号", View.VISIBLE, View.GONE);
                etAccount.setText(SPUtils.getInstance().getString(Global.MOBILEPHONE));
            }
        }

    }

    @Override
    public void login(LoginBean bean) {
        if (cbRememberAccount.isChecked()) {
            SPUtils.getInstance().put(Global.REMEMBER_ACCOUNT, true);
            SPUtils.getInstance().put(Global.PASSWORD, etPassword.getText().toString().trim());
        }
        SPUtils.getInstance().put(Global.TYPE, type);
        SPUtils.getInstance().put(Global.ACCOUNT, bean.getSellerCode());
        SPUtils.getInstance().put(Global.ACCOUNTTYPE, bean.getAccountType());
        SPUtils.getInstance().put(Global.TOKEN, bean.getToken());
        SPUtils.getInstance().put(Global.SELLERCODE, bean.getSellerCode());
        SPUtils.getInstance().put(Global.SHOPCODE, bean.getSellerCode());
        SPUtils.getInstance().put(Global.MOBILEPHONE, bean.getMobilephone());
        SPUtils.getInstance().put(Global.ISLOGIN, true);
        startActivity(MainActivity.class);
        finish();
    }

    @Override
    public void getVerifyCode(BaseBean bean) {
        countDown();
        ToastUtils.showShort("验证码已发送，请查收");
    }

    @OnClick({R.id.tv_mobile_login, R.id.tv_shop_code_login, R.id.tv_getVerifyCode, R.id.tv_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_mobile_login:
                type = "2";
                initType(tvMobileLogin, tv_shop_code_login, "请输入要绑定的登陆手机号", View.VISIBLE, View.GONE);
                break;
            case R.id.tv_shop_code_login:
                type = "1";
                initType(tv_shop_code_login, tvMobileLogin, "请输入本店编号(登陆账号)", View.GONE, View.VISIBLE);
                break;
            case R.id.tv_getVerifyCode:
                sellerCode = etAccount.getText().toString().trim();
                if (type.equals("2") && StringUtils.isEmpty(sellerCode)) {
                    ToastUtils.showShort("请输入要绑定的登陆手机号");
                } else {
                    map = new HashMap<>();
                    map.put("mobilephone", type);
                    mPresenter.getVerifyCode(map);
                }
                break;
            case R.id.tv_login:
                sellerCode = etAccount.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String verifyCode = edLoginVerificationCode.getText().toString().trim();
                if (StringUtils.isEmpty(sellerCode)) {
                    if (type.equals("1")) {
                        ToastUtils.showShort("请输入本店编号(登陆账号)");
                    } else if (type.equals("2")) {
                        ToastUtils.showShort("请输入要绑定的登陆手机号");
                    }
                } else if (StringUtils.isEmpty(password) && type.equals("1")) {
                    ToastUtils.showShort("请输入密码");
                } else if (StringUtils.isEmpty(verifyCode) && type.equals("2")) {
                    ToastUtils.showShort("请输入验证码");
                } else if (!isSendCode && type.equals("2")) {
                    ToastUtils.showShort("请获取验证码");
                } else if (4 != verifyCode.length() && type.equals("2")) {
                    ToastUtils.showShort("请输入4位验证码");
                } else if (!cbLoginCheckBoxAgreement.isChecked()) {
                    ToastUtils.showShort("请同意协议");
                } else {
                    map = new HashMap<>();
                    map.put("type", type);
                    if (type.equals("1")) {
                        map.put("sellerCode", sellerCode);
                        map.put("password", password);
                    } else if (type.equals("2")) {
                        map.put("mobilephone", sellerCode);
                        map.put("verifyCode", verifyCode);
                    }
                    mPresenter.login(map);
                }
                break;
        }
    }

    private void initType(TextView tvMobileLogin, TextView tv_shop_code_login, String 请输入要绑定的登陆手机号, int visible, int gone) {
        tvMobileLogin.setTextColor(UIUtils.getColor(R.color.color_00A174));
        tv_shop_code_login.setTextColor(UIUtils.getColor(R.color.color_666666));
        etAccount.setHint(请输入要绑定的登陆手机号);
        lineView1.setVisibility(visible);
        lineView2.setVisibility(gone);
        rlCodeView.setVisibility(visible);
        tvStr.setVisibility(gone);
        rlPassword.setVisibility(gone);
    }

    /**
     * 倒计时
     */
    private void countDown() {
        if (mTimeCountDownHelper == null) {
            mTimeCountDownHelper = new TimeCountDownHelper();
            mTimeCountDownHelper.
                    countInterval(1000).
                    timeSpan(60).
                    timeUnit(TimeUnit.MILLISECONDS).
                    listener(new TimeCountDownHelper.TimeCountListener() {
                        @Override
                        public void onTimeCountDown(long time) {
                            mTime = time;
                            isSendCode = true;
                            tvGetVerifyCode.setEnabled(false);
                            tvGetVerifyCode.setText(time + "s后再次获取");
                            tvGetVerifyCode.setTextColor(UIUtils.getColor(R.color.color_666666));
                            if (mTime == 0) {
                                isSendCode = false;
                                tvGetVerifyCode.setEnabled(true);
                                tvGetVerifyCode.setText("获取验证码");
                                tvGetVerifyCode.setTextColor(UIUtils.getColor(R.color.color_00A174));
                            }
                        }
                    });
        }
        if (mTimeCountDownHelper != null) {
            mTimeCountDownHelper.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTimeCountDownHelper != null) {
            mTimeCountDownHelper.release();
        }
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }
}
