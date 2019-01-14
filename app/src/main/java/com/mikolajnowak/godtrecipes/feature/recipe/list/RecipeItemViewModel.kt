package com.mikolajnowak.godtrecipes.feature.recipe.list

import androidx.lifecycle.LiveData
import com.mikolajnowak.godtrecipes.data.recipe.model.Recipe
import com.mikolajnowak.godtrecipes.liveData.InitializedLiveData

interface RecipeItemViewModel {

    val id: LiveData<String>
    val title: LiveData<String>
    val imageUrl: LiveData<String>
    val description: LiveData<String>
    val ingredients: LiveData<List<String>>
}

class RecipeItemViewModelImpl(

    private val recipe: Recipe

) : RecipeItemViewModel {

    override val id = InitializedLiveData(recipe.id)
    override val title = InitializedLiveData(recipe.title)
    override val imageUrl = InitializedLiveData(recipe.imageUrl)
    override val description = InitializedLiveData(recipe.description)
    override val ingredients = InitializedLiveData(recipe.ingredients)

    override fun equals(other: Any?): Boolean =
        if (other is RecipeItemViewModelImpl) {
            this.recipe == other
        } else {
            super.equals(other)
        }

    override fun hashCode(): Int {
        return recipe.hashCode()
    }
}
