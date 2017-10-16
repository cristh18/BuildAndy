package com.tolodev.buildandy.ui.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.tolodev.buildandy.R
import com.tolodev.buildandy.databinding.ActivityMainBinding
import com.tolodev.buildandy.ui.fragments.HomeFragment


class MainActivity : BaseActivity() {

    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        addFragment(activityMainBinding.container.id, HomeFragment())
    }
}
