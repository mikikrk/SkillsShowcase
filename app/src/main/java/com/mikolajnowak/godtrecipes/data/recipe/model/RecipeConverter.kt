package com.mikolajnowak.godtrecipes.data.recipe.model

import com.mikolajnowak.godtrecipes.data.recipe.model.response.RecipeResponse

fun RecipeResponse.toEntity() =
        Recipe(id,
                title,
                images.firstOrNull()?.url,
                description,
                ingredients.flatMap { collectionResponse -> collectionResponse.elements }
                        .map { ingredient -> ingredient.name })
