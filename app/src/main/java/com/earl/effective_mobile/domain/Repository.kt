package com.earl.effective_mobile.domain

import com.earl.effective_mobile.data.models.BasketData
import com.earl.effective_mobile.data.models.BestSellerListData
import com.earl.effective_mobile.data.models.HomeStoreListData
import com.earl.effective_mobile.data.models.ProductDetailsData

interface Repository {

    suspend fun fetchHomeStoreList() : HomeStoreListData

    suspend fun fetchBestSellerList() : BestSellerListData

    suspend fun fetchProductDetails() : ProductDetailsData

    suspend fun fetchBasket() : BasketData

    suspend fun fetchBasketItemsListSize() : Int
}