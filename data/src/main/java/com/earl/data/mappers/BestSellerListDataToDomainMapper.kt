package com.earl.data.mappers

import com.earl.data.models.BestSellerData
import com.earl.domain.models.BestSellerListDomain

interface BestSellerListDataToDomainMapper {
    fun map(list: List<BestSellerData>): BestSellerListDomain
    fun map(e: Exception): BestSellerListDomain
}
