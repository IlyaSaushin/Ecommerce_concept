package com.earl.effective_mobile.domain.models

import com.earl.effective_mobile.domain.mappers.BasketItemDomainToUiMapper

interface BasketItemDomain {

    fun <T> map(mapper: BasketItemDomainToUiMapper<T>) : T

    class Base(
        private val id: Int,
        private val images: String,
        private val price: Int,
        private val title: String
    ) : BasketItemDomain {
        override fun <T> map(mapper: BasketItemDomainToUiMapper<T>) = mapper.map(id, images, price, title)
    }
}