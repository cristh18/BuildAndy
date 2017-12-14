package com.tolodev.buildandy.ui.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.tolodev.buildandy.R
import com.tolodev.buildandy.data.AndyImageAssets
import com.tolodev.buildandy.databinding.ActivityDetailBinding
import com.tolodev.buildandy.ui.fragments.BodyPartFragment


class DetailActivity : BaseActivity() {

    lateinit var activityDetailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val intent = intent
        val index = intent.getIntExtra(MainActivity.BODY_INDEX, 0)
        setupView(savedInstanceState, index)
    }

    private fun setupView(savedInstanceState: Bundle?, bodyPartIndex: Int) {
        if (savedInstanceState == null) {
            addFragment(activityDetailBinding.containerHead.id, BodyPartFragment.newInstance(bodyPartIndex, AndyImageAssets.BodyPartType.HEAD.bodyPart))
            addFragment(activityDetailBinding.containerBody.id, BodyPartFragment.newInstance(bodyPartIndex, AndyImageAssets.BodyPartType.BODY.bodyPart))
            addFragment(activityDetailBinding.containerLegs.id, BodyPartFragment.newInstance(bodyPartIndex, AndyImageAssets.BodyPartType.LEGS.bodyPart))
        }
    }

}
