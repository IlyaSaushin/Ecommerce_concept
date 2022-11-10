package com.earl.domain.models

import com.earl.domain.mappers.BasketDomainToUiMapper

interface BasketDomain {

    fun <T> map(mapper: BasketDomainToUiMapper<T>) : T

    class Base(
        private val basket: List<BasketItemDomain>,
        private val delivery: String,
        private val id: Int,
        private val total: Int
    ) : BasketDomain {
        override fun <T> map(mapper: BasketDomainToUiMapper<T>) = mapper.map(basket, delivery, id, total)
    }
}