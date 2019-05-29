[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CartDao](./index.md)

# CartDao

`interface CartDao`

### Functions

| Name | Summary |
|---|---|
| [clearCart](clear-cart.md) | `abstract fun clearCart(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Deletes all items in the cart |
| [delete](delete.md) | `abstract fun delete(cartItem: `[`CartItem`](../../com.urbanpiper.upsdk.model.networkresponse/-cart-item/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Delete an item from the cart |
| [getAllItems](get-all-items.md) | `abstract fun getAllItems(): LiveData<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CartItem`](../../com.urbanpiper.upsdk.model.networkresponse/-cart-item/index.md)`>>`<br>Returns all the cart items |
| [getAllItemsById](get-all-items-by-id.md) | `abstract fun getAllItemsById(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CartItem`](../../com.urbanpiper.upsdk.model.networkresponse/-cart-item/index.md)`>>`<br>Returns all the cart items based on the id |
| [getAllItemsObservable](get-all-items-observable.md) | `abstract fun getAllItemsObservable(): Observable<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CartItem`](../../com.urbanpiper.upsdk.model.networkresponse/-cart-item/index.md)`>>`<br>Returns all the cart items in the form of an observable |
| [insert](insert.md) | `abstract fun insert(cartItem: `[`CartItem`](../../com.urbanpiper.upsdk.model.networkresponse/-cart-item/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Updates an item in the table |
| [update](update.md) | `abstract fun update(cartItem: `[`CartItem`](../../com.urbanpiper.upsdk.model.networkresponse/-cart-item/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Updates an item in the table |
