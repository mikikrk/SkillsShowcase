package com.mikolajnowak.godtrecipes.data.recipe

import androidx.lifecycle.LiveData
import com.mikolajnowak.godtrecipes.data.recipe.model.Recipe
import com.mikolajnowak.godtrecipes.data.recipe.model.toEntity
import com.mikolajnowak.godtrecipes.liveData.addSimpleSource
import com.mikolajnowak.godtrecipes.liveData.rx.DisposableMediatorLiveData
import com.mikolajnowak.godtrecipes.network.GodtApiService
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@Reusable
class RecipesRepository @Inject constructor() {

    @Inject
    lateinit var recipeDao: RecipeDao

    @Inject
    lateinit var godtApi: GodtApiService

    fun getRecipes(searchQuery: String): LiveData<List<Recipe>> =
            DisposableMediatorLiveData<List<Recipe>>().apply {
                addDisposable(loadFromApiIntoDB())
                addSimpleSource(getRoomList(searchQuery))
            }

    private fun loadFromApiIntoDB() =
            godtApi.getRecipesListDetailed()
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.computation())
                    .map { recipesList ->
                        recipesList.map { recipeResponse ->
                            recipeResponse.toEntity()
                        }
                    }
                    .subscribe({ recipesList ->
                        recipeDao.insertAll(recipesList)
                    }, {
                        //TODO return to UI
                    })

    private fun getRoomList(searchQuery: String): LiveData<List<Recipe>> {
        return if (searchQuery.isEmpty()) {
            recipeDao.getAllRecipies()
        } else {
            recipeDao.findRecipies(searchQuery)
        }
    }
}
