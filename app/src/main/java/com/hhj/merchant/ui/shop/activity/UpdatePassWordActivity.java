package com.hhj.merchant.ui.shop.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.utility.ToolbarBackTitle;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.hhj.merchant.R;
import com.hhj.merchant.ui.shop.contract.UpdatePassWordContract;
import com.hhj.merchant.ui.shop.presenter.UpdatePassWordPresenter;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class UpdatePassWordActivity extends BaseActivity<UpdatePassWordPresenter> implements UpdatePassWordContract {
    @BindView(R.id.et_password)
    EditText et_password;
    @BindView(R.id.et_newPassword)
    EditText et_newPassword;
    @BindView(R.id.et_again_newPassword)
    EditText et_again_newPassword;
    private Map<String, String> map;
    private String source;

    @Override
    protected IToolbar getIToolbar() {
        return new ToolbarBackTitle(this, "修改密码");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_update_pass_word;
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
        source = getIntent().getStringExtra("source");
    }

    @Override
    protected void initNetWork(int pageIndex) {

    }

    @OnClick({R.id.tv_confirmUpdate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_confirmUpdate:
                String password = et_password.getText().toString().trim();
                String newPassword = et_newPassword.getText().toString().trim();
                String again_newPassword = et_again_newPassword.getText().toString().trim();
                if (StringUtils.isEmpty(password)) {
                    ToastUtils.showShort("请输入旧密码");
                } else if (StringUtils.isEmpty(newPassword)) {
                    ToastUtils.showShort("请输入新密码");
                } else if (StringUtils.isEmpty(again_newPassword)) {
                    ToastUtils.showShort("请再次输入新密码");
                } else if (!newPassword.equals(again_newPassword)) {
                    ToastUtils.showShort("两次新密码不一致");
                } else {
                    map = new HashMap<>();
                    if ("SetActivity".equals(source)) {
                        map.put("password", password);
                        map.put("newPassword", newPassword);
                        mPresenter.updateSellerPassword(map);
                    } else if ("AddDeliveryClerkAndDetailsActivity".equals(source)) {
                        String id = getIntent().getStringExtra("id");
                        map.put("id", id);
                        map.put("newPasswd", newPassword);
                        map.put("requestType", "2");
                        mPresenter.modify(map);
                    }
                }
                break;
        }
    }

    @Override
    public void updateSellerPassword(BaseBean bean) {
        ToastUtils.showShort("密码已修改成功");
        finish();
    }

    @Override
    public void modify(BaseBean bean) {
        ToastUtils.showShort("密码已修改成功");
        finish();
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }
}
