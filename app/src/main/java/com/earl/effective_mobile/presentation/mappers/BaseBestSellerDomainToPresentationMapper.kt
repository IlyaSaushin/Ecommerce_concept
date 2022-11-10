package com.earl.effective_mobile.presentation.mappers

import com.earl.domain.mappers.BestSellerDomainToPresentationMapper
import com.earl.effective_mobile.presentation.models.BestSellerPresentation

class BaseBestSellerDomainToPresentationMapper :
    BestSellerDomainToPresentationMapper<BestSellerPresentation> {

    override fun map(
        id: Int,
        is_favorites: Boolean,
        title: String,
        price_without_discount: Int,
        discount_price: Int,
        picture: String
    ) = BestSellerPresentation.Base(
        id,
        is_favorites,
        title,
        price_without_discount,
        discount_price,
        picture
    )
}