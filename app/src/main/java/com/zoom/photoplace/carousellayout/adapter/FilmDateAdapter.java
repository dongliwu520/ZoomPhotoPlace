package com.zoom.photoplace.carousellayout.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zoom.photoplace.R;
import com.zoom.photoplace.carousellayout.util.DeviceUtils;

import java.util.List;

public class FilmDateAdapter extends BaseAdapter {

    Context mContext = null;
    private int selectPosition=0;

    private  List<String> mDateTitles;
		private int width;
    public FilmDateAdapter(Context context, List<String> titles) {
        this.mContext = context;
        width = DeviceUtils.getScreenWidth(mContext)/3;
        mDateTitles=titles;
    }

    /**
     * 设置选中position
     *
     * @param selectPosition
     */
    public void setSelectPosition(int selectPosition) {
        this.selectPosition = selectPosition;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mDateTitles.size();
    }

    @Override
    public Object getItem(int arg0) {
        return mDateTitles.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            //界面元素
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.film_date_item, null);

            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.llImage = (LinearLayout) convertView.findViewById(R.id.ll_image);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        
        holder.name.setText(mDateTitles.get(position));
        if (selectPosition == position) {
            holder.name.setTextColor(mContext.getResources().getColor(R.color.new_title_bg));
            holder.llImage.setVisibility(View.VISIBLE);
        } else {
            holder.name.setTextColor(mContext.getResources().getColor(R.color.new_black));
            holder.llImage.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }

    class ViewHolder {

        TextView name;
        LinearLayout llImage;
    }

}
