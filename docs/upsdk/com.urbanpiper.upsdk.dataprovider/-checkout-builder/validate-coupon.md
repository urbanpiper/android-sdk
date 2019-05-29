[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CheckoutBuilder](index.md) / [validateCoupon](./validate-coupon.md)

# validateCoupon

`fun validateCoupon(couponCode: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, body: `[`ValidateCouponBody`](../../com.urbanpiper.upsdk.model/-validate-coupon-body/index.md)`, callback: `[`Callback`](../-callback/index.md)`<`[`OrderValidateCouponResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-order-validate-coupon-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

ValidateCoupon should be called when a coupon is added by the user, if user is in the cart page.
If user has applied a coupon this method should be called every time the cart changes.
This method adds the discount from the coupon, pre-processes the contents of the cart to return
the computational details for the order, like the charges, taxes, total, discount, etc.

### Parameters

`couponCode` -
* Coupon Code

`body` -
* Validate coupon body

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun validateCoupon(couponCode: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, body: `[`ValidateCouponBody`](../../com.urbanpiper.upsdk.model/-validate-coupon-body/index.md)`): Observable<`[`OrderValidateCouponResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-order-validate-coupon-response/index.md)`>`

ValidateCoupon should be called when a coupon is added by the user, if user is in the cart page.
If user has applied a coupon this method should be called every time the cart changes.
This method adds the discount from the coupon, pre-processes the contents of the cart to return
the computational details for the order, like the charges, taxes, total, discount, etc.

### Parameters

`couponCode` -
* Coupon Code

`body` -
* Validate coupon body

**Return**
Observable - the result of the network request is returned as an Observable

