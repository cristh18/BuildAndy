package com.tolodev.buildandy.ui.activities

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.widget.Toast
import com.tolodev.buildandy.R
import com.tolodev.buildandy.data.AndyImageAssets
import com.tolodev.buildandy.databinding.ActivityMainBinding
import com.tolodev.buildandy.ui.fragments.BodyPartFragment
import com.tolodev.buildandy.ui.fragments.HomeFragment
import com.tolodev.buildandy.util.DeviceUtil


class MainActivity : BaseActivity(), HomeFragment.HomeFragmentListener {

    companion object {
        val BODY_INDEX = "BODY_INDEX"
    }

    private lateinit var activityMainBinding: ActivityMainBinding
    private var bodyPartIndexSelected = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupView(savedInstanceState)
    }

    private fun setupView(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            addFragment(activityMainBinding.container.id, HomeFragment())
            if (DeviceUtil.isTablet()) {
                addFragment(activityMainBinding.containerHead?.id as Int, BodyPartFragment.newInstance(0, AndyImageAssets.BodyPartType.HEAD.bodyPart))
                addFragment(activityMainBinding.containerBody?.id as Int, BodyPartFragment.newInstance(0, AndyImageAssets.BodyPartType.BODY.bodyPart))
                addFragment(activityMainBinding.containerLegs?.id as Int, BodyPartFragment.newInstance(0, AndyImageAssets.BodyPartType.LEGS.bodyPart))
            }
        }
    }

    override fun imageSelected(imageSelected: Int, index: Int) {
        Toast.makeText(this, "Select image: ".plus(imageSelected.toString()).plus(" - Index Position: ".plus(index)), Toast.LENGTH_SHORT).show()
        bodyPartIndexSelected = index
    }

    override fun showAndy() {
        launchDetailActivity()
    }

    private fun launchDetailActivity() {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(BODY_INDEX, bodyPartIndexSelected)
        startActivity(intent)
    }

}
