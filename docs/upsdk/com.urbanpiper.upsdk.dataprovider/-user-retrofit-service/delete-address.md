[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserRetrofitService](index.md) / [deleteAddress](./delete-address.md)

# deleteAddress

`@DELETE("/api/v1/user/address/{address_id}/") abstract fun deleteAddress(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Path("address_id") addressId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`UserAddressSaveResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-user-address-save-response/index.md)`>`

Deletes a previously stored user address.

### Parameters

`authToken` -

`addressId` - 