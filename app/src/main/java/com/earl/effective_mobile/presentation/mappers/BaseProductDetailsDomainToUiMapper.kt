package com.earl.effective_mobile.presentation.mappers

import com.earl.effective_mobile.domain.mappers.ProductDetailsDomainToUiMapper
import com.earl.effective_mobile.presentation.models.ProductDetailsUi

class BaseProductDetailsDomainToUiMapper : ProductDetailsDomainToUiMapper<ProductDetailsUi> {

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
    ) = ProductDetailsUi.Base(
        cpu, camera, capacity, color, id, images, isFavorite, price, rating, sd, ssd, title
    )
}