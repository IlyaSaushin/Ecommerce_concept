package com.earl.domain.mappers

interface BasketItemDomainToUiMapper<T> {

    fun map(
        id: Int,
        images: String,
        price: Int,
        title: String
    ) : T
}