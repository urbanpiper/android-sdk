package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.AllStoresResponse
import com.urbanpiper.upsdk.model.networkresponse.StoreLocationResponse
import retrofit2.Callback

interface StoreService {

    fun getNearestStore(latitude: Double, longitude: Double, callback: Callback<StoreLocationResponse>): CancellableTask

    fun getAllStores(callback: Callback<AllStoresResponse>): CancellableTask
}