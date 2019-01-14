package com.mikolajnowak.godtrecipes.liveData

import androidx.lifecycle.MutableLiveData

class InitializedLiveData<T>(

        initialValue: T

) : MutableLiveData<T>() {

    init {
        postValue(initialValue)
    }
}
