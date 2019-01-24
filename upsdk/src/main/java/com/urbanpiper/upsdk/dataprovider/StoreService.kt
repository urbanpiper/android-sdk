package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkResponse.AllStoresResponse
import com.urbanpiper.upsdk.model.networkResponse.StoreLocationResponse
import retrofit2.Callback

interface StoreService {

    fun getNearestStore(latitude: Double, longitude: Double, callback: Callback<StoreLocationResponse>)

    fun getAllStores(callback: Callback<AllStoresResponse>)
}