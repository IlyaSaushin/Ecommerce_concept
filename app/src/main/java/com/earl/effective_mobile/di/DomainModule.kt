package com.earl.effective_mobile.di

import com.earl.effective_mobile.domain.Interactor
import org.koin.dsl.module

val domainModule = module {

    single<Interactor> {
        Interactor.Base(
            repository = get(),
            homeStoreListDataToDomainMapper = get(),
            bestSellerListDataToDomainMapper = get(),
            productDetailsDataToDomainMapper = get(),
            basketDataToDomainMapper = get()
        )
    }
}