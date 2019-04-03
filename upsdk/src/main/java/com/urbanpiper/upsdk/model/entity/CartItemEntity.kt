package com.urbanpiper.upsdk.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.urbanpiper.upsdk.model.networkresponse.OrderCategory
import com.urbanpiper.upsdk.model.networkresponse.OrderItemOption
import com.urbanpiper.upsdk.model.networkresponse.OrderItemOptionGroup
import java.util.ArrayList

//@Entity(tableName = "cart_table")
//data class CartItemEntity(
//
//    @PrimaryKey(autoGenerate = true)
//    var databaseId: Int = 0,
//
//    @ColumnInfo(name = "id")
//    var id: Int = 0,
//
//    @ColumnInfo(name = "image_url")
//    var imgUrl: String,
//
//    @ColumnInfo(name = "image_landscape_url")
//    var imgLandscapeUrl: String,
//
//    @ColumnInfo(name = "item_desc")
//    var desc: String,
//
//    @ColumnInfo(name = "item_price")
//    var price: Float = 0.toFloat(),
//
//    @ColumnInfo(name = "current_stock")
//    var current_stock: Int = -1,
//
//    @ColumnInfo(name = "item_title")
//    var name: String,
//
//    @ColumnInfo(name = "sort_order")
//    var sortOrder: Int = 0,
//
//    @ColumnInfo(name = "service_tax_rate")
//    var serviceTaxRate: Float = 0.toFloat(),
//
//    @ColumnInfo(name = "vat_rate")
//    var vatRate: Float = 0.toFloat(),
//
//    @TypeConverters(OrderItemOptionGroupTypeConverter::class)
//    @ColumnInfo(name = "option_groups")
//    var optionGroups: ArrayList<OrderItemOptionGroup>,
//
//    @TypeConverters(OrderItemOptionTypeConverter::class)
//    @ColumnInfo(name = "options")
//    var optionsSelectedForOrdering: ArrayList<OrderItemOption>,
//
//    @TypeConverters(OrderItemOptionTypeConverter::class)
//    @ColumnInfo(name = "options_to_remove")
//    var optionsSelectedForRemoval: ArrayList<OrderItemOption>,
//
//    @ColumnInfo(name = "quantity")
//    var quantity: Int = 0,
//
//    @ColumnInfo(name = "discount")
//    var discount: Float = 0.toFloat(),
//
//    @ColumnInfo(name = "food_type")
//    var foodType: Int = 0,
//
//    @TypeConverters(OrderCategoryTypeConverter::class)
//    @ColumnInfo(name = "item_category")
//    var itemCategory: OrderCategory,
//
//    @TypeConverters(OrderCategoryTypeConverter::class)
//    @ColumnInfo(name = "category")
//    var category: OrderCategory,
//
//    @TypeConverters(OrderCategoryTypeConverter::class)
//    @ColumnInfo(name = "sub_category")
//    var subCategory: OrderCategory,
//
//    @TypeConverters(FulfillmentModeTypeConverter::class)
//    @ColumnInfo(name = "fulfillment_modes")
//    var fulfillmentModes: Array<String>,
//
//    @ColumnInfo(name = "price_descriptor")
//    var priceDesc: String,
//
//    @ColumnInfo(name = "pre_order_start_time")
//    var preOrderStartTime: Long,
//
//    @ColumnInfo(name = "pre_order_end_time")
//    var preOrderEndTime: Long,
//
//    @ColumnInfo(name = "likes")
//    var likes: Int = 0,
//
//    @ColumnInfo(name = "userLiked")
//    var userLiked: Boolean = false
//) {
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//        other as CartItemEntity
//        if (id != other.id) return false
//        return true
//    }
//
//    override fun hashCode(): Int {
//        return id
//    }
//}