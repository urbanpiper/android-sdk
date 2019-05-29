[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserRetrofitService](index.md) / [getPastOrders](./get-past-orders.md)

# getPastOrders

`@GET("/api/v2/orders/") abstract fun getPastOrders(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`OrderHistoryResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-order-history-response/index.md)`>`

Fetches the summary data for orders placed in the past by a
user.

### Parameters

`authToken` -
* Authorization token
