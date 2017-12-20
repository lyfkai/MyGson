package com.tjhq.mygson.rxjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tjhq.mygson.R;
import com.tjhq.mygson.rxjava.demo1.RxjavaPtActivity;
import com.tjhq.mygson.rxjava.demo2.RxjavaCzfActivity;
import com.tjhq.mygson.rxjava.demo3.RxjavaMapActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/*
Observable：在观察者模式中称为“被观察者”；
Observer：观察者模式中的“观察者”，可接收Observable发送的数据；
subscribe：订阅，观察者与被观察者，通过subscribe()方法进行订阅；
Subscriber：也是一种观察者，在2.0中 它与Observer没什么实质的区别，不同的是 Subscriber要与Flowable(也是一种被观察者)联合使用，该部分内容是2.0新增的
Observable的几种创建方式:


01,just()方式
使用just( )，将创建一个Observable并自动调用onNext( )发射数据。
也就是通过just( )方式 直接触发onNext()，just中传递的参数将直接在Observer的onNext()方法中接收到。

02,fromIterable()方式
使用fromIterable()，遍历集合，发送每个item.多次自动调用onNext()方法，每次传入一个item.
注意：Collection接口是Iterable接口的子接口，所以所有Collection接口的实现类都可以作为Iterable对象直接传入fromIterable()
方法。

03,defer()方式
当观察者订阅时,才创建Observable，并且针对每个观察者创建都是一个新的Observable.
通过Callable中的回调方法call(),决定使用以何种方式来创建这个Observable对象,当订阅后，发送事件.

04,interval( )方式
创建一个按固定时间间隔发射整数序列的Observable，可用作定时器。按照固定时间间隔来调用onNext()方法。

05,timer( )方式
通过此种方式创建一个Observable,它在一个给定的延迟后发射一个特殊的值，即表示延迟指定时间后，调用onNext()方法。

06,range( )方式,range(x,y)
创建一个发射特定整数序列的Observable，第一个参数x为起始值，第二个y为发送的个数，如果y为0则不发送，y为负数则抛异常。
range(1,5)
上述表示发射1到5的数。即调用5次Next()方法，依次传入1-5数字。

07,repeat( )方式
创建一个Observable，该Observable的事件可以重复调用。
*/

public class RxjavaActivity extends AppCompatActivity {

    @InjectView(R.id.bt_pt_rx)
    Button btPtRx;
    @InjectView(R.id.bt_czf_rx)
    Button btCzfRx;
    @InjectView(R.id.bt_map_rx)
    Button btMapRx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.bt_pt_rx, R.id.bt_czf_rx,R.id.bt_map_rx})
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.bt_pt_rx:
                intent = new Intent(this, RxjavaPtActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_czf_rx:
                intent = new Intent(this, RxjavaCzfActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_map_rx:
                intent = new Intent(this, RxjavaMapActivity.class);
                startActivity(intent);
                break;
        }
    }
}
