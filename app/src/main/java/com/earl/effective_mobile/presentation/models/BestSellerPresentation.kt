package com.earl.effective_mobile.presentation.models

import android.graphics.Paint
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.earl.effective_mobile.R
import com.earl.effective_mobile.core.Same

interface BestSellerPresentation : Same<BestSellerPresentation> {

    override fun same(data: BestSellerPresentation) = data == this

    fun details(
        image: ImageView,
        currentPrice: TextView,
        lastPrice: TextView,
        name: TextView
    )

    fun isFavorite() : Boolean

    class Base(
        val id: Int,
        val is_favorites: Boolean,
        val title: String,
        val price_without_discount: Int,
        val discount_price: Int,
        val picture: String,
    ) : BestSellerPresentation {
        override fun details(
            image: ImageView,
            currentPrice: TextView,
            lastPrice: TextView,
            name: TextView
        ) {
           val context = image.context
            Glide.with(image).load(picture).into(image)
            currentPrice.text = context.resources.getString(R.string.discount_price, discount_price.toString())
            lastPrice.text = context.resources.getString(R.string.priceBefore, price_without_discount.toString())
            lastPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            name.text = title
        }

        override fun isFavorite() = is_favorites
    }
}