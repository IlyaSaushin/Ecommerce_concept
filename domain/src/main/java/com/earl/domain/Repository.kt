package com.earl.domain

interface Repository {

    suspend fun <T> fetchHomeStoreList() : T

    suspend fun <T> fetchBestSellerList() : T

    suspend fun <T> fetchProductDetails() : T

    suspend fun <T> fetchBasket() : T

    suspend fun fetchBasketItemsListSize() : Int
}