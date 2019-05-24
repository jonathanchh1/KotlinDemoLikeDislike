package com.emi.testlikebutton


import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter

object BindingMethod {


    @BindingAdapter("bind:srcCompat")
    @JvmStatic
    fun srcCompat(view: ImageView, @DrawableRes drawableId: Int) {
        view.setImageResource(drawableId)
    }



}