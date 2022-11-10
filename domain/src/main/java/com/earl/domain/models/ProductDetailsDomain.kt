package com.earl.domain.models

import com.earl.domain.mappers.ProductDetailsDomainToUiMapper

interface ProductDetailsDomain {

    fun <T> map(mapper: ProductDetailsDomainToUiMapper<T>) : T

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
        override fun <T> map(mapper: ProductDetailsDomainToUiMapper<T>) =
            mapper.map(cpu, camera, capacity, color, id, images, isFavorite, price, rating, sd, ssd, title)
    }
}