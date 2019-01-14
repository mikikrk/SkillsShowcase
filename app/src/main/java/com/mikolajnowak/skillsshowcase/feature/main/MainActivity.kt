package com.mikolajnowak.godtreceipes.feature.main

import android.os.Bundle
import com.mikolajnowak.godtreceipes.R
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
