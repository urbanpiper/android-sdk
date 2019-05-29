[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CartRepository](./index.md)

# CartRepository

`class CartRepository`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CartRepository(cartDao: `[`CartDao`](../-cart-dao/index.md)`)` |

### Functions

| Name | Summary |
|---|---|
| [clearCart](clear-cart.md) | `suspend fun clearCart(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>This method deletes all the items in the cart |
| [delete](delete.md) | `suspend fun delete(cartItem: `[`CartItem`](../../com.urbanpiper.upsdk.model.networkresponse/-cart-item/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>This method deletes an item from the cart |
| [getAllCartItems](get-all-cart-items.md) | `fun getAllCartItems(): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CartItem`](../../com.urbanpiper.upsdk.model.networkresponse/-cart-item/index.md)`>>`<br>This method returns a list of all cart items |
| [getAllItemsForId](get-all-items-for-id.md) | `fun getAllItemsForId(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CartItem`](../../com.urbanpiper.upsdk.model.networkresponse/-cart-item/index.md)`>>`<br>Returns a list of all items based on the id |
| [getAllItemsObservable](get-all-items-observable.md) | `fun getAllItemsObservable(): Observable<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CartItem`](../../com.urbanpiper.upsdk.model.networkresponse/-cart-item/index.md)`>>`<br>Returns a list of all the items as an observable |
| [insert](insert.md) | `suspend fun insert(cartItem: `[`CartItem`](../../com.urbanpiper.upsdk.model.networkresponse/-cart-item/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>This method inserts a cart item into the database |
| [update](update.md) | `suspend fun update(cartItem: `[`CartItem`](../../com.urbanpiper.upsdk.model.networkresponse/-cart-item/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>This method updates the existing cart item in the database |
