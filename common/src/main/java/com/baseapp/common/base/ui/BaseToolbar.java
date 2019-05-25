package com.baseapp.common.base.ui;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseapp.common.R;
import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.baserx.RxClickTransformer;
import com.baseapp.common.utils.UIUtils;
import com.blankj.utilcode.util.LogUtils;
import com.jakewharton.rxbinding2.view.RxView;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/3/27 0027.
 *
 * @Desc: Toolbar封装基类
 */

public abstract class BaseToolbar implements IToolbar {

    protected BaseActivity mActivity;
    private ImageView mLeftImage;
    private Toolbar default_toolbar;
    private Toolbar mToolbarView;
    private int background;
    private TextView mTitleText;
    private LinearLayout ll_left;
    private LinearLayout ll_right;
    private ImageView iv_left;
    private TextView tv_left_str;
    private ImageView iv_right;
    private TextView tv_right_str;

    public BaseToolbar(BaseActivity activity) {
        this.mActivity = activity;
    }

    /**
     * 对于使用默认布局的toolbar，继承该类的子类请谨慎重写该方法
     * 重写需要针对特定情境实现完成整逻辑
     *
     * @return
     */
    @Override
    public Toolbar getToolbar() {
        mToolbarView = (Toolbar) View.inflate(mActivity, R.layout.view_default_toolbar, null);

        default_toolbar = mToolbarView.findViewById(R.id.default_toolbar);
        mLeftImage = mToolbarView.findViewById(R.id.default_toolbar_left_image);
        mTitleText = mToolbarView.findViewById(R.id.default_toolbar_title);
        ll_left = mToolbarView.findViewById(R.id.ll_left);
        ll_right = mToolbarView.findViewById(R.id.ll_right);
        iv_left = mToolbarView.findViewById(R.id.iv_left);
        tv_left_str = mToolbarView.findViewById(R.id.tv_left_str);
        iv_right = mToolbarView.findViewById(R.id.iv_right);
        tv_right_str = mToolbarView.findViewById(R.id.tv_right_str);
        mActivity.setSupportActionBar(mToolbarView);
        mActivity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        Toolbar.LayoutParams params = new Toolbar.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT, UIUtils.getDimen(R.dimen.toolBarHeight));
        mToolbarView.setLayoutParams(params);
        switch (getToolbarConfig()) {
            case JUST_BACK:
                mLeftImage.setVisibility(View.VISIBLE);
                mTitleText.setVisibility(View.GONE);
                initBackImageListener();
                break;
            case JUST_TITLE:
                mLeftImage.setVisibility(View.GONE);
                mTitleText.setVisibility(View.VISIBLE);
                mTitleText.setText(getTitle());
                getTitleTextView(mTitleText);
                initTitleClickListener();
                break;
            case BACK_WITH_TITLE:
                mLeftImage.setVisibility(View.VISIBLE);
                mTitleText.setVisibility(View.VISIBLE);
                mTitleText.setText(getTitle());
                getTitleTextView(mTitleText);

                initBackImageListener();
                initTitleClickListener();
                break;
            case NORMAL:
                mLeftImage.setVisibility(View.VISIBLE);
                mTitleText.setVisibility(View.VISIBLE);
                mTitleText.setText(getTitle());
                getTitleTextView(mTitleText);
                initBackImageListener();
                initTitleClickListener();
                break;
        }
        if (background != 0) {
            mToolbarView.setBackgroundColor(background);
        }
        return mToolbarView;
    }

    @Override
    public void getTitleTextView(TextView mTitleTextView) {
    }


    /**
     * 标题点击空实现，有需要点击事件的界面重写该方法
     *
     * @param title
     */
    @Override
    public void onTitleClicked(String title) {

    }


    /**
     * 初始化返回按键点击事件
     */
    private void initBackImageListener() {
        RxView.
                clicks(mLeftImage).
                compose(RxClickTransformer.getClickTransformer()).
                subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        mActivity.onBackPressed();
                    }
                });

    }

    /**
     * 初始化标题点击事件
     */
    private void initTitleClickListener() {
        RxView.
                clicks(mTitleText).
                compose(RxClickTransformer.getClickTransformer()).
                subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        onTitleClicked(mTitleText.getText().toString());
                    }
                });
    }
    /**
     * 初始化右侧图标点击事件
     */
    private void initLeftClickListener() {
        RxView.
                clicks(ll_left).
                compose(RxClickTransformer.getClickTransformer()).
                subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        onLlLeftClicked();
                    }
                });
    }
    /**
     * 初始化右侧图标点击事件
     */
    private void initRightClickListener() {
        RxView.
                clicks(ll_right).
                compose(RxClickTransformer.getClickTransformer()).
                subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        onLlRightClicked();
                    }
                });
    }

    public BaseToolbar setBackground(int color) {
        background = color;
        return this;
    }
    public void setTitleText(String text) {
        mTitleText.setText(text);
    }
    public void setLeftVisibility(int visibility) {
        mLeftImage.setVisibility(View.GONE);
        ll_left.setVisibility(visibility);
        initLeftClickListener();
    }
    public void setRightVisibility(int visibility) {
        ll_right.setVisibility(visibility);
        initRightClickListener();
    }
    public void setLeftImage(int id) {
        iv_left.setImageResource(id);
    }

    public void setLeftTextView(String text) {
        tv_left_str.setText(text);
    }

    public void setRightImage(int id) {
        iv_right.setImageResource(id);
    }

    public void setRightTextView(String text) {
        tv_right_str.setText(text);
    }
}
