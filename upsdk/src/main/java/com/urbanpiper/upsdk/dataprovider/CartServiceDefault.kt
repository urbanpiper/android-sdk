package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.Order
import com.urbanpiper.upsdk.model.ValidateCouponBody
import com.urbanpiper.upsdk.model.networkresponse.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class CartServiceDefault(private val authToken: String, private val bizId: String, retrofit: Retrofit) : CartService {

    private val cartService: CartRetrofitService =
        retrofit.create(CartRetrofitService::class.java)

    /**
     * re-order api
     */
    override fun reOrder(
        orderId: String, locationId: String, lat: String, lng: String, callback: Callback<ReOrderResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            reOrder(orderId, locationId, lat, lng)
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
     * re-order api
     */
    override fun reOrder(orderId: String, locationId: String, lat: String, lng: String): Observable<ReOrderResponse> {
        return cartService.reOrder(authToken, orderId, locationId, lat, lng)
    }

    /**
     * Get the recommended items from the server. The items returned are based on a particular item
     * in details or checkout page.
     */
    override fun getCartRelatedItems(
        itemIds: String, locationId: Int, callback: Callback<RecommendedItemResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            getCartRelatedItems(itemIds, locationId)
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
     * Get the recommended items from the server. The items returned are based on a particular item
     * in details or checkout page.
     */
    override fun getCartRelatedItems(itemIds: String, locationId: Int): Observable<RecommendedItemResponse> {
        return cartService.getCartRelatedItems(authToken, itemIds, locationId)
    }

    /**
     * Sends the order details to the server for validation.
     */
    override fun validateCart(order: Order, callback: Callback<PreProcessOrderResponse>): CancellableTask {
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
    override fun validateCart(order: Order): Observable<PreProcessOrderResponse> {
        return cartService.validateCart(authToken, bizId, 1, order)
    }

    /**
     * Advanced version of coupon validation - takes in the complete
     * order data as request body.
     */
    override fun validateCoupon(
        couponCode: String, body: ValidateCouponBody, callback: Callback<OrderValidateCouponResponse>
    ): CancellableTask {
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
    override fun validateCoupon(couponCode: String, body: ValidateCouponBody): Observable<OrderValidateCouponResponse> {
        return cartService.validateCoupon(authToken, couponCode, body)
    }

    /**
     * Initiates a payment for the particular biz's store. This is useful if the biz is
     * using a franchisee model.
     *
     */
    override fun initPayment(
        storeId: Int, amount: Int, purpose: String, redirectUrl: String, paytm: String, simpl: String,
        callback: Callback<PaymentInitResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            initPayment(storeId, amount, purpose, redirectUrl, paytm, simpl)
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
    override fun initPayment(
        storeId: Int, amount: Int, purpose: String, redirectUrl: String, paytm: String, simpl: String
    ): Observable<PaymentInitResponse> {
        return cartService.initPayment(authToken, bizId, storeId, amount, purpose, redirectUrl, paytm, simpl)
    }

    /**
     * Sends the order details to the server for persistence.
     */
    override fun placeOrder(body: Order, callback: Callback<OrderSaveResponse>): CancellableTask {
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
    override fun placeOrder(body: Order): Observable<OrderSaveResponse> {
        return cartService.placeOrder(authToken, bizId, body)
    }

    /**
     * Marks the completion of a transaction.
     *
     */
    override fun verifyPayment(
        transactionId: String, gwTxnId: String, failed: Int, callback: Callback<PaymentCallbackResponse>
    ): CancellableTask {
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
    override fun verifyPayment(
        transactionId: String, gwTxnId: String, failed: Int
    ): Observable<PaymentCallbackResponse> {
        return cartService.verifyPayment(authToken, transactionId, gwTxnId, failed)
    }


}