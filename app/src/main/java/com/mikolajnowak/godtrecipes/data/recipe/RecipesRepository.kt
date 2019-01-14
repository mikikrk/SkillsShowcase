package com.mikolajnowak.godtrecipes.data.recipe

import androidx.lifecycle.LiveData
import com.mikolajnowak.godtrecipes.data.recipe.model.Recipe
import com.mikolajnowak.godtrecipes.data.room.AppDatabase
import com.mikolajnowak.godtrecipes.liveData.InitializedLiveData
import dagger.Reusable
import javax.inject.Inject

@Reusable
class RecipesRepository @Inject constructor() {

    @Inject
    lateinit var recipeDao: RecipeDao

    fun getRecipes(searchQuery: String): LiveData<List<Recipe>> =
            if (searchQuery.isEmpty()) {
                recipeDao.getAllRecipies()
            } else {
                recipeDao.findRecipies(searchQuery)
            }
}
