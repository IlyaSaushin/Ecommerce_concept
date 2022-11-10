package com.earl.domain.models

import com.earl.core.ErrorType
import com.earl.domain.mappers.HomeStoreListDomainToPresentationMapper

sealed class HomeStoreListDomain {

    abstract fun <T> map(mapper: HomeStoreListDomainToPresentationMapper) : T

    data class Success(private val list: List<HomeStoreDomain>) : HomeStoreListDomain() {
        override fun <T> map(mapper: HomeStoreListDomainToPresentationMapper) = mapper.map(list) as T
    }

    data class Fail(private val ex: ErrorType) : HomeStoreListDomain() {
        override fun <T> map(mapper: HomeStoreListDomainToPresentationMapper) = mapper.map(ex) as T
    }
}
