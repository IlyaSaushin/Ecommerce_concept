package com.earl.effective_mobile.presentation.models

sealed class BestSellerListPresentation {

    abstract fun list() : List<BestSellerPresentation>

    data class Success(private val list: List<BestSellerPresentation>) : BestSellerListPresentation() {
        override fun list() = list
    }

    data class Fail(private val ex: com.earl.core.ErrorType) : BestSellerListPresentation() {
        override fun list() = emptyList<BestSellerPresentation>()
    }
}
