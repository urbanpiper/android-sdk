package com.urbanpiper.upsdk.dataprovider

import android.service.autofill.UserData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.urbanpiper.upsdk.model.Order
import com.urbanpiper.upsdk.model.UpdateUserInfoBody
import com.urbanpiper.upsdk.model.networkresponse.UserAddress
import com.urbanpiper.upsdk.model.networkresponse.UserFeedback
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
    private var updateUserInfoBody: UpdateUserInfoBody = UpdateUserInfoBody(userData)

    var userAddress: UserAddress = UserAddress(
        anyInt(), anyString(), anyString(), anyString(), anyDouble(), anyDouble(),
        anyString(), anyString(), anyInt(), anyInt(), anyString()
    )

    var submitFeedback: UserFeedback = UserFeedback(
        anyString(), anyInt(), UserFeedback.Type.ORDERING, anyInt(),
        anyString(), anyString(), anyString(), anyString()
    )
//
//    var order: Order = Order(
//        anyString(), anyInt(), anyFloat(), anyFloat(), anyFloat(), anyFloat(), anyFloat(), anyFloat(), anyLong(),
//        anyString(), anyString(), anyString(), anyString(), anyDouble(), anyDouble(), anyFloat(), anyFloat(), anyString(),
//        anyFloat(),
//    )
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
        assertNotNull(upClient.getCheckOutBuilder())
        assertNotNull(upClient.getRegistrationBuilder())
        assertNotNull(upClient.getForgotPasswordBuilder())

        // Method to change language
        assertNotNull(upClient.changeLanguage("en"))

        // Promotions
        assertNotNull(upClient.getBanners())
        assertNotNull(upClient.getOffers())
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
        assertNotNull(upClient.addAddress(userAddress))
        assertNotNull(upClient.updateAddress(userAddress))
        assertNotNull(upClient.deleteAddress(anyString()))
        assertNotNull(upClient.getWalletTransactions(anyString(), anyString()))
        assertNotNull(upClient.getPastOrders())
        assertNotNull(upClient.getPastOrderDetails(anyInt()))
        assertNotNull(upClient.redeemReward(anyInt()))
        assertNotNull(upClient.getNotifications())
        assertNotNull(upClient.submitFeedback(submitFeedback))
        assertNotNull(upClient.getUserLikes(anyString()))
        assertNotNull(upClient.likeItem(anyInt()))
        assertNotNull(upClient.unLikeItem(anyInt()))
        assertNotNull(upClient.getResetPasswordToken(anyString()))
        assertNotNull(upClient.resetPassword(anyString(), anyString(), anyString(), anyString()))

        // Cart
        assertNotNull(upClient.reOrder(anyString(), anyString(), anyString(), anyString()))
        assertNotNull(upClient.getCartRelatedItems(anyString(), anyInt()))
//        assertNotNull(upClient.validateCart(order))


    }

    @Test
    fun changeLanguageFromEn_toHi() {
        upClient.changeLanguage("hi")
        assertEquals("hi", upClient.getBizLanguage())
    }

}