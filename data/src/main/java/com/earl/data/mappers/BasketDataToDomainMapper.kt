package com.earl.data.mappers

import com.earl.data.models.BasketItemData

interface BasketDataToDomainMapper<T> {

    fun map(
        basket: List<BasketItemData>,
        delivery: String,
        id: Int,
        total: Int
    ) : T
}