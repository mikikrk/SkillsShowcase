package com.mikolajnowak.godtrecipes.di.viewModel

import androidx.lifecycle.ViewModel
import com.mikolajnowak.godtrecipes.feature.recipe.RecipesViewModel
import com.mikolajnowak.godtrecipes.feature.recipe.RecipesViewModelImpl
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ViewModelsModule {

    @Provides
    @IntoMap
    @ViewModelKey(RecipesViewModel::class)
    fun provideRecipesVM(): ViewModel =
            RecipesViewModelImpl()
}
