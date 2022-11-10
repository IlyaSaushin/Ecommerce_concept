package com.earl.effective_mobile.presentation.models

import com.earl.effective_mobile.core.ErrorType

sealed class BestSellerListPresentation {

    abstract fun list() : List<BestSellerPresentation>

    data class Success(private val list: List<BestSellerPresentation>) : BestSellerListPresentation() {
        override fun list() = list
    }

    data class Fail(private val ex: ErrorType) : BestSellerListPresentation() {
        override fun list() = emptyList<BestSellerPresentation>()
    }
}
