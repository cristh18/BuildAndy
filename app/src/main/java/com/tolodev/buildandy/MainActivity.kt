package com.tolodev.buildandy

import android.os.Bundle

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(R.id.container_head, BodyPartFragment())
        addFragment(R.id.container_body, BodyPartFragment())
        addFragment(R.id.container_legs, BodyPartFragment())
    }
}
