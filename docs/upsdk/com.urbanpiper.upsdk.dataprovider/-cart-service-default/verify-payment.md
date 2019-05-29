[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CartServiceDefault](index.md) / [verifyPayment](./verify-payment.md)

# verifyPayment

`fun verifyPayment(transactionId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, gwTxnId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, transactionStatus: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`PaymentCallbackResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-payment-callback-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

This step is only required if the payment did not happen through a
redirection flow (i.e - through a webview with a redirection url from the payment init response)
This Marks the completion of a transaction.

### Parameters

`transactionId` -
* Transaction id from payment init

`gwTxnId` -
* payment gateway transaction id

`transactionStatus` -
* transaction status, it can have the following values
0 - Transaction success
1 - Transaction failed
5 - Transaction cancelled

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun verifyPayment(transactionId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, gwTxnId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, transactionStatus: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`PaymentCallbackResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-payment-callback-response/index.md)`>`

This step is only required if the payment did not happen through a
redirection flow (i.e - through a webview with a redirection url from the payment init response)
This Marks the completion of a transaction.

### Parameters

`transactionId` -
* Transaction id from payment init

`gwTxnId` -
* payment gateway transaction id

`transactionStatus` -
* transaction status, it can have the following values
0 - Transaction success
1 - Transaction failed
5 - Transaction cancelled

**Return**
Observable - the result of the network request is returned as an Observable

