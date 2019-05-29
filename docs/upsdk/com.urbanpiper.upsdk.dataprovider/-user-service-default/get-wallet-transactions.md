[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserServiceDefault](index.md) / [getWalletTransactions](./get-wallet-transactions.md)

# getWalletTransactions

`fun getWalletTransactions(limit: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, offset: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`TransactionsResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-transactions-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [UserService.getWalletTransactions](../-user-service/get-wallet-transactions.md)

This endpoint returns a list of prepaid transactions associated with the user.
Each of the transactions contains some basic information about the context of the transaction.
Since the white-label prepaid wallet instrument is available to the user to perform some other
transaction - like paying for an online order or an in-store purchase -
each prepaid transaction can be thought of as an enabler for an associated transaction.

### Parameters

`limit` -
* Limit

`offset` -
* Offset

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun getWalletTransactions(limit: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, offset: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`TransactionsResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-transactions-response/index.md)`>`

Overrides [UserService.getWalletTransactions](../-user-service/get-wallet-transactions.md)

This endpoint returns a list of prepaid transactions associated with the user.
Each of the transactions contains some basic information about the context of the transaction.
Since the white-label prepaid wallet instrument is available to the user to perform some other
transaction - like paying for an online order or an in-store purchase -
each prepaid transaction can be thought of as an enabler for an associated transaction.

### Parameters

`limit` -
* Limit

`offset` -
* Offset

**Return**
Observable - the result of the network request is returned as an Observable

