package com.tolodev.buildandy.application

import android.app.Application
import com.tolodev.buildandy.util.DeviceUtil

class AndyApplication : Application() {

    companion object {
        @JvmStatic
        lateinit var app: AndyApplication
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        DeviceUtil.initDeviceParams(this)
    }
}