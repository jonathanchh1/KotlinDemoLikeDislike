package com.emi.testlikebutton


import android.util.Log
import androidx.lifecycle.ViewModel


class LikeViewModel constructor(var like : LikeModel): ViewModel() {


    fun name() = like.name
    fun icon() = like.icon
    fun likes() = like.likes


    fun onLike(){
        like.likes.set(like.likes.get() + 1)
    }


    fun onDislike(){
        if(like.likes.get() > 0){
            like.likes.set(like.likes.get() - 1)
        }else if(like.likes.get() == 0){
            Log.d("msg", "its on zero ")
        }else{
            Log.d("error", "there was an error")
        }
    }

    
}