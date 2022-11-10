package com.earl.domain.mappers

import com.earl.core.ErrorType
import com.earl.domain.models.HomeStoreDomain

interface HomeStoreListDomainToPresentationMapper {
    fun <T> map(list: List<HomeStoreDomain>): T
    fun <T> map(e: ErrorType): T
}