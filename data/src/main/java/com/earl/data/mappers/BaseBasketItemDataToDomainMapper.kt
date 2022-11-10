package com.earl.data.mappers

import com.earl.domain.models.BasketItemDomain

class BaseBasketItemDataToDomainMapper : BasketItemDataToDomainMapper<BasketItemDomain> {

    override fun map(id: Int, images: String, price: Int, title: String) = BasketItemDomain.Base(id, images, price, title)
}