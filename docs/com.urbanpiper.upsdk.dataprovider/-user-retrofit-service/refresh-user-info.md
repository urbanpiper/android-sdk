[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserRetrofitService](index.md) / [refreshUserInfo](./refresh-user-info.md)

# refreshUserInfo

`@GET("/api/v1/user/profile/") abstract fun refreshUserInfo(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("customer_phone") phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`UserInfoResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-user-info-response/index.md)`>`

Returns The user info

### Parameters

`authToken` -
* Authorization token

`phone` -
* Phone number
