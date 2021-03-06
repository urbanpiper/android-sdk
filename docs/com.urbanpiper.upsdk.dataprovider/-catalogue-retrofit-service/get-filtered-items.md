[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CatalogueRetrofitService](index.md) / [getFilteredItems](./get-filtered-items.md)

# getFilteredItems

`@GET("/api/v1/order/categories/{category_id}/items/") abstract fun getFilteredItems(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Path("category_id") categoryId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, @Query("location_id") locationId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("filter_by") filterBy: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("biz_id") bizId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("offset") offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, @Query("limit") limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`CategoryItemResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-category-item-response/index.md)`>`

Retrieves the list of items available under a particular category with filters applied.

### Parameters

`categoryId` -

`bizId` -

`locationId` -

`filterBy` -

`offset` -

`limit` -

`authToken` - 