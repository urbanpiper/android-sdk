package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.OrderCategory
import com.urbanpiper.upsdk.model.networkresponse.OrderItem

interface CartTracker {

    fun addItem(category: OrderCategory, item: OrderItem )

    fun removeItem(category: OrderCategory, item: OrderItem)

    fun clearCart()

}