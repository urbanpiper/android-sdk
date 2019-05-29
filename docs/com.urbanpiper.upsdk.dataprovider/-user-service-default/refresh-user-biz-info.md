[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserServiceDefault](index.md) / [refreshUserBizInfo](./refresh-user-biz-info.md)

# refreshUserBizInfo

`fun refreshUserBizInfo(callback: `[`Callback`](../-callback/index.md)`<`[`UserBizInfoResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-user-biz-info-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [UserService.refreshUserBizInfo](../-user-service/refresh-user-biz-info.md)

Returns the profile data associated with a particular user identified by his/her phone number.

### Parameters

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun refreshUserBizInfo(): Observable<`[`UserBizInfoResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-user-biz-info-response/index.md)`>`

Overrides [UserService.refreshUserBizInfo](../-user-service/refresh-user-biz-info.md)

Returns the profile data associated with a particular user identified by his/her phone number.

**Return**
Observable - the result of the network request is returned as an Observable

