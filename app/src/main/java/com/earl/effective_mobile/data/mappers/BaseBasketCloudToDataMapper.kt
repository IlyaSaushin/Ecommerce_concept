package com.earl.effective_mobile.data.mappers

import com.earl.effective_mobile.data.models.BasketData
import com.earl.effective_mobile.data.models.BasketItemData

class BaseBasketCloudToDataMapper : BasketCloudToDataMapper<BasketData> {

    override fun map(
        basket: List<BasketItemData>,
        delivery: String,
        id: Int,
        total: Int
    ) = BasketData.Base(basket, delivery, id, total)
}