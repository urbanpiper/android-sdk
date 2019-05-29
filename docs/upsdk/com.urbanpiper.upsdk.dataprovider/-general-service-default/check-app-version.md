[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [GeneralServiceDefault](index.md) / [checkAppVersion](./check-app-version.md)

# checkAppVersion

`fun checkAppVersion(username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, version: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`VersionCheckResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-version-check-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [GeneralService.checkAppVersion](../-general-service/check-app-version.md)

returns the latest version of the android app as configured on the server

This can be used to force update the application. The response has a field that shows if force update
is required. This method should be called when the app is opened and after the user sign's in.

### Parameters

`username` -
* username of the user

`version` -
* version of the application

`callback` -
* Callback to receive the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun checkAppVersion(username: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, version: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`VersionCheckResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-version-check-response/index.md)`>`

Overrides [GeneralService.checkAppVersion](../-general-service/check-app-version.md)

returns the latest version of the android app as configured on the server

This can be used to force update the application. The response has a field that shows if force update
is required. This method should be called when the app is opened and after the user sign's in.

### Parameters

`username` -
* username of the user

`version` -
* version of the application

**Return**
Observable - the result of the network request is returned as an Observable

