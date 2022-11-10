package com.earl.effective_mobile.data.retrofit

import com.earl.effective_mobile.data.mappers.*
import com.earl.effective_mobile.data.models.*
import com.google.gson.annotations.SerializedName

data class MainApi(
    @SerializedName("home_store") val homeStore: List<HomeStore>,
    @SerializedName("best_seller") val bestSeller: List<BestSeller>
)

data class HomeStore(
    @SerializedName("id") val id: Int,
    @SerializedName("is_new") val is_new: Boolean,
    @SerializedName("title") val title: String,
    @SerializedName("subtitle") val subtitle: String,
    @SerializedName("picture") val picture: String,
    @SerializedName("is_buy") val is_buy: Boolean,
) {
    fun map(mapper: HomeStoreCloudToDataMapper<HomeStoreData>) =
        mapper.map(id, is_new, title, subtitle, picture, is_buy)
}

data class BestSeller(
    @SerializedName("id") val id: Int,
    @SerializedName("is_favorites") val is_favorites: Boolean,
    @SerializedName("title") val title: String,
    @SerializedName("price_without_discount") val price_without_discount: Int,
    @SerializedName("discount_price") val discount_price: Int,
    @SerializedName("picture") val picture: String,
) {
    fun map(mapper: BestSellerCloudToDataMapper<BestSellerData>) =
        mapper.map(id, is_favorites, title, price_without_discount, discount_price, picture)
}

data class ProductDetails(
    @SerializedName("CPU") val cpu: String,
    @SerializedName("camera") val camera: String,
    @SerializedName("capacity") val capacity: List<String>,
    @SerializedName("color") val color: List<String>,
    @SerializedName("id") val id: String,
    @SerializedName("images") val images: List<String>,
    @SerializedName("isFavorites") val isFavorite: Boolean,
    @SerializedName("price") val price: Int,
    @SerializedName("rating") val rating: Float,
    @SerializedName("sd") val sd: String,
    @SerializedName("ssd") val ssd: String,
    @SerializedName("title") val title: String,
) {
    fun map(mapper: ProductDetailsCloudToDataMapper<ProductDetailsData>) =
        mapper.map(
            cpu,
            camera,
            capacity,
            color,
            id,
            images,
            isFavorite,
            price,
            rating,
            sd,
            ssd,
            title
        )
}

data class BasketApi(
    @SerializedName("basket") val basket: List<Basket>,
    @SerializedName("delivery") val delivery: String,
    @SerializedName("id") val id: Int,
    @SerializedName("total") val total: Int
) {
    fun map(mapperBase: BasketCloudToDataMapper<BasketData>, mapperItem: BasketItemCloudToDataMapper<BasketItemData>) =
    mapperBase.map(
    basket.map { it.map(mapperItem) },
    delivery,
    id,
    total
    )
}

data class Basket(
    @SerializedName("id") val id: Int,
    @SerializedName("images") val images: String,
    @SerializedName("price") val price: Int,
    @SerializedName("title") val title: String,
) {
    fun map(mapper: BasketItemCloudToDataMapper<BasketItemData>) =
        mapper.map(id, images, price, title)
}
