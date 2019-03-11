package com.urbanpiper.upsdk.dataprovider

import android.util.Log
import com.urbanpiper.upsdk.dataprovider.Cart.Singleton.instance
import com.urbanpiper.upsdk.model.networkresponse.OrderCategory
import com.urbanpiper.upsdk.model.networkresponse.OrderItem
import java.util.*
import kotlin.collections.ArrayList

class Cart : CartTracker {

    /**
     * The cart is a tree map.
     */
    private var cart: TreeMap<OrderCategory, ArrayList<OrderItem>> = TreeMap()

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
    fun getCartTreeMap(): TreeMap<OrderCategory, ArrayList<OrderItem>> {
        return instance.cart
    }

    override fun addItem(category: OrderCategory, item: OrderItem) {
        addItemToCart(category, item)
    }

    override fun removeItem(category: OrderCategory, item: OrderItem) {
        removeItemFromCart(category, item)
    }

    override fun clearCart() {
        resetCart()
    }

    /**
     * Returns the total number of items in the cart
     */
    fun getTotalItemsInCart(cart: TreeMap<OrderCategory, ArrayList<OrderItem>>): Int {
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
    fun getCartItems(): ArrayList<OrderItem> {
        val allItems: ArrayList<OrderItem> = ArrayList()

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
    fun getItemCountForId(category: OrderCategory, item: OrderItem): Int {
        val items: ArrayList<OrderItem>? = instance.cart[category]
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


    private fun removeItemFromCart(category: OrderCategory, item: OrderItem) {
        val items: ArrayList<OrderItem>? = instance.cart[category]
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
    private fun addItemToCart(category: OrderCategory, item: OrderItem) {
        var items: ArrayList<OrderItem>? = instance.cart[category]
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
        cart: TreeMap<OrderCategory, ArrayList<OrderItem>>, category: OrderCategory, item: OrderItem
    ) {
        val itemsIterator: MutableIterator<OrderItem> = cart[category]!!.iterator()

        while (itemsIterator.hasNext()) {
            val currentItem: OrderItem = itemsIterator.next()

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