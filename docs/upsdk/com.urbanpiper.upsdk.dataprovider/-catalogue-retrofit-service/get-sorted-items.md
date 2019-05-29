[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CatalogueRetrofitService](index.md) / [getSortedItems](./get-sorted-items.md)

# getSortedItems

`@GET("/api/v1/order/categories/{category_id}/items/") abstract fun getSortedItems(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Path("category_id") categoryId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, @Query("location_id") locationId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("sort_by") sortBy: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("biz_id") bizId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("offset") offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, @Query("limit") limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`CategoryItemResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-category-item-response/index.md)`>`

Retrieves a list of items sorted by the sort option selected

### Parameters

`categoryId` -

`bizId` -

`locationId` -

`sortBy` -

`offset` -

`limit` -

`authToken` - 