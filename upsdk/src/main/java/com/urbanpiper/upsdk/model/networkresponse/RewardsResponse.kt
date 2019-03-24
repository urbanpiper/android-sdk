package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

import java.io.Serializable
import java.util.ArrayList

data class RewardsResponse(
    @SerializedName("meta")
    var meta: ResponseMeta,
    @SerializedName("in_store_coupon_rewards")
    var inStoreCouponRewards: List<Reward>,
    @SerializedName("locked")
    var locked: List<Reward>,
    @SerializedName("unlocked")
    var unlocked: List<Reward>,
    @SerializedName("claimed")
    var claimed: List<Reward>,
    @SerializedName("redeemed")
    var redeemedButNotClaimed: List<Reward>,
    @SerializedName("allRewards")
    var allRewards: List<Reward> = ArrayList()
) {

    data class Reward(
        @SerializedName("locked")
        var locked: Boolean = false,
        @SerializedName("description")
        var description: String,
        @SerializedName("title")
        var title: String,
        @SerializedName("img_link")
        var imgLink: String,
        @SerializedName("value")
        var value: String,
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
        var redeemCodes: List<RewardRedemption>,
        @SerializedName("previous_claims")
        var previousClaims: List<PreviousClaims>
    )

    data class RewardRedemption(
        @SerializedName("redemption_code")
        var redeemCode: String,
        @SerializedName("expires_in")
        var expiresOn: Long = 0
    )

    data class PreviousClaims(
        @SerializedName("claimed_on")
        var claimedOn: Long = 0,
        @SerializedName("redemption_code")
        var redeemCode: String
    )

    fun toJson(): String {
        return Gson().toJson(this)
    }
}

