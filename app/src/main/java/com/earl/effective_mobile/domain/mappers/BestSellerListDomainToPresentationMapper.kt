package com.earl.effective_mobile.domain.mappers

import com.earl.effective_mobile.core.ErrorType
import com.earl.effective_mobile.domain.models.BestSellerDomain
import com.earl.effective_mobile.presentation.models.BestSellerListPresentation

interface BestSellerListDomainToPresentationMapper {
    fun map(list: List<BestSellerDomain>): BestSellerListPresentation
    fun map(e: ErrorType): BestSellerListPresentation
}