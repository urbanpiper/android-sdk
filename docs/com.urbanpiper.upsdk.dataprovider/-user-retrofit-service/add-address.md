[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserRetrofitService](index.md) / [addAddress](./add-address.md)

# addAddress

`@POST("/api/v1/user/address/?format=json") abstract fun addAddress(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Body body: `[`UserAddress`](../../com.urbanpiper.upsdk.model.networkresponse/-user-address/index.md)`): Observable<`[`UserAddressSaveResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-user-address-save-response/index.md)`>`

For saving a user's address for order delivery.

### Parameters

`authToken` - 