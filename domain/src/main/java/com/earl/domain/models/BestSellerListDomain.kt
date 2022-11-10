package com.earl.domain.models

import com.earl.core.ErrorType
import com.earl.domain.mappers.BestSellerListDomainToPresentationMapper

sealed class BestSellerListDomain {

    abstract fun <T> map(mapper: BestSellerListDomainToPresentationMapper) : T

    data class Success(private val list: List<BestSellerDomain>) : BestSellerListDomain() {
        override fun <T> map(mapper: BestSellerListDomainToPresentationMapper) = mapper.map(list) as T
    }

    data class Fail(private val errorType: ErrorType) : BestSellerListDomain() {
        override fun <T> map(mapper: BestSellerListDomainToPresentationMapper) = mapper.map(errorType) as T
    }
}
