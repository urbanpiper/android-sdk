package com.urbanpiper.upsdk.dataprovider;

import android.text.TextUtils;

/**
 *
 *  Written in java for now
 *
 *  It would be easier to create the UPClient object if the builder was written in java
 *  for third party dev's who might use java to build the android application
 *
 */
public final class UPClientBuilder {

    private String bizId;
    private String apiUserName;
    private String apiKey;
    private String language;

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
    public UPClientBuilder setApiUserName(String apiUserName) {
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
     * @return - The UPClient object
     */
    public UPClient build() {
        if (bizId.length() == 0) {
            throw new IllegalArgumentException("Biz id is a required param ");
        }

        if (apiUserName.length() == 0) {
            throw new IllegalArgumentException("API Username is a required param ");
        }

        if (apiKey.length() == 0) {
            throw new IllegalArgumentException("API key is a required param ");
        }

        if (language.length() == 0) {
            throw new IllegalArgumentException("Language is a required param ");
        }

        return new UPClientDefault(bizId
                , apiUserName
                , apiKey
                , language);
    }


}

