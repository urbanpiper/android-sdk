package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class DeliverableAddressResponse (
    @SerializedName("addresses")
    @Expose
    private var addresses: List<DeliverableAddress> = ArrayList()
)
