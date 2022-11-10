package com.earl.effective_mobile.di

import com.earl.effective_mobile.data.mappers.*
import com.earl.effective_mobile.data.models.*
import com.earl.effective_mobile.domain.mappers.*
import com.earl.effective_mobile.domain.models.*
import com.earl.effective_mobile.presentation.mappers.*
import com.earl.effective_mobile.presentation.models.*
import org.koin.dsl.module

val mappersModule = module {

    single<BestSellerCloudToDataMapper<BestSellerData>> {
        BaseBestSellerCloudToDataMapper()
    }

    single<HomeStoreCloudToDataMapper<HomeStoreData>> {
        BaseHomeStoreCloudToDataMapper()
    }

    single<BestSellerDataToDomainMapper<BestSellerDomain>> {
        BaseBestSellerDataToDomainMapper()
    }

    single<HomeStoreDataToDomainMapper<HomeStoreDomain>> {
        BaseHomeStoreDataToDomainMapper()
    }

    single<BestSellerListDataToDomainMapper> {
        BaseBestSellerListDataToDomainMapper(mapper = get())
    }

    single<HomeStoreListDataToDomainMapper> {
        BaseHomeStoreListDataToDomainMapper(mapper = get())
    }

    single<BestSellerDomainToPresentationMapper<BestSellerPresentation>> {
        BaseBestSellerDomainToPresentationMapper()
    }

    single<HomeStoreDomainToPresentationMapper<HomeStorePresentation>> {
        BaseHomeStoreDomainToPresentationMapper()
    }

    single<BestSellerListDomainToPresentationMapper> {
        BaseBestSellerListDomainToPresentationMapper(mapper = get())
    }

    single<HomeStoreListDomainToPresentationMapper> {
        BaseHomeStoreListDomainToPresentationMapper(mapper = get())
    }

    single<ProductDetailsCloudToDataMapper<ProductDetailsData>> {
        BaseProductDetailsCloudToDataMapper()
    }

    single<ProductDetailsDataToDomainMapper<ProductDetailsDomain>> {
        BaseProductDetailsDataToDomainMapper()
    }

    single<ProductDetailsDomainToUiMapper<ProductDetailsUi>> {
        BaseProductDetailsDomainToUiMapper()
    }

    single<BasketItemCloudToDataMapper<BasketItemData>> {
        BaseBasketItemCloudToDataMapper()
    }

    single<BasketCloudToDataMapper<BasketData>> {
        BaseBasketCloudToDataMapper()
    }

    single<BasketItemDomainToUiMapper<BasketItemUi>> {
        BaseBasketItemDomainToUiMapper()
    }

    single<BasketDomainToUiMapper<BasketUi>> {
        BaseBasketDomainToUiMapper(itemMapper = get())
    }

    single<BasketItemDataToDomainMapper<BasketItemDomain>> {
        BaseBasketItemDataToDomainMapper()
    }

    single<BasketDataToDomainMapper<BasketDomain>> {
        BaseBasketDataToDomainMapper(itemMapper = get())
    }
 }