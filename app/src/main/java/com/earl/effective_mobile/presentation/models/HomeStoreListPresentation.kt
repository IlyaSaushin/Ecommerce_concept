package com.earl.effective_mobile.presentation.models

import com.earl.effective_mobile.core.ErrorType

sealed class HomeStoreListPresentation {

    abstract fun list() : List<HomeStorePresentation>

    data class Success(private val list: List<HomeStorePresentation>) : HomeStoreListPresentation() {
        override fun list() = list
    }

    data class Fail(private val ex: ErrorType) : HomeStoreListPresentation() {
        override fun list() = emptyList<HomeStorePresentation>()
    }
}
