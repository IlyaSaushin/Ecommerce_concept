package com.earl.domain

interface Interactor {

    suspend fun <T> fetchHomeStoreList() : T

    suspend fun <T> fetchBestSellerList() : T

    suspend fun <T> fetchProductDetails() : T

    suspend fun <T> fetchBasket() : T

    suspend fun <T> fetchBasketItemsListSize() : Int

    class Base(
        private val repository: Repository,
//        private val homeStoreListDataToDomainMapper: com.earl.data.mappers.BaseHomeStoreListDataToDomainMapper,
//        private val bestSellerListDataToDomainMapper: com.earl.data.mappers.BaseBestSellerListDataToDomainMapper,
//        private val productDetailsDataToDomainMapper: com.earl.data.mappers.BaseProductDetailsDataToDomainMapper,
//        private val basketDataToDomainMapper: com.earl.data.mappers.BaseBasketItemDataToDomainMapper
    ) : Interactor {

//        override suspend fun fetchHomeStoreList() = repository.fetchHomeStoreList().map(homeStoreListDataToDomainMapper)
        override suspend fun <T> fetchHomeStoreList() = repository.fetchHomeStoreList() as T

//        override suspend fun <T> fetchBestSellerList() = repository.fetchBestSellerList().map(bestSellerListDataToDomainMapper)
        override suspend fun <T> fetchBestSellerList() = repository.fetchBestSellerList() as T

//        override suspend fun <T> fetchProductDetails() = repository.fetchProductDetails().map(productDetailsDataToDomainMapper)
        override suspend fun <T> fetchProductDetails() = repository.fetchProductDetails() as T

//        override suspend fun <T> fetchBasket() = repository.fetchBasket().map(basketDataToDomainMapper)
        override suspend fun <T> fetchBasket() = repository.fetchBasket() as T

        override suspend fun <T> fetchBasketItemsListSize() = repository.fetchBasketItemsListSize()
    }
}