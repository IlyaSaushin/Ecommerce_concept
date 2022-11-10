package com.earl.effective_mobile.data.models

import com.earl.effective_mobile.data.mappers.BestSellerListDataToDomainMapper
import com.earl.effective_mobile.domain.models.BestSellerListDomain

sealed class BestSellerListData {

    abstract fun map(mapper: BestSellerListDataToDomainMapper) : BestSellerListDomain

    data class Success(private val list: List<BestSellerData>) : BestSellerListData() {
        override fun map(mapper: BestSellerListDataToDomainMapper) = mapper.map(list)
    }

    data class Fail(private val ex: Exception) : BestSellerListData() {
        override fun map(mapper: BestSellerListDataToDomainMapper) = mapper.map(ex)
    }
}
