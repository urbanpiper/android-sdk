[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [GeneralRetrofitService](index.md) / [getNearestStore](./get-nearest-store.md)

# getNearestStore

`@GET("/api/v1/stores/") abstract fun getNearestStore(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("lat") latitude: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, @Query("lng") longitude: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, @Query("biz_id") bizId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`StoreResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-store-response/index.md)`>`

Returns the nearest store for the latitude and longitude

### Parameters

`authToken` -
* Authorization token, login not needed

`latitude` -
* User's latitude

`longitude` -
* User's longitude
