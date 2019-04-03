package com.urbanpiper.sdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import com.urbanpiper.upsdk.dataprovider.Callback
import com.urbanpiper.upsdk.dataprovider.UpClientError
import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import com.urbanpiper.upsdk.model.networkresponse.CartItem
import com.urbanpiper.upsdk.model.networkresponse.CategoryItemResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cart = MyApp.Singleton.upClient.getCart(2070)

        val cartItems: LiveData<List<CartItem>> = cart.getAllItemsLiveData()
        cartItems.observe(this, androidx.lifecycle.Observer { items ->
            items?.let {

                Log.d("Cart items", " Size ${items.size}")

                Toast.makeText(this@MainActivity, " Size ${items.size}", Toast.LENGTH_LONG).show()

                for(item in items){
                    Log.d("Cart items", " ${item.toJson()}")
                }
            }
        })

        MyApp.Singleton.upClient.getCategoryItems(3115, "2070", 0, 20)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : io.reactivex.Observer<CategoryItemResponse> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: CategoryItemResponse) {
                    for (item in t.objects) {
                        cart.addItem(item)
                    }
                }

                override fun onError(e: Throwable) {

                }

            })

        cart.clearCart()

    }
}
