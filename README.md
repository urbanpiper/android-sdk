# Android SDK for UrbanPiper platform

Source-code for the Android SDK to be used for building custom apps on top of the UrbanPiper platform.

Welcome to the android-sdk wiki!

# Android SDK for UP

## Basic Setup

The Urban piper android SDK is written in kotlin and it is fully interoperable in java.

### Add the dependency

This will be written later, as we have not hosted the project anywhere

### Init

The SDK should be init inside the extended application class. 

The **UPClientBuilder** must be used to create an object of the type **UPClient**

The required parameters are
 - Biz id
- API username
- API key
- language
- Application context
- callback - It returns user info if user is signed in, or if the user session has expired it will return
a 401

Example 

Init SDK in kotlin

```kotlin
 upClient = UPClientBuilder()
            .setBizId("76720224")
            .setApiUserName("biz_adm_clients_yjXwAgQzHqYM")
            .setApiKey("5ee66ab0ec691963ebe2e9485ae0fdfe232d8fa8")
            .setLanguage("en")
            .setApplicationContext(this)
            .setCallback(object : Callback<UserBizInfoResponse> {
                override fun success(response: UserBizInfoResponse) {
                    Log.d("callback response", " $response")
                }

                override fun failure(upClientError: UpClientError) {
                    upClientError.getResponseCode()
                    Log.e("", " Failure response  ${upClientError.getResponseCode()}")
                }
            })
            .build()
```

Init SDK in java


```java
    UPClient client = new UPClientBuilder()
            .setBizId("")
            .setApiKey("")
            .setApiUserName("")
            .setApiKey("")
            .setLanguage("")
            .setApplicationContext(context)
            .setCallback(new Callback<UserBizInfoResponse>() {
                @Override
                public void success(UserBizInfoResponse response) {

                }

                @Override
                public void failure(@NotNull UpClientError upClientError) {

                }
            });
```
### Usage

All the methods are available through **UPClient** object after init.

There are two types of each method

1. The result is returned as a callback which is passed in as a param. This method returns a CancellableTask using which the task can be cancelled by calling ```.cancel()``` on the return value.


Eg: 
```kotlin
getBanners(callback: Callback<BannerResponse>): CancellableTask 
```
2. This method returns an RXJava observable through which the result of the network response can be observed.

Eg: 
```kotlin
upclient.getBanners(): Observable<BannerResponse>
```

_**From here on all examples will only show the RXJava implementation. But keep in mind, all methods have both types available for use.**_

_**Note: The callback is always passed as the last or in some cases the only argument in all the methods. **_






















