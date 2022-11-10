package com.earl.effective_mobile.presentation.mappers

import com.earl.domain.mappers.BasketDomainToUiMapper
import com.earl.domain.mappers.BasketItemDomainToUiMapper
import com.earl.domain.models.BasketItemDomain
import com.earl.effective_mobile.presentation.models.BasketItemUi
import com.earl.effective_mobile.presentation.models.BasketUi

class BaseBasketDomainToUiMapper(
    private val itemMapper: BasketItemDomainToUiMapper<BasketItemUi>
) : BasketDomainToUiMapper<BasketUi> {

    override fun map(
        basket: List<BasketItemDomain>,
        delivery: String,
        id: Int,
        total: Int
    ) = BasketUi.Base(basket.map { it.map(itemMapper) }, delivery, id, total)
}