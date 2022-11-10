package com.earl.effective_mobile.data.models

import com.earl.effective_mobile.data.mappers.ProductDetailsDataToDomainMapper
import com.earl.effective_mobile.domain.models.ProductDetailsDomain

interface ProductDetailsData {

    fun map(mapper: ProductDetailsDataToDomainMapper<ProductDetailsDomain>) : ProductDetailsDomain

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
    ) : ProductDetailsData {
        override fun map(mapper: ProductDetailsDataToDomainMapper<ProductDetailsDomain>) =
            mapper.map(cpu, camera, capacity, color, id, images, isFavorite, price, rating, sd, ssd, title)
    }
}