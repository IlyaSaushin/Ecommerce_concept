package com.earl.effective_mobile.presentation.models

import android.widget.ImageView
import android.widget.TextView

interface ProductCategory : com.earl.core.Same<ProductCategory> {

    override fun same(data: ProductCategory) = this == data

    fun setDetails(title: TextView, image: ImageView)

    fun clickReact()

    fun isSelected() : Boolean

    class Base(
        private val name: String,
        private val icon: Int,
        private var isSelected: Boolean
    ) : ProductCategory {

        override fun setDetails(title: TextView, image: ImageView) {
            title.text = name
            image.setImageResource(icon)
        }

        override fun clickReact() {
            isSelected = !isSelected
        }

        override fun isSelected() = isSelected
    }
}