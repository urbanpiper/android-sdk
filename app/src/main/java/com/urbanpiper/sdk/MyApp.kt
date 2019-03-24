package com.urbanpiper.sdk

import android.app.Application
import android.util.Log
import com.urbanpiper.upsdk.dataprovider.*
import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import com.urbanpiper.upsdk.model.networkresponse.UserBizInfoResponse
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MyApp : Application() {

    lateinit var upClient: UPClient

    override fun onCreate() {
        super.onCreate()
        Log.d("Application created ", " UP client init")

        upClient = UPClientBuilder()
            .setBizId("76720224")
            .setApiUsername("biz_adm_clients_yjXwAgQzHqYM")
            .setApiKey("5ee66ab0ec691963ebe2e9485ae0fdfe232d8fa8")
            .setLanguage("en")
            .setApplicationContext(applicationContext)
            .setCallback(object : Callback<UserBizInfoResponse> {
                override fun success(response: UserBizInfoResponse) {
                    Log.d("callback response", " $response")
                }

                override fun failure(upClientError: UpClientError) {
                    upClientError.getResponseCode()
                    Log.e("", " Failure response  ${upClientError.getResponseCode()}")
                }
            })
            .build()

//        Log.d("init ", " Init result ${upClient.getTest()}")

//        upClient.getBanners()
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe(object: Observer<BannerResponse> {
//                override fun onComplete() {
//                }
//
//                override fun onSubscribe(d: Disposable) {
//                }
//
//                override fun onNext(t: BannerResponse) {
//                }
//
//                override fun onError(e: Throwable) {
//                }
//
//            })

//        val cancellableTask = upClient.getBanners(object : Callback<BannerResponse>{
//            override fun success(response: BannerResponse) {
//
//            }
//
//            override fun failure(upClientError: UpClientError) {
//
//            }
//        })
//
//        // Note - This method can be called to cancel the network request
//        cancellableTask.cancel()
    }


//    fun getBanners(callback: Callback<BannerResponse>): CancellableTask {
//        return upClient.getBanners(callback)
//    }
//
//    fun getBanners(): Observable<BannerResponse> {
//        return upClient.getBanners()
//    }

}