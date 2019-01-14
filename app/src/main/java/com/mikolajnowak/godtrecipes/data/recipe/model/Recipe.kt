package com.mikolajnowak.godtrecipes.data.recipe.model

data class Recipe (
    val id: String,
    val title: String,
    val imageUrl: String,
    val description: String,
    val ingredients: List<String>
)
