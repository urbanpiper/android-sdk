package com.urbanpiper.sdk;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.urbanpiper.upsdk.dataprovider.Callback;
import com.urbanpiper.upsdk.dataprovider.CancellableTask;
import com.urbanpiper.upsdk.dataprovider.UpClientError;
import com.urbanpiper.upsdk.model.networkresponse.BannerResponse;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import org.jetbrains.annotations.NotNull;

public class MainActivityJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_java);

        CancellableTask cancellableTask = ((MyApp) getApplication())
                .getBanners(new Callback<BannerResponse>() {
                    @Override
                    public void success(BannerResponse response) {

                    }

                    @Override
                    public void failure(@NotNull UpClientError upClientError) {

                    }
                });

        // This method cancels the network request
        cancellableTask.cancel();

        // Observable
        Observable<BannerResponse> observable = ((MyApp) getApplication()).getBanners();

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


}
