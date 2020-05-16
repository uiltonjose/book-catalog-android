package com.ujps.bookcatalog.utils;

import android.content.Context;
import android.widget.ImageView;

import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class ImageUtil {

    public static void fetchImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .placeholder(getImageProgress(context))
                .into(imageView);
    }

    private static CircularProgressDrawable getImageProgress(Context context) {
        CircularProgressDrawable progress = new CircularProgressDrawable(context);
        progress.setStrokeWidth(5f);
        progress.setCenterRadius(30f);
        progress.start();
        return progress;
    }
}
