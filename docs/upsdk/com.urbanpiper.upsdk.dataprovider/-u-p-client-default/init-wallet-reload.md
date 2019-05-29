[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UPClientDefault](index.md) / [initWalletReload](./init-wallet-reload.md)

# initWalletReload

`fun initWalletReload(storeId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, redirectUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, paytm: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, simpl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, callback: `[`Callback`](../-callback/index.md)`<`[`PaymentInitResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-payment-init-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [CartService.initWalletReload](../-cart-service/init-wallet-reload.md)

Initiates wallet reload

### Parameters

`storeId` -
* Store id

`amount` -
* amount

`redirectUrl` -
* redirect url

`paytm` -
* paytm

`simpl` -
* simpl

`callback` -
* Callback to return the result
`fun initWalletReload(storeId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, redirectUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, paytm: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, simpl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): Observable<`[`PaymentInitResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-payment-init-response/index.md)`>`

Overrides [CartService.initWalletReload](../-cart-service/init-wallet-reload.md)

Initiates wallet reload

### Parameters

`storeId` -
* Store id

`amount` -
* amount

`redirectUrl` -
* redirect url

`paytm` -
* paytm

`simpl` -
* simpl
