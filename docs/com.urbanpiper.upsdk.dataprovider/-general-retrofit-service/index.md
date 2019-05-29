[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [GeneralRetrofitService](./index.md)

# GeneralRetrofitService

`interface GeneralRetrofitService`

Defines the general interactions to be made with the server

### Functions

| Name | Summary |
|---|---|
| [appVersionCheck](app-version-check.md) | `abstract fun appVersionCheck(authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, bizId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, version: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`VersionCheckResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-version-check-response/index.md)`>`<br>Determines the latest version of the android app as configured on the server. |
| [getAllStores](get-all-stores.md) | `abstract fun getAllStores(authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`StoreListResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-store-list-response/index.md)`>`<br>Returns a list of all the stores |
| [getNearestStore](get-nearest-store.md) | `abstract fun getNearestStore(authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, latitude: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, longitude: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, bizId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`StoreResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-store-response/index.md)`>`<br>Returns the nearest store for the latitude and longitude |
| [registerDeviceForFCM](register-device-for-f-c-m.md) | `abstract fun registerDeviceForFCM(fcmRegistrationBody: `[`FCMRegistrationBody`](../../com.urbanpiper.upsdk.model/-f-c-m-registration-body/index.md)`, authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`Void`](https://developer.android.com/reference/java/lang/Void.html)`>`<br>Registers device for fcm |
