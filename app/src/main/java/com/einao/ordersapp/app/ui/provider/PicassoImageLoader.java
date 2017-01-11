package com.einao.ordersapp.app.ui.provider;


import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.einao.ordersapp.R;
import com.einao.ordersapp.domain.providers.ImageLoader;
import com.squareup.picasso.Picasso;

public class PicassoImageLoader implements ImageLoader<ImageView> {

    private final Context context;

    public PicassoImageLoader(Context context) {
        this.context = context;
    }

    @Override
    public void load(ImageView view, String url) {

        if (url != null && !url.isEmpty() && Uri.parse(url) != null) {
            Picasso.with(context)
                    .load(url)
                    .placeholder(R.mipmap.ic_placeholder)
                    .error(R.mipmap.ic_placeholder)
                    .into(view);
        } else {
            view.setImageResource(R.mipmap.ic_placeholder);
        }
    }
}
