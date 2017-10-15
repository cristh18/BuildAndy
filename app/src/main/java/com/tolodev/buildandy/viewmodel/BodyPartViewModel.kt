package com.tolodev.buildandy.viewmodel

import android.app.Application
import android.databinding.ObservableField
import com.tolodev.buildandy.data.AndyImageAssets
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

class BodyPartViewModel(application: Application?) : BaseViewModel(application) {


    var bodyPartSubscriptions: CompositeDisposable = CompositeDisposable()
    var changeBodyPart = BehaviorSubject.create<Boolean>()


    var andyImage: ObservableField<Int> = ObservableField()

    var imageIndex: Int = 0
    var bodySection: Int = 0

    fun handleSubscriptions() {
        bodyPartSubscriptions.add(changeAndyClothesDisposable())
    }

    private fun changeAndyClothesDisposable(): Disposable {
        return changeBodyPart
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter({ t -> t })
                .subscribeBy(  // named arguments for lambda Subscribers
                        onNext = { b: Boolean? ->
                            imageIndex += 1
                            andyImage.set(AndyImageAssets.getNextImage(imageIndex, bodySection))
                        },
                        onError = { it.printStackTrace() }
                )
    }

    override fun getViewModelName(): String = BodyPartViewModel::class.java.name

    fun getAndyBodyPartImage() {
        andyImage.set(AndyImageAssets.getBodyPartByPosition(imageIndex, bodySection))
    }
}