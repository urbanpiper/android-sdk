[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [GeneralService](./index.md)

# GeneralService

`interface GeneralService`

### Functions

| Name | Summary |
|---|---|
| [checkAppVersion](check-app-version.md) | `abstract fun checkAppVersion(username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, version: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`VersionCheckResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-version-check-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)<br>`abstract fun checkAppVersion(username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, version: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`VersionCheckResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-version-check-response/index.md)`>`<br>returns the latest version of the android app as configured on the server |
| [getAllStores](get-all-stores.md) | `abstract fun getAllStores(callback: `[`Callback`](../-callback/index.md)`<`[`StoreListResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-store-list-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)<br>`abstract fun getAllStores(): Observable<`[`StoreListResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-store-list-response/index.md)`>`<br>Returns all the stores for the business |
| [getNearestStore](get-nearest-store.md) | `abstract fun getNearestStore(lat: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, lng: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`StoreResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-store-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)<br>`abstract fun getNearestStore(lat: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, lng: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): Observable<`[`StoreResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-store-response/index.md)`>`<br>Returns the nearest store based on lat/ lng |
| [registerFCMToken](register-f-c-m-token.md) | `abstract fun registerFCMToken(token: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, deviceId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`Void`](https://developer.android.com/reference/java/lang/Void.html)`>): `[`CancellableTask`](../-cancellable-task/index.md)<br>`abstract fun registerFCMToken(token: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, deviceId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`Void`](https://developer.android.com/reference/java/lang/Void.html)`>`<br>Register the device for FCM |

### Inheritors

| Name | Summary |
|---|---|
| [GeneralServiceDefault](../-general-service-default/index.md) | `class GeneralServiceDefault : `[`GeneralService`](./index.md) |
| [UPClient](../-u-p-client/index.md) | `interface UPClient : `[`GeneralService`](./index.md)`, `[`CatalogueService`](../-catalogue-service/index.md)`, `[`UserService`](../-user-service/index.md)`, `[`PromotionsService`](../-promotions-service/index.md)`, `[`CartService`](../-cart-service/index.md) |
