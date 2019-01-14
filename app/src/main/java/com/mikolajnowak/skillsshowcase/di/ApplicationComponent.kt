package com.mikolajnowak.godtreceipes.di

import android.app.Application
import com.mikolajnowak.godtreceipes.SkillsShowcaseApplication
import com.mikolajnowak.godtreceipes.di.view.ContributeModule
import com.mikolajnowak.godtreceipes.di.viewModel.ViewModelsModule
import com.mikolajnowak.godtreceipes.network.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ContributeModule::class,
        ViewModelsModule::class,
        NetworkModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    fun inject(application: SkillsShowcaseApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}
