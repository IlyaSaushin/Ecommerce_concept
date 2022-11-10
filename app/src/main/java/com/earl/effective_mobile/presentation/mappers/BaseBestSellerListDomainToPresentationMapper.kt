package com.earl.effective_mobile.presentation.mappers

import com.earl.effective_mobile.core.ErrorType
import com.earl.effective_mobile.domain.mappers.BestSellerDomainToPresentationMapper
import com.earl.effective_mobile.domain.mappers.BestSellerListDomainToPresentationMapper
import com.earl.effective_mobile.domain.models.BestSellerDomain
import com.earl.effective_mobile.presentation.models.BestSellerListPresentation
import com.earl.effective_mobile.presentation.models.BestSellerPresentation

class BaseBestSellerListDomainToPresentationMapper(
    private val mapper: BestSellerDomainToPresentationMapper<BestSellerPresentation>
) : BestSellerListDomainToPresentationMapper {

    override fun map(list: List<BestSellerDomain>) = BestSellerListPresentation.Success(list.map{ it.map(mapper) })

    override fun map(e: ErrorType) = BestSellerListPresentation.Fail(e)
}