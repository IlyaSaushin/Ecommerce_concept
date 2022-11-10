package com.earl.effective_mobile.domain.mappers

import com.earl.effective_mobile.presentation.models.BasketItemUi

class BaseBasketItemDomainToUiMapper : BasketItemDomainToUiMapper<BasketItemUi> {

    override fun map(id: Int, images: String, price: Int, title: String) = BasketItemUi.Base(id, images, price, title)
}