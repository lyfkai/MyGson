package com.tjhq.mygson.evenbus.demo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tjhq.mygson.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SecondActivity extends AppCompatActivity {

    @InjectView(R.id.tv_message)
    TextView tvMessage;
    @InjectView(R.id.bt_message)
    Button btMessage;
    @InjectView(R.id.bt_subscription)
    Button btSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.inject(this);


        btMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageEvent("欢迎你的到来"));
                finish();
            }
        });


        btSubscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(new MessageEvent("粘性事件"));
                finish();
            }
        });
    }
}
