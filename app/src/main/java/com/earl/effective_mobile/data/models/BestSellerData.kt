package com.earl.effective_mobile.data.models

import com.earl.effective_mobile.data.mappers.BestSellerDataToDomainMapper

interface BestSellerData {

    fun <T> map(mapper: BestSellerDataToDomainMapper<T>) : T

    class Base(
        val id: Int,
        val is_favorites: Boolean,
        val title: String,
        val price_without_discount: Int,
        val discount_price: Int,
        val picture: String,
    ) : BestSellerData {
        override fun <T> map(mapper: BestSellerDataToDomainMapper<T>) = mapper.map(
            id, is_favorites, title, price_without_discount, discount_price, picture
        )
    }
}