package com.tolodev.buildandy.viewmodel

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.ClipData.Item


class SharedViewModel(application: Application) : BaseViewModel(application) {

    private val selected = MutableLiveData<Item>()

    fun select(item: Item) {
        selected.value = item
    }

    fun getSelected(): LiveData<Item> {
        return selected
    }

    override fun getViewModelName(): String = SharedViewModel::class.java.name


}