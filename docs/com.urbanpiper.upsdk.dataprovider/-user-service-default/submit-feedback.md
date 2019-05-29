[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserServiceDefault](index.md) / [submitFeedback](./submit-feedback.md)

# submitFeedback

`fun submitFeedback(feedback: `[`UserFeedback`](../../com.urbanpiper.upsdk.model.networkresponse/-user-feedback/index.md)`, callback: `[`Callback`](../-callback/index.md)`<`[`SimpleResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-simple-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [UserService.submitFeedback](../-user-service/submit-feedback.md)

this method submits user feedback

### Parameters

`feedback` -
* feedback object

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun submitFeedback(feedback: `[`UserFeedback`](../../com.urbanpiper.upsdk.model.networkresponse/-user-feedback/index.md)`): Observable<`[`SimpleResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-simple-response/index.md)`>`

Overrides [UserService.submitFeedback](../-user-service/submit-feedback.md)

this method submits user feedback

### Parameters

`feedback` -
* feedback object

`feedback` -

**Return**
Observable - the result of the network request is returned as an Observable

