[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserService](index.md) / [getNotifications](./get-notifications.md)

# getNotifications

`abstract fun getNotifications(callback: `[`Callback`](../-callback/index.md)`<`[`UserBizNotificationsResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-user-biz-notifications-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

This method returns a list of all the notifications that was sent to that user

### Parameters

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`abstract fun getNotifications(): Observable<`[`UserBizNotificationsResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-user-biz-notifications-response/index.md)`>`

This method returns a list of all the notifications that was sent to that user

**Return**
Observable - the result of the network request is returned as an Observable

