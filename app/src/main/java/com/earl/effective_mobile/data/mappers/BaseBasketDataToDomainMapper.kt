package com.earl.effective_mobile.data.mappers

import com.earl.effective_mobile.data.models.BasketItemData
import com.earl.effective_mobile.domain.models.BasketDomain
import com.earl.effective_mobile.domain.models.BasketItemDomain

class BaseBasketDataToDomainMapper(
    private val itemMapper: BasketItemDataToDomainMapper<BasketItemDomain>
) : BasketDataToDomainMapper<BasketDomain> {

    override fun map(
        basket: List<BasketItemData>,
        delivery: String,
        id: Int,
        total: Int
    ) = BasketDomain.Base(basket.map { it.map(itemMapper) }, delivery, id, total)
}