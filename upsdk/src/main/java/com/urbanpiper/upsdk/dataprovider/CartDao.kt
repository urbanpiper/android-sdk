package com.urbanpiper.upsdk.dataprovider

import androidx.lifecycle.LiveData
import androidx.room.*
import com.urbanpiper.upsdk.model.networkresponse.CartItem
import io.reactivex.Observable

@Dao
interface CartDao {

    /**
     * Updates an item in the table
     *
     * @param cartItem
     */
    @Insert
    fun insert(cartItem: CartItem)

    /**
     * Updates an item in the table
     *
     * @param cartItem
     */
    @Update
    fun update(cartItem: CartItem)

    /**
     * Delete an item from the cart
     *
     * @param cartItem
     */
    @Delete
    fun delete(cartItem: CartItem)

    /**
     * Deletes all items in the cart
     *
     */
    @Query("DELETE from cart_table")
    fun clearCart()

    /**
     *  Returns all the cart items
     *
     */
    @Query("SELECT * FROM cart_table")
    fun getAllItems(): LiveData<List<CartItem>>

    /**
     *  Returns all the cart items in the form of an observable
     *
     */
    @Query("SELECT * FROM cart_table")
    fun getAllItemsObservable(): Observable<List<CartItem>>

    /**
     * Returns all the cart items based on the id
     *
     * @param id - Id of the cart item
     */
    @Query("SELECT * FROM cart_table WHERE id = :id")
    fun getAllItemsById(id: Int): Observable<List<CartItem>>
}