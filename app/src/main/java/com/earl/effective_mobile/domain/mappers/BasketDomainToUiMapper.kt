package com.earl.effective_mobile.domain.mappers

import com.earl.effective_mobile.domain.models.BasketItemDomain

interface BasketDomainToUiMapper <T> {

    fun map(
        basket: List<BasketItemDomain>,
        delivery: String,
        id: Int,
        total: Int
    ) : T
}