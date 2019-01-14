package com.mikolajnowak.godtrecipes.feature.recipe

import android.os.Bundle
import com.mikolajnowak.godtrecipes.R
import dagger.android.support.DaggerAppCompatActivity

class RecipesActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.receipes_activity)
    }
}
