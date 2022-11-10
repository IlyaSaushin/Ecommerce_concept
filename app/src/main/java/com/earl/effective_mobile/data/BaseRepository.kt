package com.earl.effective_mobile.data

import com.earl.effective_mobile.data.mappers.*
import com.earl.effective_mobile.data.models.*
import com.earl.effective_mobile.data.retrofit.Service
import com.earl.effective_mobile.domain.Repository

class BaseRepository(
    private val service: Service,
    private val homeStoreCloudToDataMapper: HomeStoreCloudToDataMapper<HomeStoreData>,
    private val bestSellerCloudToDataMapper: BestSellerCloudToDataMapper<BestSellerData>,
    private val productDetailsCloudToDataMapper: ProductDetailsCloudToDataMapper<ProductDetailsData>,
    private val basketCloudToDataMapper: BasketCloudToDataMapper<BasketData>,
    private val basketItemCloudToDataMapper: BasketItemCloudToDataMapper<BasketItemData>
) : Repository {

    override suspend fun fetchHomeStoreList() = try {
        val list = service.mainApi().homeStore
        HomeStoreListData.Success(list.map { it.map(homeStoreCloudToDataMapper) })
    } catch (e: Exception) {
        HomeStoreListData.Fail(e)
    }

    override suspend fun fetchBestSellerList() = try {
        val list = service.mainApi().bestSeller
        BestSellerListData.Success(list.map { it.map(bestSellerCloudToDataMapper) })
    } catch (e: Exception) {
        BestSellerListData.Fail(e)
    }

    override suspend fun fetchProductDetails() = service.productDetails().map(productDetailsCloudToDataMapper)

    override suspend fun fetchBasket() = service.basket().map(basketCloudToDataMapper, basketItemCloudToDataMapper)

    override suspend fun fetchBasketItemsListSize() = service.basket().basket.size
}