package com.zoom.photoplace.carousellayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zoom.photoplace.R;


/**
 * Created by xiexucheng on 2018/4/20.
 */

public class FilmTextView extends LinearLayout {

    public TextView tvNumView, tvOhterView;
    private int mTextColor = Color.RED;
    private int tvNumViewSize = 13;
    private int tvOhterViewSize = 10;
    private String tvNumViewText = "20";
    private String tvOhterViewText = "次";

    public FilmTextView(Context context) {
        this(context, null);
    }

    public FilmTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FilmTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public FilmTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        //设置横向
        setOrientation(HORIZONTAL);
        initView(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        //设置单位字体sp
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        tvNumViewSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, tvNumViewSize, dm);
        tvOhterViewSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, tvOhterViewSize, dm);

        //设置动态属性
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.FilmTextView);
        mTextColor = array.getColor(R.styleable.FilmTextView_ft_textColor, mTextColor);
        tvNumViewSize = array.getDimensionPixelSize(R.styleable.FilmTextView_ft_textNumViewSize, tvNumViewSize);
        tvOhterViewSize = array.getDimensionPixelSize(R.styleable.FilmTextView_ft_textOtherViewSize, tvOhterViewSize);
        tvNumViewText = array.getString(R.styleable.FilmTextView_ft_textNum);
        tvOhterViewText = array.getString(R.styleable.FilmTextView_ft_textOther);
        array.recycle(); //记得回收

        //设置父布局
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;

        tvNumView = new TextView(context);
        tvNumView.setLayoutParams(layoutParams);
        tvNumView.setTextColor(mTextColor);
        tvNumView.setText(tvNumViewText);
        tvNumView.setTextSize(TypedValue.COMPLEX_UNIT_SP, tvNumViewSize);

        tvOhterView = new TextView(context);
        tvOhterView.setLayoutParams(layoutParams);
        tvOhterView.setTextColor(mTextColor);
        tvOhterView.setText(tvOhterViewText);
        tvOhterView.setTextSize(TypedValue.COMPLEX_UNIT_SP, tvOhterViewSize);

        addView(tvNumView);
        addView(tvOhterView);
    }

    public void setTexts(String tvOneText,String tvTwoText){
        tvNumView.setText(tvOneText);
        tvOhterView.setText(tvTwoText);
    }
}
