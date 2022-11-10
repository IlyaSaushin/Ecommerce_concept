package com.earl.effective_mobile.di

import com.earl.effective_mobile.presentation.screens.basket.BasketViewModel
import com.earl.effective_mobile.presentation.screens.main.MainFragmentViewModel
import com.earl.effective_mobile.presentation.screens.productDetails.main.ProductDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {

    viewModel<MainFragmentViewModel> {
        MainFragmentViewModel(
            interactor = get(),
            homeStoreListDomainToPresentationMapper = get(),
            bestSellerListDomainToPresentationMapper = get()
        )
    }
    viewModel<ProductDetailsViewModel>() {
        ProductDetailsViewModel(
            interactor = get(),
            productDetailsDomainToUiMapper = get()
        )
    }
    viewModel<BasketViewModel>{
        BasketViewModel(
            interactor = get(),
            basketDomainToUiMapper = get()
        )
    }
}