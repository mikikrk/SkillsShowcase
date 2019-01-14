package com.mikolajnowak.godtrecipes.utils

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.core.text.HtmlCompat
import com.mikolajnowak.godtrecipes.network.GlideApp

val Context.inflater: LayoutInflater
    get() = LayoutInflater.from(this)

fun ViewGroup.inflate(@LayoutRes resId: Int, attachToRoot: Boolean = false): View =
        context.inflater.inflate(resId, this, attachToRoot)

fun EditText.addOnTextChangedListener(callback: (CharSequence?, Int, Int, Int) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            callback(s, start, before, count)
        }
    })
}

fun ImageView.loadImage(url: String) {
    GlideApp.with(context).load(url).into(this)
}

fun String.toHtml() =
        HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_COMPACT)
