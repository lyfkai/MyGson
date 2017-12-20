package com.tjhq.mygson.evenbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tjhq.mygson.R;
import com.tjhq.mygson.evenbus.demo1.LoginNoActivity;
import com.tjhq.mygson.evenbus.demo2.RegisEvenBusActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


//EvenBus
public class EvenBusActivity extends AppCompatActivity {

    @InjectView(R.id.bt_updata_ui)
    Button btUpdataUi;
    @InjectView(R.id.bt_postSticky_ui)
    Button btPostStickyUi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_even_bus);
        ButterKnife.inject(this);
    }


    @OnClick({R.id.bt_updata_ui,R.id.bt_postSticky_ui})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_updata_ui:
                //实现类是未登录状态下登陆成功后更新UI
                Intent intent = new Intent(this, LoginNoActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_postSticky_ui:
                //普通事件传递  和  粘性事件传递
                Intent intent1 = new Intent(this, RegisEvenBusActivity.class);
                startActivity(intent1);
                break;
        }
    }


}
