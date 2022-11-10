package com.earl.effective_mobile.domain.models

import com.earl.effective_mobile.domain.mappers.HomeStoreDomainToPresentationMapper

interface HomeStoreDomain {

    fun <T> map(mapper: HomeStoreDomainToPresentationMapper<T>) : T

    class Base(
        val id: Int,
        val is_new: Boolean,
        val title: String,
        val subtitle: String,
        val picture: String,
        val is_buy: Boolean,
    ) : HomeStoreDomain {
        override fun <T> map(mapper: HomeStoreDomainToPresentationMapper<T>) = mapper.map(
            id, is_new, title, subtitle, picture, is_buy
        )
    }
}