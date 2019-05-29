[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CartRetrofitService](index.md) / [verifyPayment](./verify-payment.md)

# verifyPayment

`@GET("/payments/callback/{txn_id}") abstract fun verifyPayment(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Path("txn_id") transactionId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("gateway_txn_id") gwTxnId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("failed") failed: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`PaymentCallbackResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-payment-callback-response/index.md)`>`

Marks the completion of a transaction.

### Parameters

`transactionId` -
* transaction id from payment init

`gwTxnId` -
* Gateway transaction id

`failed` -
* set to 1 if a failure occurred. Else, set to 0.

`authToken` -
* Auth token
