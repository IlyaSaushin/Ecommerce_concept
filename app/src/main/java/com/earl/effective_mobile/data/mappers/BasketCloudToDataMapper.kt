package com.earl.effective_mobile.data.mappers

import com.earl.effective_mobile.data.models.BasketItemData

interface BasketCloudToDataMapper<T> {

    fun  map(
        basket: List<BasketItemData>,
        delivery: String,
        id: Int,
        total: Int
    ) : T
}