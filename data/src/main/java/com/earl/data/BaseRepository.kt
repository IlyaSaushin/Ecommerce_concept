package com.earl.data

import com.earl.data.mappers.*
import com.earl.data.models.*
import com.earl.data.retrofit.Service
import com.earl.domain.Repository
import com.earl.domain.models.BasketDomain
import com.earl.domain.models.ProductDetailsDomain

class BaseRepository(
    private val service: Service,
    private val homeStoreCloudToDataMapper: HomeStoreCloudToDataMapper<HomeStoreData>,
    private val bestSellerCloudToDataMapper: BestSellerCloudToDataMapper<BestSellerData>,
    private val productDetailsCloudToDataMapper: ProductDetailsCloudToDataMapper<ProductDetailsData>,
    private val basketCloudToDataMapper: BasketCloudToDataMapper<BasketData>,
    private val basketItemCloudToDataMapper: BasketItemCloudToDataMapper<BasketItemData>,
    private val homeStoreListDataToDomainMapper: HomeStoreListDataToDomainMapper,
    private val bestSellerListDataToDomainMapper: BestSellerListDataToDomainMapper,
    private val productDetailsDataToDomainMapper: ProductDetailsDataToDomainMapper<ProductDetailsDomain>,
    private val basketDataToDomainMapper: BasketDataToDomainMapper<BasketDomain>
) : Repository {

    override suspend fun <T> fetchHomeStoreList() = try {
        val list = service.mainApi().homeStore
        HomeStoreListData.Success(list.map { it.map(homeStoreCloudToDataMapper) }).map(homeStoreListDataToDomainMapper) as T
    } catch (e: Exception) {
        HomeStoreListData.Fail(e).map(homeStoreListDataToDomainMapper) as T
    }

    override suspend fun <T> fetchBestSellerList() = try {
        val list = service.mainApi().bestSeller
        BestSellerListData.Success(list.map { it.map(bestSellerCloudToDataMapper) }).map(bestSellerListDataToDomainMapper) as T
    } catch (e: Exception) {
        BestSellerListData.Fail(e).map(bestSellerListDataToDomainMapper) as T
    }

    override suspend fun <T> fetchProductDetails() = service.productDetails().map(productDetailsCloudToDataMapper).map(productDetailsDataToDomainMapper) as T

    override suspend fun <T> fetchBasket() = service.basket().map(basketCloudToDataMapper, basketItemCloudToDataMapper).map(basketDataToDomainMapper) as T

    override suspend fun fetchBasketItemsListSize() = service.basket().basket.size
}