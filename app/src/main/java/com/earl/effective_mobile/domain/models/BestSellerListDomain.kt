package com.earl.effective_mobile.domain.models

import com.earl.effective_mobile.core.ErrorType
import com.earl.effective_mobile.domain.mappers.BestSellerListDomainToPresentationMapper
import com.earl.effective_mobile.presentation.models.BestSellerListPresentation

sealed class BestSellerListDomain {

    abstract fun map(mapper: BestSellerListDomainToPresentationMapper) : BestSellerListPresentation

    data class Success(private val list: List<BestSellerDomain>) : BestSellerListDomain() {
        override fun map(mapper: BestSellerListDomainToPresentationMapper) = mapper.map(list)
    }

    data class Fail(private val errorType: ErrorType) : BestSellerListDomain() {
        override fun map(mapper: BestSellerListDomainToPresentationMapper) = mapper.map(errorType)
    }
}
