package com.tolodev.buildandy.ui.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.tolodev.buildandy.R
import com.tolodev.buildandy.data.AndyImageAssets
import com.tolodev.buildandy.databinding.ActivityMainBinding
import com.tolodev.buildandy.ui.fragments.BodyPartFragment


class MainActivity : BaseActivity() {

    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setupView()
    }

    private fun setupView() {
        addFragment(activityMainBinding.containerHead.id, BodyPartFragment.newInstance(0, AndyImageAssets.BodyPartType.HEAD.bodyPart))
        addFragment(activityMainBinding.containerBody.id, BodyPartFragment.newInstance(0, AndyImageAssets.BodyPartType.BODY.bodyPart))
        addFragment(activityMainBinding.containerLegs.id, BodyPartFragment.newInstance(0, AndyImageAssets.BodyPartType.LEGS.bodyPart))
    }


}
