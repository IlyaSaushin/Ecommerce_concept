package com.earl.effective_mobile.data.mappers

interface ProductDetailsCloudToDataMapper<T> {

    fun map(
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
        title: String,
    ) : T
}