[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserRetrofitService](index.md) / [getWalletTransactions](./get-wallet-transactions.md)

# getWalletTransactions

`@GET("/api/v2/ub/wallet/transactions/") abstract fun getWalletTransactions(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("limit") limit: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("offset") offset: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`TransactionsResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-transactions-response/index.md)`>`

Returns wallet transaction's of the user

### Parameters

`authToken` -
*

`limit` -
*

`offset` -
*
