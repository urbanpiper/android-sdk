[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [SocialRegBuilder](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`SocialRegBuilder(userServiceDefault: `[`UserServiceDefault`](../-user-service-default/index.md)`)`

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
