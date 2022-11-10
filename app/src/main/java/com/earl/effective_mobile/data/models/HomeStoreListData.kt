package com.earl.effective_mobile.data.models

import com.earl.effective_mobile.data.mappers.HomeStoreListDataToDomainMapper
import com.earl.effective_mobile.domain.models.HomeStoreListDomain

sealed class HomeStoreListData {

    abstract fun map(mapper: HomeStoreListDataToDomainMapper) : HomeStoreListDomain

    data class Success(private val list: List<HomeStoreData>) : HomeStoreListData() {
        override fun map(mapper: HomeStoreListDataToDomainMapper) = mapper.map(list)
    }

    data class Fail(private val ex: Exception) : HomeStoreListData() {
        override fun map(mapper: HomeStoreListDataToDomainMapper) = mapper.map(ex)
    }
}
