package com.earl.data.mappers

import com.earl.core.ErrorType
import com.earl.data.models.HomeStoreData
import com.earl.domain.models.HomeStoreDomain
import com.earl.domain.models.HomeStoreListDomain
import retrofit2.HttpException
import java.net.UnknownHostException

class BaseHomeStoreListDataToDomainMapper(
    private val mapper: HomeStoreDataToDomainMapper<HomeStoreDomain>
) : HomeStoreListDataToDomainMapper {

    override fun map(list: List<HomeStoreData>) = HomeStoreListDomain.Success(list.map { it.map(mapper) })

    override fun map(e: Exception) = HomeStoreListDomain.Fail(
        when (e) {
            is UnknownHostException -> ErrorType.NO_CONNECTION
            is HttpException -> ErrorType.SERVICE_UNAVAILABLE
            else -> ErrorType.GENERIC_ERROR
        }
    )
}