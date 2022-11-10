package com.earl.effective_mobile.domain.mappers

import com.earl.effective_mobile.data.mappers.HomeStoreDataToDomainMapper
import com.earl.effective_mobile.domain.models.HomeStoreDomain

class BaseHomeStoreDataToDomainMapper : HomeStoreDataToDomainMapper<HomeStoreDomain> {

    override fun map(
        id: Int,
        is_new: Boolean,
        title: String,
        subtitle: String,
        picture: String,
        is_buy: Boolean
    ) = HomeStoreDomain.Base(
        id,
        is_new,
        title,
        subtitle,
        picture,
        is_buy
    )
}