package com.mikolajnowak.godtrecipes.di.view

import com.mikolajnowak.godtrecipes.feature.recipe.RecipesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ContributeModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): RecipesActivity
}
