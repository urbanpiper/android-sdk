package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.Order
import com.urbanpiper.upsdk.model.ValidateCouponBody
import com.urbanpiper.upsdk.model.networkresponse.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CheckoutBuilder(private val cartServiceDefault: CartServiceDefault) {

//    private var response1: ValidateCartResponse? = null
//    private var response2: OrderValidateCouponResponse? = null
//    private var response3: PaymentInitResponse? = null
//    private var response4: OrderSaveResponse? = null

    /**
     * Validate cart should be called every time the cart changes, if user is in the cart page.
     * This method pre-processes the contents of the cart to return the computational details for the order,
     * like the charges, taxes, total, etc. We strongly recommend client applications not to perform these
     * complex computations at their end, since there are many variables that can affect the
     * computations—not all of which are available with the client application at any time.
     *
     * @param order
     * @param callback
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
     * Validate cart should be called every time the cart changes, if user is in the cart page.
     * This method pre-processes the contents of the cart to return the computational details for the order,
     * like the charges, taxes, total, etc. We strongly recommend client applications not to perform these
     * complex computations at their end, since there are many variables that can affect the
     * computations—not all of which are available with the client application at any time.
     *
     * @param order
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun validateCart(order: Order): Observable<ValidateCartResponse> {
        val observable = cartServiceDefault.validateCart(order).share()

        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    //                    response1 = success
                }, { error ->
                })
        )
        return observable
    }


    /**
     * ValidateCoupon should be called when a coupon is added by the user, if user is in the cart page.
     * If user has applied a coupon this method should be called every time the cart changes.
     * This method adds the discount from the coupon, pre-processes the contents of the cart to return
     * the computational details for the order, like the charges, taxes, total, discount, etc.
     *
     * @param couponCode - Coupon Code
     * @param body - Validate coupon body
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun validateCoupon(
        couponCode: String, body: ValidateCouponBody, callback: Callback<OrderValidateCouponResponse>
    ): CancellableTask {
//        assert(response1 != null)
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
     * ValidateCoupon should be called when a coupon is added by the user, if user is in the cart page.
     * If user has applied a coupon this method should be called every time the cart changes.
     * This method adds the discount from the coupon, pre-processes the contents of the cart to return
     * the computational details for the order, like the charges, taxes, total, discount, etc.
     *
     * @param couponCode - Coupon Code
     * @param body - Validate coupon body
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun validateCoupon(couponCode: String, body: ValidateCouponBody): Observable<OrderValidateCouponResponse> {
//        assert(response1 != null)
        val observable = cartServiceDefault.validateCoupon(couponCode, body)

        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    //                    response2 = success
                }, { error ->
                })
        )
        return observable
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
//        assert(response1 != null)
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
//        assert(response1 != null)
        val observable = cartServiceDefault.initPayment(storeId, amount, redirectUrl, paytm, simpl)

        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    //                    response3 = success
                }, { error ->
                })
        )
        return observable

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

//        assert(response3 != null)
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
//        assert(response3 != null)
        val observable = cartServiceDefault.placeOrder(body)

        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    //                    response4 = success
                }, { error ->
                })
        )
        return observable
    }

    /**
     * This step is only required if the payment did not happen through a
     * redirection flow (i.e - through a webview with a redirection url from the payment init response)
     * This Marks the completion of a transaction.
     *
     * @param transactionId - Transaction id from payement init
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
//        assert(response4 != null)
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
     * @param transactionId - Transaction id from payement init
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
//        assert(response4 != null)
        val observable = cartServiceDefault.verifyPayment(transactionId, gwTxnId, transactionStatus)

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