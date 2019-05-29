[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserRetrofitService](index.md) / [getPastOrderDetails](./get-past-order-details.md)

# getPastOrderDetails

`@GET("/api/v2/orders/{order_id}/") abstract fun getPastOrderDetails(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Path("order_id") orderId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`OrderDetailResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-order-detail-response/index.md)`>`

Fetches the summary data for orders placed in the past by a
user.

### Parameters

`authToken` - 