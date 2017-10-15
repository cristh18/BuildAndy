package com.tolodev.buildandy.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel


abstract class BaseViewModel(application: Application?) : AndroidViewModel(application) {

    abstract fun getViewModelName():String

}