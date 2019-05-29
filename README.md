Welcome to the urban piper android-sdk wiki!

# Android SDK for UP

## Basic Setup

The Urban piper android SDK is written in Kotlin and it is fully interoperable in java.

### How it works

The urban piper SDK is built so that third party developers can build native android applications for online ordering with the urbanpiper platform.

### Add the dependency

This will be written later, as we have not hosted the project anywhere

### Initialisation

The SDK should be initialised inside the extended application class. 

The ```UPClientBuilder``` must be used to create an object of the type ```UPClient```

The required parameters are,

```bizId```, `ApiUsername`, `Apikey` can be obtained by contacting the technical team at support@urbanpiper.com

| Params  | Description |
| ------------- | ------------- |
| BizId | Business id of the merchant for whom the app is being built |
| ApiUsername  | API username used internally in the SDK to connect to the backend |
| ApiKey | API key used internally in the SDK to connect to the backend |
| Callback | callback of type UserBizInfoResponse. If the user is logged in it returns a user info, otherwise it returns an error.    |
| Language | This is an optional field. The default language is set the ```en```. Other languages can be configured (eg. ```hi```)    |

#### Example 

#### Init SDK in kotlin

```kotlin
 val upClient = UPClientBuilder()
            .setBizId("76230224")
            .setApiUsername("biz_adm_clients_yj1234QzHqYM")
            .setApiKey("5ee66ab0ec691963ebe2e9485ae0fdfe897d8fa8")
            .setLanguage("en") // Optional - The default language is english
            .setCallback(object : Callback<UserBizInfoResponse> {
                override fun success(response: UserBizInfoResponse) {
                    Log.d("Myapp", "Success Response " + response.toString())
                }

                override fun failure(upClientError: UpClientError) {
                    upClientError.getResponseCode()
                    Log.e("Myapp", "Failure response " + upClientError.getResponseCode())
                }
            })
            .build()
```

#### Init SDK in java

```java 
  UPClient upClient = new UPClientBuilder()
          .setBizId("76230224")
          .setApiUsername("biz_adm_clients_yj1234QzHqYM")
          .setApiKey("5ee66ab0ec691963ebe2e9485ae0fdfe897d8fa8")
          .setLanguage("en") // Optional - The default language is english
          .setCallback(new Callback<UserBizInfoResponse>() {
              @Override
              public void success(UserBizInfoResponse response) {
                   Log.d("Myapp", "Success Response " + response.toString())
              }

              @Override
              public void failure(@NotNull UpClientError upClientError) {
                  Log.e("Myapp", "Failure response " + upClientError.getResponseCode())
              }
          });
```

_**From here on all examples will be written in kotlin with its RXJava implementation.**_

### Usage

All the methods are available through ```UPClient``` object after init.

Each method can be called in two different ways,

**1** - The result is returned as a callback which is passed in as a param.
This method returns an CancellableTask using which the task can be cancelled by calling ```cancellableTask.cancel()```. 

```Callback<T>``` is a custom callback class in the SDK that is used to return the result of the network request.

```UPClientError``` is a custom class that returns the errors, if the network request failed.

Eg: 

```kotlin
upClient.getBanners(object: Callback<BannerResponse>) {
      override fun success(response: BannerResponse) {
         // Returns successful response       
      }

      override fun failure(upClientError: UpClientError) {
         // Returns failure response. The failure response is a custom class in the SDK called UpClientError       
      }
})  
```

**2** - This method returns an RXJava observable through which the result of the network response can be observed.

Eg: 
```kotlin
upclient.getBanners(): Observable<BannerResponse>
```
The class documentation is listed below.
https://urbanpiper.github.io/android-sdk/

For a list of all possible methods,
https://urbanpiper.github.io/android-sdk/com.urbanpiper.upsdk.dataprovider/-u-p-client-default/
