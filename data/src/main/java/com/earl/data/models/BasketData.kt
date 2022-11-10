package com.earl.data.models

import com.earl.data.mappers.BasketDataToDomainMapper

interface BasketData {

    fun <T> map(mapper: BasketDataToDomainMapper<T>) : T

    class Base(
        private val basket: List<BasketItemData>,
        private val delivery: String,
        private val id: Int,
        private val total: Int
    ) : BasketData {
        override fun <T> map(mapper: BasketDataToDomainMapper<T>) = mapper.map(basket, delivery, id, total)
    }
}