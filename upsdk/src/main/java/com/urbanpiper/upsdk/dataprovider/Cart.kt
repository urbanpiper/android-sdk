package com.urbanpiper.upsdk.dataprovider

import android.content.Context
import androidx.lifecycle.LiveData
import com.urbanpiper.upsdk.model.networkresponse.CartItem
import io.reactivex.Observable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

object Cart {

    private lateinit var cartRepository: CartRepository

    private var parentJob = Job()

    private val coRoutineContext: CoroutineContext
        get() = parentJob + Dispatchers.IO

    private val scope = CoroutineScope(coRoutineContext)

    /**
     * Initializes the database. This is called from the UpInitContentProvider
     *
     * @param context - This is the context
     */
    fun init(context: Context?) {
        if (context != null) {
            val cartDao = CartRoomDatabase.getDatabase(context).cartDao()
            cartRepository = CartRepository(cartDao)
        }
    }

    /**
     * Returns an instance of the cart
     *
     * @param locationId - Location Id
     */
    fun getInstance(locationId: Int): Cart {
//        val locId: Int = SharedPrefManager.getCartLocationId()
//        return if (locId == locationId) {
//            Cart
//        } else {
//            clearCart()
//            Cart
//        }
        return Cart
    }

    /**
     * Add an item into the cart
     *
     * @param cartItem - Cart Item
     */
    fun addItem(cartItem: CartItem) = scope.launch {
        cartRepository.insert(cartItem)
    }

    /**
     * Remove an item from the cart
     *
     * @param cartItem
     */
    fun removeItem(cartItem: CartItem) = scope.launch {
        cartRepository.delete(cartItem)
    }

    /**
     * Clear the cart
     *
     */
    fun clearCart() = scope.launch {
        cartRepository.clearCart()
    }

    /**
     * Get all the cart items
     *
     */
    fun getAllItemsObservable(): Observable<List<CartItem>> {
        return cartRepository.getAllItemsObservable()
    }

    /**
     * Get all the items by id
     *
     * @param id - ID of the item
     */
    fun getAllItemsById(id: Int): Observable<List<CartItem>> {
        return cartRepository.getAllItemsForId(id)
    }

    /**
     * Get all the items using a live data observable
     *
     */
    fun getAllItemsLiveData(): LiveData<List<CartItem>> {
        return cartRepository.getAllCartItems()
    }

    /**
     * Get all the items in the cart
     */
    fun getTotalItemsInCart(): Int {
        return 0
    }

    /**
     * Get the total cart value
     */
    fun getCartValue(): Float {
        return 0f
    }

    /**
     * Get the item count for id
     */
    fun getItemCountForId(): Int {
        return 0
    }

}