package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName

import java.io.Serializable
import java.util.ArrayList

/**
 * Created by prem on 21/12/2016.
 */

data class RewardsResponse(
    @SerializedName("meta")
    var meta: ResponseMeta? = null,
    @SerializedName("in_store_coupon_rewards")
    var inStoreCouponRewards: List<Reward>? = null,
    @SerializedName("locked")
    var locked: List<Reward>? = null,
    @SerializedName("unlocked")
    var unlocked: List<Reward>? = null,
    @SerializedName("claimed")
    var claimed: List<Reward>? = null,
    @SerializedName("redeemed")
    var redeemedButNotClaimed: List<Reward>? = null,
    @SerializedName("allRewards")
    var allRewards: List<Reward> = ArrayList()
) {

    data class Reward(
        @SerializedName("locked")
        var locked: Boolean = false,
        @SerializedName("description")
        var description: String? = null,
        @SerializedName("title")
        var title: String? = null,
        @SerializedName("img_link")
        var imgLink: String? = null,
        @SerializedName("value")
        var value: String? = null,
        @SerializedName("points")
        var points: Int = 0,
        @SerializedName("redeemable")
        var redeemable: Boolean = false,
        @SerializedName("in_store_coupon_rewards")
        var inStoreCouponRewards: Boolean = false,
        @SerializedName("claimed_count")
        var claimedCount: Int = 0,
        @SerializedName("type")
        var type: Int = 0,
        @SerializedName("id")
        var id: Int = 0,
        @SerializedName("expires_on")
        var expiresOn: Long = 0,
        @SerializedName("redemption_codes")
        var redeemCodes: List<RewardRedemption>? = null,
        @SerializedName("previous_claims")
        var previousClaims: List<PreviousClaims>? = null
    )

    data class RewardRedemption(
        @SerializedName("redemption_code")
        var redeemCode: String? = null,
        @SerializedName("expires_in")
        var expiresOn: Long = 0
    )

    data class PreviousClaims(
        @SerializedName("claimed_on")
        var claimedOn: Long = 0,
        @SerializedName("redemption_code")
        var redeemCode: String? = null
    )
}

