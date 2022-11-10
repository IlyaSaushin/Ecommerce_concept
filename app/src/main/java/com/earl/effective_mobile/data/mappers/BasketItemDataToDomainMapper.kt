package com.earl.effective_mobile.data.mappers

interface BasketItemDataToDomainMapper<T> {

    fun map(
        id: Int,
        images: String,
        price: Int,
        title: String
    ) : T
}