[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CatalogueRetrofitService](index.md) / [searchItems](./search-items.md)

# searchItems

`@GET("/api/v2/search/items/") abstract fun searchItems(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("keyword") query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("location_id") location: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`CategorySearchResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-category-search-response/index.md)`>`

Retrieves order items based on search items
ordering.

### Parameters

`query` -

`authToken` - 