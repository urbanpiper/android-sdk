[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [GeneralServiceDefault](./index.md)

# GeneralServiceDefault

`class GeneralServiceDefault : `[`GeneralService`](../-general-service/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `GeneralServiceDefault(bizId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, retrofit: Retrofit)` |

### Functions

| Name | Summary |
|---|---|
| [checkAppVersion](check-app-version.md) | `fun checkAppVersion(username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, version: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`VersionCheckResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-version-check-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)<br>`fun checkAppVersion(username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, version: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`VersionCheckResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-version-check-response/index.md)`>`<br>returns the latest version of the android app as configured on the server |
| [getAllStores](get-all-stores.md) | `fun getAllStores(callback: `[`Callback`](../-callback/index.md)`<`[`StoreListResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-store-list-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)<br>`fun getAllStores(): Observable<`[`StoreListResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-store-list-response/index.md)`>`<br>Returns all the stores for the business |
| [getNearestStore](get-nearest-store.md) | `fun getNearestStore(lat: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, lng: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`StoreResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-store-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)<br>`fun getNearestStore(lat: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, lng: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): Observable<`[`StoreResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-store-response/index.md)`>`<br>Returns the nearest store based on lat/ lng |
| [registerFCMToken](register-f-c-m-token.md) | `fun registerFCMToken(token: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, deviceId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`Void`](https://developer.android.com/reference/java/lang/Void.html)`>): `[`CancellableTask`](../-cancellable-task/index.md)<br>`fun registerFCMToken(token: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, deviceId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`Void`](https://developer.android.com/reference/java/lang/Void.html)`>`<br>Register the device for FCM |
