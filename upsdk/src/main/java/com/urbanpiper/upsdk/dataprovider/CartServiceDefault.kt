package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.Order
import com.urbanpiper.upsdk.model.ValidateCouponBody
import com.urbanpiper.upsdk.model.networkresponse.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class CartServiceDefault(private val bizId: String, retrofit: Retrofit) : CartService {

    private val cartService: CartRetrofitService =
        retrofit.create(CartRetrofitService::class.java)

    /**
     * Re order Api
     *
     * @param orderId - Id of the order
     * @param locationId - location id of the user
     * @param lat - latitude
     * @param lng - longitude
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
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
     * Re order api
     *
     * @param orderId - Id of the order
     * @param locationId - location id of the user
     * @param lat - latitude
     * @param lng - longitude
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun reOrder(orderId: String, locationId: String, lat: String, lng: String): Observable<ReOrderResponse> {
        val authToken: String = SharedPrefManager.getAuthToken(true)
        return cartService.reOrder(authToken, orderId, locationId, lat, lng)
    }

    /**
     * Get the recommended items from the server. The items returned are based on a particular item
     * in details or checkout page.
     *
     * @param itemIds - Item id's can be passed as comma separated values (id1,id2,id3)
     * @param locationId - Location id of the user
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
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
     *
     * @param itemIds - Item id's can be passed as comma separated values (id1,id2,id3)
     * @param locationId - Location id of the user
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getCartRelatedItems(itemIds: String, locationId: Int): Observable<RecommendedItemResponse> {
        val authToken: String = SharedPrefManager.getAuthToken(SharedPrefManager.isUserLoggedIn())
        return cartService.getCartRelatedItems(authToken, itemIds, locationId)
    }

    /**
     * This is an important method in the flow of placing an order. This endpoint validates the contents
     * of the cart to return the computational details for the order, like the charges, taxes, total, etc.
     * We strongly recommend client applications not to perform these complex computations at their end,
     * since there are many variables that can affect the computations—not all of which are available with
     * the client application at any time.
     *
     * @param order - Order object
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun validateCart(order: Order, callback: Callback<ValidateCartResponse>): CancellableTask {
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
     * This is an important method in the flow of placing an order. This endpoint validates the contents
     * of the cart to return the computational details for the order, like the charges, taxes, total, etc.
     * We strongly recommend client applications not to perform these complex computations at their end,
     * since there are many variables that can affect the computations—not all of which are available with
     * the client application at any time.
     *
     * @param order - Order object
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun validateCart(order: Order): Observable<ValidateCartResponse> {
        val authToken: String = SharedPrefManager.getAuthToken(SharedPrefManager.isUserLoggedIn())
        return cartService.validateCart(authToken, bizId, 1, order)
    }

    /**
     * This endpoint accepts a coupon code and the current order data to determine whether the coupon
     * can be applied, and what the discount value would be. The Order information is required for this
     * endpoint to function since a coupon’s validity is usually tied to the current order data.
     *
     * @param couponCode - Coupon code
     * @param body - Validate coupon body
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun validateCoupon(
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
     * This endpoint accepts a coupon code and the current order data to determine whether the coupon
     * can be applied, and what the discount value would be. The Order information is required for this
     * endpoint to function since a coupon’s validity is usually tied to the current order data.
     *
     * @param couponCode - Coupon code
     * @param body - Validate coupon body
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun validateCoupon(couponCode: String, body: ValidateCouponBody): Observable<OrderValidateCouponResponse> {
        val authToken: String = SharedPrefManager.getAuthToken(true)
        return cartService.validateCoupon(authToken, couponCode, body)
    }

    /**
     * Starts the payment process
     *
     * @param storeId - Store id
     * @param amount - amount
     * @param redirectUrl - redirect url - https://urbanpiper.com
     * @param paytm - send true`` if paytm is the payment option or send null``
     * @param simpl - send true`` if simpl is the payment option or send null``
     * If both paytm and simpl are not being used then send both options as null.
     *
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun initPayment(
        storeId: Int, amount: Int, redirectUrl: String, paytm: String?, simpl: String?,
        callback: Callback<PaymentInitResponse>
    ): CancellableTask {
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
     * Starts the payment process
     *
     * @param storeId - Store id
     * @param amount - amount
     * @param redirectUrl - redirect url - https://urbanpiper.com
     * @param paytm - send true`` if paytm is the payment option or send null``
     * @param simpl - send true`` if simpl is the payment option or send null``
     * If both paytm and simpl are not being used then send both options as null.
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun initPayment(
        storeId: Int, amount: Int, redirectUrl: String, paytm: String?, simpl: String?
    ): Observable<PaymentInitResponse> {
        val authToken: String = SharedPrefManager.getAuthToken(true)
        return cartService.initPayment(authToken, bizId, storeId, amount, "ordering", redirectUrl, paytm, simpl)
    }

    /**
     * Sends the order details to the server
     *
     * If the payment option is NOT Cash on delivery, a provisional order is placed
     * order.state = "awaiting_payment"
     *
     * If the payment option is Cash on Delivery, Then order.state = null
     *
     * @param body - Order object
     * @param callback - callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun placeOrder(body: Order, callback: Callback<OrderSaveResponse>): CancellableTask {
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
     * Sends the order details to the server
     *
     * If the payment option is NOT Cash on delivery, a provisional order is placed
     * order.state = "awaiting_payment"
     *
     * If the payment option is Cash on Delivery, Then order.state = null
     *
     * @param body - Order object
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun placeOrder(body: Order): Observable<OrderSaveResponse> {
        val authToken: String = SharedPrefManager.getAuthToken(true)
        return cartService.placeOrder(authToken, bizId, body)
    }

    /**
     * This step is only required if the payment did not happen through a
     * redirection flow (i.e - through a webview with a redirection url from the payment init response)
     * This Marks the completion of a transaction.
     *
     * @param transactionId - Transaction id from payment init
     * @param gwTxnId - payment gateway transaction id
     * @param transactionStatus - transaction status, it can have the following values
     * 0 - Transaction success
     * 1 - Transaction failed
     * 5 - Transaction cancelled
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun verifyPayment(
        transactionId: String, gwTxnId: String, transactionStatus: Int, callback: Callback<PaymentCallbackResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            verifyPayment(transactionId, gwTxnId, transactionStatus)
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
     * This step is only required if the payment did not happen through a
     * redirection flow (i.e - through a webview with a redirection url from the payment init response)
     * This Marks the completion of a transaction.
     *
     * @param transactionId - Transaction id from payment init
     * @param gwTxnId - payment gateway transaction id
     * @param transactionStatus - transaction status, it can have the following values
     * 0 - Transaction success
     * 1 - Transaction failed
     * 5 - Transaction cancelled
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun verifyPayment(
        transactionId: String, gwTxnId: String, transactionStatus: Int
    ): Observable<PaymentCallbackResponse> {
        val authToken: String = SharedPrefManager.getAuthToken(true)
        return cartService.verifyPayment(authToken, transactionId, gwTxnId, transactionStatus)
    }

    /**
     * Initiates wallet reload
     *
     * @param storeId - Store id
     * @param amount - amount
     * @param redirectUrl - redirect url
     * @param paytm - paytm
     * @param simpl - simpl
     * @param callback - Callback to return the result
     */
    override fun initWalletReload(
        storeId: Int, amount: Int, redirectUrl: String, paytm: String?, simpl: String?,
        callback: Callback<PaymentInitResponse>
    ): CancellableTask {
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
     * Initiates wallet reload
     *
     * @param storeId - Store id
     * @param amount - amount
     * @param redirectUrl - redirect url
     * @param paytm - paytm
     * @param simpl - simpl
     */
    override fun initWalletReload(
        storeId: Int, amount: Int, redirectUrl: String, paytm: String?, simpl: String?
    ): Observable<PaymentInitResponse> {
        val authToken: String = SharedPrefManager.getAuthToken(true)
        return cartService.initPayment(authToken, bizId, storeId, amount, "reload", redirectUrl, paytm, simpl)
    }

    /**
     * Verify that the wallet transaction occurred
     *
     * @param transactionId - transaction id
     * @param gwTxnId - gateway transaction id
     * @param transactionStatus - transaction status
     * @param callback - Callback to return the result
     */
    override fun verifyWalletPayment(
        transactionId: String, gwTxnId: String, transactionStatus: Int, callback: Callback<PaymentCallbackResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            verifyWalletPayment(transactionId, gwTxnId, transactionStatus)
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
     * Verify that the wallet transaction occurred
     *
     * @param transactionId - transaction id
     * @param gwTxnId - gateway transaction id
     * @param transactionStatus - transaction status
     */
    override fun verifyWalletPayment(
        transactionId: String, gwTxnId: String, transactionStatus: Int
    ): Observable<PaymentCallbackResponse> {
        val authToken: String = SharedPrefManager.getAuthToken(true)
        return cartService.verifyPayment(authToken, transactionId, gwTxnId, transactionStatus)
    }
}