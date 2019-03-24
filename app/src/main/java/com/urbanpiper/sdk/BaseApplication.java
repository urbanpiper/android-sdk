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

        CancellableTask cancellableTask = upClient.getBanners(new Callback<BannerResponse>() {
            @Override
            public void success(BannerResponse response) {

            }

            @Override
            public void failure(@NotNull UpClientError upClientError) {

            }
        });

        // Note - This method can be called to cancel the network request
        cancellableTask.cancel();

        Observable<BannerResponse> observable = upClient.getBanners();

        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BannerResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerResponse bannerResponse) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public UPClient getUpClient() {
        if (upClient == null) {
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
            return upClient;
        } else {
            return upClient;
        }
    }
}
