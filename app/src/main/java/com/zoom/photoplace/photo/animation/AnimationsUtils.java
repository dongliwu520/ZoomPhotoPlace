package com.zoom.photoplace.photo.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;

import com.zoom.photoplace.photo.widget.HackyViewPager;

/**
 * 动画类
 * Created by wudongli on 2018/7/5.
 */

public class AnimationsUtils {

    private Rect startBounds;
    private AnimatorSet set;
    private int mShortAnimationDuration = 400;
    private float startScaleFinal;
    public View thumbView;
    private RelativeLayout rlViewPager,container;
    private HackyViewPager viewPager;
    private OnAnimationEndListener onAnimationEndListener = null;

    /**
     * 初始化动画
     * @param container 主页面父布局
     * @param rlViewPager ViewPager父布局
     * @param viewPager 需要使用的图片查看器viewpager
     */
    public AnimationsUtils(RelativeLayout container, RelativeLayout rlViewPager, HackyViewPager viewPager){
        this.container = container;
        this.rlViewPager = rlViewPager;
        this.viewPager = viewPager;
    }

    public void getImageLocation(final View ThumbView,boolean isClick){
        if (set != null) {
            set.cancel();
        }
        thumbView = ThumbView;
        startBounds = new Rect();
        final Rect finalBounds = new Rect();
        final Point globalOffset = new Point();
        thumbView.getGlobalVisibleRect(startBounds);
        container.getGlobalVisibleRect(finalBounds, globalOffset);//以屏幕 左上角 为参考系的
        float startScale;
        if ((float) finalBounds.width() / finalBounds.height() > (float) startBounds.width() / startBounds.height()) {

            startScale = (float) startBounds.height() / finalBounds.height();
            float startWidth = startScale * finalBounds.width();
            float deltaWidth = (startWidth - startBounds.width()) / 2;
            startBounds.left -= deltaWidth;
            startBounds.right += deltaWidth;
        } else {

            startScale = (float) startBounds.width() / finalBounds.width();
            float startHeight = startScale * finalBounds.height();
            float deltaHeight = (startHeight - startBounds.height()) / 2;
            startBounds.top -= deltaHeight;
            startBounds.bottom += deltaHeight;
        }
        thumbView.setAlpha(0f);
        //是否是recycleview的onItemClick事件 是的话就是true 需要加上动画
        if (isClick) {
            rlViewPager.setVisibility(View.VISIBLE);
            viewPager.setVisibility(View.VISIBLE);
            viewPager.setPivotX(0f);
            viewPager.setPivotY(0f);
            set = new AnimatorSet();
            set.play(ObjectAnimator.ofFloat(viewPager, View.X, startBounds.left, finalBounds.left))
                    .with(ObjectAnimator.ofFloat(viewPager, View.Y, startBounds.top, finalBounds.top))
                    .with(ObjectAnimator.ofFloat(viewPager, View.SCALE_X, startScale, 1f).setDuration(100))
                    .with(ObjectAnimator.ofFloat(viewPager, View.SCALE_Y, startScale, 1f).setDuration(100));
            set.setDuration(mShortAnimationDuration);
            set.setInterpolator(new DecelerateInterpolator());
            set.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    set = null;
                    if (onAnimationEndListener != null) {
                        onAnimationEndListener.StartAnimationEnd(animation);
                    }
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                    set = null;
                }
            });
            set.start();
        }
        startScaleFinal = startScale;
    }
    // 关掉动画
    public void closeAnims() {
        if (set != null) {
            set.cancel();
        }
        set = new AnimatorSet();
        set.play(ObjectAnimator.ofFloat(viewPager, View.X, startBounds.left))
                .with(ObjectAnimator.ofFloat(viewPager, View.Y, startBounds.top))
                .with(ObjectAnimator.ofFloat(viewPager, View.SCALE_X, startScaleFinal).setDuration(200))
                .with(ObjectAnimator.ofFloat(viewPager, View.SCALE_Y, startScaleFinal).setDuration(200));
        set.setDuration(mShortAnimationDuration);
        set.setInterpolator(new DecelerateInterpolator());
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                thumbView.setAlpha(1f);
                rlViewPager.setVisibility(View.GONE);
                viewPager.setVisibility(View.GONE);
                if (onAnimationEndListener != null) {
                    onAnimationEndListener.EndAnimationEnd(animation);
                }
                set = null;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                set = null;
            }
        });
        set.start();
    }
    public  interface OnAnimationEndListener{
        /**
         * 动画开始时结束监听
         * @param animation
         */
        void StartAnimationEnd(Animator animation);
        /**
         * 动画结束时结束监听
         * @param animation
         */
        void EndAnimationEnd(Animator animation);
    }
    public void setOnAnimationEndListener(OnAnimationEndListener onAnimationEndListener){

        this.onAnimationEndListener = onAnimationEndListener;

    }
}
