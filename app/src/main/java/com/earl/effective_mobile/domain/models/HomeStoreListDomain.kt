package com.earl.effective_mobile.domain.models

import android.widget.ImageView
import com.earl.effective_mobile.core.ErrorType
import com.earl.effective_mobile.domain.mappers.HomeStoreListDomainToPresentationMapper
import com.earl.effective_mobile.presentation.models.HomeStoreListPresentation

sealed class HomeStoreListDomain {

    abstract fun map(mapper: HomeStoreListDomainToPresentationMapper) : HomeStoreListPresentation

    data class Success(private val list: List<HomeStoreDomain>) : HomeStoreListDomain() {
        override fun map(mapper: HomeStoreListDomainToPresentationMapper) = mapper.map(list)
    }

    data class Fail(private val ex: ErrorType) : HomeStoreListDomain() {
        override fun map(mapper: HomeStoreListDomainToPresentationMapper) = mapper.map(ex)
    }
}
