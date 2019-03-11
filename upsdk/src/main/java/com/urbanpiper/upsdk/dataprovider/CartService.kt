package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.Order
import com.urbanpiper.upsdk.model.ValidateCouponBody
import com.urbanpiper.upsdk.model.networkresponse.*
import io.reactivex.Observable

interface CartService {

    /**
     * re-order api
     */
    fun reOrder(
        orderId: String, locationId: String, lat: String, lng: String, callback: Callback<ReOrderResponse>
    ): CancellableTask

    /**
     * re-order api
     */
    fun reOrder(orderId: String, locationId: String, lat: String, lng: String): Observable<ReOrderResponse>

    /**
     * Get the recommended items from the server. The items returned are based on a particular item
     * in details or checkout page.
     */
    fun getCartRelatedItems(
        itemIds: String, locationId: Int, callback: Callback<RecommendedItemResponse>
    ): CancellableTask

    /**
     * Get the recommended items from the server. The items returned are based on a particular item
     * in details or checkout page.
     */
    fun getCartRelatedItems(itemIds: String, locationId: Int): Observable<RecommendedItemResponse>

    /**
     * Sends the order details to the server for validation.
     */
    fun validateCart(order: Order, callback: Callback<PreProcessOrderResponse>): CancellableTask

    /**
     * Sends the order details to the server for validation.
     */
    fun validateCart(order: Order): Observable<PreProcessOrderResponse>

    /**
     * Advanced version of coupon validation - takes in the complete
     * order data as request body.
     */
    fun validateCoupon(
        couponCode: String, body: ValidateCouponBody, callback: Callback<OrderValidateCouponResponse>
    ): CancellableTask

    /**
     * Advanced version of coupon validation - takes in the complete
     * order data as request body.
     */
    fun validateCoupon(
        couponCode: String, body: ValidateCouponBody
    ): Observable<OrderValidateCouponResponse>

    /**
     * Initiates a payment for the particular biz's store. This is useful if the biz is
     * using a franchisee model.
     *
     */
    fun initPayment(
        storeId: Int, amount: Int, purpose: String, redirectUrl: String, paytm: String, simpl: String,
        callback: Callback<PaymentInitResponse>
    ): CancellableTask

    /**
     * Initiates a payment for the particular biz's store. This is useful if the biz is
     * using a franchisee model.
     *
     */
    fun initPayment(
        storeId: Int, amount: Int, purpose: String, redirectUrl: String, paytm: String, simpl: String
    ): Observable<PaymentInitResponse>

    /**
     * Sends the order details to the server for persistence.
     */
    fun placeOrder(body: Order, callback: Callback<OrderSaveResponse>): CancellableTask

    /**
     * Sends the order details to the server for persistence.
     */
    fun placeOrder(body: Order): Observable<OrderSaveResponse>

    /**
     * Marks the completion of a transaction.
     *
     */
    fun verifyPayment(
        transactionId: String, gwTxnId: String, failed: Int, callback: Callback<PaymentCallbackResponse>
    ): CancellableTask

    /**
     * Marks the completion of a transaction.
     *
     */
    fun verifyPayment(
        transactionId: String, gwTxnId: String, failed: Int
    ): Observable<PaymentCallbackResponse>

    fun getCartInstance(): Cart

}


