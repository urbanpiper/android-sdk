[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserRetrofitService](index.md) / [verifyOTP](./verify-o-t-p.md)

# verifyOTP

`@POST("/api/v2/card/?nopinsend=true") abstract fun verifyOTP(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Body body: `[`VerifyOTPBody`](../../com.urbanpiper.upsdk.model/-verify-o-t-p-body/index.md)`): Observable<`[`RegistrationResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-registration-response/index.md)`>`

Verify OTP after sign-in up with OTP

### Parameters

`authToken` -
* Auth Token

`body` -
* Object of verify OTP body
