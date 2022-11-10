package com.earl.data.models

import com.earl.data.mappers.HomeStoreDataToDomainMapper

interface HomeStoreData {

    fun <T> map(mapper: HomeStoreDataToDomainMapper<T>) : T

    class Base(
        val id: Int,
        val is_new: Boolean,
        val title: String,
        val subtitle: String,
        val picture: String,
        val is_buy: Boolean,
    ) : HomeStoreData {
        override fun <T> map(mapper: HomeStoreDataToDomainMapper<T>) = mapper.map(
            id, is_new, title, subtitle, picture, is_buy
        )
    }
}