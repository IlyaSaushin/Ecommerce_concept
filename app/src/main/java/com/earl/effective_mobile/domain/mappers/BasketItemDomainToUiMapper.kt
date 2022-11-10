package com.earl.effective_mobile.domain.mappers

interface BasketItemDomainToUiMapper<T> {

    fun map(
        id: Int,
        images: String,
        price: Int,
        title: String
    ) : T
}