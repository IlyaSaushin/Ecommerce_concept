package com.earl.data.mappers

interface BestSellerCloudToDataMapper<T> {

    fun map(
        id: Int,
        is_favorites: Boolean,
        title: String,
        price_without_discount: Int,
        discount_price: Int,
        picture: String,
    ) : T
}