package com.tolodev.buildandy.ui.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.tolodev.buildandy.R
import com.tolodev.buildandy.data.AndyImageAssets
import com.tolodev.buildandy.databinding.ActivityDetailBinding
import com.tolodev.buildandy.databinding.ActivityMainBinding
import com.tolodev.buildandy.ui.fragments.BodyPartFragment

import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity() {

    lateinit var activityDetailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        setupView(savedInstanceState)
    }

    private fun setupView(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            addFragment(activityDetailBinding.containerHead.id, BodyPartFragment.newInstance(0, AndyImageAssets.BodyPartType.HEAD.bodyPart))
            addFragment(activityDetailBinding.containerBody.id, BodyPartFragment.newInstance(0, AndyImageAssets.BodyPartType.BODY.bodyPart))
            addFragment(activityDetailBinding.containerLegs.id, BodyPartFragment.newInstance(0, AndyImageAssets.BodyPartType.LEGS.bodyPart))
        }
    }

}
