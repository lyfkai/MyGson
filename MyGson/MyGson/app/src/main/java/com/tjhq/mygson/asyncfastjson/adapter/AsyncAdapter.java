package com.tjhq.mygson.asyncfastjson.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tjhq.mygson.R;
import com.tjhq.mygson.bean.CarBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017/11/22.
 */

public class AsyncAdapter extends BaseAdapter {

    private Context mCtx;
    private ArrayList<CarBean.DataBean> data;

    public AsyncAdapter(Context mCtx, List<CarBean.DataBean> data) {
        this.mCtx = mCtx;
        this.data = (ArrayList<CarBean.DataBean>) data;
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
        //初始化holder对象
        ViewHolder holder;
        if(convertView == null){
            //把条目布局转化为view对象
            convertView  = View.inflate(mCtx, R.layout.item_async, null);
            //初始化holder对象，并初始化holder中的控件
            holder = new ViewHolder();
            holder.ll_tv_title = (TextView) convertView.findViewById(R.id.ll_tv_title);
            holder.ll_tv_time = (TextView) convertView.findViewById(R.id.ll_tv_time);
            holder.ll_iv_async = (ImageView) convertView.findViewById(R.id.ll_iv_async);
            //给当前view做个标记，并把数据存到该tag中
            convertView.setTag(holder);

        }else {
            //如果当前view存在，则直接从中取出其保存的控件及数据
            holder = (ViewHolder) convertView.getTag();
        }
        //通过position获取当前item的car数据，从car数据中取出title、pubDate和image
        CarBean.DataBean car = data.get(position);
        holder.ll_tv_title.setText(car.getTitle());
        holder.ll_tv_time.setText(car.getPubDate());

        //使用SmartImageView的setImageUrl方法下载图片
      //  holder.ll_iv_async.setImageUrl(car.image);
        Picasso.with(mCtx).load(car.getImage()).into(holder.ll_iv_async);
        return convertView;
    }

    /*
   * 用来存放item布局中控件的holder类
   */
    class ViewHolder{
        ImageView ll_iv_async; //显示图片的控件，注意是SmartImageView
        TextView ll_tv_title; //显示标题的控件
        TextView ll_tv_time;  //显示日期的控件
    }
}
