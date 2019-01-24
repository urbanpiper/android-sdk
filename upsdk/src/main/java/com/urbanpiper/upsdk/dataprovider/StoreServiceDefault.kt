package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkResponse.AllStoresResponse
import com.urbanpiper.upsdk.model.networkResponse.StoreLocationResponse
import retrofit2.Callback
import retrofit2.Retrofit

class StoreServiceDefault(private val authToken: String, private val bizId: String, retrofit: Retrofit) : StoreService {

    private val storeRetrofitService: StoreRetrofitService =
        retrofit.create(StoreRetrofitService::class.java)

    override fun getNearestStore(latitude: Double, longitude: Double, callback: Callback<StoreLocationResponse>) {
        val nearestStore = storeRetrofitService.getNearestStore(authToken, latitude, longitude, bizId)
        nearestStore.clone().enqueue(callback)
    }

    override fun getAllStores(callback: Callback<AllStoresResponse>) {
        val allStores = storeRetrofitService.getAllStores(authToken)
        allStores.enqueue(callback)
    }
}