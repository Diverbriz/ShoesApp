package com.example.shoesapp.Presentation.Operations.picasso;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoOperations{

    public static void loadImage(String uri, Context context, ImageView imageView){
        Picasso.with(context.getApplicationContext())
                        .load(uri)
                                .into(imageView);
    }
}

