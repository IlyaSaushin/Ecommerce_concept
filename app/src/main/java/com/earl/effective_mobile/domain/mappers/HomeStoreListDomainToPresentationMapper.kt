package com.earl.effective_mobile.domain.mappers

import com.earl.effective_mobile.core.ErrorType
import com.earl.effective_mobile.domain.models.HomeStoreDomain
import com.earl.effective_mobile.presentation.models.HomeStoreListPresentation

interface HomeStoreListDomainToPresentationMapper {
    fun map(list: List<HomeStoreDomain>): HomeStoreListPresentation
    fun map(e: ErrorType): HomeStoreListPresentation
}