package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class UserBizInfoResponse(

    val meta: ResponseMeta,
    @SerializedName("objects")
    val userBizInfoList: ArrayList<UserBizInfo>
)