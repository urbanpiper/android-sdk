package com.urbanpiper.sdk;

import android.app.Application;
import com.urbanpiper.upsdk.dataprovider.*;
import com.urbanpiper.upsdk.model.networkresponse.BannerResponse;
import com.urbanpiper.upsdk.model.networkresponse.UserBizInfoResponse;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.jetbrains.annotations.NotNull;

public class BaseApplication extends Application {

    private UPClient upClient;

    @Override
    public void onCreate() {
        super.onCreate();

        upClient = new UPClientBuilder()
                .setBizId("76720224")
                .setApiUsername("biz_adm_clients_yjXwAgQzHqYM")
                .setApiKey("5ee66ab0ec691963ebe2e9485ae0fdfe232d8fa8")
                .setLanguage("en")
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
}
