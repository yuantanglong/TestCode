package com.hhj.merchant.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.hhj.merchant.R;

/*
 * @Author Liang Xuyang
 * created at 2017/6/9 0009 上午 9:57
 *
 * @Desc:可指定drawable宽和高的TextView，宽和高请使用自定义属性，指定drawable资源使用android原生属性
 * 警告：当自定义属性的宽和高都大于0时才生效
 */
public class DrawableResizableTextView extends AppCompatTextView {

    private int drawableWidth;
    private int drawableHeight;



    public DrawableResizableTextView(Context context) {
        super(context);
    }

    public DrawableResizableTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initCustomAttributes(context, attrs);
    }

    public DrawableResizableTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initCustomAttributes(context, attrs);
    }

    public void setDrawableWidth(int drawableWidth) {
        this.drawableWidth = drawableWidth;
    }

    public void setDrawableHeight(int drawableHeight) {
        this.drawableHeight = drawableHeight;
    }

    private void initCustomAttributes(Context context, @Nullable AttributeSet attrs){
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DrawableResizableTextView);
        drawableWidth = typedArray.getDimensionPixelSize(R.styleable.DrawableResizableTextView_drawableWidth, 0);  //未设定宽度默认为0
        drawableHeight = typedArray.getDimensionPixelSize(R.styleable.DrawableResizableTextView_drawableHeight, 0);  //未设定高度默认为0
        typedArray.recycle();

        Drawable[] mDrawables=getCompoundDrawables();
        setCompoundDrawablesWithIntrinsicBounds(mDrawables[0],mDrawables[1],mDrawables[2],mDrawables[3]);
    }

    @Override
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable left, @Nullable Drawable top, @Nullable Drawable right, @Nullable Drawable bottom) {

        if (drawableWidth==0||drawableHeight==0){
            super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
        }else {
            if (left != null) {
                left.setBounds(0, 0, drawableWidth, drawableHeight);
            }
            if (right != null) {
                right.setBounds(0, 0, drawableWidth, drawableHeight);
            }
            if (top != null) {
                top.setBounds(0, 0, drawableWidth, drawableHeight);
            }
            if (bottom != null) {
                bottom.setBounds(0, 0, drawableWidth, drawableHeight);
            }
            setCompoundDrawables(left, top, right, bottom);
        }
    }
}
