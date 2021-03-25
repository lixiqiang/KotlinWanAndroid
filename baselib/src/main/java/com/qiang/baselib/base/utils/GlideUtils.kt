package com.qiang.baselib.base.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

/**
 * @author lixiqiang
 * @date：2021/3/22 0022
 */
object GlideUtils {

    fun load(context: Context, url: String, error: Int, imageView: ImageView) {
        val options = RequestOptions()
            .placeholder(error)
            .error(error)
            .centerCrop()

        Glide.with(context)
            .load(url)
            .apply(options)
            .into(imageView)
    }

    fun load(context: Context, url: String, error: Int, round: Int, imageView: ImageView) {
        val options = RequestOptions()
            .transform(RoundedCorners(round))
            .placeholder(error)
            .error(error)
            .centerCrop()

        Glide.with(context)
            .load(url)
            .apply(options)
            .into(imageView)
    }
}