package com.tjhq.mygson.okhtto3.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.tjhq.mygson.R;
import com.tjhq.mygson.bean.CarBean;
import com.tjhq.mygson.okhtto3.adapter.OkhttpAdapter;
import com.tjhq.mygson.utils.Constant;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import okhttp3.Call;
import okhttp3.Request;

public class Okhttp3Activity extends AppCompatActivity {

    @InjectView(R.id.lv_okhttp_gson)
    ListView lvOkhttpGson;

    List<CarBean.DataBean> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp3);
        ButterKnife.inject(this);

        initData();
    }

    private void initData() {
        OkHttpUtils
                .get()
                .url(Constant.BASEURL+Constant.HOME_URL)
                .id(100)
                .build()
                .execute(new MyStringCallback());

    }

    public class MyStringCallback extends StringCallback{
        @Override
        public void onBefore(Request request, int id) {
        }

        @Override
        public void onAfter(int id) {
        }
        @Override
        public void onError(Call call, Exception e, int id) {
            Log.e("TAG", "联网失败" + e.getMessage());
        }

        @Override
        public void onResponse(String response, int id) {
            switch (id) {
                case 100:
//                    Toast.makeText(mContext, "http", Toast.LENGTH_SHORT).show();
                    if (response != null) {
                        Log.e("TAG", "--> - response => "+ response);
                        processData(response);
                        OkhttpAdapter adapter = new OkhttpAdapter(Okhttp3Activity.this, data);
                        lvOkhttpGson.setAdapter(adapter);
                    }
                    break;
                case 101:
                    Toast.makeText(Okhttp3Activity.this, "https", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
    
    private void processData(String json) {
        Gson gson = new Gson();
        CarBean carBean = gson.fromJson(json, CarBean.class);
        data = carBean.getData();
    }

}
