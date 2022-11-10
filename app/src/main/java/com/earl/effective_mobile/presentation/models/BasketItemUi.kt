package com.earl.effective_mobile.presentation.models

import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.earl.effective_mobile.R

interface BasketItemUi : com.earl.core.Same<BasketItemUi> {

    override fun same(data: BasketItemUi) = this == data

    fun details(
        name: TextView,
        icon: ImageView,
        cost: TextView
    )

    class Base(
        private val id: Int,
        private val images: String,
        private val price: Int,
        private val title: String
    ) : BasketItemUi {
        override fun details(name: TextView, icon: ImageView, cost: TextView) {
            val context = name.context
            name.text = title
            Glide.with(icon).load(images).into(icon)
            cost.text = context.resources.getString(R.string.discount_price, price.toFloat().toString())
        }
    }
}