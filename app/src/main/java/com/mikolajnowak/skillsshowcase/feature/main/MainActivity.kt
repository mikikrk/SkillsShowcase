package com.mikolajnowak.skillsshowcase.feature.main

import android.os.Bundle
import com.mikolajnowak.skillsshowcase.R
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
