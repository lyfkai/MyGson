package com.tjhq.mygson.evenbus.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tjhq.mygson.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class RegisEvenBusActivity extends AppCompatActivity {

    @InjectView(R.id.tv_message)
    TextView tvMessage;
    @InjectView(R.id.bt_message)
    Button btMessage;
    @InjectView(R.id.bt_subscription)
    Button btSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis_even_bus);
        ButterKnife.inject(this);

        btMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisEvenBusActivity.this,SecondActivity.class));
            }
        });

        btSubscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //注册事件
                if(!EventBus.getDefault().isRegistered(RegisEvenBusActivity.this)) {
                    EventBus.getDefault().register(RegisEvenBusActivity.this);
                }else{
                    Toast.makeText(RegisEvenBusActivity.this,"请勿重复注册事件",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册事件
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(MessageEvent messageEvent){
        tvMessage.setText(messageEvent.getMessage());
    }
    @Subscribe(sticky = true)
    public void ononMoonStickyEvent(MessageEvent messageEvent){
        tvMessage.setText(messageEvent.getMessage());
    }
}
