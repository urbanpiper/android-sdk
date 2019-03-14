package com.urbanpiper.upsdk.dataprovider

import android.service.autofill.UserData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.urbanpiper.upsdk.model.UpdateUserInfoBody
import com.urbanpiper.upsdk.model.networkresponse.UserAddress
import com.urbanpiper.upsdk.model.networkresponse.UserInfoResponse
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.mockito.ArgumentMatchers.*
import org.mockito.Mockito

@RunWith(AndroidJUnit4::class)
class UpClientFacadeTest {

    lateinit var upClient: UPClient

    var userData: UserInfoResponse = UserInfoResponse(
        anyString(), anyLong(), anyLong(), anyString(), anyString(),
        anyString(), anyString(), anyString(), anyString()
    )
    var updateUserInfoBody: UpdateUserInfoBody = UpdateUserInfoBody(userData)

    lateinit var userAddress: UserAddress

    @Before
    fun setUp() {
        Mockito.mock(updateUserInfoBody::class.java)

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

        // Method to change language
        assertNotNull(upClient.changeLanguage("en"))

        // Promotions
        assertNotNull(upClient.getBanners())
        assertNotNull(upClient.getBanners())
        assertNotNull(upClient.getRewards())

        // General
        assertNotNull(upClient.checkAppVersion(anyString(), anyString()))
        assertNotNull(upClient.registerFCMToken(anyString(), anyString()))
        assertNotNull(upClient.getNearestStore(anyDouble(), anyDouble()))
        assertNotNull(upClient.getAllStores())

        // Catalogue
        assertNotNull(upClient.getCategories(anyInt()))
        assertNotNull(upClient.getCategoryItems(anyInt(), anyString(), anyInt(), anyInt()))
        assertNotNull(upClient.getFilterAndSortOptions(anyInt()))
        assertNotNull(upClient.getFilteredItems(anyInt(), anyString(), anyString(), anyInt(), anyInt()))
        assertNotNull(upClient.getSortedItems(anyInt(), anyString(), anyString(), anyInt(), anyInt()))
        assertNotNull(upClient.getRecommendedItems(anyInt()))
        assertNotNull(upClient.getRelatedItems(anyString(), anyInt()))
        assertNotNull(upClient.getItemDetails(anyInt(), anyInt()))
        assertNotNull(upClient.searchItems(anyString(), anyInt()))

        // User
        assertNotNull(upClient.login(anyString(), anyString()))
        assertNotNull(upClient.refreshToken(anyString()))
        assertNotNull(
            upClient.socialLoginOTP(anyString(), anyString(), anyString(), anyString(), anyString(), anyString())
        )
        assertNotNull(upClient.socialLogin(anyString(), anyString(), anyString()))
        assertNotNull(upClient.refreshUserInfo(anyString()))
        assertNotNull(upClient.refreshUserBizInfo())
        assertNotNull(upClient.updateUserInfo(anyString(), updateUserInfoBody))
        assertNotNull(upClient.changePassword(anyString(), anyString(), anyString(), anyString()))
        assertNotNull(upClient.getDeliverableAddresses(anyString()))


        // Cart


    }

    @Test
    fun changeLanguageFromEn_toHi() {
        upClient.changeLanguage("hi")
        assertEquals("hi", upClient.getBizLanguage())
    }

}