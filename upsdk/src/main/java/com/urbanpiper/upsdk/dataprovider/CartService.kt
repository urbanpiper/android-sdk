package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.Order
import com.urbanpiper.upsdk.model.ValidateCouponBody
import com.urbanpiper.upsdk.model.networkresponse.*
import io.reactivex.Observable

/**
 * List of methods related to cart
 */
interface CartService {

    /**
     * This endpoint validates whether a previously placed order can be re-ordered.
     * The response indicates which items can be re-ordered and which can’t be.
     *
     * @param orderId - Order Id
     * @param locationId - Location Id
     * @param lat - user's current latitude
     * @param lng - user's current longitude
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun reOrder(
        orderId: String, locationId: String, lat: String, lng: String, callback: Callback<ReOrderResponse>
    ): CancellableTask

    /**
     * This endpoint validates whether a previously placed order can be re-ordered.
     * The response indicates which items can be re-ordered and which can’t be.
     *
     * @param orderId - Order Id
     * @param locationId - Location Id
     * @param lat - user's current latitude
     * @param lng - user's current longitude
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun reOrder(orderId: String, locationId: String, lat: String, lng: String): Observable<ReOrderResponse>

    /**
     * returns a list of items which are sent based on the location id and other items
     * Multiple item id's can be passed as comma separated values Eg( id1,id2,id3 )
     *
     * @param itemIds - Item id
     * @param locationId - Location id
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun getCartRelatedItems(
        itemIds: String, locationId: Int, callback: Callback<RecommendedItemResponse>
    ): CancellableTask

    /**
     * returns a list of items which are sent based on the location id and other items
     * Multiple item id's can be passed as comma separated values Eg( id1,id2,id3 )
     *
     * @param itemIds - Item id
     * @param locationId - Location id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun getCartRelatedItems(itemIds: String, locationId: Int): Observable<RecommendedItemResponse>

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
    fun validateCart(order: Order, callback: Callback<ValidateCartResponse>): CancellableTask

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
    fun validateCart(order: Order): Observable<ValidateCartResponse>

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
    ): CancellableTask

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
    fun validateCoupon(
        couponCode: String, body: ValidateCouponBody
    ): Observable<OrderValidateCouponResponse>

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
    ): CancellableTask

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
    ): Observable<PaymentInitResponse>

    /**
     * Init wallet reload
     */
    fun initWalletReload(
        storeId: Int, amount: Int, redirectUrl: String, paytm: String, simpl: String,
        callback: Callback<PaymentInitResponse>
    ): CancellableTask

    /**
     * Init wallet reload
     */
    fun initWalletReload(
        storeId: Int, amount: Int,  redirectUrl: String, paytm: String, simpl: String
    ): Observable<PaymentInitResponse>

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
    fun placeOrder(body: Order, callback: Callback<OrderSaveResponse>): CancellableTask

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
    fun placeOrder(body: Order): Observable<OrderSaveResponse>

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
    ): CancellableTask

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
    ): Observable<PaymentCallbackResponse>

    /**
     * Returns an instance of the local cart
     */
    fun getCart(): Cart

}


