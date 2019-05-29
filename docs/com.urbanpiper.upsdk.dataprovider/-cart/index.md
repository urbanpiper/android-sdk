[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [Cart](./index.md)

# Cart

`object Cart`

### Functions

| Name | Summary |
|---|---|
| [addItem](add-item.md) | `fun addItem(cartItem: `[`CartItem`](../../com.urbanpiper.upsdk.model.networkresponse/-cart-item/index.md)`): Job`<br>Add an item into the cart |
| [clearCart](clear-cart.md) | `fun clearCart(): Job`<br>Clear the cart |
| [getAllItemsById](get-all-items-by-id.md) | `fun getAllItemsById(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CartItem`](../../com.urbanpiper.upsdk.model.networkresponse/-cart-item/index.md)`>>`<br>Get all the items by id |
| [getAllItemsLiveData](get-all-items-live-data.md) | `fun getAllItemsLiveData(): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CartItem`](../../com.urbanpiper.upsdk.model.networkresponse/-cart-item/index.md)`>>`<br>Get all the items using a live data observable |
| [getAllItemsObservable](get-all-items-observable.md) | `fun getAllItemsObservable(): Observable<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CartItem`](../../com.urbanpiper.upsdk.model.networkresponse/-cart-item/index.md)`>>`<br>Get all the cart items |
| [getCartValue](get-cart-value.md) | `fun getCartValue(): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>Get the total cart value |
| [getInstance](get-instance.md) | `fun getInstance(locationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Cart`](./index.md)<br>Returns an instance of the cart |
| [getItemCountForId](get-item-count-for-id.md) | `fun getItemCountForId(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Get the item count for id |
| [getTotalItemsInCart](get-total-items-in-cart.md) | `fun getTotalItemsInCart(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Get all the items in the cart |
| [init](init.md) | `fun init(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Initializes the database. This is called from the UpInitContentProvider |
| [removeItem](remove-item.md) | `fun removeItem(cartItem: `[`CartItem`](../../com.urbanpiper.upsdk.model.networkresponse/-cart-item/index.md)`): Job`<br>Remove an item from the cart |
