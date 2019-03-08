package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class CategoryItemResponse(
    @SerializedName("combos")
    val combos: List<Any>,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("objects")
    val objects: List<Object>
) {
    data class Meta(
        @SerializedName("limit")
        val limit: Int,
        @SerializedName("next")
        val next: Any,
        @SerializedName("offset")
        val offset: Int,
        @SerializedName("previous")
        val previous: Any,
        @SerializedName("total_count")
        val totalCount: Int
    )

    data class Object(
        @SerializedName("category")
        val category: Category,
        @SerializedName("current_stock")
        val currentStock: Int,
        @SerializedName("extras")
        val extras: List<Any>,
        @SerializedName("food_type")
        val foodType: String,
        @SerializedName("fulfillment_modes")
        val fulfillmentModes: List<String>,
        @SerializedName("id")
        val id: Int,
        @SerializedName("image_landscape_url")
        val imageLandscapeUrl: String,
        @SerializedName("image_url")
        val imageUrl: String,
        @SerializedName("item_desc")
        val itemDesc: String,
        @SerializedName("item_price")
        val itemPrice: Int,
        @SerializedName("item_title")
        val itemTitle: String,
        @SerializedName("likes")
        val likes: Int,
        @SerializedName("option_groups")
        val optionGroups: List<Any>,
        @SerializedName("price_descriptor")
        val priceDescriptor: Any,
        @SerializedName("service_tax_rate")
        val serviceTaxRate: Int,
        @SerializedName("slug")
        val slug: String,
        @SerializedName("sort_order")
        val sortOrder: Int,
        @SerializedName("tags")
        val tags: List<Any>,
        @SerializedName("vat_rate")
        val vatRate: Int
    ) {

    }

    fun toJson(): String {
        return Gson().toJson(this)
    }
}