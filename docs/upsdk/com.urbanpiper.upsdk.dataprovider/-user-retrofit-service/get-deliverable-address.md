[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserRetrofitService](index.md) / [getDeliverableAddress](./get-deliverable-address.md)

# getDeliverableAddress

`@GET("/api/v1/user/address/") abstract fun getDeliverableAddress(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("location_id") locationId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`DeliverableAddressResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-deliverable-address-response/index.md)`>`

Gets a list of addresses for the user. Each address has a field deliverable which
will be true/false based on the current location id.

### Parameters

`authToken` -
* It is logged in user auth

`location` -
* Location id of the store
