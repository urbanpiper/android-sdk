[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserRetrofitService](index.md) / [createUser](./create-user.md)

# createUser

`@POST("/api/v2/card/") abstract fun createUser(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("customer_phone") customerPhone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("email") email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("password") password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("customer_name") customerName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("channel") channel: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Body body: `[`AccountRegistrationBody`](../../com.urbanpiper.upsdk.model.networkresponse/-account-registration-body/index.md)`?): Observable<`[`RegistrationResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-registration-response/index.md)`>`

For creating a new user account.

### Parameters

`authToken` -
* Auth token

`customerPhone` -
* phone

`email` -
* email

`password` -
* password

`customerName` -
* name

`channel` -
* channel = app_android
