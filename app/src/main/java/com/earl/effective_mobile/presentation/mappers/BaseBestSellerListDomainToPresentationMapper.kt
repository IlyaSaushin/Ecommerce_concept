package com.earl.effective_mobile.presentation.mappers

import com.earl.domain.mappers.BestSellerDomainToPresentationMapper
import com.earl.domain.mappers.BestSellerListDomainToPresentationMapper
import com.earl.domain.models.BestSellerDomain
import com.earl.effective_mobile.presentation.models.BestSellerListPresentation
import com.earl.effective_mobile.presentation.models.BestSellerPresentation

class BaseBestSellerListDomainToPresentationMapper(
    private val mapper: BestSellerDomainToPresentationMapper<BestSellerPresentation>
) : BestSellerListDomainToPresentationMapper {

    override fun <T> map(list: List<BestSellerDomain>) = BestSellerListPresentation.Success(list.map{ it.map(mapper) }) as T

    override fun <T> map(e: com.earl.core.ErrorType) = BestSellerListPresentation.Fail(e) as T
}