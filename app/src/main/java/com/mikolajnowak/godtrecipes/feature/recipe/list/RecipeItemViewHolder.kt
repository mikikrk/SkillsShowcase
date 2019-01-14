package com.mikolajnowak.godtrecipes.feature.recipe.list

import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

class RecipeItemViewHolder(

    override val containerView: View,
    val lifecycleOwner: LifecycleOwner

) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun bind(recipeItemViewModel: RecipeItemViewModel) {

    }

    fun clear() {

    }
}
