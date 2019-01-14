package com.mikolajnowak.godtrecipes.liveData.event

open class MutableSingleLiveEvent<T> : SingleLiveEvent<T>() {

    public override fun postValue(value: T?) {
        super.postValue(value)
    }

    public override fun setValue(t: T?) {
        super.setValue(t)
    }

    public override fun call() {
        super.call()
    }
}
