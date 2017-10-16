package com.tolodev.buildandy.data

import android.content.res.TypedArray
import com.tolodev.buildandy.R
import com.tolodev.buildandy.application.AndyApplication

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

        fun getAll(): MutableList<Int> {

            val heads: MutableList<Int> = getBodyPart(getHeads())
            val bodies: MutableList<Int> = getBodyPart(getHeads())
            val legs: MutableList<Int> = getBodyPart(getHeads())

            val allImages: MutableList<Int> = mutableListOf()
            allImages.addAll(heads)
            allImages.addAll(bodies)
            allImages.addAll(legs)

            return allImages
        }

        fun getBodyPart(bodySection: TypedArray): MutableList<Int> {
            var i = 0
            val images: MutableList<Int> = mutableListOf()
            val size = bodySection.length()
            while (i < size) {
                images.add(bodySection.getResourceId(i, -1))
                i++
            }
            bodySection.recycle()
            return images
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
            andyBodySection.recycle()
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