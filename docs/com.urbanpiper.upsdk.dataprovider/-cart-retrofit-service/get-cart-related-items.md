[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CartRetrofitService](index.md) / [getCartRelatedItems](./get-cart-related-items.md)

# getCartRelatedItems

`@GET("/api/v2/items/{item_id}/recommendations/") abstract fun getCartRelatedItems(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Path("item_id") itemId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("location_id") locationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`RecommendedItemResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-recommended-item-response/index.md)`>`

Get the recommended items from the server. The items returned are based on a particular item
in details or checkout page.

### Parameters

`itemId` -
* Comma separated item id's or single item.

`locationId` -
* Id of the nearest store

`authToken` -
* Auth token
