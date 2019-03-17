package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.Order
import com.urbanpiper.upsdk.model.ValidateCouponBody
import com.urbanpiper.upsdk.model.networkresponse.*
import io.reactivex.Observable
import retrofit2.http.*

/**
 * TODO
 *
 */
interface CartRetrofitService {

    /**
     * re-order api
     *
     * @param authToken - Authorization token
     * @param orderID - Order id
     * @param lat - latitude
     * @param lng - longitude
     * @param location_id - id of the location(store)
     */
    @GET("/api/v2/order/{id}/reorder/")
    fun reOrder(
        @Header("Authorization") authToken: String,
        @Path("id") orderID: String,
        @Query("location_id") location_id: String,
        @Query("lat") lat: String,
        @Query("lng") lng: String
    ): Observable<ReOrderResponse>

    /**
     * Get the recommended items from the server. The items returned are based on a particular item
     * in details or checkout page.
     *
     * @param itemId - Comma separated item id's or single item.
     * @param locationId - Id of the nearest store
     * @param authToken  - Auth token
     */
    @GET("/api/v2/items/{item_id}/recommendations/")
    fun getCartRelatedItems(
        @Header("Authorization") authToken: String
        , @Path("item_id") itemId: String
        , @Query("location_id") locationId: Int
    ): Observable<RecommendedItemResponse>

    /**
     * Sends the order details to the server for pre-processing.
     *
     * @param order
     * @param bizId
     * @param preProcessOutput
     * @param authToken
     */
    @POST("/api/v1/order/")
    fun validateCart(
        @Header("Authorization") authToken: String,
        @Query("biz_id") bizId: String,
        @Query("pre_proc") preProcessOutput: Int,
        @Body order: Order
    ): Observable<ValidateCartResponse>

    /**
     * Advanced version of coupon validation - takes in the complete
     * order data as request body.
     *
     * @param couponCode
     * @param body
     * @param authToken
     */
    @POST("/api/v1/coupons/{coupon_code}/")
    fun validateCoupon(
        @Header("Authorization") authToken: String,
        @Path("coupon_code") couponCode: String,
        @Body body: ValidateCouponBody
    ) : Observable<OrderValidateCouponResponse>

    /**
     * Initiates a payment for the particular biz's store. This is useful if the biz is
     * using a franchisee model.
     *
     * @param bizId
     * @param storeId
     * @param authToken
     * @param amount
     * @param purpose - can be either or `ordering`/`reload`
     */
    @GET("/payments/init/{biz_id}/{store_id}/?channel=app_android")
    fun initPayment(
        @Header("Authorization") authToken: String,
        @Path("biz_id") bizId: String,
        @Path("store_id") storeId: Int,
        @Query("amount") amount: Int,
        @Query("purpose") purpose: String,
        @Query("redirect_url") redirectUrl: String,
        @Query("paytm") paytm: String?,
        @Query("simpl") simpl: String?
    ) : Observable<PaymentInitResponse>

    /**
     * Sends the order details to the server for persistence.
     *
     * @param order
     * @param bizId
     * @param authToken
     * @param cb
     */
    @POST("/api/v1/order/")
    fun placeOrder(
        @Header("Authorization") authToken: String,
        @Query("biz_id") bizId: String,
        @Body order: Order
    ): Observable<OrderSaveResponse>

    /**
     * Marks the completion of a transaction.
     *
     * @param transactionId
     * @param gwTxnId
     * @param failed        set to 1 if a failure occurred. Else, set to 0.
     * @param authToken
     * @param cb
     */
    @GET("/payments/callback/{txn_id}")
    fun verifyPayment(
        @Header("Authorization") authToken: String,
        @Path("txn_id") transactionId: String,
        @Query("gateway_txn_id") gwTxnId: String,
        @Query("failed") failed: Int
    ): Observable<PaymentCallbackResponse>

}