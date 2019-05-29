[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CatalogueRetrofitService](index.md) / [getCategories](./get-categories.md)

# getCategories

`@GET("/api/v1/order/categories/") abstract fun getCategories(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Header("cache-control") cacheControl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "no-cache", @Query("biz_id") bizId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("location_id") locationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`CategoriesResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-categories-response/index.md)`>`

Retrieves all the available categories available for
ordering.

### Parameters

`bizId` -
* Id of biz id

`locationId` -
* Optional. If present, categories for that location would be fetched.

`authToken` -
* Auth token

`cacheControl` -
* pass null if caching is ok, else, pass "no-cache".
