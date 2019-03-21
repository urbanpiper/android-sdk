package com.urbanpiper.upsdk.dataprovider;

import android.content.Context;
import android.text.TextUtils;
import com.urbanpiper.upsdk.model.networkresponse.UserBizInfoResponse;

/**
 * Written in java for now
 * <p>
 * It would be easier to create the UPClient object if the builder was written in java
 * for third party dev's who might use java to build the android application
 */
public final class UPClientBuilder {

    private String bizId;
    private String apiUserName;
    private String apiKey;
    private String language;
    private Context context;
    private Callback<UserBizInfoResponse> callback = null;

    /**
     * Biz id - It identifies your business on the UrbanPiper platform
     * <p>
     * Required parameter
     *
     * @param bizId - Business
     * @return - Builder
     */
    public UPClientBuilder setBizId(String bizId) {
        this.bizId = bizId;
        return this;
    }

    /**
     * Api Username
     *
     * @param apiUserName
     * @return - Builder
     */
    public UPClientBuilder setApiUsername(String apiUserName) {
        this.apiUserName = apiUserName;
        return this;
    }

    /**
     * Api key
     *
     * @param apiKey
     * @return - Builder
     */
    public UPClientBuilder setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    /**
     * Language
     *
     * @param language
     * @return - Builder
     */
    public UPClientBuilder setLanguage(String language) {
        this.language = language;
        return this;
    }

    /**
     * Callback that returns user information
     *
     * @param callback
     * @return - Builder
     */
    public UPClientBuilder setCallback(Callback<UserBizInfoResponse> callback) {
        this.callback = callback;
        return this;
    }

    /**
     * Application context
     *
     * @param context
     * @return - Builder
     */
    public UPClientBuilder setApplicationContext(Context context) {
        this.context = context;
        return this;
    }

    /**
     * @return - The UPClient object
     */
    public UPClient build() {
        if (TextUtils.isEmpty(bizId)) {
            throw new IllegalArgumentException("Biz id is a required parameter ");
        }

        if (TextUtils.isEmpty(apiUserName)) {
            throw new IllegalArgumentException("API Username is a required parameter ");
        }

        if (TextUtils.isEmpty(apiKey)) {
            throw new IllegalArgumentException("API key is a required parameter ");
        }

        if (TextUtils.isEmpty(language)) {
            throw new IllegalArgumentException("Language is a required parameter ");
        }

        if (callback == null) {
            throw new IllegalArgumentException("Callback is a required parameter ");
        }

        if (context == null) {
            throw new IllegalArgumentException("Context is a required parameter ");
        }
        return new UPClientDefault(bizId
                , apiUserName
                , apiKey
                , language
                , context
                , callback);
    }


}

