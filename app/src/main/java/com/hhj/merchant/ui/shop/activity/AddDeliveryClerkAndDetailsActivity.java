package com.hhj.merchant.ui.shop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.http.Api;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.utility.ToolbarBackTitle;
import com.baseapp.common.utils.FormatUtil;
import com.baseapp.common.utils.GlideUtils;
import com.baseapp.common.utils.TimeCountDownUtil;
import com.baseapp.common.utils.UIUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.GetListBean;
import com.hhj.merchant.ui.shop.contract.AddDeliveryClerkAndDetailsContract;
import com.hhj.merchant.ui.shop.presenter.AddDeliveryClerkAndDetailsPresenter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;

public class AddDeliveryClerkAndDetailsActivity extends BaseActivity<AddDeliveryClerkAndDetailsPresenter> implements AddDeliveryClerkAndDetailsContract {
    @BindView(R.id.iv_avatar)
    ImageView iv_avatar;
    @BindView(R.id.et_name)
    EditText et_name;
    @BindView(R.id.et_mobile)
    EditText et_mobile;
    @BindView(R.id.et_password)
    EditText et_password;
    @BindView(R.id.et_confirm_password)
    EditText et_confirm_password;
    @BindView(R.id.ll_UpdatePassWord)
    LinearLayout ll_UpdatePassWord;
    @BindView(R.id.ll_add_view)
    LinearLayout ll_add_view;
    @BindView(R.id.et_verifyCode)
    EditText et_verifyCode;
    @BindView(R.id.tv_send_code)
    TextView tv_send_code;
    private String type;
    private GetListBean.NativePeopleBean nativePeopleBean;
    private String mobile;
    private boolean isSendCode = false;
    private Map<String, String> map;
    private Intent intent;
    private TimeCountDownUtil.Builder listener;

    @Override
    protected IToolbar getIToolbar() {
        type = getIntent().getStringExtra("type");
        String title = "";
        if (type.equals("add")) {
            title = "添加配送员";
        } else if (type.equals("details")) {
            title = "配送员管理";
        }
        return new ToolbarBackTitle(this, title);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_delivery_clerk_and_details;
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
        type = getIntent().getStringExtra("type");
        if (type.equals("details")) {
            ll_UpdatePassWord.setVisibility(View.VISIBLE);
            ll_add_view.setVisibility(View.GONE);
            nativePeopleBean = (GetListBean.NativePeopleBean) getIntent().getSerializableExtra("nativePeopleBean");
            GlideUtils.loadImage(mContext, Api.getmApiConfig().getmHostImgBase() + nativePeopleBean.getAvatar(), R.mipmap.head, R.mipmap.head, iv_avatar);
            et_name.setText(nativePeopleBean.getName());
            et_name.setFocusable(false);
            et_name.setFocusableInTouchMode(false);
            et_mobile.setText(nativePeopleBean.getMobile());
            et_mobile.setFocusable(false);
            et_mobile.setFocusableInTouchMode(false);
        }
    }

    @Override
    protected void initNetWork(int pageIndex) {

    }

    @OnClick({R.id.ll_UpdatePassWord, R.id.tv_send_code, R.id.tv_confirm_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_UpdatePassWord:
                intent = new Intent(mContext, UpdatePassWordActivity.class);
                intent.putExtra("source", "AddDeliveryClerkAndDetailsActivity");
                intent.putExtra("id", nativePeopleBean.getId());
                startActivity(intent);
                break;
            case R.id.tv_send_code:
                mobile = et_mobile.getText().toString().trim();
                if (StringUtils.isEmpty(mobile)) {
                    ToastUtils.showShort("请输入手机号");
                } else if (!FormatUtil.isMobileNO(mobile)) {
                    ToastUtils.showShort("请输入正确手机号!");
                } else {
                    map = new HashMap<>();
                    map.put("mobile", mobile);
                    mPresenter.getDeliveryVerifyCode(map);
                }

                break;
            case R.id.tv_confirm_add:
                String name = et_name.getText().toString().trim();
                mobile = et_mobile.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                String confirm_password = et_confirm_password.getText().toString().trim();
                String verifyCode = et_verifyCode.getText().toString().trim();
                if (StringUtils.isEmpty(name)) {
                    ToastUtils.showShort("请输入姓名");
                } else if (StringUtils.isEmpty(mobile)) {
                    ToastUtils.showShort("请输入手机号");
                } else if (StringUtils.isEmpty(password)) {
                    ToastUtils.showShort("请输入初始密码");
                } else if (StringUtils.isEmpty(confirm_password)) {
                    ToastUtils.showShort("请输入确认密码");
                } else if (!password.equals(confirm_password)) {
                    ToastUtils.showShort("两次密码不一致");
                } else if (StringUtils.isEmpty(verifyCode)) {
                    ToastUtils.showShort("请输入验证码");
                } else if (!isSendCode) {
                    ToastUtils.showShort("请获取验证码");
                } else if (verifyCode.length() < 4) {
                    ToastUtils.showShort("验证码位数不正确");
                } else {
                    map = new HashMap<>();
                    map.put("name", name);
                    map.put("mobile", mobile);
                    map.put("verifyCode", verifyCode);
                    map.put("newPasswd", password);
                    map.put("passwd", password);
                    mPresenter.create(map);
                }
                break;
        }
    }

    @Override
    public void getDeliveryVerifyCode(BaseBean bean) {
        ToastUtils.showShort("验证码已发送，请查收!");
        listener = TimeCountDownUtil.
                builder().
                timeSpan(60).
                timeUnit(TimeUnit.MILLISECONDS).
                countInterval(1000).
                listener(new TimeCountDownUtil.TimeCountListener() {
                    @Override
                    public void onTimeCountDown(long time) {
                        isSendCode = true;
                        tv_send_code.setEnabled(false);
                        tv_send_code.setText(time + "s后再次获取");
                        tv_send_code.setTextColor(UIUtils.getColor(R.color.color_666666));
                        if (time == 0) {
                            isSendCode = false;
                            tv_send_code.setEnabled(true);
                            tv_send_code.setText("获取验证码");
                            tv_send_code.setTextColor(UIUtils.getColor(R.color.color_00A174));
                        }
                    }
                });
        listener.start();
    }

    @Override
    public void create(BaseBean bean) {
        ToastUtils.showShort("添加成功");
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        TimeCountDownUtil.release();
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }
}
