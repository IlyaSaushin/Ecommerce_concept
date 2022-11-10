package com.earl.effective_mobile.presentation.mappers

import com.earl.domain.mappers.HomeStoreDomainToPresentationMapper
import com.earl.effective_mobile.presentation.models.HomeStorePresentation

class BaseHomeStoreDomainToPresentationMapper :
    HomeStoreDomainToPresentationMapper<HomeStorePresentation> {

    override fun map(
        id: Int,
        is_new: Boolean,
        title: String,
        subtitle: String,
        picture: String,
        is_buy: Boolean
    ) = HomeStorePresentation.Base(
        id,
        is_new,
        title,
        subtitle,
        picture,
        is_buy
    )
}