package com.earl.data.mappers

import com.earl.data.models.BasketItemData
import com.earl.domain.models.BasketDomain
import com.earl.domain.models.BasketItemDomain

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