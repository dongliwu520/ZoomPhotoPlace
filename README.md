# ZoomPhotoPlace
-----
本项目是仿微博及猫眼查看图片的动画效果，使用viewpager查看图片放大，可以报道查看当前回到图片位置 
<br>
<div>
## 图片效果

<br>
<img width="270" height="480" src="https://github.com/dongliwu520/ZoomPhotoPlace/blob/master/ezgif.com-optimize.gif"/>
</div>

## 初始化动画
```java
animationUtils = new AnimationsUtils(container, rlViewPager, viewPager);
```

## 触发动画
```java
//第一次点击时传true
animationUtils.getImageLocation(view, true);
//后面进入图片查看器后滑动一张图就传当前itemView和false
animationUtils.getImageLocation(viewHolder.itemView, false);
```

## 返回动画
```java
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
```

## 触发与返回动画结束监听
```java
//关掉该关的View
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
```