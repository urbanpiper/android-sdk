package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.Order
import com.urbanpiper.upsdk.model.ValidateCouponBody
import com.urbanpiper.upsdk.model.networkresponse.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CheckoutBuilder(private val cartServiceDefault: CartServiceDefault) {

    private var response1: PreProcessOrderResponse? = null
    private var response2: OrderValidateCouponResponse? = null
    private var response3: PaymentInitResponse? = null
    private var response4: OrderSaveResponse? = null

    /**
     * Sends the order details to the server for validation.
     */
    fun validateCart(order: Order, callback: Callback<PreProcessOrderResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            validateCart(order)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    callback.success(success)
                }, { error ->
                    callback.failure(UpClientError(error))
                })
        )
        return CancellableTaskDisposableWrapper(compositeDisposable)
    }

    /**
     * Sends the order details to the server for validation.
     */
    fun validateCart(order: Order): Observable<PreProcessOrderResponse> {
        val observable = cartServiceDefault.validateCart(order).share()

        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    response1 = success
                }, { error ->
                })
        )
        return observable
    }


    /**
     * Advanced version of coupon validation - takes in the complete
     * order data as request body.
     */
    fun validateCoupon(
        couponCode: String, body: ValidateCouponBody, callback: Callback<OrderValidateCouponResponse>
    ): CancellableTask {
        assert(response1 != null)
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            validateCoupon(couponCode, body)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    callback.success(success)
                }, { error ->
                    callback.failure(UpClientError(error))
                })
        )
        return CancellableTaskDisposableWrapper(compositeDisposable)
    }

    /**
     * Advanced version of coupon validation - takes in the complete
     * order data as request body.
     */
    fun validateCoupon(couponCode: String, body: ValidateCouponBody): Observable<OrderValidateCouponResponse> {
        assert(response1 != null)
        val observable = cartServiceDefault.validateCoupon(couponCode, body)

        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    response2 = success
                }, { error ->
                })
        )
        return observable
    }


    fun initPayment(
        storeId: Int, amount: Int, redirectUrl: String, paytm: String, simpl: String,
        callback: Callback<PaymentInitResponse>
    ): CancellableTask {
        assert(response1 != null)
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            initPayment(storeId, amount, redirectUrl, paytm, simpl)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    callback.success(success)
                }, { error ->
                    callback.failure(UpClientError(error))
                })
        )
        return CancellableTaskDisposableWrapper(compositeDisposable)
    }

    /**
     * Initiates a payment for the particular biz's store. This is useful if the biz is
     * using a franchisee model.
     *
     */
    fun initPayment(
        storeId: Int, amount: Int, redirectUrl: String, paytm: String, simpl: String
    ): Observable<PaymentInitResponse> {
        assert(response1 != null)
        val observable = cartServiceDefault.initPayment(storeId, amount, redirectUrl, paytm, simpl)

        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->

                    response3 = success
                }, { error ->
                })
        )
        return observable

    }


    /**
     * Sends the order details to the server for persistence.
     */
    fun placeOrder(body: Order, callback: Callback<OrderSaveResponse>): CancellableTask {

        assert(response3 != null)
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            placeOrder(body)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    callback.success(success)
                }, { error ->
                    callback.failure(UpClientError(error))
                })
        )
        return CancellableTaskDisposableWrapper(compositeDisposable)
    }

    /**
     * Sends the order details to the server for persistence.
     */
    fun placeOrder(body: Order): Observable<OrderSaveResponse> {
        assert(response3 != null)
        val observable = cartServiceDefault.placeOrder(body)

        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    response4 = success
                }, { error ->
                })
        )
        return observable
    }


    /**
     * Marks the completion of a transaction.
     *
     */
    fun verifyPayment(
        transactionId: String, gwTxnId: String, failed: Int, callback: Callback<PaymentCallbackResponse>
    ): CancellableTask {
        assert(response4 != null)
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            verifyPayment(transactionId, gwTxnId, failed)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    callback.success(success)
                }, { error ->
                    callback.failure(UpClientError(error))
                })
        )
        return CancellableTaskDisposableWrapper(compositeDisposable)
    }

    /**
     * Marks the completion of a transaction.
     *
     */
    fun verifyPayment(
        transactionId: String, gwTxnId: String, failed: Int
    ): Observable<PaymentCallbackResponse> {
        assert(response4 != null)
        val observable = cartServiceDefault.verifyPayment(transactionId, gwTxnId, failed)

        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    var response5 = success
                }, { error ->
                })
        )
        return observable
    }


}