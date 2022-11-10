package com.earl.data.mappers

interface BasketItemCloudToDataMapper<T> {

    fun map(
        id: Int,
        images: String,
        price: Int,
        title: String
    ) : T
}