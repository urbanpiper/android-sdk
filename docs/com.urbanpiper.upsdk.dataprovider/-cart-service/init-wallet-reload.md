[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CartService](index.md) / [initWalletReload](./init-wallet-reload.md)

# initWalletReload

`abstract fun initWalletReload(storeId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, redirectUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, paytm: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, simpl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, callback: `[`Callback`](../-callback/index.md)`<`[`PaymentInitResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-payment-init-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Starts the wallet reload process

### Parameters

`storeId` -
* Store id

`amount` -
* multiply this by 100

`redirectUrl` -
* redirect url - https://urbanpiper.com

`paytm` -
* send `true` if paytm is the payment option or send `null`

`simpl` -
* send `true` if simpl is the payment option or send `null`

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`abstract fun initWalletReload(storeId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, redirectUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, paytm: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, simpl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): Observable<`[`PaymentInitResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-payment-init-response/index.md)`>`

Starts the wallet reload process

### Parameters

`storeId` -
* Store id

`amount` -
* multiply this by 100

`redirectUrl` -
* redirect url - https://urbanpiper.com

`paytm` -
* send `true` if paytm is the payment option or send `null`

`simpl` -
* send `true` if simpl is the payment option or send `null`

**Return**
Observable - the result of the network request is returned as an Observable

