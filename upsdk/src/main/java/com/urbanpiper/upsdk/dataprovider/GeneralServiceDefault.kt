package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.FCMRegistrationBody
import com.urbanpiper.upsdk.model.networkresponse.AllStoresResponse
import com.urbanpiper.upsdk.model.networkresponse.AppVersionCheckResponse
import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import com.urbanpiper.upsdk.model.networkresponse.StoreLocationResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit

class GeneralServiceDefault(private val authToken: String, private val bizId: String, retrofit: Retrofit) :
    GeneralService {

    private val generalRetrofitService: GeneralRetrofitService =
        retrofit.create(GeneralRetrofitService::class.java)


    override fun appVersionCheck(username: String, version: String, callback: Callback<AppVersionCheckResponse>): CancellableTask {
        val appVersionCheck = generalRetrofitService.appVersionCheck(authToken, bizId, username, version)
        appVersionCheck.clone().enqueue(callback)
        return CancellableTaskWrapper(appVersionCheck)
    }

    override fun registerDeviceForFCM(fcmRegistrationToken: String, deviceId: String, callback: Callback<Void>) : CancellableTask{
        val body = FCMRegistrationBody(fcmRegistrationToken, deviceId)

        val regDeviceForFCM = generalRetrofitService.registerDeviceForFCM(body, authToken)

        regDeviceForFCM.clone().enqueue(callback)
        return CancellableTaskWrapper(regDeviceForFCM)
    }

    override fun getNearestStore(latitude: Double, longitude: Double, callback: Callback<StoreLocationResponse>): CancellableTask {
        val nearestStore: Call<StoreLocationResponse> = generalRetrofitService.getNearestStore(authToken, latitude, longitude, bizId)
        nearestStore.clone().enqueue(callback)
        return CancellableTaskWrapper(nearestStore)
    }

    override fun getAllStores(callback: Callback<AllStoresResponse>): CancellableTask {
        val allStores = generalRetrofitService.getAllStores(authToken)
        allStores.enqueue(callback)
        return CancellableTaskWrapper(allStores)
    }
}