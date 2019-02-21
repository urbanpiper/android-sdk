package com.urbanpiper.upsdk

import android.util.Log
import android.widget.Toast
import com.urbanpiper.upsdk.dataprovider.UPClient
import com.urbanpiper.upsdk.dataprovider.UPClientBuilder
import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FacadeTest {

    private lateinit var upClient: UPClient

    @Before
    fun setUp() {
        upClient = UPClientBuilder()
            .setBizId("76720224")
            .setApiUserName("biz_adm_clients_yjXwAgQzHqYM")
            .setApiKey("5ee66ab0ec691963ebe2e9485ae0fdfe232d8fa8")
            .setLanguage("en")
            .build()
    }

    @Test
    fun testFacade() {
        assertNotNull(upClient.getBizId())
        assertNotNull(upClient.getApiUserName())
        assertNotNull(upClient.getAPIKey())
        assertNotNull(upClient.getBizLanguage())

//        upClient.getBanners(object : Callback<BannerResponse> {
//            override fun onResponse(call: Call<BannerResponse>, response: Response<BannerResponse>) {
//                assertEquals(true, response.isSuccessful)
//            }
//
//            override fun onFailure(call: Call<BannerResponse>, t: Throwable) {
//            }
//        })


    }


}