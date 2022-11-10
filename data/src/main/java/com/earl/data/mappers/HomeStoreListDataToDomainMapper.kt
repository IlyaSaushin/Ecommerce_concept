package com.earl.data.mappers

import com.earl.data.models.HomeStoreData
import com.earl.domain.models.HomeStoreListDomain

interface HomeStoreListDataToDomainMapper {
    fun map(list: List<HomeStoreData>): HomeStoreListDomain
    fun map(e: Exception): HomeStoreListDomain
}