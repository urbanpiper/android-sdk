[upsdk](../index.md) / [com.urbanpiper.upsdk.dataprovider](./index.md)

## Package com.urbanpiper.upsdk.dataprovider

### Types

| Name | Summary |
|---|---|
| [Callback](-callback/index.md) | `interface Callback<T>`<br>This callback returns the response from a network call |
| [CancellableTask](-cancellable-task/index.md) | `interface CancellableTask`<br>Interface is used to help with cancelling a network request made with retrofit |
| [CancellableTaskDisposableWrapper](-cancellable-task-disposable-wrapper/index.md) | `class CancellableTaskDisposableWrapper : `[`CancellableTask`](-cancellable-task/index.md)<br>Helper method to cancel network requests |
| [Cart](-cart/index.md) | `object Cart` |
| [CartDao](-cart-dao/index.md) | `interface CartDao` |
| [CartOld](-cart-old/index.md) | `class CartOld`<br>This class contains the implementation of the cart |
| [CartRepository](-cart-repository/index.md) | `class CartRepository` |
| [CartRetrofitService](-cart-retrofit-service/index.md) | `interface CartRetrofitService`<br>A list of retrofit endpoints related to cart operations |
| [CartRoomDatabase](-cart-room-database/index.md) | `abstract class CartRoomDatabase : RoomDatabase` |
| [CartService](-cart-service/index.md) | `interface CartService`<br>List of methods related to cart |
| [CartServiceDefault](-cart-service-default/index.md) | `class CartServiceDefault : `[`CartService`](-cart-service/index.md) |
| [CartTracker](-cart-tracker/index.md) | `interface CartTracker`<br>Helper method for the cart implementation |
| [CatalogueRetrofitService](-catalogue-retrofit-service/index.md) | `interface CatalogueRetrofitService`<br>List of catalogue related retrofit calls |
| [CatalogueService](-catalogue-service/index.md) | `interface CatalogueService`<br>List of methods related to the catalogue |
| [CatalogueServiceDefault](-catalogue-service-default/index.md) | `class CatalogueServiceDefault : `[`CatalogueService`](-catalogue-service/index.md) |
| [CheckoutBuilder](-checkout-builder/index.md) | `class CheckoutBuilder` |
| [GeneralRetrofitService](-general-retrofit-service/index.md) | `interface GeneralRetrofitService`<br>Defines the general interactions to be made with the server |
| [GeneralService](-general-service/index.md) | `interface GeneralService` |
| [GeneralServiceDefault](-general-service-default/index.md) | `class GeneralServiceDefault : `[`GeneralService`](-general-service/index.md) |
| [ItemOptionBuilder](-item-option-builder/index.md) | `class ItemOptionBuilder` |
| [PromotionsRetrofitService](-promotions-retrofit-service/index.md) | `interface PromotionsRetrofitService` |
| [PromotionsService](-promotions-service/index.md) | `interface PromotionsService` |
| [PromotionsServiceDefault](-promotions-service-default/index.md) | `class PromotionsServiceDefault : `[`PromotionsService`](-promotions-service/index.md) |
| [RegistrationBuilder](-registration-builder/index.md) | `class RegistrationBuilder`<br>Registration builder |
| [ResetPasswordBuilder](-reset-password-builder/index.md) | `class ResetPasswordBuilder` |
| [SharedPrefManager](-shared-pref-manager/index.md) | `object SharedPrefManager` |
| [SocialRegBuilder](-social-reg-builder/index.md) | `class SocialRegBuilder`<br>A helper class that contains the related api's to register a social login user. The api's have to be called in the following order. |
| [UPClient](-u-p-client/index.md) | `interface UPClient : `[`GeneralService`](-general-service/index.md)`, `[`CatalogueService`](-catalogue-service/index.md)`, `[`UserService`](-user-service/index.md)`, `[`PromotionsService`](-promotions-service/index.md)`, `[`CartService`](-cart-service/index.md) |
| [UPClientBuilder](-u-p-client-builder/index.md) | `class UPClientBuilder`<br>Written in java for now <br> It would be easier to create the UPClient object if the builder was written in java for third party dev's who might use java to build the android application |
| [UPClientDefault](-u-p-client-default/index.md) | `class UPClientDefault : `[`UPClient`](-u-p-client/index.md)<br>All methods for the UPSDK are available through this class. |
| [UpClientError](-up-client-error/index.md) | `class UpClientError`<br>This class returns network errors |
| [UpInitContentProvider](-up-init-content-provider/index.md) | `class UpInitContentProvider : `[`ContentProvider`](https://developer.android.com/reference/android/content/ContentProvider.html)<br>This is an internal class used to init parts of the SDK |
| [UserRetrofitService](-user-retrofit-service/index.md) | `interface UserRetrofitService` |
| [UserService](-user-service/index.md) | `interface UserService` |
| [UserServiceDefault](-user-service-default/index.md) | `class UserServiceDefault : `[`UserService`](-user-service/index.md) |
