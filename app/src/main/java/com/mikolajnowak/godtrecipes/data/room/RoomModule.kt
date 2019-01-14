package com.mikolajnowak.godtrecipes.data.room

import android.content.Context
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.mikolajnowak.godtrecipes.data.recipe.RecipeDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideApplicationDatabase(applicationContext: Context): AppDatabase =
            Room.databaseBuilder(applicationContext,
                    AppDatabase::class.java,
                    "GodtRecipies")
                    .build()

    @Provides
    @Singleton
    fun provideRecipesDao(appDatabase: AppDatabase): RecipeDao = appDatabase.recipesDao()
}