[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CartServiceDefault](index.md) / [initPayment](./init-payment.md)

# initPayment

`fun initPayment(storeId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, redirectUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, paytm: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, simpl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, callback: `[`Callback`](../-callback/index.md)`<`[`PaymentInitResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-payment-init-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Starts the payment process

### Parameters

`storeId` -
* Store id

`amount` -
* amount

`redirectUrl` -
* redirect url - https://urbanpiper.com

`paytm` -
* send true` if paytm is the payment option or send null`

`simpl` -
* send true` if simpl is the payment option or send null`
If both paytm and simpl are not being used then send both options as null.

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun initPayment(storeId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, redirectUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, paytm: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, simpl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): Observable<`[`PaymentInitResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-payment-init-response/index.md)`>`

Starts the payment process

### Parameters

`storeId` -
* Store id

`amount` -
* amount

`redirectUrl` -
* redirect url - https://urbanpiper.com

`paytm` -
* send true` if paytm is the payment option or send null`

`simpl` -
* send true` if simpl is the payment option or send null`
If both paytm and simpl are not being used then send both options as null.

**Return**
Observable - the result of the network request is returned as an Observable

