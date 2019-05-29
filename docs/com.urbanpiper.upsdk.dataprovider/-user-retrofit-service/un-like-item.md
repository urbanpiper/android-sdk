[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserRetrofitService](index.md) / [unLikeItem](./un-like-item.md)

# unLikeItem

`@DELETE("/api/v1/user/item/{item_id}/like/") abstract fun unLikeItem(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Path("item_id") itemId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`Like`](../../com.urbanpiper.upsdk.model.networkresponse/-like/index.md)`>`

Unlike the item.

### Parameters

`authToken` - 