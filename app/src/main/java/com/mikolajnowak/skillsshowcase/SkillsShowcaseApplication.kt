package com.mikolajnowak.godtreceipes

import com.mikolajnowak.godtreceipes.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class SkillsShowcaseApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val component = DaggerApplicationComponent.builder()
                .application(this)
                .build()
        component.inject(this)
        return component
    }
}
