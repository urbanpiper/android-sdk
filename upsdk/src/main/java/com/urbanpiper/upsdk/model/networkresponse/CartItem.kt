package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class CartItem(
    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("image_url")
    var imgUrl: String,

    @SerializedName("image_landscape_url")
    var imgLandscapeUrl: String,

    @SerializedName("item_desc")
    var desc: String,

    @SerializedName("item_price")
    var price: Float = 0.toFloat(),

    @SerializedName("current_stock")
    var current_stock: Int = -1,

    @SerializedName("item_title")
    var name: String,

    @SerializedName("sort_order")
    var sortOrder: Int = 0,

    @SerializedName("service_tax_rate")
    var srvcTaxRate: Float = 0.toFloat(),

    @SerializedName("vat_rate")
    var vatRate: Float = 0.toFloat(),

    @SerializedName("option_groups")
    var optionGroups: ArrayList<OrderItemOptionGroup>,

    @SerializedName("options")
    var optionsSelectedForOrdering: ArrayList<OrderItemOption>,

    @SerializedName("options_to_remove")
    var optionsSelectedForRemoval: ArrayList<OrderItemOption>,

    @SerializedName("quantity")
    var quantity: Int = 0,

    @SerializedName("discount")
    var discount: Float = 0.toFloat(),

    @SerializedName("food_type")
    var foodType: Int = 0,

    @SerializedName("discountedPrice")
    var discountedPrice: Float = 0f,

    @SerializedName("item_category")
    var itemCategory: OrderCategory,

    @SerializedName("category")
    var category: OrderCategory,

    @SerializedName("sub_category")
    var subCategory: OrderCategory,

    @SerializedName("fulfillment_modes")
    var fulfillmentModes: Array<String>,

    @SerializedName("price_descriptor")
    var priceDesc: String,

    @SerializedName("pre_order_start_time")
    var preOrderStartTime: Long,

    @SerializedName("pre_order_end_time")
    var preOrderEndTime: Long,

    @SerializedName("likes")
    var likes: Int = 0,

    @SerializedName("userLiked")
    var userLiked: Boolean = false

) {
    fun hasOptions(): Boolean {
        return optionGroups.size > 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CartItem

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }

    fun toJson(): String {
        return Gson().toJson(this)
    }
}
