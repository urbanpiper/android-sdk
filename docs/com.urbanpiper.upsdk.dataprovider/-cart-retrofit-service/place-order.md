[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CartRetrofitService](index.md) / [placeOrder](./place-order.md)

# placeOrder

`@POST("/api/v1/order/") abstract fun placeOrder(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("biz_id") bizId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Body order: `[`Order`](../../com.urbanpiper.upsdk.model/-order/index.md)`): Observable<`[`OrderSaveResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-order-save-response/index.md)`>`

Sends the order details to the server for persistence.

### Parameters

`order` -
* Order object

`bizId` -
* biz Id

`authToken` -
* Auth token
