package com.mikolajnowak.godtrecipes.feature.recipe.list

import android.text.Html
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.mikolajnowak.godtrecipes.utils.loadImage
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.recipe_item.*

class RecipeItemViewHolder(

    override val containerView: View,
    private val lifecycleOwner: LifecycleOwner

) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    private var item: RecipeItemViewModel? = null

    private val thumbnailObserver = Observer<String> { imageUrl ->
        imageUrl?.let { thumbnailIV.loadImage(it) }
    }
    private val titleObserver = Observer<String> { title ->
        title?.let { titleTV.text = it }
    }
    private val descriptionObserver = Observer<String> { description ->
        description?.let { descriptionTV.text = Html.fromHtml(it, Html.FROM_HTML_MODE_COMPACT) }
    }
    private val ingredientsObserver = Observer<List<String>> { ingredients ->
        ingredients?.let { ingredientsTV.text = it.toString() }
    }

    fun bind(recipeItemViewModel: RecipeItemViewModel) {
        item = recipeItemViewModel
        recipeItemViewModel.imageUrl.observe(lifecycleOwner, thumbnailObserver)
        recipeItemViewModel.title.observe(lifecycleOwner, titleObserver)
        recipeItemViewModel.description.observe(lifecycleOwner, descriptionObserver)
        recipeItemViewModel.ingredients.observe(lifecycleOwner, ingredientsObserver)
    }

    fun clear() {
        item?.imageUrl?.removeObserver(thumbnailObserver)
        item?.title?.removeObserver(titleObserver)
        item?.description?.removeObserver(descriptionObserver)
        item?.ingredients?.removeObserver(ingredientsObserver)
    }
}
