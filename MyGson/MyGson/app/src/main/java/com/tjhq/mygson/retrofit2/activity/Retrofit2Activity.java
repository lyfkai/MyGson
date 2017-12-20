package com.tjhq.mygson.retrofit2.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.tjhq.mygson.bean.CarBean;
import com.tjhq.mygson.retrofit2.GsonUtils;
import com.tjhq.mygson.retrofit2.RetrofitService;
import com.tjhq.mygson.retrofit2.adapter.RetrofitAdapter;
import com.tjhq.mygson.utils.Constant;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by pc on 2017/11/22.
 */

public class Retrofit2Activity extends Activity {

    @InjectView(com.tjhq.mygson.R.id.lv_retrofit_gson)
    ListView lvRetrofitGson;

    List<CarBean.DataBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.tjhq.mygson.R.layout.activity_retrofit2);
        ButterKnife.inject(this);
        initData();
    }

    private void initData() {
        initRetrofit();
    }

    private void initRetrofit() {
        //获取Retrofit对象，设置地址
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASEURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService retrofitService = retrofit.create(RetrofitService.class);

        retrofitService.getString().enqueue(new Callback<CarBean>() {
            @Override
            public void onResponse(Call<CarBean> call, Response<CarBean> response) {

                String result = GsonUtils.getInstance().o2J(response.body());
                Log.e("TAG","获取数据"+result);
                Gson gson = new Gson();
                CarBean carBean = gson.fromJson(result, CarBean.class);
                Log.e("TAG","显示第一页"+carBean.getPageNo()+"显示一页多少条数据："+carBean.getPageSize()+"一共有多少数据"+carBean.getTotal());
                data =carBean.getData();
                RetrofitAdapter retrofitAdapter = new RetrofitAdapter(Retrofit2Activity.this,data);
                lvRetrofitGson.setAdapter(retrofitAdapter);
            }

            @Override
            public void onFailure(Call<CarBean> call, Throwable t) {

            }
        });
    }}

