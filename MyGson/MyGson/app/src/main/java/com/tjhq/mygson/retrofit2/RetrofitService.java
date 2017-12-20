package com.tjhq.mygson.retrofit2;

import com.tjhq.mygson.bean.CarBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pc on 2017/11/22.
 */

public interface RetrofitService {
    //请求方式为GET，参数为basil2style，因为没有变量所以下面getString方法也不需要参数
    @GET("txt/car.json")
    //定义返回的方法，返回的响应体使用了ResponseBody
    Call<CarBean> getString();
}
