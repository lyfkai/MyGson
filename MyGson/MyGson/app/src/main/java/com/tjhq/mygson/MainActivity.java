package com.tjhq.mygson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tjhq.mygson.asyncfastjson.activity.AsyncActivity;
import com.tjhq.mygson.dagger.Dagger2Activity;
import com.tjhq.mygson.evenbus.EvenBusActivity;
import com.tjhq.mygson.okhtto3.activity.Okhttp3Activity;
import com.tjhq.mygson.picture.PictureGlideActivity;
import com.tjhq.mygson.picture.PicturePicassoActivity;
import com.tjhq.mygson.picture.PicturefrescoActivity;
import com.tjhq.mygson.retrofit2.activity.Retrofit2Activity;
import com.tjhq.mygson.rxjava.RxjavaActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.bt_async_fastjson)
    Button btAsyncFastjson;
    @InjectView(R.id.bt_okhttp_gson)
    Button btOkhttpGson;
    @InjectView(R.id.bt_retrofit2_gson)
    Button btRetrofit2Gson;
    @InjectView(R.id.bt_glide)
    Button btGlide;
    @InjectView(R.id.bt_picasso)
    Button btPicasso;
    @InjectView(R.id.bt_fresco)
    Button btFresco;
    @InjectView(R.id.bt_rxjava)
    Button btRxjava;
    @InjectView(R.id.bt_even_bus)
    Button btEvenBus;
    @InjectView(R.id.bt_dagger)
    Button btDagger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.bt_async_fastjson, R.id.bt_okhttp_gson, R.id.bt_retrofit2_gson, R.id.bt_glide, R.id.bt_picasso,
            R.id.bt_fresco,R.id.bt_rxjava,R.id.bt_even_bus,R.id.bt_dagger})
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.bt_async_fastjson:
                intent = new Intent(this, AsyncActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_okhttp_gson:
                intent = new Intent(this, Okhttp3Activity.class);
                startActivity(intent);
                break;
            case R.id.bt_retrofit2_gson:
                intent = new Intent(this, Retrofit2Activity.class);
                startActivity(intent);
                break;
            case R.id.bt_glide:
                intent = new Intent(this, PictureGlideActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_picasso:
                intent = new Intent(this, PicturePicassoActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_fresco:
                intent = new Intent(this, PicturefrescoActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_rxjava:
                intent = new Intent(this, RxjavaActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_even_bus:
                intent = new Intent(this, EvenBusActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_dagger:
                intent = new Intent(this, Dagger2Activity.class);
                startActivity(intent);
                break;
        }

    }

}
