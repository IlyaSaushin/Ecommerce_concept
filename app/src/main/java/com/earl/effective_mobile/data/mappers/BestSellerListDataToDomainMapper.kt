package com.earl.effective_mobile.data.mappers

import com.earl.effective_mobile.data.models.BestSellerData
import com.earl.effective_mobile.domain.models.BestSellerListDomain

interface BestSellerListDataToDomainMapper {
    fun map(list: List<BestSellerData>): BestSellerListDomain
    fun map(e: Exception): BestSellerListDomain
}
