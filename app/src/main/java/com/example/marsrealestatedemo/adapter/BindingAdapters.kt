package com.example.marsrealestatedemo.adapter

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.R
import com.bumptech.glide.request.RequestOptions
import com.example.marsrealestatedemo.enumpackage.MarsStatus
import com.example.marsrealestatedemo.local.Mars

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl?.let {
        val imgUri  = imgUrl.toUri().buildUpon().scheme("https").build()

        Glide.with(imgView.context)
            .load(imgUri)
//            .apply(RequestOptions()
//                .placeholder(R.drawable.loading_animation)
//                .error(R.drawable.ic_broken_image)
//            )
            .into(imgView)
    }
}
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Mars>?){
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}
@BindingAdapter("marsStatus")
fun bindStatus(statusImageView: ImageView, status: MarsStatus?){
    when (status){
        MarsStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
//            statusImageView.setImageResource(R.drawable.loading_img)
        }
        MarsStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
//            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        MarsStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}