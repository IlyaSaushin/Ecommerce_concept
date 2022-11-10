package com.earl.effective_mobile.domain

import com.earl.effective_mobile.data.mappers.BasketDataToDomainMapper
import com.earl.effective_mobile.data.mappers.BestSellerListDataToDomainMapper
import com.earl.effective_mobile.data.mappers.HomeStoreListDataToDomainMapper
import com.earl.effective_mobile.data.mappers.ProductDetailsDataToDomainMapper
import com.earl.effective_mobile.domain.models.BasketDomain
import com.earl.effective_mobile.domain.models.BestSellerListDomain
import com.earl.effective_mobile.domain.models.HomeStoreListDomain
import com.earl.effective_mobile.domain.models.ProductDetailsDomain

interface Interactor {

    suspend fun fetchHomeStoreList() : HomeStoreListDomain

    suspend fun fetchBestSellerList() : BestSellerListDomain

    suspend fun fetchProductDetails() : ProductDetailsDomain

    suspend fun fetchBasket() : BasketDomain

    suspend fun fetchBasketItemsListSize() : Int

    class Base(
        private val repository: Repository,
        private val homeStoreListDataToDomainMapper: HomeStoreListDataToDomainMapper,
        private val bestSellerListDataToDomainMapper: BestSellerListDataToDomainMapper,
        private val productDetailsDataToDomainMapper: ProductDetailsDataToDomainMapper<ProductDetailsDomain>,
        private val basketDataToDomainMapper: BasketDataToDomainMapper<BasketDomain>
    ) : Interactor {

        override suspend fun fetchHomeStoreList() = repository.fetchHomeStoreList().map(homeStoreListDataToDomainMapper)

        override suspend fun fetchBestSellerList() = repository.fetchBestSellerList().map(bestSellerListDataToDomainMapper)

        override suspend fun fetchProductDetails() = repository.fetchProductDetails().map(productDetailsDataToDomainMapper)

        override suspend fun fetchBasket() = repository.fetchBasket().map(basketDataToDomainMapper)

        override suspend fun fetchBasketItemsListSize() = repository.fetchBasketItemsListSize()
    }
}