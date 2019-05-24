package com.emi.testlikebutton

import androidx.databinding.ObservableInt


data class LikeModel(
    val name: String,
    val icon:Int,
    val likes: ObservableInt = ObservableInt(0))