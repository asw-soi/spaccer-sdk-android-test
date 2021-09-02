package com.spacer.example.extensions

import android.content.Context
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter


object DataBindingAdapter {
    @JvmStatic
    @BindingAdapter("resourceText")
    fun TextView.setResourceText(resId: Int?) {
        resId ?: return
        this.text = context.getString(resId)
    }

    @JvmStatic
    @BindingAdapter("resourceHint")
    fun TextView.setResourceHint(resId: Int?) {
        resId ?: return
        this.hint = context.getString(resId)
    }

    @JvmStatic
    @BindingAdapter("visibleOrGone")
    fun View.setVisibleOrGone(value: Boolean?) {
        this.visibility = (value == true) then View.VISIBLE ?: View.GONE
    }

    infix fun <T> Boolean.then(other: T) = if (this) other else null
}