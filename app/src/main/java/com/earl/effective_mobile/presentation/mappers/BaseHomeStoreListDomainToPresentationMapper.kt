package com.earl.effective_mobile.presentation.mappers

import com.earl.domain.mappers.HomeStoreDomainToPresentationMapper
import com.earl.domain.mappers.HomeStoreListDomainToPresentationMapper
import com.earl.domain.models.HomeStoreDomain
import com.earl.effective_mobile.presentation.models.HomeStoreListPresentation
import com.earl.effective_mobile.presentation.models.HomeStorePresentation

class BaseHomeStoreListDomainToPresentationMapper(
    private val mapper: HomeStoreDomainToPresentationMapper<HomeStorePresentation>
) : HomeStoreListDomainToPresentationMapper {

    override fun <T> map(list: List<HomeStoreDomain>) = HomeStoreListPresentation.Success(list.map { it.map(mapper) }) as T

    override fun <T> map(e: com.earl.core.ErrorType) = HomeStoreListPresentation.Fail(e) as T
}