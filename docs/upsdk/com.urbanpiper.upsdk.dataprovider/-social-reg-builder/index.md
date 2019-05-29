[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [SocialRegBuilder](./index.md)

# SocialRegBuilder

`class SocialRegBuilder`

A helper class that contains the related api's to register a social login user.
The api's have to be called in the following order.

`verifyPhone(...)`, function to verify the phone number provided by an unregistered social login user,
sends an OTP to the phone number passed on success, if the message variable is "new_registration_required"
the user has be registered using the `registerSocialUser(...)`, call, else the user's phone number is already
present in the system and the phone number needs to be verified by the `verifySocialOTP(...)`, call

* `registerSocialUser(...)`, function to register a new social login user if the message variable in verifyPhone
response is "new_registration_required"

* `verifyRegOTP(...)`, function to verify the phone number passed in by the user if the message variable in
verifyPhone response is "new_registration_required"

* `resendRegOTP(...)`, function to resend a new otp to the user's phone number passed in by the user
if the message variable in verifyPhone response is "new_registration_required"

* `verifySocialOTP(...)`, function to verify the phone number passed in by the user if the message
variable in verifyPhone response is not "new_registration_required"

* `resendSocialOTP(...)`, function to resend a new otp to the user's phone number passed in by the user
if the message variable in verifyPhone response is not "new_registration_required"

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SocialRegBuilder(userServiceDefault: `[`UserServiceDefault`](../-user-service-default/index.md)`)`<br>A helper class that contains the related api's to register a social login user. The api's have to be called in the following order. |

### Properties

| Name | Summary |
|---|---|
| [response1](response1.md) | `var response1: `[`SocialAuthResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-social-auth-response/index.md)`?` |
| [response2](response2.md) | `var response2: `[`SocialAuthResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-social-auth-response/index.md)`?` |

### Functions

| Name | Summary |
|---|---|
| [createSocialUser](create-social-user.md) | `fun createSocialUser(phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`RegistrationResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-registration-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)<br>Create a new user`fun createSocialUser(phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`RegistrationResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-registration-response/index.md)`>`<br>create a new user |
| [resendRegOTP](resend-reg-o-t-p.md) | `fun resendRegOTP(phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`RegistrationResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-registration-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)<br>This method is used ot resend the OTP`fun resendRegOTP(phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`RegistrationResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-registration-response/index.md)`>`<br>This method is used to resend the OTP |
| [resendSocialOtp](resend-social-otp.md) | `fun resendSocialOtp(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, provider: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, accessToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`SocialAuthResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-social-auth-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)<br>`fun resendSocialOtp(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, provider: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, accessToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`SocialAuthResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-social-auth-response/index.md)`>`<br>Resend Social OTP |
| [verifyPhone](verify-phone.md) | `fun verifyPhone(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, provider: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, accessToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`SocialAuthResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-social-auth-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)<br>`fun verifyPhone(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, provider: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, accessToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`SocialAuthResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-social-auth-response/index.md)`>`<br>Check if phone number is present in the server. It will also send an OTP if the user is present in the server, or you will have to create a new user |
| [verifyRegOTP](verify-reg-o-t-p.md) | `fun verifyRegOTP(phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, otp: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`RegistrationResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-registration-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)<br>verify OTP`fun verifyRegOTP(phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, otp: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`RegistrationResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-registration-response/index.md)`>`<br>Verify OTP |
| [verifySocialOTP](verify-social-o-t-p.md) | `fun verifySocialOTP(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, provider: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, accessToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, action: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, otp: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`SocialAuthResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-social-auth-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)<br>Resend Social login OTP`fun verifySocialOTP(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, provider: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, accessToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, action: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, otp: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`SocialAuthResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-social-auth-response/index.md)`>`<br>Verifies Social Login OTP |
