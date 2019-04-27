package com.hhj.hhj_android_merchant.ui.main.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.hhj.hhj_android_merchant.R;
import com.hhj.hhj_android_merchant.ui.login.activity.LoginActivity;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bingoogolapple.bgabanner.BGABanner;


/**
 * @author Administrator
 */
public class GuideActivity extends BaseActivity {
    @BindView(R.id.mBGABanner)
    BGABanner mBGABanner;

    @Override
    public int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    protected boolean enableSwipeBack() {
        return false;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        /*
          设置进入按钮和跳过按钮控件资源 id 及其点击事件
          如果进入按钮和跳过按钮有一个不存在的话就传 0
          在 BGABanner 里已经帮开发者处理了防止重复点击事件
          在 BGABanner 里已经帮开发者处理了「跳过按钮」和「进入按钮」的显示与隐藏
         */
        mBGABanner.setEnterSkipViewIdAndDelegate(R.id.linearLayout, R.id.tv_guide_skip, new BGABanner.GuideDelegate() {
            @Override
            public void onClickEnterOrSkip() {

            }
        });
        mBGABanner.setData(R.mipmap.guide_page1, R.mipmap.guide_page2, R.mipmap.guide_page3);
        mBGABanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    @OnClick({R.id.tv_register, R.id.tv_login, R.id.tv_guide_skip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_register:
                startActivity(LoginActivity.class);
                break;
            case R.id.tv_login:

                break;
            case R.id.tv_guide_skip:

                break;
        }
    }

    @Override
    protected IToolbar getIToolbar() {
        return null;
    }
}
