package com.earl.effective_mobile.domain.models

import com.earl.effective_mobile.domain.mappers.ProductDetailsDomainToUiMapper
import com.earl.effective_mobile.presentation.models.ProductDetailsUi

interface ProductDetailsDomain {

    fun map(mapper: ProductDetailsDomainToUiMapper<ProductDetailsUi>) : ProductDetailsUi

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
    ) : ProductDetailsDomain {
        override fun map(mapper: ProductDetailsDomainToUiMapper<ProductDetailsUi>) =
            mapper.map(cpu, camera, capacity, color, id, images, isFavorite, price, rating, sd, ssd, title)
    }
}