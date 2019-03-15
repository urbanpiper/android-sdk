package com.urbanpiper.sdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.urbanpiper.upsdk.dataprovider.UpClientError
import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        MyApp().getBanners(object : Callback<BannerResponse> {
//            override fun onResponse(call: Call<BannerResponse>, response: Response<BannerResponse>) {
//                Log.d("success", " ${response.isSuccessful}")
//
//                if (response.isSuccessful) {
//                    val banners = response.body()
//
//                    if (banners != null) {
//                        Log.d("success", " ${banners.toJson()}")
//
//                        if (!banners.images.isNullOrEmpty()) {
//                            for (i in 0 until banners.images.size) {
//                                Log.d("Success ", "Banner Name ${banners.images[0].image}")
//                                text.text = "Banner Name ${banners.images[0].image}"
//                            }
//                        }
//                    }
//                } else {
//                    Toast.makeText(baseContext, "Response is not successful", Toast.LENGTH_LONG).show()
//                }
//            }
//
//            override fun onFailure(call: Call<BannerResponse>, t: Throwable) {
//                if(call.isCanceled){
//                    Log.e("Cancelled", "Retrofit call failed", t)
//                }
//                Log.e("failure", "Retrofit call failed", t)
//            }
//        })

//        compositeDisposable.add(
//            MyApp().getBanners()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe { result ->
//                    if (result != null) {
//                        val banners: BannerResponse = result
//
//                        if (!banners.images.isNullOrEmpty()) {
//                            for (i in 0 until banners.images.size) {
//                                Log.d("Success ", "Banner Name ${banners.images[0].image}")
//                                text.text = "Banner Name ${banners.images[0].image}"
//                            }
//                        }
//                    }
//                })

//        val cancellableTask = MyApp().getBanners(object : com.urbanpiper.upsdk.dataprovider.Callback<BannerResponse> {
//            override fun success(response: BannerResponse) {
//
//                val banners: BannerResponse = response
//
//                if (!banners.images.isNullOrEmpty()) {
//                    for (i in 0 until banners.images.size) {
//                        Log.d("Success ", "Banner Name ${banners.images[0].image}")
//                        text.text = "Banner Name ${banners.images[0].image}"
//                    }
//                }
//
//            }

//            override fun failure(upClientError: UpClientError) {
//
//            }
//        })


//        compositeDisposable.add(
//            MyApp().login("9880170805", "nikhil12345")
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe({ response ->
//                    Log.d("Main Activity ", "${response.message}  ${response.token} ${response.status}")
//
//                }, { error ->
//                    Log.d("error", "Login failed ", error)
//                })
//        )
//
//
//        val builder = MyApp().getRegistrationBuilder()
//
//        val observable = builder.createUser("a", "b", "c", "A")
//
//        builder.verifyOTP("a", "v", "lol")
    }
}
