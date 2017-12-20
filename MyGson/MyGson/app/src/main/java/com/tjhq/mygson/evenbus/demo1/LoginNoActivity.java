package com.tjhq.mygson.evenbus.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.tjhq.mygson.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class LoginNoActivity extends AppCompatActivity {

    @InjectView(R.id.tv_msg)
    TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_no);
        ButterKnife.inject(this);

        EventBus.getDefault().register(this);//注册
        tvMsg.append("  当前页面："+hashCode()+" \n");

    }
    public void startUpdateUI(View view) {
        startActivity(new Intent(this, LoginNoActivity.class));
    }
    public void goLogin(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
    @Subscribe
    public void onEventMainThread(UpdateUiEvent uiEvent) {
        tvMsg.setText("  当前页面："+hashCode()+"\n信息："+uiEvent.getMs());//接收到事件  将信息设置到页面上
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);//取消注册
        super.onDestroy();
    }

}
