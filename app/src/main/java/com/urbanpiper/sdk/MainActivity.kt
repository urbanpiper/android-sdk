package com.urbanpiper.sdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.urbanpiper.upsdk.model.networkresponse.BannerResponse

import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyApp().getBanners(object : Callback<BannerResponse> {
            override fun onResponse(call: Call<BannerResponse>, response: Response<BannerResponse>) {
                Log.d("success", " ${response.isSuccessful}")

                if (response.isSuccessful) {
                    val banners = response.body()

                    if (banners != null) {
                        Log.d("success", " ${banners.toJson()}")

                        if (!banners.images.isNullOrEmpty()) {
                            for (i in 0 until banners.images.size) {
                                Log.d("Success ", "Banner Name ${banners.images[0].image}")
                                text.text = "Banner Name ${banners.images[0].image}"
                            }
                        }
                    }
                } else {
                    Toast.makeText(baseContext, "Response is not successful", Toast.LENGTH_LONG).show()
                }

            }

            override fun onFailure(call: Call<BannerResponse>, t: Throwable) {
                if(call.isCanceled){
                    Log.e("Cancelled", "Retrofit call failed", t)
                }

                Log.e("failure", "Retrofit call failed", t)
            }
        })




    }


}
