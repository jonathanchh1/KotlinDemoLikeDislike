package com.emi.testlikebutton

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LikeViewModelFactory constructor(private var model: LikeModel) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LikeViewModel::class.java))
            return LikeViewModel(model) as T

        throw IllegalArgumentException("its not the modelclass")
    }
}