package com.urbanpiper.upsdk.dataprovider

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class UpClientFacadeTest {

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

        assertNotNull(upClient.changeLanguage("en"))

    }

    @Test
    fun changeLanguageFromEn_toHi() {
        upClient.changeLanguage("hi")
        assertEquals("hi", upClient.getBizLanguage())
    }

}