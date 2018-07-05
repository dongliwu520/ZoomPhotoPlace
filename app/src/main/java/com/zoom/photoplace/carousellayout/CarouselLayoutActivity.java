package com.zoom.photoplace.carousellayout;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.zoom.photoplace.R;
import com.zoom.photoplace.carousellayout.adapter.CMFilmPosterAdapter;
import com.zoom.photoplace.data.Constants;
import com.zoom.photoplace.carousellayout.widget.carousellayout.CarouselLayoutManager;
import com.zoom.photoplace.carousellayout.widget.carousellayout.CarouselZoomPostLayoutListener;
import com.zoom.photoplace.carousellayout.widget.carousellayout.CenterScrollListener;
import com.zoom.photoplace.carousellayout.widget.carousellayout.DefaultChildSelectionListener;
import com.zoom.photoplace.model.FilmList;
import com.zoom.photoplace.model.TFilmNumberSelectDataWrapper;
import com.zoom.photoplace.model.TResultWrapper;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by wudongli on 2018/5/1.
 */

public class CarouselLayoutActivity extends Activity implements View.OnClickListener{

    @ViewInject(R.id.list_horizontal)
    private RecyclerView listHorizontal;

    @ViewInject(R.id.titleLeft)
    private TextView titleLeft;

    private String filmName;
    private TFilmNumberSelectDataWrapper data;
    FilmList[] filmList;
    private int currentSelectFilmPosition = 0;
    private int currentFilmPosition = 0;

    private CMFilmPosterAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_cinema_number_select);
        x.view().inject(this);
        filmName = getIntent().getStringExtra("filmName");

        initView();
        requestData();
    }

    private void initView(){
        titleLeft.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.titleLeft:
                finish();
                break;
        }
    }

    //请求数据
    private void requestData() {
        TResultWrapper<TFilmNumberSelectDataWrapper> tResult = JSON.parseObject(Constants.CAROUSEL_LAYOUT_DATA, new TypeReference<TResultWrapper<TFilmNumberSelectDataWrapper>>() {
        });
        data = tResult.getData();
        loadData(data);
    }

    private void loadData(TFilmNumberSelectDataWrapper nsData){
        if (null != data.getFilmList() && data.getFilmList().length > 0) {
            //填充海报
            filmList = data.getFilmList();
            for (int i = 0; i < filmList.length; i++) {
                if (filmList[i].getFilmName().equals(filmName)) {
                    currentSelectFilmPosition = i;
                    currentFilmPosition = i;
                    break;
                }
            }
            initRecyclerView(listHorizontal,new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, false),data.getFilmList(),currentSelectFilmPosition);
        }
    }

    //填充海报图列表
    public void initRecyclerView(final RecyclerView recyclerView, final CarouselLayoutManager layoutManager, final FilmList[] filmLists, final int position) {
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == 0) {//停止滚动时
                    recyclerView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //选中中间的图片的操作
                            adapter.setSelectPosition(currentFilmPosition);
                        }
                    },350);
                }
            }
        });
        adapter= new CMFilmPosterAdapter(this,filmLists,position);
        // enable zoom effect. this line can be customized
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
        layoutManager.setMaxVisibleItems(2);
        recyclerView.setLayoutManager(layoutManager);
        // we expect only fixed sized item for now
        recyclerView.setHasFixedSize(true);
        // sample adapter with random data
        recyclerView.setAdapter(adapter);
        // enable center post scrolling
        recyclerView.addOnScrollListener(new CenterScrollListener());
        // 设置中心条目点击监听 点击选中必须要的监听 不加点击选不中
        DefaultChildSelectionListener.initCenterItemListener(new DefaultChildSelectionListener.OnCenterItemClickListener() {
            @Override
            public void onCenterItemClicked(@NonNull final RecyclerView recyclerView, @NonNull final CarouselLayoutManager carouselLayoutManager, @NonNull final View v) {
            }
        }, recyclerView, layoutManager);

        adapter.setLayoutManager(layoutManager);
        /**
         * 自动选中中间View
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                recyclerView.scrollToPosition(position);
            }
        }, 100);
    }
}
