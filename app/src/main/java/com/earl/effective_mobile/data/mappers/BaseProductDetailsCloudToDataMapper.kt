package com.earl.effective_mobile.data.mappers

import com.earl.effective_mobile.data.models.ProductDetailsData

class BaseProductDetailsCloudToDataMapper : ProductDetailsCloudToDataMapper<ProductDetailsData> {

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
    ) = ProductDetailsData.Base(
        cpu, camera, capacity, color, id, images, isFavorite, price, rating, sd, ssd, title
    )
}