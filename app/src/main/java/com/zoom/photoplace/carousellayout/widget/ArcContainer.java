package com.zoom.photoplace.carousellayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.zoom.photoplace.R;
import com.zoom.photoplace.carousellayout.util.DeviceUtils;

public class ArcContainer extends RelativeLayout {

    Context mContext;

    Path mClipPath;

    int width = 0;
    int height = 0;
    public float ARC_HERIGT = 50f;
    Paint mPaint;
    private PorterDuffXfermode porterDuffXfermode;

    public void setOrignalHeight(int orignalHeight) {
        this.orignalHeight = orignalHeight;
    }

    private float orignalHeight;
    private boolean firstGetHeight = true;

    public ArcContainer(Context context) {
        super(context);
        init(context, null);
    }

    public ArcContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    int screenWidth;

    private void init(Context context, AttributeSet attrs) {
        mContext = context;
        screenWidth = DeviceUtils.getScreenWidth(context);
        porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.WHITE);
        mClipPath = new Path();
        if (attrs != null) {
            TypedArray tArray = context.obtainStyledAttributes(attrs,
                    R.styleable.ArcContainer);
            orignalHeight = tArray.getDimension(R.styleable.ArcContainer_orignalHeight, (float) ((screenWidth / 2.46) - ARC_HERIGT));
            ARC_HERIGT = tArray.getDimension(R.styleable.ArcContainer_arc_height, 50f);
        }
    }

    public int getOrignalHeight() {
        return (int) orignalHeight;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        mClipPath.rewind();
        mClipPath.moveTo(0, orignalHeight);
        mClipPath.cubicTo(0, orignalHeight, width / 2, orignalHeight + 2.0f * (height - orignalHeight), width, orignalHeight);
        mClipPath.lineTo(width, height);
        mClipPath.lineTo(0, height);
        mClipPath.close();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {

        int saveCount = canvas.saveLayer(0, 0, getMeasuredWidth(), getMeasuredHeight(), null, Canvas.ALL_SAVE_FLAG);
        super.dispatchDraw(canvas);
        mPaint.setXfermode(porterDuffXfermode);
        canvas.drawPath(mClipPath, mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(saveCount);
    }
}
