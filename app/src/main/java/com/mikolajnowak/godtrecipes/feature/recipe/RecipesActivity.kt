package com.mikolajnowak.godtrecipes.feature.recipe

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.mikolajnowak.godtrecipes.R
import com.mikolajnowak.godtrecipes.di.viewModel.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class RecipesActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: RecipesViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(RecipesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipes_activity)
    }
}
