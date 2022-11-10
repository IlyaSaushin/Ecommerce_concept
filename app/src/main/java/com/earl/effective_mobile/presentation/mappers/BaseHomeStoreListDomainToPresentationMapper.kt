package com.earl.effective_mobile.presentation.mappers

import com.earl.effective_mobile.core.ErrorType
import com.earl.effective_mobile.domain.mappers.HomeStoreDomainToPresentationMapper
import com.earl.effective_mobile.domain.mappers.HomeStoreListDomainToPresentationMapper
import com.earl.effective_mobile.domain.models.HomeStoreDomain
import com.earl.effective_mobile.presentation.models.HomeStoreListPresentation
import com.earl.effective_mobile.presentation.models.HomeStorePresentation

class BaseHomeStoreListDomainToPresentationMapper(
    private val mapper: HomeStoreDomainToPresentationMapper<HomeStorePresentation>
) : HomeStoreListDomainToPresentationMapper {

    override fun map(list: List<HomeStoreDomain>) = HomeStoreListPresentation.Success(list.map { it.map(mapper) })

    override fun map(e: ErrorType) = HomeStoreListPresentation.Fail(e)
}