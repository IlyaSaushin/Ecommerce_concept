package com.earl.effective_mobile.data.mappers

import com.earl.effective_mobile.domain.models.BasketItemDomain

class BaseBasketItemDataToDomainMapper : BasketItemDataToDomainMapper<BasketItemDomain> {

    override fun map(id: Int, images: String, price: Int, title: String) = BasketItemDomain.Base(id, images, price, title)
}