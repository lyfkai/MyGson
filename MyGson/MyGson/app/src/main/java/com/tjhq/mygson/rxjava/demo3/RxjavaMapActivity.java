package com.tjhq.mygson.rxjava.demo3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tjhq.mygson.R;
import com.tjhq.mygson.rxjava.AppConstant;
import com.tjhq.mygson.rxjava.Utils;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxjavaMapActivity extends AppCompatActivity {

    @InjectView(R.id.rx_map_bt)
    Button rxMapBt;
    @InjectView(R.id.rx_map_tv)
    TextView rxMapTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_map);
        ButterKnife.inject(this);
        rxMapBt.setOnClickListener(new View.OnClickListener() {
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
                .map(new Function<List<ApiUser>, List<User>>() {

                    @Override
                    public List<User> apply(List<ApiUser> apiUsers) throws Exception {
                        return Utils.convertApiUserListToUserList(apiUsers);
                    }
                })
                .subscribe(getObserver());
    }

    private Observable<List<ApiUser>> getObservable() {
        return Observable.create(new ObservableOnSubscribe<List<ApiUser>>() {
            @Override
            public void subscribe(ObservableEmitter<List<ApiUser>> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onNext(Utils.getApiUserList());
                    e.onComplete();
                }
            }
        });
    }



    private Observer<List<User>> getObserver() {
        return new Observer<List<User>>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d("TAG", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(List<User> userList) {
                rxMapTv.append(" onNext");
                rxMapTv.append(AppConstant.LINE_SEPARATOR);
                for (User user : userList) {
                    rxMapTv.append(" firstname : " + user.firstname +"===lastname:"+user.lastname);
                    rxMapTv.append(AppConstant.LINE_SEPARATOR);
                }
                Log.d("TAG", " onNext : " + userList.size());
            }

            @Override
            public void onError(Throwable e) {
                rxMapTv.append(" onError : " + e.getMessage());
                rxMapTv.append(AppConstant.LINE_SEPARATOR);
                Log.d("TAG", " onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                rxMapTv.append(" onComplete");
                rxMapTv.append(AppConstant.LINE_SEPARATOR);
                Log.d("TAG", " onComplete");
            }
        };
    }

}
