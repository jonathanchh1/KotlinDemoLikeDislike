package com.emi.testlikebutton



import android.graphics.Canvas
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.emi.testlikebutton.databinding.ActivityMainBinding

import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var myAdapterImpl: LikingAdapter? = null

    lateinit var viewModel : LikeViewModel
    lateinit var  factory : LikeViewModelFactory
   private val dataMap = mapOf("Messi" to R.drawable.p_meisi, "Second Player" to R.drawable.p_cl, "Modi" to R.drawable.p_modi, "Last Player" to R.drawable.p_mbp)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val dataSource = ArrayList<LikeModel>()
        for ((k, v) in dataMap) {
           val profile = LikeModel(k, v)
            dataSource.add(profile)
            factory = LikeViewModelFactory(profile)

        }
        viewModel = ViewModelProviders.of(this, factory).get(LikeViewModel::class.java)


        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)
        binding.rvContent.layoutManager = LinearLayoutManager(baseContext)

        myAdapterImpl = LikingAdapter(dataSource)

        binding.rvContent.adapter = myAdapterImpl
        binding.rvContent.addItemDecoration(object : RecyclerView.ItemDecoration() {
            var mDivider = resources.getDrawable(R.drawable.item_divi_line)
            override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
                val left = parent.paddingLeft
                val right = parent.width - parent.paddingRight
                val childCount = parent.childCount
                for (i in 0 until childCount) {
                    val child = parent.getChildAt(i)
                    val top = child.bottom
                    val bottom = top + mDivider.intrinsicHeight
                    mDivider.setBounds(left, top, right, bottom)
                    mDivider.draw(c)
                }

            }
        })

}

}
