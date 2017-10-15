package com.tolodev.buildandy.binding

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

class GeneralBinding {
    object ImageViewBindingAdapter {
        @BindingAdapter("bind:imageId")
        @JvmStatic
        fun loadImage(view: ImageView, bodyPartId: Int) {
            Picasso.with(view.context).load(bodyPartId).into(view)
        }
    }
}