package com.earl.data.mappers

import com.earl.data.models.BasketItemData

class BaseBasketItemCloudToDataMapper : BasketItemCloudToDataMapper<BasketItemData> {

    override fun map(id: Int, images: String, price: Int, title: String) = BasketItemData.Base(id, images, price, title)
}