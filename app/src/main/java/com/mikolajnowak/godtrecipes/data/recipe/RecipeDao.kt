package com.mikolajnowak.godtrecipes.data.recipe

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.mikolajnowak.godtrecipes.data.recipe.model.Recipe

@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipe")
    fun getAllRecipies(): LiveData<List<Recipe>>

    @Query("SELECT * FROM recipe WHERE title LIKE '%' || :searchQuery || '%' OR ingredients LIKE '%' || :searchQuery || '%'")
    fun findRecipies(searchQuery: String): LiveData<List<Recipe>>
}
