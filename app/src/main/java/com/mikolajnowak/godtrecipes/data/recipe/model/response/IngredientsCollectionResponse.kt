package com.mikolajnowak.godtrecipes.data.recipe.model.response

data class IngredientsCollectionResponse(
        val elements: List<IngredientResponse>
)

data class IngredientResponse(
        val name: String
)
