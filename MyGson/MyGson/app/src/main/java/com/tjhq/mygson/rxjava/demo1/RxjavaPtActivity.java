package com.tjhq.mygson.rxjava.demo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tjhq.mygson.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RxjavaPtActivity extends AppCompatActivity {
    private Button rx_java_bt;
    private TextView rx_java_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_pt);
        initView();
        myOnclick();
    }


    //初始化控件
    private void initView() {
        rx_java_bt = (Button)findViewById(R.id.rx_java_bt);
        rx_java_tv = (TextView)findViewById(R.id.rx_java_tv);
    }

    //点击事件
    private void myOnclick() {
        rx_java_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //订阅
                //拿到发送器对象
                Observable<String> observable =getObservable();
                //拿到接受者对象
                Observer<String> observer=getObserver();
                //把内容传到接受者当中
                observable.subscribe(observer);
            }
        });
    }

    /**
     * 消息发射器
     */
    public Observable<String> getObservable(){
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("我是测试RxJava");
                e.onComplete();
                //和onComplete互斥（调用onComplete，不在调用onComplete）
            }
        });
        return observable;
    }

    /**
     * 消息接受者
     */
    public Observer<String> getObserver(){

        Observer<String> observer=new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("111","onSubscribe");
            }

            @Override
            public void onNext(String value) {
                rx_java_tv.setText(value);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("111","onError");
            }

            @Override
            public void onComplete() {
                Log.e("111","onComplete");
            }
        };
        return observer;
    }


}
