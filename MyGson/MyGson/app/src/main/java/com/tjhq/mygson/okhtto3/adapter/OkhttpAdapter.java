package com.tjhq.mygson.okhtto3.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tjhq.mygson.R;
import com.tjhq.mygson.bean.CarBean;


import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by pc on 2017/11/22.
 */

public class OkhttpAdapter extends BaseAdapter {

    List<CarBean.DataBean> data;
    Context mCtx;

    public OkhttpAdapter(Context mCtx, List<CarBean.DataBean> data) {
        this.mCtx = mCtx;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {
            //把条目布局转化为view对象
            convertView = View.inflate(mCtx, R.layout.item_okhttp, null);
            //初始化holder对象，并初始化holder中的控件
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            //如果当前view存在，则直接从中取出其保存的控件及数据
            holder = (ViewHolder) convertView.getTag();
        }
        //通过position获取当前item的car数据，从car数据中取出title、pubDate和image
        CarBean.DataBean car = data.get(position);
        holder.llTvTitle.setText(car.getTitle());
        holder.llTvTime.setText(car.getPubDate());

        //使用SmartImageView的setImageUrl方法下载图片
        //  holder.ll_iv_async.setImageUrl(car.image);
        Picasso.with(mCtx).load(car.getImage()).into(holder.llIvOkhttp);
        return convertView;
    }


     class ViewHolder {
        @InjectView(R.id.ll_iv_okhttp)
        ImageView llIvOkhttp;
        @InjectView(R.id.ll_tv_title)
        TextView llTvTitle;
        @InjectView(R.id.ll_tv_time)
        TextView llTvTime;


        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
