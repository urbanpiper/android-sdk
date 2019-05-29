[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserRetrofitService](index.md) / [getUserLikes](./get-user-likes.md)

# getUserLikes

`@GET("/api/v1/user/item/likes/") abstract fun getUserLikes(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("item_ids") ids: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`UserLikesResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-user-likes-response/index.md)`>`

For getting list of likes

### Parameters

`authToken` - 