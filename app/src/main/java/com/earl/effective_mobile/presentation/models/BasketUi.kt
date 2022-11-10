package com.earl.effective_mobile.presentation.models

import android.widget.TextView
import com.earl.effective_mobile.R

interface BasketUi {

    fun baskets() : List<BasketItemUi>

    fun details(
        totalPrice: TextView,
        deliveryPrice: TextView,
    )

    class Base(
        private val basket: List<BasketItemUi>,
        private val delivery: String,
        private val id: Int,
        private val total: Int
    ) : BasketUi {

        override fun baskets() = basket

        override fun details(totalPrice: TextView, deliveryPrice: TextView) {
            val context = totalPrice.context
            totalPrice.text = context.resources.getString(R.string.totalprice, total.toString())
            deliveryPrice.text = delivery
        }
    }
}