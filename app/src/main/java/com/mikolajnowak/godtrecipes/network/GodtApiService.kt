package com.mikolajnowak.godtrecipes.network

import com.mikolajnowak.godtrecipes.data.recipe.model.response.RecipeResponse
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface GodtApiService {

    @GET("getRecipesListDetailed?tags=&size=thumbnail-medium&ratio=1")
    fun getRecipesListDetailed(@Query("limit") limit: Int = 50, @Query("from") from: Int = 0): Single<List<RecipeResponse>>
}
