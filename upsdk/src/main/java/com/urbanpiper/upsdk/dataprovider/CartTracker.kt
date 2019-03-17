package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.OrderCategory
import com.urbanpiper.upsdk.model.networkresponse.CartItem

/**
 * Helper method for the cart implementation
 */
interface CartTracker {

    fun addItem(category: OrderCategory, item: CartItem )

    fun removeItem(category: OrderCategory, item: CartItem)

    fun clearCart()

}