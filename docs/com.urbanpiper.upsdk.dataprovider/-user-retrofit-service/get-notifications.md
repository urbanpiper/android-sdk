[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserRetrofitService](index.md) / [getNotifications](./get-notifications.md)

# getNotifications

`@GET("/api/v1/ub/notifications/?channel__in=app_notification,all") abstract fun getNotifications(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`UserBizNotificationsResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-user-biz-notifications-response/index.md)`>`

Retrieves the list of notifications available for the user.

### Parameters

`authToken` - : only supports user-auth.