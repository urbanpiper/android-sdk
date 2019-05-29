[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserRetrofitService](index.md) / [likeItem](./like-item.md)

# likeItem

`@POST("/api/v1/user/item/{item_id}/like/") abstract fun likeItem(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Path("item_id") itemId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, @Body blank: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`Like`](../../com.urbanpiper.upsdk.model.networkresponse/-like/index.md)`>`

Like item.
Retrofit will throw you error if you send post request without Body.

### Parameters

`authToken` - 