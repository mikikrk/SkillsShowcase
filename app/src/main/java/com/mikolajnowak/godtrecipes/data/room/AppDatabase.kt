package com.mikolajnowak.godtrecipes.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mikolajnowak.godtrecipes.data.recipe.RecipeDao
import com.mikolajnowak.godtrecipes.data.recipe.model.Recipe

@Database(entities = arrayOf(
        Recipe::class
), version = 1)
@TypeConverters(
        StringListConverter::class
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun recipesDao(): RecipeDao
}