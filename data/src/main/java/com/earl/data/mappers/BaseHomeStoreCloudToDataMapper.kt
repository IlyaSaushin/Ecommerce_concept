package com.earl.data.mappers

import com.earl.data.models.HomeStoreData

class BaseHomeStoreCloudToDataMapper : HomeStoreCloudToDataMapper<HomeStoreData> {

    override fun map(
        id: Int,
        is_new: Boolean,
        title: String,
        subtitle: String,
        picture: String,
        is_buy: Boolean
    ) = HomeStoreData.Base(
        id,
        is_new,
        title,
        subtitle,
        picture,
        is_buy
    )
}