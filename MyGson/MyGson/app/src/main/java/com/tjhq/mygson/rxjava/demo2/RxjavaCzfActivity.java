package com.tjhq.mygson.rxjava.demo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tjhq.mygson.R;
import com.tjhq.mygson.rxjava.AppConstant;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RxjavaCzfActivity extends AppCompatActivity {

    @InjectView(R.id.rx_java_bt)
    Button rxJavaBt;
    @InjectView(R.id.rx_java_tv)
    TextView rxJavaTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_czf);
        ButterKnife.inject(this);

        rxJavaBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doSomeWork();
            }
        });

    }

    private void doSomeWork() {
          getObservable()
                // Run on a background thread
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver());
    }

    private Observable<String> getObservable() {
        return Observable.just("Cricket", "Football","just");
    }


    private Observer<String> getObserver() {
        return new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d("TAG", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(String value) {
                rxJavaTv.append(" onNext : value : " + value);
                rxJavaTv.append(AppConstant.LINE_SEPARATOR);
                 Log.d("TAG", " onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                rxJavaTv.append(" onError : " + e.getMessage());
                rxJavaTv.append(AppConstant.LINE_SEPARATOR);
                Log.d("TAG", " onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                rxJavaTv.append(" onComplete");
                rxJavaTv.append(AppConstant.LINE_SEPARATOR);
                Log.d("TAG", " onComplete");
            }
        };
    }
}
