package com.urbanpiper.upsdk.dataprovider

import android.util.Log
import com.urbanpiper.upsdk.dataprovider.Cart.Singleton.instance
import com.urbanpiper.upsdk.model.networkresponse.OrderCategory
import com.urbanpiper.upsdk.model.networkresponse.CartItem
import java.util.*
import kotlin.collections.ArrayList

/**
 * This class contains the implementation of the cart
 */
class Cart : CartTracker {

    /**
     * The cart is a tree map.
     */
    private var cart: TreeMap<OrderCategory, ArrayList<CartItem>> = TreeMap()

    private var itemCount: Int = 0
    private var lastUpdatedAt: Long = 0L

    // This creates a single instance of a cart
    object Singleton {
        val instance: Cart = Cart()
    }

    /**
     * Returns an instance of the cartManager
     */
    fun getInstance(): Cart {
        return instance
    }

    /**
     * Returns the cart
     */
    fun getCartTreeMap(): TreeMap<OrderCategory, ArrayList<CartItem>> {
        return instance.cart
    }

    override fun addItem(category: OrderCategory, item: CartItem) {
        addItemToCart(category, item)
    }

    override fun removeItem(category: OrderCategory, item: CartItem) {
        removeItemFromCart(category, item)
    }

    override fun clearCart() {
        resetCart()
    }

    /**
     * Returns the total number of items in the cart
     */
    fun getTotalItemsInCart(cart: TreeMap<OrderCategory, ArrayList<CartItem>>): Int {
        var count = 0
        val categories: Set<OrderCategory> = cart.keys

        for (category in categories) {
            for (item in cart[category]!!) {
                count += item.quantity
            }
        }

        if (count == 0) {
            cart.clear()
        }
        return count
    }

    /**
     * Returns a list of all the items in the cart
     */
    fun getAllCartItems(): ArrayList<CartItem> {
        val allItems: ArrayList<CartItem> = ArrayList()

        for (items in instance.cart.values) {
            allItems.addAll(items)
        }
        return allItems
    }


    /**
     * Returns a list of all the items
     */
    fun getCartValue(): Float {
        var value = 0F

        val categories: Set<OrderCategory> = cart.keys

        for (category in categories) {
            for (item in cart[category]!!) {
                val price: Float = item.price
                value += price * item.quantity
            }
        }
        return value
    }

    /**
     * Get the quantity of items stored in the cart
     */
    fun getItemCountForId(category: OrderCategory, item: CartItem): Int {
        val items: ArrayList<CartItem>? = instance.cart[category]
        var count = 0
        if (items == null){
            return count
        } else if (!contains(items,item)){
            return count
        } else {
            for (i in items) {
                if (i == item) {
                    count = i.quantity
                    return count
                }
            }
        }
        return count
    }


    private fun removeItemFromCart(category: OrderCategory, item: CartItem) {
        val items: ArrayList<CartItem>? = instance.cart[category]
        if (items == null) {
            Log.e("cart", "Item does not exist in the cart")
        } else if (!contains(items, item)) {
            Log.e("cart", "Item does not exist in the cart")
        } else {
            removeItemFromCategory(instance.cart, category, item)
            if (items.size == 0) {
                instance.cart.remove(category)
            }

            instance.itemCount = getTotalItemsInCart(instance.cart)
            instance.lastUpdatedAt = System.currentTimeMillis()
        }

    }

    /**
     * Add an item to the cart
     */
    private fun addItemToCart(category: OrderCategory, item: CartItem) {
        var items: ArrayList<CartItem>? = instance.cart[category]
        if (items == null) {
            items = ArrayList()
            instance.cart[category] = items
        } else if (contains(items, item)) {
            remove(items, item, item.hasOptions())
        }
        items.add(item)

        // Updating cart internal values
        instance.itemCount = getTotalItemsInCart(instance.cart)
        instance.lastUpdatedAt = System.currentTimeMillis()
    }

    /**
     * Remove item from a category in the cart
     *
     */
    private fun removeItemFromCategory(
        cart: TreeMap<OrderCategory, ArrayList<CartItem>>, category: OrderCategory, item: CartItem
    ) {
        val itemsIterator: MutableIterator<CartItem> = cart[category]!!.iterator()

        while (itemsIterator.hasNext()) {
            val currentItem: CartItem = itemsIterator.next()

            if (currentItem == item) {
                currentItem.quantity = currentItem.quantity - 1
                if (currentItem.quantity <= 0) {
                    itemsIterator.remove()
                }
            }
            break
        }
    }

    /**
     * Remove an item from the list
     */
    private fun <T : Any> remove(list: ArrayList<T>, item: T, hasOptions: Boolean): T? {
        for (i in list) {
            if (i == item) {
                if (hasOptions && i != item) {
                    continue
                }
                list.remove(i)
                return item
            }

        }
        return null
    }

    /**
     * Check if the item is present in the list
     */
    private fun <T : Any> contains(list: List<T>, item: T): Boolean {
        for (i in list) {
            if (i == item) {
                return true
            }
        }
        return false
    }

    /**
     * Reset's the cart
     */
    private fun resetCart() {
        instance.cart.clear()
        instance.itemCount = 0
    }
}