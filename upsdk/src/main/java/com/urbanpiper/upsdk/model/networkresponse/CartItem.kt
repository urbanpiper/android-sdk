package com.urbanpiper.upsdk.model.networkresponse

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.urbanpiper.upsdk.model.entity.FulfillmentModeTypeConverter
import com.urbanpiper.upsdk.model.entity.OrderCategoryTypeConverter
import com.urbanpiper.upsdk.model.entity.OrderItemOptionGroupTypeConverter
import com.urbanpiper.upsdk.model.entity.OrderItemOptionTypeConverter
import java.util.ArrayList

@Entity(tableName = "cart_table")
data class CartItem(

    @PrimaryKey(autoGenerate = true)
    var databaseId: Int? = 0,

    @SerializedName("id")
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @SerializedName("image_url")
    @ColumnInfo(name = "image_url")
    var imgUrl: String?,

    @SerializedName("image_landscape_url")
    @ColumnInfo(name = "image_landscape_url")
    var imgLandscapeUrl: String?,

    @SerializedName("item_desc")
    @ColumnInfo(name = "item_desc")
    var desc: String?,

    @SerializedName("item_price")
    @ColumnInfo(name = "item_price")
    var price: Float? = 0.toFloat(),

    @SerializedName("current_stock")
    @ColumnInfo(name = "current_stock")
    var current_stock: Int? = -1,

    @SerializedName("item_title")
    @ColumnInfo(name = "item_title")
    var name: String?,

    @SerializedName("sort_order")
    @ColumnInfo(name = "sort_order")
    var sortOrder: Int? = 0,

    @SerializedName("service_tax_rate")
    @ColumnInfo(name = "service_tax_rate")
    var serviceTaxRate: Float? = 0.toFloat(),

    @SerializedName("vat_rate")
    @ColumnInfo(name = "vat_rate")
    var vatRate: Float? = 0.toFloat(),

    @SerializedName("option_groups")
    @TypeConverters(OrderItemOptionGroupTypeConverter::class)
    @ColumnInfo(name = "option_groups")
    var optionGroups: ArrayList<OrderItemOptionGroup?>? = ArrayList(),

    @TypeConverters(OrderItemOptionTypeConverter::class)
    @ColumnInfo(name = "options")
    @SerializedName("options")
    var optionsSelectedForOrdering: ArrayList<OrderItemOption?>? = ArrayList(),

    @TypeConverters(OrderItemOptionTypeConverter::class)
    @ColumnInfo(name = "options_to_remove")
    @SerializedName("options_to_remove")
    var optionsSelectedForRemoval: ArrayList<OrderItemOption?>? = ArrayList(),

    @ColumnInfo(name = "quantity")
    @SerializedName("quantity")
    var quantity: Int? = 0,

    @ColumnInfo(name = "discount")
    @SerializedName("discount")
    var discount: Float? = 0.toFloat(),

    @ColumnInfo(name = "food_type")
    @SerializedName("food_type")
    var foodType: Int? = 0,

    @TypeConverters(OrderCategoryTypeConverter::class)
    @ColumnInfo(name = "item_category")
    @SerializedName("item_category")
    var itemCategory: OrderCategory?,

    @TypeConverters(OrderCategoryTypeConverter::class)
    @ColumnInfo(name = "category")
    @SerializedName("category")
    var category: OrderCategory?,

    @TypeConverters(OrderCategoryTypeConverter::class)
    @ColumnInfo(name = "sub_category")
    @SerializedName("sub_category")
    var subCategory: OrderCategory?,

    @TypeConverters(FulfillmentModeTypeConverter::class)
    @ColumnInfo(name = "fulfillment_modes")
    @SerializedName("fulfillment_modes")
    var fulfillmentModes: Array<String>?,

    @ColumnInfo(name = "price_descriptor")
    @SerializedName("price_descriptor")
    var priceDesc: String?,

    @ColumnInfo(name = "pre_order_start_time")
    @SerializedName("pre_order_start_time")
    var preOrderStartTime: Long?,

    @ColumnInfo(name = "pre_order_end_time")
    @SerializedName("pre_order_end_time")
    var preOrderEndTime: Long?,

    @ColumnInfo(name = "likes")
    @SerializedName("likes")
    var likes: Int? = 0,

    @ColumnInfo(name = "userLiked")
    @SerializedName("userLiked")
    var userLiked: Boolean? = false

) {
    fun hasOptions(): Boolean {
        return if(optionGroups != null){
            optionGroups!!.size > 0
        } else{
            false
        }
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
