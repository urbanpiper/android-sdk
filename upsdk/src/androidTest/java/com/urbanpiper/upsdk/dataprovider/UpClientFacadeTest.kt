package com.urbanpiper.upsdk.dataprovider

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.mockito.ArgumentMatchers.*

@RunWith(AndroidJUnit4::class)
class UpClientFacadeTest {

    lateinit var upClient: UPClient

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


        // Cart


    }

    @Test
    fun changeLanguageFromEn_toHi() {
        upClient.changeLanguage("hi")
        assertEquals("hi", upClient.getBizLanguage())
    }

}