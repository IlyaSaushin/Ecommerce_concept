package com.earl.data.mappers

import com.earl.domain.models.ProductDetailsDomain

class BaseProductDetailsDataToDomainMapper : ProductDetailsDataToDomainMapper<ProductDetailsDomain> {

    override fun map(
        cpu: String,
        camera: String,
        capacity: List<String>,
        color: List<String>,
        id: String,
        images: List<String>,
        isFavorite: Boolean,
        price: Int,
        rating: Float,
        sd: String,
        ssd: String,
        title: String
    ) = ProductDetailsDomain.Base(
        cpu, camera, capacity, color, id, images, isFavorite, price, rating, sd, ssd, title
    )
}