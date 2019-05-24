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
import com.baseapp.common.view.Global;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.hhj.merchant.R;
import com.hhj.merchant.ui.shop.contract.UpdatePhoneContract;
import com.hhj.merchant.ui.shop.presenter.UpdatePhonePresenter;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class UpdatePhoneActivity extends BaseActivity<UpdatePhonePresenter> implements UpdatePhoneContract {
    @BindView(R.id.et_telephone)
    EditText et_telephone;
    private Map<String, String> map;

    @Override
    protected IToolbar getIToolbar() {
        return new ToolbarBackTitle(this, "修改联系方式");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_update_phone;
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
        et_telephone.setHint(SPUtils.getInstance().getString(Global.TELEPHONE));
    }

    @Override
    protected void initNetWork(int pageIndex) {

    }

    @OnClick({R.id.tv_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_save:
                String telephone = et_telephone.getText().toString().trim();
                if (StringUtils.isEmpty(telephone)) {
                    ToastUtils.showShort("请输入联系方式");
                } else {
                    map = new HashMap<>();
                    map.put("telephone", telephone);
                    mPresenter.updateSellerPhone(map);
                }
                break;
        }
    }

    @Override
    public void updateSellerPhone(BaseBean bean) {
        ToastUtils.showShort("联系方式已更新");
        SPUtils.getInstance().put(Global.TELEPHONE, et_telephone.getText().toString().trim());
        finish();
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }
}
