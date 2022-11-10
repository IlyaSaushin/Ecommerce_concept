package com.earl.effective_mobile.data.mappers

interface BasketItemCloudToDataMapper<T> {

    fun map(
        id: Int,
        images: String,
        price: Int,
        title: String
    ) : T
}