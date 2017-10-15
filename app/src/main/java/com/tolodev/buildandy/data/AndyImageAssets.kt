package com.tolodev.buildandy.data

import android.content.res.TypedArray
import com.tolodev.buildandy.application.AndyApplication
import com.tolodev.buildandy.R

class AndyImageAssets {

    companion object {
        private fun getHeads(): TypedArray {
            return AndyApplication.app.resources.obtainTypedArray(R.array.heads)
        }

        private fun getBodies(): TypedArray {
            return AndyApplication.app.resources.obtainTypedArray(R.array.bodies)
        }

        private fun getLegs(): TypedArray {
            return AndyApplication.app.resources.obtainTypedArray(R.array.legs)
        }

        fun getBodyPartByPosition(position: Int, bodyPart: Int): Int {
            var i = 0
            val andyBodySection: TypedArray = getBodyPartType(bodyPart)
            val size = andyBodySection.length()
            while (i < size) {
                if (position == i) {
                    return andyBodySection.getResourceId(i, -1)
                }
                i++
            }
            return andyBodySection.getResourceId(0, -1)
        }

        private fun getBodyPartType(bodyPart: Int): TypedArray {
            return when (bodyPart) {
                BodyPartType.HEAD.bodyPart -> getHeads()
                BodyPartType.BODY.bodyPart -> getBodies()
                else -> getLegs()
            }
        }

        fun getNextImage(currentImageIndex: Int, bodyPart: Int): Int {
            return if (currentImageIndex < 11) {
                getBodyPartByPosition(currentImageIndex, bodyPart)
            } else {
                getBodyPartByPosition(0, bodyPart)
            }
        }
    }

    enum class BodyPartType(val bodyPart: Int) { HEAD(1), BODY(2), LEGS(3) }


}