package com.tolodev.buildandy.application

import android.app.Application

class AndyApplication : Application() {

    companion object {
        @JvmStatic
        lateinit var app: AndyApplication
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }

}