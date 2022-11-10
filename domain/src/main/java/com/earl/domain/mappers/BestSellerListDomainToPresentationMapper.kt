package com.earl.domain.mappers

import com.earl.core.ErrorType
import com.earl.domain.models.BestSellerDomain

interface BestSellerListDomainToPresentationMapper {
    fun <T> map(list: List<BestSellerDomain>): T
    fun <T> map(e: ErrorType): T
}