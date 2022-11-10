package com.earl.data.mappers

import com.earl.data.models.BasketData
import com.earl.data.models.BasketItemData

class BaseBasketCloudToDataMapper : BasketCloudToDataMapper<BasketData> {

    override fun map(
        basket: List<BasketItemData>,
        delivery: String,
        id: Int,
        total: Int
    ) = BasketData.Base(basket, delivery, id, total)
}