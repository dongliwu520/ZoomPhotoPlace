package com.zoom.photoplace.carousellayout.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zoom.photoplace.R;
import com.zoom.photoplace.carousellayout.widget.carousellayout.CarouselLayoutManager;
import com.zoom.photoplace.carousellayout.widget.customshape.CustomShapeImageView;
import com.zoom.photoplace.model.FilmList;

/**
 * Created by wudongli on 2018/5/2.
 */

public class CMFilmPosterAdapter extends RecyclerView.Adapter<CMFilmPosterAdapter.ViewHolder> {
    private Context context;

    CarouselLayoutManager layoutManager;
    FilmList[] mfilmLists;
    int selectPosition = -1;

    public CMFilmPosterAdapter(Context context, FilmList[] filmLists, int position) {
        this.context = context;
        this.mfilmLists = filmLists;
        this.selectPosition = position;
    }

    public void setSelectPosition(int position){
        this.selectPosition = position;
        notifyDataSetChanged();
    }
    public void setLayoutManager(CarouselLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }
    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film_poster, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        FilmList film = mfilmLists[position];

            Glide.with(context)
                    .load(film.getFrontImg())
                    .placeholder(R.mipmap.img_product_default_bg)
                    .error(R.mipmap.img_product_default_bg)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .skipMemoryCache(false)
                    .into(holder.image);
        if (selectPosition == position) {
            holder.tv50.setVisibility(View.GONE);
            holder.tv70.setVisibility(View.GONE);
        } else if((selectPosition - 1) == position || (selectPosition + 1) == position){
            holder.tv50.setVisibility(View.VISIBLE);
            holder.tv70.setVisibility(View.GONE);
        } else if((selectPosition - 2) == position || (selectPosition + 2) == position){
            holder.tv50.setVisibility(View.GONE);
            holder.tv70.setVisibility(View.VISIBLE);
        } else{
            holder.tv50.setVisibility(View.GONE);
            holder.tv70.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mfilmLists.length;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        private CustomShapeImageView image;
        private TextView tv50,tv70;

        ViewHolder(final View view) {
            super(view);
            tv50 = (TextView) view.findViewById(R.id.tv50);
            tv70 = (TextView) view.findViewById(R.id.tv70);
            image = (CustomShapeImageView) view.findViewById(R.id.image);
        }
    }
}
