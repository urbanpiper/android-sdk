[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CatalogueRetrofitService](index.md) / [getItemDetails](./get-item-details.md)

# getItemDetails

`@GET("/api/v1/items/{item_id}/") abstract fun getItemDetails(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Path("item_id") itemId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, @Query("location_id") locationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`ItemDetailsResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-item-details-response/index.md)`>`

Retrieves the item details for item.

### Parameters

`itemId` - 