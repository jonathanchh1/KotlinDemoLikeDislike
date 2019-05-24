package com.emi.testlikebutton

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.emi.testlikebutton.databinding.ItemLikeTrendBinding


class LikingAdapter(private val LikeList : ArrayList<LikeModel>) : RecyclerView.Adapter<LikingAdapter.LikeBindingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): LikeBindingViewHolder{
        val itemView = DataBindingUtil.inflate<ItemLikeTrendBinding>(LayoutInflater.from(parent.context), R.layout.item_like_trend, parent, false)
        return LikeBindingViewHolder(itemView /* itemClick */)
    }

    override fun getItemCount(): Int {
        return LikeList.size
    }

    override fun onBindViewHolder(viewHolder: LikeBindingViewHolder, position: Int) {
        viewHolder.bind(LikeList[position])
    }





    inner class LikeBindingViewHolder(val binding : ItemLikeTrendBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(Like : LikeModel){
         if(binding.profile == null){
             binding.profile = LikeViewModel(Like)
         }else{
             binding.profile!!.like = Like
         }

            }

    }

    /*

    class LikeBindingViewHolder(val view: ItemLikeTrendBinding /* private val itemClick: (LikeModel) -> Unit */ ) : RecyclerView.ViewHolder(view.root) {

        fun bind(itemData: LikeModel) {

          /*  itemView.bt_like.setOnClickListener {
                itemClick(itemData)
            }

            */
        }
    }

    */
}