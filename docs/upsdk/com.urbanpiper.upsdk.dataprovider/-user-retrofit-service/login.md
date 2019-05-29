[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserRetrofitService](index.md) / [login](./login.md)

# login

`@POST("/api/v2/auth/token/") abstract fun login(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Body body: `[`JWTAuthLoginBody`](../../com.urbanpiper.upsdk.model/-j-w-t-auth-login-body/index.md)`): Observable<`[`AuthSuccessResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-auth-success-response/index.md)`>`

Observable to login with JWT authentication

### Parameters

`authToken` -
* Biz auth token

`body` -
* Pass the body auth retrofit
