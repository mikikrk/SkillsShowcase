package com.mikolajnowak.godtrecipes.data.recipe

import androidx.lifecycle.LiveData
import com.mikolajnowak.godtrecipes.data.recipe.model.Recipe
import com.mikolajnowak.godtrecipes.liveData.InitializedLiveData
import dagger.Reusable
import javax.inject.Inject

@Reusable
class RecipesRepository @Inject constructor() {

    fun getRecipes(searchQuery: String): LiveData<List<Recipe>> {
        val recipes = listOf(Recipe("1", "title1", "https://i.pinimg.com/736x/37/2e/07/372e079d1ad511dbca4fd67e2feb51c1--strawberry-balsamic-icecream.jpg", "some description", listOf("sugar", "salt")))
        return InitializedLiveData(recipes)
    }
}
