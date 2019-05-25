package com.hhj.merchant.ui.main.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.utility.ActivityManager;
import com.baseapp.common.utility.ToolbarBackTitle;
import com.baseapp.common.utils.UIUtils;
import com.baseapp.common.view.DialogWrapper;
import com.baseapp.common.view.Global;
import com.blankj.utilcode.util.SPUtils;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.SellernInfoBean;
import com.hhj.merchant.bean.TabEntity;
import com.hhj.merchant.ui.login.activity.LoginActivity;
import com.hhj.merchant.ui.main.contract.MainContract;
import com.hhj.merchant.ui.main.presenter.MainPresenter;
import com.hhj.merchant.ui.order.activity.OrderSearchActivity;
import com.hhj.merchant.ui.order.fragment.OrderFragment;
import com.hhj.merchant.ui.order.fragment.OrderListFragment;
import com.hhj.merchant.ui.shop.activity.SetActivity;
import com.hhj.merchant.ui.shop.fragment.ShopFragment;
import com.hhj.merchant.ui.wallet.fragment.WalletFragment;
import com.hhj.merchant.view.MyCommonTabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import cn.jpush.android.api.JPushInterface;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract {
    @BindView(R.id.myCommonTabLayout)
    MyCommonTabLayout myCommonTabLayout;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private String[] mTitles = {"订单", "钱包", "店铺"};
    private int[] mIconSelectIds = {
            R.mipmap.tabbar_home_selected, R.mipmap.tabbar_shopping_car_selected,
            R.mipmap.tabbar_my_selected};
    private int[] mIconUnselectIds = {
            R.mipmap.tabbar_home, R.mipmap.tabbar_shopping_car,
            R.mipmap.tabbar_my};
    private ToolbarBackTitle toolbarBackTitle;
    private int position = 0;
    private String accountType;
    private OrderListFragment fragment;
    private DialogWrapper.TipDialogBuilder mPermissionSettingDialogBuilder;
    private Dialog mDialog;

    @Override
    protected IToolbar getIToolbar() {
        toolbarBackTitle = new ToolbarBackTitle(this, "", new ToolbarBackTitle.ViewClick() {
            @Override
            public void onLlLeftClicked() {

            }

            @Override
            public void onLlRightClicked() {
                if (accountType.equals("3")) {
                    exitLogin();
                } else {
                    startActivity(OrderSearchActivity.class);
                }
            }
        });
        return toolbarBackTitle;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
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
    protected void onResume() {
        super.onResume();
        mPresenter.getSellerInfo();
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
                        if (mPermissionSettingDialogBuilder != null) {
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
                        JPushInterface.stopPush(MainActivity.this);
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
    protected void initView(@Nullable Bundle savedInstanceState) {
        initTitle(position);
        switch (accountType) {
            case "0":
                break;
            case "1":
                mTitles = new String[2];
                mTitles[0] = "钱包";
                mTitles[1] = "店铺";
                mIconSelectIds = new int[2];
                mIconSelectIds[0] = R.mipmap.tabbar_shopping_car_selected;
                mIconSelectIds[1] = R.mipmap.tabbar_my_selected;
                mIconUnselectIds = new int[2];
                mIconUnselectIds[0] = R.mipmap.tabbar_shopping_car;
                mIconUnselectIds[1] = R.mipmap.tabbar_my;
                mFragments.add(new WalletFragment());
                mFragments.add(new ShopFragment());
                break;
            case "2":
                mTitles = new String[2];
                mTitles[0] = "订单";
                mTitles[1] = "钱包";
                mIconSelectIds = new int[2];
                mIconSelectIds[0] = R.mipmap.tabbar_home_selected;
                mIconSelectIds[1] = R.mipmap.tabbar_shopping_car_selected;
                mIconUnselectIds = new int[2];
                mIconUnselectIds[0] = R.mipmap.tabbar_home;
                mIconUnselectIds[1] = R.mipmap.tabbar_shopping_car;
                mFragments.add(new OrderFragment());
                mFragments.add(new WalletFragment());
                break;
            case "3":
                mTitles = new String[1];
                mTitles[0] = "订单";
                mIconSelectIds = new int[1];
                mIconSelectIds[0] = R.mipmap.tabbar_home_selected;
                mIconUnselectIds = new int[1];
                mIconUnselectIds[0] = R.mipmap.tabbar_home;
                fragment = new OrderListFragment();
                Bundle bundle = new Bundle();
                bundle.putString("tag", "MainActivity");
                fragment.setArguments(bundle);
                mFragments.add(fragment);
                myCommonTabLayout.setVisibility(View.GONE);
                break;
        }
        mFragments.add(new OrderFragment());
        mFragments.add(new WalletFragment());
        mFragments.add(new ShopFragment());
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        myCommonTabLayout.setTabData(mTabEntities, this, R.id.mFrameLayout, mFragments);
        myCommonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                initTitle(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    private void initTitle(int position) {
        accountType = SPUtils.getInstance().getString(Global.ACCOUNTTYPE, "0");
        if (position == 0) {
            if (accountType.equals("1")) {
                toolbarBackTitle.setTitleText("数据中心");
                toolbarBackTitle.setLeftVisibility(View.GONE);
                toolbarBackTitle.setRightVisibility(View.GONE);
            } else if (accountType.equals("3")) {
                toolbarBackTitle.setTitleText(SPUtils.getInstance().getString(Global.SELLERNAME));
                toolbarBackTitle.setLeftVisibility(View.GONE);
                toolbarBackTitle.setRightVisibility(View.VISIBLE);
                toolbarBackTitle.setRightImage(R.mipmap.quit);
                toolbarBackTitle.setRightTextView("退出登录");
            } else {
                toolbarBackTitle.setTitleText(SPUtils.getInstance().getString(Global.SELLERNAME));
                toolbarBackTitle.setLeftVisibility(View.VISIBLE);
                toolbarBackTitle.setLeftImage(R.mipmap.saoma_icon);
                toolbarBackTitle.setLeftTextView("扫码核销");
                toolbarBackTitle.setRightVisibility(View.VISIBLE);
                toolbarBackTitle.setRightImage(R.mipmap.search_icon);
                toolbarBackTitle.setRightTextView("搜索");
            }
        } else if (position == 1) {
            if (accountType.equals("1")) {
                toolbarBackTitle.setTitleText("店铺管理");
                toolbarBackTitle.setLeftVisibility(View.GONE);
                toolbarBackTitle.setRightVisibility(View.GONE);
            } else {
                toolbarBackTitle.setTitleText("数据中心");
                toolbarBackTitle.setLeftVisibility(View.GONE);
                toolbarBackTitle.setRightVisibility(View.GONE);
            }
        } else if (position == 2) {
            toolbarBackTitle.setTitleText("店铺管理");
            toolbarBackTitle.setLeftVisibility(View.GONE);
            toolbarBackTitle.setRightVisibility(View.GONE);
        }
    }


    @Override
    public void getSellerInfo(SellernInfoBean bean) {
        SPUtils.getInstance().put(Global.SELLERNAME, bean.getSellerName());
        SPUtils.getInstance().put(Global.SELLERLOGO, bean.getSellerLogo());
        SPUtils.getInstance().put(Global.TELEPHONE, bean.getTelephone());
        SPUtils.getInstance().put(Global.BUSINESSTIME, bean.getBusinessTime());
        SPUtils.getInstance().put(Global.DELIVERYTIME, bean.getDeliveryTime());
        SPUtils.getInstance().put(Global.ISDEALER, bean.getIsDealer());
        SPUtils.getInstance().put(Global.LATITUDE, bean.getLatitude());
        SPUtils.getInstance().put(Global.LONGITUDE, bean.getLongitude());
        initTitle(position);
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        myCommonTabLayout.setCurrentTab(0);
        mPresenter.getSellerInfo();
    }
}
