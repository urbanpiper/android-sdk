[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [GeneralRetrofitService](index.md) / [appVersionCheck](./app-version-check.md)

# appVersionCheck

`@GET("/api/v1/app/android/") abstract fun appVersionCheck(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("biz_id") bizId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("user") username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("ver") version: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`VersionCheckResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-version-check-response/index.md)`>`

Determines the latest version of the android app
as configured on the server.

