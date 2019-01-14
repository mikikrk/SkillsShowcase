package com.mikolajnowak.godtrecipes.feature.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mikolajnowak.godtrecipes.data.recipe.RecipesRepository
import com.mikolajnowak.godtrecipes.feature.recipe.list.RecipeItemViewModel
import com.mikolajnowak.godtrecipes.feature.recipe.list.RecipeItemViewModelImpl
import com.mikolajnowak.godtrecipes.liveData.InitializedLiveData
import com.mikolajnowak.godtrecipes.liveData.addSimpleSource
import com.mikolajnowak.godtrecipes.liveData.map
import com.mikolajnowak.godtrecipes.liveData.mediator.ReplaceableMediatorLiveData

abstract class RecipesViewModel : ViewModel() {

    abstract val recipesList: LiveData<List<RecipeItemViewModel>>
    abstract val searchQuery: LiveData<String>

    abstract fun search(searchQuery: String)
}

class RecipesViewModelImpl(

        private val recipesRepository: RecipesRepository

) : RecipesViewModel() {

    override val recipesList = ReplaceableMediatorLiveData<List<RecipeItemViewModel>>()
    override val searchQuery = InitializedLiveData("")

    init {
        search("")
    }

    override fun search(searchQuery: String) {
        recipesRepository.getRecipes(searchQuery)
                .map { newList ->
                    newList?.map { recipe ->
                        RecipeItemViewModelImpl(recipe) as RecipeItemViewModel
                    }
                }
                .also { newList ->
                    recipesList.addSimpleSource(newList)
                }
    }
}
