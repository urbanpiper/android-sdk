[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserRetrofitService](index.md) / [updateUserInfo](./update-user-info.md)

# updateUserInfo

`@PUT("/api/v1/user/profile/") abstract fun updateUserInfo(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("customer_phone") phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Body body: `[`UpdateUserInfoBody`](../../com.urbanpiper.upsdk.model/-update-user-info-body/index.md)`): Observable<`[`UpdateUserInfoResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-update-user-info-response/index.md)`>`

Updates the user info

### Parameters

`authToken` -
* Authorization token

`phone` -
* Phone number

`body` -
* Object of type UserInfoUpdateBody
