package com.earl.effective_mobile.domain.mappers

import com.earl.effective_mobile.core.ErrorType
import com.earl.effective_mobile.data.mappers.BestSellerDataToDomainMapper
import com.earl.effective_mobile.data.mappers.BestSellerListDataToDomainMapper
import com.earl.effective_mobile.data.models.BestSellerData
import com.earl.effective_mobile.domain.models.BestSellerDomain
import com.earl.effective_mobile.domain.models.BestSellerListDomain
import retrofit2.HttpException
import java.net.UnknownHostException

class BaseBestSellerListDataToDomainMapper(
    private val mapper: BestSellerDataToDomainMapper<BestSellerDomain>
) : BestSellerListDataToDomainMapper {
    
    override fun map(list: List<BestSellerData>) = BestSellerListDomain.Success(list.map{ it.map(mapper) })

    override fun map(e: Exception) = BestSellerListDomain.Fail(
        when (e) {
            is UnknownHostException -> ErrorType.NO_CONNECTION
            is HttpException -> ErrorType.SERVICE_UNAVAILABLE
            else -> ErrorType.GENERIC_ERROR
        }
    )
}