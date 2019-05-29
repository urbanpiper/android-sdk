[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CartServiceDefault](index.md) / [verifyWalletPayment](./verify-wallet-payment.md)

# verifyWalletPayment

`fun verifyWalletPayment(transactionId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, gwTxnId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, transactionStatus: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`PaymentCallbackResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-payment-callback-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [CartService.verifyWalletPayment](../-cart-service/verify-wallet-payment.md)

Verify that the wallet transaction occurred

### Parameters

`transactionId` -
* transaction id

`gwTxnId` -
* gateway transaction id

`transactionStatus` -
* transaction status

`callback` -
* Callback to return the result
`fun verifyWalletPayment(transactionId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, gwTxnId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, transactionStatus: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`PaymentCallbackResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-payment-callback-response/index.md)`>`

Overrides [CartService.verifyWalletPayment](../-cart-service/verify-wallet-payment.md)

Verify that the wallet transaction occurred

### Parameters

`transactionId` -
* transaction id

`gwTxnId` -
* gateway transaction id

`transactionStatus` -
* transaction status
