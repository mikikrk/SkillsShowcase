package com.mikolajnowak.godtrecipes.liveData.mediator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer

class ReplaceableMediatorLiveData<T> : MediatorLiveData<T>() {

    private var previousSource: LiveData<T>? = null

    override fun <S : Any?> addSource(source: LiveData<S>, onChanged: Observer<in S>) {
        previousSource?.let { removeSource(it) }
        super.addSource(source, onChanged)
    }
}
