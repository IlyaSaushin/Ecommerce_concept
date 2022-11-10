package com.earl.effective_mobile.presentation.models

import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.earl.effective_mobile.R

interface ProductDetailsUi : com.earl.core.Same<ProductDetailsUi>, com.earl.core.DisplayableItem {

    override fun same(data: ProductDetailsUi) = this == data

    fun setRecyclerImage(image: ImageView)

    fun image() : List<String>

    fun colors() : List<String>

    fun mamory() : List<String>

    fun setMainDetails(
        name: TextView,
        rate: RatingBar,
        favorite: ImageView
    )

    fun setShopDetails(
        textPrice: TextView,
        cpuQuality: TextView,
        cameraQuality: TextView,
        sdQuality: TextView,
        ssdQuality: TextView
    )

    class Base(
        val cpu: String,
        val camera: String,
        val capacity: List<String>,
        val color: List<String>,
        val id: String,
        val images: List<String>,
        val isFavorite: Boolean,
        val price: Int,
        val rating: Float,
        val sd: String,
        val ssd: String,
        val title: String,
    ) : ProductDetailsUi {

        override fun setRecyclerImage(image: ImageView) {
            Glide.with(image).load(images).into(image)
        }

        override fun image() = images

        override fun setMainDetails(name: TextView, rate: RatingBar, favorite: ImageView) {
            name.text = title
            rate.rating = rating
            if (isFavorite) {
                favorite.setImageResource(R.drawable.addedtofavbtn)
            } else {
                favorite.setImageResource(R.drawable.addtofavbtn)
            }
        }

        override fun setShopDetails(
            textPrice: TextView,
            cpuQuality: TextView,
            cameraQuality: TextView,
            sdQuality: TextView,
            ssdQuality: TextView
        ) {
            val context = textPrice.context
            textPrice.text = context.resources.getString(R.string.add_to_cart, price.toFloat().toString())
            cpuQuality.text = cpu
            cameraQuality.text = camera
            sdQuality.text = sd
            ssdQuality.text = ssd
        }

        override fun colors() = color

        override fun mamory() = listOf(sd)
    }
}