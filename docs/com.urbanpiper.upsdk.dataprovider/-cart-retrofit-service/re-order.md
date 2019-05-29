[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CartRetrofitService](index.md) / [reOrder](./re-order.md)

# reOrder

`@GET("/api/v2/order/{id}/reorder/") abstract fun reOrder(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Path("id") orderID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("location_id") location_id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("lat") lat: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("lng") lng: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`ReOrderResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-re-order-response/index.md)`>`

re-order api

### Parameters

`authToken` -
* Authorization token

`orderID` -
* Order id

`lat` -
* latitude

`lng` -
* longitude

`location_id` -
* id of the location(store)
