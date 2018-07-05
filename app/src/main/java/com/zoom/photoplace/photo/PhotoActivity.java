package com.zoom.photoplace.photo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zoom.photoplace.R;
import com.zoom.photoplace.data.Constants;
import com.zoom.photoplace.photo.adapter.RecycleAdapter;
import com.zoom.photoplace.photo.animation.AnimationsUtils;
import com.zoom.photoplace.photo.widget.photoview.PhotoView;
import com.zoom.photoplace.photo.widget.photoview.PhotoViewAttacher;
import com.zoom.photoplace.photo.widget.HackyViewPager;

public class PhotoActivity extends Activity implements View.OnClickListener {
    String[] data = Constants.PHOTO_DATA;
    public RecyclerView gridView;
    private RecycleAdapter adapter;
    RelativeLayout rlTitle, rlViewPager, container;
    LinearLayout llBottomSave;
    TextView tvBackground;
    ViperPagerAdapter viewPagerAdapter;
    HackyViewPager viewPager;
    String url = "";
    ImageView title_back;
    int positon;
    AnimationsUtils animationUtils = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (RecyclerView) findViewById(R.id.hl_films);
        rlTitle = (RelativeLayout) findViewById(R.id.rl_title);
        rlViewPager = (RelativeLayout) findViewById(R.id.rl_view_pager);
        container = (RelativeLayout) findViewById(R.id.container);
        llBottomSave = (LinearLayout) findViewById(R.id.ll_bottom_save);
        tvBackground = (TextView) findViewById(R.id.tv_background);
        viewPager = (HackyViewPager) findViewById(R.id.hlist_view_pager);
        title_back = (ImageView) findViewById(R.id.title_back);
        title_back.setOnClickListener(this);

        animationUtils = new AnimationsUtils(container, rlViewPager, viewPager);
        LinearLayoutManager mLayoutManages = new LinearLayoutManager(this);
        mLayoutManages.setOrientation(OrientationHelper.VERTICAL);//设置滚动方向，横向滚动
        gridView.setLayoutManager(mLayoutManages);
        gridView.setLayoutManager(new GridLayoutManager(this, 4));
        adapter = new RecycleAdapter(this, data);
        gridView.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecycleAdapter.OnRecycleViewItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                url = data[position];
                viewPager.setCurrentItem(position, false);
                animationUtils.getImageLocation(view, true);

            }
        });

        viewPagerAdapter = new ViperPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        initListener();

    }

    private void initListener() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {//当前选中的item
                positon = position;
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == 2) {
                    RecyclerView.LayoutManager layoutManager = gridView.getLayoutManager();
                    //判断是当前layoutManager是否为LinearLayoutManager
                    // 只有LinearLayoutManager才有查找第一个和最后一个可见view位置的方法
                    if (layoutManager instanceof LinearLayoutManager) {
                        LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
                        //获取最后一个可见view的位置
                        int lastItemPosition = linearManager.findLastVisibleItemPosition();
                        //获取第一个可见view的位置
                        int firstItemPosition = linearManager.findFirstVisibleItemPosition();
                        System.out.println(lastItemPosition + "   " + firstItemPosition);
                        if (data.length <= positon) {
                            gridView.smoothScrollToPosition(data.length - 1);
                        } else {
                            gridView.smoothScrollToPosition(positon + 6);
                        }
                    }
                    gridView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            animationUtils.thumbView.setAlpha(1f);
                            RecycleAdapter.MyViewHolder viewHolder = (RecycleAdapter.MyViewHolder) gridView.findViewHolderForAdapterPosition(positon);
                            if (viewHolder != null) {
                                animationUtils.getImageLocation(viewHolder.itemView, false);
                            }
                        }
                    }, 500);
                }
            }
        });
        animationUtils.setOnAnimationEndListener(new AnimationsUtils.OnAnimationEndListener() {
            @Override
            public void StartAnimationEnd(Animator animation) {
                if (animation != null) {
                    tvBackground.setBackgroundColor(getResources().getColor(R.color.black));
                    tvBackground.setVisibility(View.VISIBLE);
                    tvBackground.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            rlTitle.setVisibility(View.VISIBLE);
                            llBottomSave.setVisibility(View.VISIBLE);
                        }
                    }, 500);
                }
            }

            @Override
            public void EndAnimationEnd(Animator animation) {
                if (animation != null) {
                    rlTitle.setVisibility(View.GONE);
                    llBottomSave.setVisibility(View.GONE);
                    tvBackground.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_back:
                closeViewPager();
                break;
        }
    }

    class ViperPagerAdapter extends PagerAdapter {

        Context mContext;

        public ViperPagerAdapter(Context context) {
            this.mContext = context;
        }

        @Override
        public int getCount() {
            return data.length;
        }

        boolean isVisibility = true;

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public View instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(container.getContext());
            String path = data[position];
            Glide.with(container.getContext()).load(path).diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.mipmap.img_home_default_bg).error(R.mipmap.img_home_default_bg).into(photoView);
            photoView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
                @Override
                public void onPhotoTap(View view, float x, float y) {
                    if (isVisibility) {
                        rlTitle.setVisibility(View.GONE);
                        llBottomSave.setVisibility(View.GONE);
                    } else {
                        rlTitle.setVisibility(View.VISIBLE);
                        llBottomSave.setVisibility(View.VISIBLE);
                    }
                    isVisibility = !isVisibility;
                }
            });
            photoView.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
                @Override
                public void onViewTap(View view, float x, float y) {
                    if (isVisibility) {
                        rlTitle.setVisibility(View.GONE);
                        llBottomSave.setVisibility(View.GONE);
                    } else {
                        rlTitle.setVisibility(View.VISIBLE);
                        llBottomSave.setVisibility(View.VISIBLE);
                    }
                    isVisibility = !isVisibility;
                }
            });
            photoView.setOnGesturesSlidingListener(new PhotoViewAttacher.OnGesturesSlidingListener() {
                @Override
                public void OnGesturesSliding(Boolean isUp) {
                    if (rlViewPager.getVisibility() == View.VISIBLE) {
                        closeViewPager();
                    }
                }
            });
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

    /**
     * 关闭图片查看器Viewpager
     */
    private void closeViewPager() {
        rlTitle.setVisibility(View.GONE);
        llBottomSave.setVisibility(View.GONE);
        rlViewPager.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (rlViewPager.getVisibility() == View.VISIBLE) {
                    tvBackground.setVisibility(View.GONE);
                    animationUtils.closeAnims();
                }
            }
        }, 500);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (rlViewPager.getVisibility() == View.VISIBLE) {
                closeViewPager();
                return true;
            }
            return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }
}
