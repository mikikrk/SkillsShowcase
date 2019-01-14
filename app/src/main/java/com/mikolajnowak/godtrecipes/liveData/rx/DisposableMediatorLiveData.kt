package com.mikolajnowak.godtrecipes.liveData.rx

import com.mikolajnowak.godtrecipes.liveData.mediator.ReplaceableMediatorLiveData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class DisposableMediatorLiveData<T>: ReplaceableMediatorLiveData<T>() {

    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onInactive() {
        super.onInactive()
        compositeDisposable.dispose()
    }
}
