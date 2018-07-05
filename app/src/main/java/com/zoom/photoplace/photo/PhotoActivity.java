package com.zoom.photoplace;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
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
import com.zoom.photoplace.adapter.RecycleAdapter;
import com.zoom.photoplace.photo.PhotoView;
import com.zoom.photoplace.photo.PhotoViewAttacher;
import com.zoom.photoplace.widget.HackyViewPager;

public class MainActivity extends Activity implements View.OnClickListener{
    String[] data = {"http://imgsrc.baidu.com/imgad/pic/item/ac4bd11373f0820207282ceb41fbfbedaa641baf.jpg",
            "http://static.228.cn/upload/movie_api/new_movie_img/1142/photo/1142_46f402795533dec7cd84b01817e5e4854857861.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1142/photo/1142_af7dda06c925750b40033770ceb9342c1250646.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_9e302f42fae36c3cfef1f033ee91b969874219.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_be4b9baa8e6c59693006f338af37e858469477.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_97dfa5cac894bb3c89b9c4b151a73966224122.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_06695e8608db88bb97eb797cfbbbef5f959711.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_81cfd1b3b46076100534972685801ef6960871.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_dbb2f586e7ae9ec3c2f1f5de83bdc9871006611.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_1973e63cd84c436e6496305b79afc206890698.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_231a359bd06a4ed22caf54695e937c37961520.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_09cd41f603dcfd2362d19db895bf6afc888648.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_92ed979e46fc83b8a81a846c5f76baed914307.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_312b4de5565245096d939f57c53b861b853150.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_1dac4513cd26c8605413abff15dc5ebe267878.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_20c455645c49e5fd8d7fd324f9dee49c760899.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_1d2594392e33fc987dd96543742a7877599299.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_79e1588cef49d723815a5db5bbb162bb994143.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_19e03a53546ae8d006a38f3db2c000c61002562.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_cb55bbd0f7d74fd224b642bd1583c086582351.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_fa7132679dac28fa4d4927c60a68cb22353469.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_b4ed61198396e0fe511715f2d7166b9d451137.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_d5ce48a83e8fec8136ecee9caf0a7065912519.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_00f2404bddecadcef932127f58c8b69c838396.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_55d20f349dce5222e4a6e2fb23352fa35478798.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_e9244749427a6efc3c9d0ce78c3e7f946687868.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_ec2f63d714bfa4183052a2011653a1284397751.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_2274bb7687f21953a6c9a5f08e500f466366693.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_4f21139100da4213d7d7d9a4036ace215403905.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_85b187e9377e01adb1507485b518e3cf5319674.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_282fa3ed2eab81ddf59ec035dd479e045325330.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_4955761de2a94812cfe643630effd3794825203.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_2a632f91d81fb281830e75fea39ce9b06015641.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_f0e54ed45a856095bbbbc1109285f3824202273.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_21e3ee92d1dc61865a362f576eb5a79e98333.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_af4012c36a89062bad3fc4cda9bd909999439.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_5963e0232f4f094e294dafd0a4b554b3100517.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_14a67d353d09ef2dbb1923380072e95199449.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_29523f1d7982ff198b2dbe661dc5a0d2538932.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_e30f5b4400044efec2bfd8fc7683ddb214643138.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_90a7d0528ae2bb835e4c01ff068ce8793839584.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_80a8fbfa2278fef8b9f9a525984b08513712538.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_638cdad1f0edb8e2d4da02dda37feac3383037.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_13190b29d1aa9b0320ccb76f14c0a87512058133.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_c047d498d849971e663b45ced3e8813e787116.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1281/photo/1281_cb6d237d1fe95aac5f7183c394950ef6762535.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1219/photo/1219_41aa689394ef19f60b7f3b0a25721f4852087.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1219/photo/1219_7a0490a7fe0df6f00b84cdf4bc1ab886124330.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1219/photo/1219_cd83883c06522fda85f9c6323dbdc1ff121929.jpg",
            "https://static.228.cn/upload/movie_api/new_movie_img/1219/photo/1219_3e13c6f1ce2cdfc8b83867eb269f687e75632.jpg"
    };
    public RecyclerView gridView;
    private RecycleAdapter adapter;
    RelativeLayout rlTitle,rlViewPager,container;
    LinearLayout llBottomSave;
    TextView tvBackground;
    ViperPagerAdapter viewPagerAdapter;
    HackyViewPager viewPager;
    String url = "";
    ImageView title_back;
    int positon;
    private int mPosition = -1;
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

        LinearLayoutManager mLayoutManages = new LinearLayoutManager(this);
        mLayoutManages.setOrientation(OrientationHelper.VERTICAL);//设置滚动方向，横向滚动
        gridView.setLayoutManager(mLayoutManages);
        gridView.setLayoutManager(new GridLayoutManager(this, 4));
        adapter = new RecycleAdapter(this, data);
        gridView.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecycleAdapter.OnRecycleViewItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                mPosition = position;
                url = data[position];
                viewPager.setCurrentItem(position,false);
                getImageLocation(view,true);

            }
        });

        viewPagerAdapter = new ViperPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
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
                            thumbView.setAlpha(1f);
                            RecycleAdapter.MyViewHolder viewHolder = (RecycleAdapter.MyViewHolder) gridView.findViewHolderForAdapterPosition(positon);
                            if (viewHolder != null) {
                                getImageLocation(viewHolder.itemView,false);
                            }
                        }
                    },500);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                rlViewPager.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (rlViewPager.getVisibility() == View.VISIBLE) {
                            tvBackground.setVisibility(View.GONE);
                            closeAnims();
                        }
                    }
                }, 500);
                break;
        }
    }

    class ViperPagerAdapter extends PagerAdapter {

        Context mContext;
        public ViperPagerAdapter(Context context){
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
                    }else{
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
                    }else{
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
                        rlViewPager.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (rlViewPager.getVisibility() == View.VISIBLE) {
                                    tvBackground.setVisibility(View.GONE);
                                    closeAnims();
                                }
                            }
                        }, 500);
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

    private int mShortAnimationDuration = 400;
    private Rect startBounds;
    private float startScaleFinal;
    View thumbView;

    private void getImageLocation(final View ThumbView,boolean isClick){
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
                    tvBackground.setBackgroundColor(getResources().getColor(R.color.black));
                    tvBackground.setVisibility(View.VISIBLE);
                    tvBackground.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            rlTitle.setVisibility(View.VISIBLE);
                            llBottomSave.setVisibility(View.VISIBLE);
                        }
                    },500);
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
    AnimatorSet set;
    private void closeAnims() {
        rlTitle.setVisibility(View.GONE);
        llBottomSave.setVisibility(View.GONE);
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
                rlTitle.setVisibility(View.GONE);
                llBottomSave.setVisibility(View.GONE);
                tvBackground.setVisibility(View.GONE);
                set = null;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                thumbView.setAlpha(1f);
                rlViewPager.setVisibility(View.GONE);
                viewPager.setVisibility(View.GONE);
                rlTitle.setVisibility(View.GONE);
                llBottomSave.setVisibility(View.GONE);
                set = null;
            }
        });
        set.start();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (rlViewPager.getVisibility() == View.VISIBLE) {
                rlViewPager.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (rlViewPager.getVisibility() == View.VISIBLE) {
                            tvBackground.setVisibility(View.GONE);
                            closeAnims();
                        }
                    }
                }, 500);
                return true;
            }
            return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }
}
