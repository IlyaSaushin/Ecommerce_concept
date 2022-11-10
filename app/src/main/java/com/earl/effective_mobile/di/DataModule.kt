package com.earl.effective_mobile.di

import org.koin.dsl.module

val dataModule = module {

    single<com.earl.domain.Repository> {
        com.earl.data.BaseRepository(
            service = get(),
            homeStoreCloudToDataMapper = get(),
            bestSellerCloudToDataMapper = get(),
            productDetailsCloudToDataMapper = get(),
            basketCloudToDataMapper = get(),
            basketItemCloudToDataMapper = get(),
            homeStoreListDataToDomainMapper = get(),
            bestSellerListDataToDomainMapper = get(),
            productDetailsDataToDomainMapper = get(),
            basketDataToDomainMapper = get()
        )
    }
}