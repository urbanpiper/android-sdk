package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.AllStoresResponse
import com.urbanpiper.upsdk.model.networkresponse.StoreLocationResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit

class StoreServiceDefault(private val authToken: String, private val bizId: String, retrofit: Retrofit) : StoreService {

    private val storeRetrofitService: StoreRetrofitService =
        retrofit.create(StoreRetrofitService::class.java)

    override fun getNearestStore(latitude: Double, longitude: Double, callback: Callback<StoreLocationResponse>): CancellableTask {
        val nearestStore: Call<StoreLocationResponse> = storeRetrofitService.getNearestStore(authToken, latitude, longitude, bizId)
        nearestStore.clone().enqueue(callback)
        return CancellableTaskWrapper(nearestStore)
    }

    override fun getAllStores(callback: Callback<AllStoresResponse>): CancellableTask {
        val allStores = storeRetrofitService.getAllStores(authToken)
        allStores.enqueue(callback)
        return CancellableTaskWrapper(allStores)
    }
}