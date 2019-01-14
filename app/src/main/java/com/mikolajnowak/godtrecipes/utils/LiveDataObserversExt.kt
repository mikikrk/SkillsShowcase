package com.mikolajnowak.godtrecipes.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LiveData<T>.observeOnce(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
    observe(lifecycleOwner, object : Observer<T> {
        override fun onChanged(data: T?) {
            if (data != null) {
                removeObserver(this)
                observer.onChanged(data)
            }
        }
    })
}
