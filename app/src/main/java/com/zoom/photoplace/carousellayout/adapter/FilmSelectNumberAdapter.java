package com.zoom.photoplace.carousellayout.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zoom.photoplace.R;
import com.zoom.photoplace.carousellayout.widget.FilmTextView;
import com.zoom.photoplace.model.TicketInfoList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wudongli on 2018/5/2.
 */

public class FilmSelectNumberAdapter extends BaseAdapter{

    private ViewHolder holder;
    private View view;
    private Context mContext;
    List<TicketInfoList> mTicketInfoLists = new ArrayList<TicketInfoList>();


    public void FilmSelectNumberData(TicketInfoList[] filmLists) {
        if (filmLists == null) {
            return;
        }
        mTicketInfoLists.clear();
        Collections.addAll(this.mTicketInfoLists, filmLists);
        this.notifyDataSetChanged();
    }

    public FilmSelectNumberAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mTicketInfoLists.size();
    }

    @Override
    public Object getItem(int position) {
        return mTicketInfoLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            view = View.inflate(mContext, R.layout.film_select_seat_item, null);
            holder = new ViewHolder();
            holder.tv_seat_start_time = (TextView) view.findViewById(R.id.tv_seat_start_time);
            holder.tv_seat_end_time = (TextView) view.findViewById(R.id.tv_seat_end_time);
            holder.tv_seat_type = (TextView) view.findViewById(R.id.tv_seat_type);
            holder.tv_seat_number = (TextView) view.findViewById(R.id.tv_seat_number);
            holder.tv_seat_price = (FilmTextView) view.findViewById(R.id.tv_seat_price);
            holder.tv_sale_price = (TextView) view.findViewById(R.id.tv_sale_price);
            holder.tv_seat_buy = (TextView) view.findViewById(R.id.tv_seat_buy);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }

        TicketInfoList mTicketInfoList = mTicketInfoLists.get(position);
        holder.tv_seat_start_time.setText(mTicketInfoList.getShowTimeBegin());
        holder.tv_seat_end_time.setText(mTicketInfoList.getOvertime() + "散场");
        holder.tv_seat_type.setText(mTicketInfoList.getLanguage() + " / " + mTicketInfoList.getShowType());
        holder.tv_seat_number.setText(mTicketInfoList.getHallName() + "");

        holder.tv_seat_price.setTexts("¥ ",mTicketInfoList.getSalePrice());
        holder.tv_seat_price.tvNumView.setTextSize(13);
        holder.tv_seat_price.tvOhterView.setTextSize(17);
        holder.tv_sale_price.setText("¥" + mTicketInfoList.getCinemaPrice());
        holder.tv_sale_price.getPaint().setAntiAlias(true);//抗锯齿
        holder.tv_sale_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG); //中划线
//			holder.tv_seat_start_time.setTypeface(YongLeApplication.getInstace().getNumberTypeface());

        return view;
    }
    class ViewHolder {
        TextView tv_seat_start_time;
        TextView tv_seat_end_time;
        TextView tv_seat_type;
        TextView tv_seat_number;
        FilmTextView tv_seat_price;
        TextView tv_sale_price;
        TextView tv_seat_buy;
    }
}
