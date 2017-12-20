package com.tjhq.mygson.picture;

import android.graphics.Bitmap;

import com.squareup.picasso.Transformation;

/**
 * Created by pc on 2017/12/13.
 */

public class customTransformer implements Transformation {

    @Override
    public Bitmap transform(Bitmap source) {
        //在这里可以对Bitmap进行操作，比如改变大小，形状等
        return null;
    }

    @Override
    public String key() {
        return null;
    }
}
