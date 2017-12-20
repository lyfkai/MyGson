package com.tjhq.mygson.picture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.tjhq.mygson.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class PicturePicassoActivity extends AppCompatActivity {

    @InjectView(R.id.bt_jbjz)
    Button btJbjz;
    @InjectView(R.id.iv_jbjz)
    ImageView ivJbjz;
    @InjectView(R.id.bt_zwt)
    Button btZwt;
    @InjectView(R.id.iv_zwt)
    ImageView ivZwt;
    @InjectView(R.id.bt_ect)
    Button btEct;
    @InjectView(R.id.iv_ect)
    ImageView ivEct;
    @InjectView(R.id.bt_zhq)
    Button btZhq;
    @InjectView(R.id.iv_zhq)
    ImageView ivZhq;
    @InjectView(R.id.bt_onlyScaleDown)
    Button btOnlyScaleDown;
    @InjectView(R.id.iv_onlyScaleDown)
    ImageView ivOnlyScaleDown;
    @InjectView(R.id.bt_ls)
    Button btLs;
    @InjectView(R.id.iv_ls)
    ImageView ivLs;
    @InjectView(R.id.bt_fit)
    Button btFit;
    @InjectView(R.id.iv_fit)
    ImageView ivFit;
    @InjectView(R.id.bt_jzyx)
    Button btJzyx;
    @InjectView(R.id.iv_jzyx)
    ImageView ivJzyx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_picasso);
        ButterKnife.inject(this);
    }


    @OnClick({R.id.bt_jbjz, R.id.bt_zwt, R.id.bt_ect, R.id.bt_zhq,R.id.bt_onlyScaleDown,R.id.bt_ls,R.id.bt_fit,R.id.bt_jzyx})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_jbjz:
                //基本加载
                Picasso.with(this).load("http://img0.pcauto.com.cn/pcauto/1609/06/g_8719572_1473152785181_240x160.jpg").into(ivJbjz);
                break;
            case R.id.bt_zwt:
                //icasso的默认图片加载方式有一个淡入的效果,如果调用了noFade(),加载的图片将直接显示在ImageView上
                Picasso.with(this)
                        .load("http://www.sinaimg.cn/qc/photo_auto/photo/85/55/38468555/38468555_140.jpg")
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.drawable.f_db)
                        .noFade()
                        .into(ivJbjz);
                break;
            case R.id.bt_ect:
                //有一个场景,当你从网上加载了一张图片到Imageview上,过了一段时间,想在同一个ImageView上展示另一张图片,
                // 这个时候你就会去调用Picasso,进行二次请求,这时Picasso就会把之前的图片进行清除,可能展示的是.
                // placeholder()的图片,给用户并不是很好的体验,如果调用了noPlaceholder(),就不会出现这种情况.
                Picasso.with(this)
                        .load("http://www.sinaimg.cn/qc/photo_auto/photo/39/95/38843995/38843995_140.jpg")
                        .placeholder(R.mipmap.ic_launcher)
                        .into(ivEct, new Callback() {
                            public void onSuccess() {
                                // 当上次加载完成后,进行二次加载
                                Picasso.with(PicturePicassoActivity.this)
                                        .load("http://www.sinaimg.cn/qc/photo_auto/photo/50/72/39045072/39045072_140.jpg")
                                        .noPlaceholder()
                                        .into(ivEct);
                            }

                            public void onError() {

                            }
                        });
                break;
            case R.id.bt_zhq:
                //调用resize(x, y)来自定义图片的加载大小
                Picasso.with(this)
                        .load("http://www.sinaimg.cn/qc/photo_auto/photo/61/98/39186198/39186198_140.jpg")
                        .resize(600, 200)
                        .into(ivZhq);
                break;
            case R.id.bt_onlyScaleDown:
                //调用`onlyScaleDown()来缩短图片的加载计算时间
                Picasso.with(this)
                        .load("http://www.sinaimg.cn/qc/photo_auto/photo/72/69/39277269/39277269_140.jpg")
                        .resize(600, 200)
                        .onlyScaleDown() // 如果图片规格大于6000*2000,将只会被resize
                        .into(ivOnlyScaleDown);
                break;
            case R.id.bt_ls:
                 //对拉伸图片的处理
                //如果图片被操作了,可能在展示的时候就会比较丑,我们是想改变这种情景的,Picasso给我们提供了两种选择进行图片展示,centerCrop() 或者 centerInside().
                Picasso.with(this)
                        .load("http://www.sinaimg.cn/qc/photo_auto/photo/84/96/38338496/38338496_140.jpg")
                        .resize(600, 200)
                        .centerInside() //或者调用 .centerCrop()
                        .into(ivLs);

                break;
            case R.id.bt_fit:
                //调用.fit()来智能展示图片
                //如果调用了该API, Picasso会对图片的大小及ImageView进行测量,计算出最佳的大小及最佳的图片质量来进行图片展示,减少内存,并对视图没有影响;
                Picasso.with(this)
                        .load("http://www.sinaimg.cn/qc/photo_auto/photo/03/04/38200304/38200304_140.jpg")
                        .fit()
                        .into(ivFit);
                break;
            case R.id.bt_jzyx:
                 //调用.priority()设置图片加载的优先级
                //如果一个屏幕上顶部图片较大,而底部图片较小,因为Picasso是异步加载,所以小图会先加载出来,但是对于用户来说,更希望看到的是上面的图片先加载,底部的图片后加载,Picasso支持设置优先级,分为HIGH, MEDIUM, 和 LOW,所有的加载默认优先级为MEDIUM;
                Picasso.with(this)
                        .load("http://www.sinaimg.cn/qc/photo_auto/photo/82/29/39238229/39238229_140.jpg")
                        .fit()
                        .priority(Picasso.Priority.HIGH)
                        .into(ivJzyx);
                break;

        }
    }
}
