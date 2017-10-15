package com.tolodev.buildandy.util

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat

class DrawableUtil {

    companion object {
        fun getDrawableFromResourceId(context:Context, imageId: Int): Drawable = ContextCompat.getDrawable(context, imageId)
    }
}