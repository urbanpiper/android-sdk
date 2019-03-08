package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class UserLikesResponse(
    @SerializedName("likes")
    var likes: ArrayList<Like>,

    @SerializedName("meta")
    var meta: ResponseMeta
)
