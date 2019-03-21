package com.urbanpiper.sdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.urbanpiper.upsdk.dataprovider.Callback
import com.urbanpiper.upsdk.dataprovider.UpClientError
import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cancellableTask = MyApp().getBanners(object: Callback<BannerResponse> {
            override fun success(response: BannerResponse) {
                val banners: BannerResponse = response

                if (!banners.images.isNullOrEmpty()) {
                    for (i in 0 until banners.images.size) {
                        Log.d("Success ", "Banner Name ${banners.images[0].image}")
                        text.text = "Banner Name ${banners.images[0].image}"
                    }
                }
            }

            override fun failure(upClientError: UpClientError) {
                upClientError.getErrorType()
            }
        })

        cancellableTask.cancel()

        compositeDisposable.add(
            MyApp().getBanners()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->

                }, { error ->

                })
        )
    }
}
