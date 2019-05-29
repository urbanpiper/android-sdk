[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CartRetrofitService](index.md) / [validateCart](./validate-cart.md)

# validateCart

`@POST("/api/v1/order/") abstract fun validateCart(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("biz_id") bizId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("pre_proc") preProcessOutput: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, @Body order: `[`Order`](../../com.urbanpiper.upsdk.model/-order/index.md)`): Observable<`[`ValidateCartResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-validate-cart-response/index.md)`>`

Sends the order details to the server for pre-processing.

### Parameters

`order` -

`bizId` -

`preProcessOutput` -

`authToken` - 