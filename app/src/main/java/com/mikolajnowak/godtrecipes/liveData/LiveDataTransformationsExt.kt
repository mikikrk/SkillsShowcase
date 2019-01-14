package com.mikolajnowak.godtrecipes.liveData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Transformations

fun <T, R> LiveData<T>.map(transformation: (T?) -> R?): LiveData<R> =
    Transformations.map(this, transformation)

fun <T, R> LiveData<T>.onChange(transformation: (T?) -> R?): LiveData<R> =
    Transformations.map(this, transformation)

fun <T, R> LiveData<T>.switchMap(transformation: (T?) -> LiveData<R>): LiveData<R> =
    Transformations.switchMap(this, transformation)

fun <T> MediatorLiveData<T>.addSimpleSource(source: LiveData<T>) {
    addSource(source) { newData -> value = newData }
}
