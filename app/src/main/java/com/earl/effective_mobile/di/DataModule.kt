package com.earl.effective_mobile.di

import com.earl.effective_mobile.data.BaseRepository
import com.earl.effective_mobile.domain.Repository
import org.koin.dsl.module

val dataModule = module {

    single<Repository> {
        BaseRepository(
            service = get(),
            homeStoreCloudToDataMapper = get(),
            bestSellerCloudToDataMapper = get(),
            productDetailsCloudToDataMapper = get(),
            basketCloudToDataMapper = get(),
            basketItemCloudToDataMapper = get()
        )
    }
}