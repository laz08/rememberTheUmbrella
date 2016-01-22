package dev.remembertheumbrella.helper;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Image loader helper.
 */
public class ImageLoaderHelper {

    /**
     * Loads image from URL to the given ImageView.
     *
     * @param ctx       Context.
     * @param url       URL.
     * @param imageView Imageview.
     */
    public static void loadImage(Context ctx, String url, ImageView imageView) {

        Picasso.with(ctx).load(url).into(imageView);
    }
}
