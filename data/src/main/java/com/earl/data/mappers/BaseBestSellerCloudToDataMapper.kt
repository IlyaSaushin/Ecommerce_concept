package com.earl.data.mappers

import com.earl.data.models.BestSellerData

class BaseBestSellerCloudToDataMapper : BestSellerCloudToDataMapper<BestSellerData> {

    override fun map(
        id: Int,
        is_favorites: Boolean,
        title: String,
        price_without_discount: Int,
        discount_price: Int,
        picture: String
    ) = BestSellerData.Base(
        id,
        is_favorites,
        title,
        price_without_discount,
        discount_price,
        picture
    )
}