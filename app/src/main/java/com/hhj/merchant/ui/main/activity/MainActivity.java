package com.hhj.merchant.ui.main.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.utility.ToolbarBackTitle;
import com.baseapp.common.view.Global;
import com.blankj.utilcode.util.SPUtils;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.SellernInfoBean;
import com.hhj.merchant.bean.TabEntity;
import com.hhj.merchant.ui.main.contract.MainContract;
import com.hhj.merchant.ui.main.presenter.MainPresenter;
import com.hhj.merchant.ui.order.activity.OrderSearchActivity;
import com.hhj.merchant.ui.order.fragment.OrderFragment;
import com.hhj.merchant.ui.shop.fragment.ShopFragment;
import com.hhj.merchant.ui.wallet.fragment.WalletFragment;
import com.hhj.merchant.view.MyCommonTabLayout;

import java.util.ArrayList;

import butterknife.BindView;

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

    @Override
    protected IToolbar getIToolbar() {
        toolbarBackTitle = new ToolbarBackTitle(this, "", new ToolbarBackTitle.ViewClick() {
            @Override
            public void onLlLeftClicked() {

            }

            @Override
            public void onLlRightClicked() {
                startActivity(OrderSearchActivity.class);
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

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        initTitle(position);
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
        if (position == 0) {
            toolbarBackTitle.setTitleText(SPUtils.getInstance().getString(Global.SELLERNAME));
            toolbarBackTitle.setLeftVisibility(View.VISIBLE);
            toolbarBackTitle.setLeftImage(R.mipmap.saoma_icon);
            toolbarBackTitle.setLeftTextView("扫码核销");
            toolbarBackTitle.setRightVisibility(View.VISIBLE);
            toolbarBackTitle.setRightImage(R.mipmap.search_icon);
            toolbarBackTitle.setRightTextView("搜索");
        } else if (position == 1) {
            toolbarBackTitle.setTitleText("数据中心");
            toolbarBackTitle.setLeftVisibility(View.GONE);
            toolbarBackTitle.setRightVisibility(View.GONE);
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
}
