package com.earl.effective_mobile.data.mappers

import com.earl.effective_mobile.data.models.HomeStoreData
import com.earl.effective_mobile.domain.models.HomeStoreListDomain

interface HomeStoreListDataToDomainMapper {
    fun map(list: List<HomeStoreData>): HomeStoreListDomain
    fun map(e: Exception): HomeStoreListDomain
}