package com.mikolajnowak.godtrecipes.feature.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mikolajnowak.godtrecipes.feature.recipe.list.RecipeItemViewModel
import com.mikolajnowak.godtrecipes.liveData.InitializedLiveData
import com.mikolajnowak.godtrecipes.liveData.mediator.ReplaceableMediatorLiveData

abstract class RecipesViewModel : ViewModel() {

    abstract val recipesList: LiveData<List<RecipeItemViewModel>>
    abstract val searchQuery: LiveData<String>

    abstract fun search(searchQuery: String)
}

class RecipesViewModelImpl : RecipesViewModel() {

    override val recipesList = ReplaceableMediatorLiveData<List<RecipeItemViewModel>>()
    override val searchQuery = InitializedLiveData("")

    override fun search(searchQuery: String) {
    }
}
