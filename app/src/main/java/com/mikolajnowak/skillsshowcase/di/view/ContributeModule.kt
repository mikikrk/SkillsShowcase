package com.mikolajnowak.skillsshowcase.di.view

import com.mikolajnowak.skillsshowcase.feature.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ContributeModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
