package com.urbanpiper.upsdk.model.networkresponse

import android.util.Log
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

data class PaymentInitResponse(
    @SerializedName("success")
    var success: Boolean = false,

    @SerializedName("message")
    var message: String,

    @SerializedName("transaction_id")
    var trxId: String,

    @SerializedName("url")
    private val redirectUrl: String,

    @SerializedName("data")
    private val data: Any,

    @SerializedName("pgKey")
    var pgKey: String,

    @SerializedName("pgType")
    var pgType: String
) {

    fun toJson(): String {
        return Gson().toJson(this)
    }

    fun getRedirectUrl(): String? {

        var redirUrl = redirectUrl

        val PG_OPT_PAYTM = "paytm"
        val PG_OPT_PAYTABS = "paytabs"

        if (data != null) {
            val gson = Gson()
            val dataJson = gson.toJson(data)
            val type = object : TypeToken<Map<String, String>>() {
            }.type
            val dataMap = gson.fromJson<Map<String, String>>(dataJson, type)

            if (dataMap.getValue("type").toLowerCase() == PG_OPT_PAYTM) {
                redirUrl = constructUrlForPaytm(dataMap)
            } else if (dataMap.getValue("type").toLowerCase() == PG_OPT_PAYTABS) {
                redirUrl = dataMap["payment_url"].toString()
            }

            // set pg type
            pgType = dataMap["type"].toString()
            // set pg key
            pgKey = dataMap["key"].toString()
        }

        return redirUrl
    }

    private fun constructUrlForPaytm(data: Map<String, String>): String {

        val constructedUrl: String
        val sb = StringBuilder(
            "<html><body><form name=\"paytm\" " +
                    "action=\"" + data["payment_url"] + "/theia/processTransaction" +
                    "\" method=\"POST\">"
        )

        val entries = data.entries
        for (entry in entries) {
            sb.append(
                String.format(
                    "<input type=\"hidden\" name=\"%s\" value=\"%s\" />\n",
                    entry.key, entry.value
                )
            )
        }

        sb.append("</form></body></html>")
        constructedUrl = sb.toString()

        return constructedUrl
    }
}
