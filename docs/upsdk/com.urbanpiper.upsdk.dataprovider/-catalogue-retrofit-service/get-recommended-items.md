[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CatalogueRetrofitService](index.md) / [getRecommendedItems](./get-recommended-items.md)

# getRecommendedItems

`@GET("/api/v2/items/0/recommendations/") abstract fun getRecommendedItems(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("location_id") locationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`RecommendedItemResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-recommended-item-response/index.md)`>`

Get the featured items from the server

### Parameters

`locationId` -
* Id of the nearest store

`authToken` -
* Auth token
