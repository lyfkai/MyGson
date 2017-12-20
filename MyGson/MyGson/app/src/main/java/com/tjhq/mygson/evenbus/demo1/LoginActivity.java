package com.tjhq.mygson.evenbus.demo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tjhq.mygson.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class LoginActivity extends AppCompatActivity {

    @InjectView(R.id.et_msg)
    EditText etMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

    }

    public void login(View view) {
        Toast.makeText(this, etMsg.getText().toString(), Toast.LENGTH_SHORT).show();
        //发送事件
        EventBus.getDefault().post(new UpdateUiEvent(etMsg.getText().toString()));
        finish();
    }

}
