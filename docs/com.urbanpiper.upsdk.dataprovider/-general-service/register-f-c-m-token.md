[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [GeneralService](index.md) / [registerFCMToken](./register-f-c-m-token.md)

# registerFCMToken

`abstract fun registerFCMToken(token: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, deviceId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`Void`](https://developer.android.com/reference/java/lang/Void.html)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Register the device for FCM

This can be used to force update the application. The response has a field that shows if force update
is required. This method should be called when the app is opened and after the user sign's in.

### Parameters

`token` -
* FCM registration token

`deviceId` -
* The unique id of the device

`callback` -
* Callback to receive the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`abstract fun registerFCMToken(token: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, deviceId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`Void`](https://developer.android.com/reference/java/lang/Void.html)`>`

Register the device for FCM

This method registers a device to receive FCM messages, This should be called when the app
is launched and after the user sign's in to the app

### Parameters

`token` -
* FCM registration token

`deviceId` -
* The unique id of the device

**Return**
Observable - the result of the network request is returned as an Observable

