package com.tolodev.buildandy


import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    protected fun addFragment(containerId: Int, fragment: BodyPartFragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
                .add(containerId, fragment)
                .commit()
    }

}