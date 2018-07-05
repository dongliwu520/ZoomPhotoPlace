package com.zoom.photoplace.photo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zoom.photoplace.R;

/**
 * Created by WUDONOLI on 17/12/17.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> implements View.OnClickListener{

    private Context context;
    private String[] data;
    private OnRecycleViewItemClickListener mOnItemClickListener;
    public MyViewHolder viewHolder;

    public RecycleAdapter(Context context, String[] data) {
        this.context = context;
        this.data = data;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //负责创建视图
        View view= LayoutInflater.from(context).inflate(R.layout.grid_view,null);
        view.setOnClickListener(this);
        // 实例化viewholder
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecycleAdapter.MyViewHolder holder, int position) {
        viewHolder = holder;
        //相当于listview的adapter中的getview方法
        //负责将数据绑定到视图上
        String p = "";
        Glide.with(context)
                .load(data[position])
                .placeholder(R.mipmap.img_product_default_bg)
                .error(R.mipmap.img_product_default_bg)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.gridimage);
        holder.itemView.setTag(position);//将位置保存在tag中
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener!=null)
        {
            mOnItemClickListener.OnItemClick(v,(int)v.getTag());
        }
    }
    public void setOnItemClickListener(OnRecycleViewItemClickListener listener)
    {
        this.mOnItemClickListener=listener;
    }
    public static interface OnRecycleViewItemClickListener{
        void OnItemClick(View view, int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView gridimage;
        public MyViewHolder(View itemView){
            super(itemView);
            gridimage = (ImageView) itemView.findViewById(R.id.gridimage);
        }
    }
}
