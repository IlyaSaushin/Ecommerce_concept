package com.earl.effective_mobile.presentation.models

sealed class HomeStoreListPresentation {

    abstract fun list() : List<HomeStorePresentation>

    data class Success(private val list: List<HomeStorePresentation>) : HomeStoreListPresentation() {
        override fun list() = list
    }

    data class Fail(private val ex: com.earl.core.ErrorType) : HomeStoreListPresentation() {
        override fun list() = emptyList<HomeStorePresentation>()
    }
}
