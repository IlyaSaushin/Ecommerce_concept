package com.earl.data.models

import com.earl.data.mappers.BestSellerListDataToDomainMapper
import com.earl.domain.models.BestSellerListDomain

sealed class BestSellerListData {

    abstract fun map(mapper: BestSellerListDataToDomainMapper) : BestSellerListDomain

    data class Success(private val list: List<BestSellerData>) : BestSellerListData() {
        override fun map(mapper: BestSellerListDataToDomainMapper) = mapper.map(list)
    }

    data class Fail(private val ex: Exception) : BestSellerListData() {
        override fun map(mapper: BestSellerListDataToDomainMapper) = mapper.map(ex)
    }
}
