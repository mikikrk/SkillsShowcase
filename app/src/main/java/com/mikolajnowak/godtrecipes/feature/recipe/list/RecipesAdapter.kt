package com.mikolajnowak.godtrecipes.feature.recipe.list

import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.mikolajnowak.godtrecipes.R
import com.mikolajnowak.godtrecipes.utils.inflate

class RecipesAdapter(

        private val lifecycleOwner: LifecycleOwner

) : ListAdapter<RecipeItemViewModel, RecipeItemViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeItemViewHolder {
        val view = parent.inflate(R.layout.recipe_item)
        return RecipeItemViewHolder(view, lifecycleOwner)
    }

    override fun onBindViewHolder(holder: RecipeItemViewHolder, position: Int) {
        getItem(position)?.let { item ->
            holder.bind(item)
        }
    }

    override fun onViewRecycled(holder: RecipeItemViewHolder) {
        super.onViewRecycled(holder)
        holder.clear()
    }
}

private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<RecipeItemViewModel>() {

    override fun areItemsTheSame(oldItem: RecipeItemViewModel, newItem: RecipeItemViewModel): Boolean =
            oldItem.id.value == newItem.id.value

    override fun areContentsTheSame(oldItem: RecipeItemViewModel, newItem: RecipeItemViewModel): Boolean =
            oldItem == newItem
}
