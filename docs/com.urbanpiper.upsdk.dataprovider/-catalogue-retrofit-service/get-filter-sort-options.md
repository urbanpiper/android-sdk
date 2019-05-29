[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CatalogueRetrofitService](index.md) / [getFilterSortOptions](./get-filter-sort-options.md)

# getFilterSortOptions

`@GET("/api/v2/categories/{category_id}/options/") abstract fun getFilterSortOptions(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Path("category_id") categoryId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`FilterAndSortOptionsResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-filter-and-sort-options-response/index.md)`>`

Get the filter and sort options for a particular category

### Parameters

`categoryId` -
* Id of the category

`authToken` -
* Auth token
