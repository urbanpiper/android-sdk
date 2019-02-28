package com.urbanpiper.upsdk.dataprovider

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import retrofit2.Call

@RunWith(AndroidJUnit4::class)
class PromotionsTest {


    @Mock
    lateinit var mockCall: Call<BannerResponse>


    @Test
    fun testBanners() {

        val promotionsRetrofitService: PromotionsRetrofitService =
            mock(PromotionsRetrofitService::class.java)

        `when`(
            promotionsRetrofitService.getBanners(
                Mockito.anyString(),
                Mockito.anyString()
            ))
            .thenReturn(mockCall)





    }

}