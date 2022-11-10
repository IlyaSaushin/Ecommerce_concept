package com.earl.effective_mobile.di

import org.koin.dsl.module

val domainModule = module {

    single<com.earl.domain.Interactor> {
        com.earl.domain.Interactor.Base(
            repository = get(),
//            homeStoreListDataToDomainMapper = get(),
//            bestSellerListDataToDomainMapper = get(),
//            productDetailsDataToDomainMapper = get(),
//            basketDataToDomainMapper = get()
        )
    }
}