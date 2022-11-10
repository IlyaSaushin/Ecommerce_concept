package com.earl.domain.mappers

import com.earl.domain.models.BasketItemDomain

interface BasketDomainToUiMapper <T> {

    fun map(
        basket: List<BasketItemDomain>,
        delivery: String,
        id: Int,
        total: Int
    ) : T
}