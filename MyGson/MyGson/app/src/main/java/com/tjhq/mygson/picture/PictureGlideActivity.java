package com.tjhq.mygson.picture;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.tjhq.mygson.R;

import java.io.File;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class PictureGlideActivity extends Activity {


    @InjectView(R.id.bt_bd)
    Button btBd;
    @InjectView(R.id.iv_bd)
    ImageView ivBd;
    @InjectView(R.id.bt_sdka)
    Button btSdka;
    @InjectView(R.id.iv_sdka)
    ImageView ivSdka;
    @InjectView(R.id.bt_net)
    Button btNet;
    @InjectView(R.id.iv_net)
    ImageView ivNet;
    @InjectView(R.id.bt_yuan)
    Button btYuan;
    @InjectView(R.id.iv_yuan)
    ImageView ivYuan;
    @InjectView(R.id.bt_tuoyuan)
    Button btTuoyuan;
    @InjectView(R.id.iv_tuoyuan)
    ImageView ivTuoyuan;
    @InjectView(R.id.bt_cuow)
    Button btCuow;
    @InjectView(R.id.iv_cuow)
    ImageView ivCuow;
    @InjectView(R.id.bt_dra)
    Button btDra;
    @InjectView(R.id.iv_dra)
    ImageView ivDra;
    @InjectView(R.id.bt_lzp)
    Button btLzp;
    @InjectView(R.id.iv_lzp)
    ImageView ivLzp;
    @InjectView(R.id.bt_suoxiao)
    Button btSuoxiao;
    @InjectView(R.id.iv_suoxiao)
    ImageView ivSuoxiao;
    @InjectView(R.id.bt_gif)
    Button btGif;
    @InjectView(R.id.iv_gif)
    ImageView ivGif;
    @InjectView(R.id.bt_tuptchong)
    Button btTuptchong;
    @InjectView(R.id.iv_tuptchong)
    ImageView ivTuptchong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_glide);
        ButterKnife.inject(this);


    }



    @OnClick({R.id.bt_bd,R.id.bt_sdka,R.id.bt_net,R.id.bt_yuan,R.id.bt_tuoyuan,R.id.bt_cuow,R.id.bt_dra,R.id.bt_lzp,R.id.bt_suoxiao,R.id.bt_gif,R.id.bt_tuptchong})
     public void onClick(View view){
        switch (view.getId()){
            case R.id.bt_bd:
                //加载本地资源
                Glide.with(this).load(R.drawable.f_db).into(ivBd);
                break;
            case R.id.bt_sdka:
                //加载SD卡图片iv
                File f = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/DCIM/Camera/IMG_20151025_120635_HDR.jpg");
                Glide.with(this).load(f).into(ivSdka);
                //or uri
                Glide.with(this).load(Uri.fromFile(f)).into(ivSdka);
                break;
            case R.id.bt_net:
                //with(Context context):Context支持 Activity Context Fragment FragmentActivity中四种类型
                //load():支持远程图片，本地图片文件，图片资源，多媒体数据库的uri
                //into():在哪个imageview中显示
                Glide.with(this).load("http://a.hiphotos.baidu.com/image/h%3D200/sign=d20242020e24ab18ff16e63705fae69a/267f9e2f070828389f547b30bf99a9014c08f1bd.jpg").into(ivNet);
                break;
            case R.id.bt_yuan:
                //图片自定义大小和圆形图片
                //图片自定义显示大小
                //Glide.with(this).load(Images.imageThumbUrls[2]).override(88, 88).into(iv41);
                //使用圆形变换，还可以使用其他的变换
                Glide.with(this).load("http://i.imgur.com/COzBnru.jpg")
                        .placeholder(R.mipmap.ic_launcher)
                        .bitmapTransform(new CropCircleTransformation(this))
                        .into(ivYuan);
                break;
            case R.id.bt_tuoyuan:
                //定义
                //常规
                //Glide.with(this).load(Images.imageThumbUrls[3]).asBitmap().transform(new        GlideRoundTransform(MainActivity.this)).into(iv4);
                //圆角弧度自定义大小
                // Glide.with(this).load(Images.imageThumbUrls[3]).transform(new GlideRoundTransform(MainActivity.this, 10)).into(iv4);
                //自定义圆形图片
                // Glide.with(this).load(Images.imageThumbUrls[3]).transform(new GlideCircleTransform(MainActivity.this)).into(iv4);

                //Glide.with(this).load(Images.imageThumbUrls[3]).bitmapTransform(new com.zq.glidedemo.RoundedCornersTransformation(this,10)).into(iv4);

                //圆形裁剪
                //Glide.with(this).load(Images.imageThumbUrls[3]).bitmapTransform(new CropCircleTransformation(this)).into(iv4);

                /**
                 * 椭圆形
                 */
                Glide.with(this)
                        .load("http://i.imgur.com/syELajx.jpg")
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)//缓存图片
                        .bitmapTransform(new RoundedCornersTransformation(this,30,0, RoundedCornersTransformation.CornerType.ALL))
                        .into(ivTuoyuan);
                break;
            case R.id.bt_cuow:
               //初始化默认图片和加载失败时的图片，图片加载优先级

               //初始化图片和加载错误时的图片
                Glide.with(this).load("http://img1.imgtn.bdimg.com/it/u=2432702027,3704029716&fm=21&gp=0.jpg")
                        .placeholder(R.mipmap.ic_launcher)
                        .priority(Priority.IMMEDIATE)//指定加载的优先级，优先级越高越优先加载
                        .error(R.mipmap.ic_launcher).centerCrop().into(ivCuow);
                break;
            case R.id.bt_dra:
                //用原图的1/10作为缩略图
                Glide.with(this).load("http://img.my.csdn.net/uploads/201407/26/1406383243_5120.jpg")
                        .thumbnail(0.1f)
                        .into(ivDra);
                //用其它图片作为缩略图
                /*  DrawableRequestBuilder<Integer>   thumbnailRequest=Glide.with(this).load(R.mipmap.ic_launcher);
                         Glide.with(this)
                        .load(Images.imageThumbUrls[1])
                        .thumbnail(thumbnailRequest)
                        .into(iv6);*/
                break;
            case R.id.bt_lzp:
                Glide.with(this).load("http://img5.imgtn.bdimg.com/it/u=2050390856,2980742959&fm=21&gp=0.jpg").bitmapTransform(new GrayscaleTransformation(this)).into(ivLzp);
                break;
            case R.id.bt_suoxiao:
          //成Drawable的类型来加载
                Glide.with(this)
                        .load("http://www.sinaimg.cn/qc/photo_auto/photo/82/29/39238229/39238229_140.jpg")
                        .placeholder(R.mipmap.ic_launcher)
                        .into(new SimpleTarget<GlideDrawable>() {
                            @Override
                            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super  GlideDrawable> glideAnimation) {
                                ivSuoxiao.setImageDrawable(resource);
                            }
                        });
                break;
            case R.id.bt_gif:
                Glide.with(this).load("http://ww1.sinaimg.cn/mw600/6345d84ejw1dvxp9dioykg.gif").asGif().into(ivGif);
                break;
            case R.id.bt_tuptchong:
                Glide.with(this).load("http://www.sinaimg.cn/qc/photo_auto/photo/72/49/39267249/39267249_140.jpg").placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).centerCrop().into(ivTuptchong);
                break;
        }
    }






        //一、最基本的使用
        //with(Context context):Context支持 Activity Context Fragment FragmentActivity中四种类型
        //load():支持远程图片，本地图片文件，图片资源，多媒体数据库的uri
        //into():在哪个imageview中显示
        //String url = "http://img0.pcauto.com.cn/pcauto/1609/06/g_8719572_1473152785181_240x160.jpg";
       // Glide.with(this).load(url).into(ivGlideJb);

        //二、加载资源图片
       /* Glide.with(this).load(R.drawable.f_db).into(ivGlideDraw);

        //三、加载文件图片
        File f = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/DCIM/Camera/IMG_20151025_120635_HDR.jpg");
        Glide.with(this).load(f).into(ivGlideFile);
        //or uri
        Glide.with(this).load(Uri.fromFile(f)).into(ivGlideFile);*/

        //四、设置占位图和动画
        //在图片过大或者网上太慢时，可以设置为图像设置一个占位图，在图像加载出来之前先显示占位图设置占位图的方式
        //还可以设置在图像加载失败时显示的图像
        /*Glide.with(this).load("http://ww4.sinaimg.cn/large/610dc034gw1f96kp6faayj20u00jywg9.jpg")
                .placeholder(R.drawable.im) //设置占位图，在加载之前显示
                .error(R.drawable.im) //在图像加载失败时显示
                .into(ivGlideZw);*/

        //五、在加载图像时，还可以设置图像显示的动画
        //crossFade()有几种重载的方法
        //crossFade(int duration):设置时间
        //crossFade(Animation animation, int duration):设置自定义的动画和时间
        //crossFade(int animationId, int duration): 加载动画资源和时间


     /*   Glide.with(this).load("http://img0.pcauto.com.cn/pcauto/1609/02/g_8709146_1472801055169_240x160.jpg")
                .placeholder(R.drawable.f_db)//设置占位图，在加载之前显示
                .error(R.drawable.f_db)//在图像加载失败时显示
                .crossFade() //设置显示动画，
                .into(ivGlideZw);*/

        //六、图像剪裁和缩放
        //Glide提供了override(horizontalSize, verticalSize)方法来裁剪图像为设置的大小，图像在裁剪之后图像可能会变形，
        // Glide还提供了两种方法 centerCrop()和fitCenter使图像等比例的缩放和显示，可以试一下这个两个方法的显示的不同

      /*  Glide.with(this)
                .load("http://ww4.sinaimg.cn/large/610dc034gw1f96kp6faayj20u00jywg9.jpg")
                .override(200, 240)
                .centerCrop()
                .into(ivGlideJanjisuof);*/


       /* Glide.with(this)
                .load("http://img0.pcauto.com.cn/pcauto/1609/02/g_8708181_1472793809972_240x160.jpg")
                .override(200, 240)
                .fitCenter()
                .into(ivGlideJanjisuof);*/

        //七、缓存
        //一般在图像处理和显示时，
        //都会使用缓存策略，内存缓存或硬盘缓存，在Glide中也提供了不同的缓存策略，默认的情况下会将显示的图像
        //进行内存缓存，也可以设置不使用内存缓存，调用方法skipMemoryCache(true),就告诉Glide我们不打算使用

        //内存缓存，默认是使用内存缓存的
        /*Glide.with(this)
                .load("http://img0.pcauto.com.cn/pcauto/1609/02/g_8704693_1472787714022_240x160.jpg")
                .skipMemoryCache(true)
                .into(ivGlideHuancun);*/

        // glide同时也提供了硬盘缓存，硬盘缓存的策略可以通过方法diskCacheStrategy()来设定
      /*  Glide.with(this)
                .load("http://ww4.sinaimg.cn/large/610dc034gw1f96kp6faayj20u00jywg9.jpg")
                .diskCacheStrategy(DiskCacheStrategy.NONE) //不使用硬盘缓存
                .into(ivGlideHuancun);*/


        //硬盘缓存策略
        // DiskCacheStrategy.NONE: 不使用硬盘缓存
        // DiskCacheStrategy.SOURCE: 将原始图像缓存在硬盘中
        // DiskCacheStrategy.RESULT: 将显示出来大小的图像缓存在硬盘(默认缓存策略)
        //  DiskCacheStrategy.ALL: 显示的图像和原始图像都会缓存





}
