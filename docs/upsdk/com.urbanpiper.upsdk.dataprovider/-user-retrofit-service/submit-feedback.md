[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserRetrofitService](index.md) / [submitFeedback](./submit-feedback.md)

# submitFeedback

`@POST("/api/v2/feedback/") abstract fun submitFeedback(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Body feedback: `[`UserFeedback`](../../com.urbanpiper.upsdk.model.networkresponse/-user-feedback/index.md)`): Observable<`[`SimpleResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-simple-response/index.md)`>`

For saving the feedback associated with an order.

### Parameters

`authToken` -

`feedback` - 