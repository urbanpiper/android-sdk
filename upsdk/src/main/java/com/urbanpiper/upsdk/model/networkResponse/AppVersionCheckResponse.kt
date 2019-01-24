package com.urbanpiper.upsdk.model.networkResponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class AppVersionCheckResponse(
    @SerializedName("latest_version")
    val latestVersion: String,
    @SerializedName("release_date")
    val releaseDate: Long,
    @SerializedName("force_update")
    val forceUpdate: Boolean,
    @SerializedName("url")
    val url: String
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}