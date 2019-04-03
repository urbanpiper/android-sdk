package com.urbanpiper.upsdk.dataprovider

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.urbanpiper.upsdk.model.networkresponse.CartItem
import io.reactivex.Observable

class CartRepository(private val cartDao: CartDao) {

    /**
     * This method returns a list of all cart items
     */
    fun getAllCartItems(): LiveData<List<CartItem>> {
        return cartDao.getAllItems()
    }

    /**
     * This method inserts a cart item into the database
     *
     * @param cartItem - Object of type cart item
     */
    @WorkerThread
    suspend fun insert(cartItem: CartItem) {
        return cartDao.insert(cartItem)
    }

    /**
     * This method updates the existing cart item in the database
     *
     * @param cartItem - Object of type cart item
     */
    @WorkerThread
    suspend fun update(cartItem: CartItem) {
        return cartDao.update(cartItem)
    }

    /**
     * This method deletes an item from the cart
     *
     * @param cartItem
     */
    @WorkerThread
    suspend fun delete(cartItem: CartItem) {
        return cartDao.delete(cartItem)
    }

    /**
     * This method deletes all the items in the cart
     */
    @WorkerThread
    suspend fun clearCart() {
        cartDao.clearCart()
    }

    /**
     * Returns a list of all the items as an observable
     *
     */
    fun getAllItemsObservable(): Observable<List<CartItem>> {
        return cartDao.getAllItemsObservable()
    }

    /**
     * Returns a list of all items based on the id
     *
     * @param id - Id of item
     */
    fun getAllItemsForId(id: Int): Observable<List<CartItem>> {
        return cartDao.getAllItemsById(id)
    }

}