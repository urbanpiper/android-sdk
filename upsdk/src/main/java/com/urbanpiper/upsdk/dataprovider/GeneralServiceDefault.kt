package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.FCMRegistrationBody
import com.urbanpiper.upsdk.model.networkresponse.StoreListResponse
import com.urbanpiper.upsdk.model.networkresponse.VersionCheckResponse
import com.urbanpiper.upsdk.model.networkresponse.StoreReponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit

class GeneralServiceDefault(private val authToken: String, private val bizId: String, retrofit: Retrofit) :
    GeneralService {

    private val generalRetrofitService: GeneralRetrofitService =
        retrofit.create(GeneralRetrofitService::class.java)

    override fun checkAppVersion(username: String, version: String, callback: Callback<VersionCheckResponse>): CancellableTask {
        val appVersionCheck = generalRetrofitService.appVersionCheck(authToken, bizId, username, version)
        appVersionCheck.clone().enqueue(callback)
        return CancellableTaskWrapper(appVersionCheck)
    }

    override fun registerFCMToken(token: String, deviceId: String, callback: Callback<Void>) : CancellableTask{
        val body = FCMRegistrationBody(token, deviceId)

        val regDeviceForFCM = generalRetrofitService.registerDeviceForFCM(body, authToken)

        regDeviceForFCM.clone().enqueue(callback)
        return CancellableTaskWrapper(regDeviceForFCM)
    }

    override fun getNearestStore(lat: Double, lng: Double, callback: Callback<StoreReponse>): CancellableTask {
        val nearestStore: Call<StoreReponse> = generalRetrofitService.getNearestStore(authToken, lat, lng, bizId)
        nearestStore.clone().enqueue(callback)
        return CancellableTaskWrapper(nearestStore)
    }

    override fun getAllStores(callback: Callback<StoreListResponse>): CancellableTask {
        val allStores = generalRetrofitService.getAllStores(authToken)
        allStores.enqueue(callback)
        return CancellableTaskWrapper(allStores)
    }
}