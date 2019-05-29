[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CartServiceDefault](index.md) / [validateCoupon](./validate-coupon.md)

# validateCoupon

`fun validateCoupon(couponCode: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, body: `[`ValidateCouponBody`](../../com.urbanpiper.upsdk.model/-validate-coupon-body/index.md)`, callback: `[`Callback`](../-callback/index.md)`<`[`OrderValidateCouponResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-order-validate-coupon-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

This endpoint accepts a coupon code and the current order data to determine whether the coupon
can be applied, and what the discount value would be. The Order information is required for this
endpoint to function since a coupon’s validity is usually tied to the current order data.

### Parameters

`couponCode` -
* Coupon code

`body` -
* Validate coupon body

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun validateCoupon(couponCode: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, body: `[`ValidateCouponBody`](../../com.urbanpiper.upsdk.model/-validate-coupon-body/index.md)`): Observable<`[`OrderValidateCouponResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-order-validate-coupon-response/index.md)`>`

This endpoint accepts a coupon code and the current order data to determine whether the coupon
can be applied, and what the discount value would be. The Order information is required for this
endpoint to function since a coupon’s validity is usually tied to the current order data.

### Parameters

`couponCode` -
* Coupon code

`body` -
* Validate coupon body

**Return**
Observable - the result of the network request is returned as an Observable

