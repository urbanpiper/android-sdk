[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [GeneralRetrofitService](index.md) / [getAllStores](./get-all-stores.md)

# getAllStores

`@GET("/api/v1/stores/") abstract fun getAllStores(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`StoreListResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-store-list-response/index.md)`>`

Returns a list of all the stores

### Parameters

`authToken` -
* Authorization token, login not needed
