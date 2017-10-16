package com.tolodev.buildandy.ui.activities


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.tolodev.buildandy.ui.fragments.BodyPartFragment

open class BaseActivity : AppCompatActivity() {

    protected fun addFragment(containerId: Int, fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
                .add(containerId, fragment)
                .commit()
    }

}