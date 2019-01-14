package com.mikolajnowak.godtrecipes.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

val Context.inflater: LayoutInflater
    get() = LayoutInflater.from(this)

fun ViewGroup.inflate(@LayoutRes resId: Int, attachToRoot: Boolean = false): View =
    context.inflater.inflate(resId, this, attachToRoot)
