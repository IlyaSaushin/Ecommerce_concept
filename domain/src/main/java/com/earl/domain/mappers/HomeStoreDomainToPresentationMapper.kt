package com.earl.domain.mappers

interface HomeStoreDomainToPresentationMapper<T> {

    fun map(
        id: Int,
        is_new: Boolean,
        title: String,
        subtitle: String,
        picture: String,
        is_buy: Boolean,
    ) : T
}