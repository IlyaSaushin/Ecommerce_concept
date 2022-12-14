package com.earl.data.models

import com.earl.data.mappers.BasketItemDataToDomainMapper

interface BasketItemData {

    fun <T> map(mapper: BasketItemDataToDomainMapper<T>) : T

    class Base(
        private val id: Int,
        private val images: String,
        private val price: Int,
        private val title: String
    ) : BasketItemData {
        override fun <T> map(mapper: BasketItemDataToDomainMapper<T>) = mapper.map(id, images, price, title)
    }
}