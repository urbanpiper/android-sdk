package com.urbanpiper.sdk;

import android.app.Application;
import com.urbanpiper.upsdk.dataprovider.Callback;
import com.urbanpiper.upsdk.dataprovider.UPClient;
import com.urbanpiper.upsdk.dataprovider.UPClientBuilder;
import com.urbanpiper.upsdk.dataprovider.UpClientError;
import com.urbanpiper.upsdk.model.networkresponse.UserBizInfoResponse;
import org.jetbrains.annotations.NotNull;

public class BaseApplication extends Application {

    private UPClient client;

    @Override
    public void onCreate() {
        super.onCreate();

        client = new UPClientBuilder()
                .setBizId("76720224")
                .setApiUsername("biz_adm_clients_yjXwAgQzHqYM")
                .setApiKey("5ee66ab0ec691963ebe2e9485ae0fdfe232d8fa8")
                .setLanguage("en")
                .setApplicationContext(this)
                .setCallback(new Callback<UserBizInfoResponse>() {
                    @Override
                    public void success(UserBizInfoResponse response) {

                    }

                    @Override
                    public void failure(@NotNull UpClientError upClientError) {

                    }
                })
                .build();
    }

    public UPClient getClient() {
        if (client == null) {
            client = new UPClientBuilder()
                    .setBizId("76720224")
                    .setApiUsername("biz_adm_clients_yjXwAgQzHqYM")
                    .setApiKey("5ee66ab0ec691963ebe2e9485ae0fdfe232d8fa8")
                    .setLanguage("en")
                    .setApplicationContext(this)
                    .setCallback(new Callback<UserBizInfoResponse>() {
                        @Override
                        public void success(UserBizInfoResponse response) {

                        }

                        @Override
                        public void failure(@NotNull UpClientError upClientError) {

                        }
                    })
                    .build();
            return client;
        } else {
            return client;
        }
    }
}
