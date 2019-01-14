package com.mikolajnowak.godtrecipes.data.recipe.model.response

data class RecipeResponse(
        val id: String,
        val title: String,
        val description: String,
        val ingredients: List<IngredientsCollectionResponse>,
        val images: List<ImageResponse>
)
