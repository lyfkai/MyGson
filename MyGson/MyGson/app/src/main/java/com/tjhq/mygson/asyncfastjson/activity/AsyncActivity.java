package com.tjhq.mygson.asyncfastjson.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.tjhq.mygson.R;
import com.tjhq.mygson.asyncfastjson.adapter.AsyncAdapter;
import com.tjhq.mygson.bean.CarBean;
import com.tjhq.mygson.utils.Constant;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AsyncActivity extends Activity {


    @InjectView(R.id.lv_Async_fastjson)
    ListView lvAsyncFastjson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        ButterKnife.inject(this);
        initData();
    }

    private void initData() {

        AsyncHttpClient client = new AsyncHttpClient();
        String home =Constant.BASEURL+Constant.HOME_URL;
        client.post(home, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                CarBean carBean = new CarBean();
             //200 响应成功  解析json数据  Gosn / FastJson
                JSONObject jsonObject = JSON.parseObject(content);
                int pageNo = jsonObject.getInteger("pageNo");
                int pageSize = jsonObject.getInteger("pageSize");
                int total = jsonObject.getInteger("total");
                carBean.setPageNo(pageNo);
                carBean.setPageSize(pageSize);
                carBean.setTotal(total);
                //解析集合
                String data = jsonObject.getString("data");
                List<CarBean.DataBean> dataBeen = jsonObject.parseArray(data,CarBean.DataBean.class);

                AsyncAdapter asyncAdapter = new AsyncAdapter(AsyncActivity.this,dataBeen);
                lvAsyncFastjson.setAdapter(asyncAdapter);
            }

            @Override
            public void onFailure(Throwable error, String content) {
             //响应失败
                Toast.makeText(AsyncActivity.this,"联网获取数据失败",Toast.LENGTH_SHORT).show();
            }
        });
    }

}


//Async上传请求方式
/*
    AsyncHttpClient client = new AsyncHttpClient();
    String url = AppNetConfig.FEEDBACK;
    RequestParams params = new RequestParams();
    params.put("department", department);
    params.put("content", content);
    client.post(url, params, new AsyncHttpResponseHandler() {
        @Override
        public void onSuccess(String content) {
                UIUtils.toast("发送反馈信息成功", false);

            }

        @Override
        public void onFailure(Throwable error, String content) {
                UIUtils.toast("发送反馈信息失败", false);

                }
        });*/
