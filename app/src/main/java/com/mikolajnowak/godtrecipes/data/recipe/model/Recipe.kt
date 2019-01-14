package com.mikolajnowak.godtrecipes.data.recipe.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recipe(
        @PrimaryKey
        val id: String,
        val title: String,
        val imageUrl: String?,
        val description: String,
        val ingredients: List<String>
)
