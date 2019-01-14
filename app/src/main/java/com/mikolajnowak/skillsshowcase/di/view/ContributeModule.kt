package com.mikolajnowak.godtreceipes.di.view

import com.mikolajnowak.godtreceipes.feature.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ContributeModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
