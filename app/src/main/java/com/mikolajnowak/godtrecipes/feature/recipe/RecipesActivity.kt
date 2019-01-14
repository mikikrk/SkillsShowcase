package com.mikolajnowak.godtrecipes.feature.recipe

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mikolajnowak.godtrecipes.R
import com.mikolajnowak.godtrecipes.di.viewModel.ViewModelFactory
import com.mikolajnowak.godtrecipes.feature.recipe.list.RecipesAdapter
import com.mikolajnowak.godtrecipes.utils.addOnTextChangedListener
import com.mikolajnowak.godtrecipes.utils.observeOnce
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.recipes_activity.*
import javax.inject.Inject

class RecipesActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: RecipesViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(RecipesViewModel::class.java)
    }
    private val adapter = RecipesAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipes_activity)
        setupRecyclerView()
        observe()
        setupEvents()
    }

    private fun setupRecyclerView() {
        recipesRV.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recipesRV.adapter = adapter
    }

    private fun observe() {
        viewModel.recipesList.observe(this, Observer { pagedList ->
            adapter.submitList(pagedList)
        })
        viewModel.searchQuery.observeOnce(this, Observer { searchInput ->
            searchInput?.let { searchET.setText(it) }
        })
    }

    private fun setupEvents() {
        searchET.addOnTextChangedListener { newText, _, _, _ ->
            viewModel.search(newText.toString())
        }
    }
}
