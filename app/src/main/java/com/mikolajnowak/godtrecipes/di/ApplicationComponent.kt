package com.mikolajnowak.godtrecipes.di

import android.app.Application
import com.mikolajnowak.godtrecipes.SkillsShowcaseApplication
import com.mikolajnowak.godtrecipes.data.DataModule
import com.mikolajnowak.godtrecipes.data.room.RoomModule
import com.mikolajnowak.godtrecipes.di.view.ContributeModule
import com.mikolajnowak.godtrecipes.di.viewModel.ViewModelsModule
import com.mikolajnowak.godtrecipes.network.NetworkModule
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
        ApplicationModule::class,
        ContributeModule::class,
        ViewModelsModule::class,
        NetworkModule::class,
        DataModule::class,
        RoomModule::class
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
