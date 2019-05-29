[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CartRetrofitService](index.md) / [validateCoupon](./validate-coupon.md)

# validateCoupon

`@POST("/api/v1/coupons/{coupon_code}/") abstract fun validateCoupon(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Path("coupon_code") couponCode: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Body body: `[`ValidateCouponBody`](../../com.urbanpiper.upsdk.model/-validate-coupon-body/index.md)`): Observable<`[`OrderValidateCouponResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-order-validate-coupon-response/index.md)`>`

Advanced version of coupon validation - takes in the complete
order data as request body.

### Parameters

`couponCode` -

`body` -

`authToken` - 