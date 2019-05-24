package com.baseapp.common.utility;

import com.baseapp.common.base.config.ToolbarConfig;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.base.ui.BaseToolbar;

/**
 * Created by Administrator on 2018/3/27 0027.
 *
 * @Desc: 只有返回按键的Toolbar封装
 */

public class ToolbarBackTitleLeftImageRightImage extends BaseToolbar {
    public String mTitle;
    public int leftImageView;
    public String leftTextView;
    public int rightImageView;
    public String rightTextView;
    ViewClick viewClick;

    public ToolbarBackTitleLeftImageRightImage(BaseActivity activity, String mTitle, int leftImageView, String leftTextView, int rightImageView, String rightTextView, ViewClick viewClick) {
        super(activity);
        this.mTitle = mTitle;
        this.leftImageView = leftImageView;
        this.leftTextView = leftTextView;
        this.rightImageView = rightImageView;
        this.rightTextView = rightTextView;
        this.viewClick = viewClick;
    }

    @Override
    public ToolbarConfig getToolbarConfig() {
        return ToolbarConfig.LEFT_TITLE_RIGHT;
    }

    @Override
    public String getTitle() {
        return mTitle;
    }


    @Override
    public void onLlLeftClicked() {
        viewClick.onLlLeftClicked();
    }

    @Override
    public void onLlRightClicked() {
        viewClick.onLlRightClicked();
    }

    public interface ViewClick {
        void onLlLeftClicked();

        void onLlRightClicked();
    }
}
