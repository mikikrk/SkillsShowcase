package com.mikolajnowak.godtrecipes.liveData.event

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import android.util.Log

import java.util.concurrent.atomic.AtomicBoolean

private val TAG = "SingleLiveEvent"

abstract class SingleLiveEvent<T> : LiveData<T>() {

    private val pending = AtomicBoolean(false)

    private var subscribedObserver: Observer<in T>? = null

    @Synchronized
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        if (subscribedObserver != null) {
            Log.w(TAG, "Unsubscribing previous observer as only one can be registered to SingleLiveEvent")
        }
        subscribedObserver = observer
        super.observe(owner, Observer {
            if (pending.compareAndSet(true, false)) {
                observer.onChanged(it)
            }
        })
    }

    override fun postValue(value: T?) {
        pending.set(true)
        super.postValue(value)
    }

    override fun setValue(t: T?) {
        pending.set(true)
        super.setValue(t)
    }

    protected open fun call() {
        postValue(null)
    }

    fun removeObserver() {
        subscribedObserver?.let {
            removeObserver(it)
        }
    }

    @Synchronized
    override fun removeObserver(observer: Observer<in T>) {
        super.removeObserver(observer)
        subscribedObserver = null
    }
}
