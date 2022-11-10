package com.earl.effective_mobile.data.mappers

interface HomeStoreCloudToDataMapper<T> {

    fun map(
        id: Int,
        is_new: Boolean,
        title: String,
        subtitle: String,
        picture: String,
        is_buy: Boolean,
    ) : T
}