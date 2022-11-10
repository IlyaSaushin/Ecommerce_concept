package com.earl.domain.models

import com.earl.domain.mappers.BestSellerDomainToPresentationMapper

interface BestSellerDomain {

    fun <T> map(mapper: BestSellerDomainToPresentationMapper<T>) : T

    class Base(
        val id: Int,
        val is_favorites: Boolean,
        val title: String,
        val price_without_discount: Int,
        val discount_price: Int,
        val picture: String,
    ) : BestSellerDomain {
        override fun <T> map(mapper: BestSellerDomainToPresentationMapper<T>) = mapper.map(
            id, is_favorites, title, price_without_discount, discount_price, picture
        )
    }
}