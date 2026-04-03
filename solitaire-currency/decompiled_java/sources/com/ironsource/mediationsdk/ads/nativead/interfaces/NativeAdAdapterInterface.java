package com.ironsource.mediationsdk.ads.nativead.interfaces;

import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.sdk.AdUnitAdapterInterface;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface NativeAdAdapterInterface extends AdUnitAdapterInterface {
    void collectNativeAdBiddingData(@NotNull JSONObject jSONObject, @Nullable JSONObject jSONObject2, @NotNull BiddingDataCallback biddingDataCallback);

    void destroyNativeAd(@NotNull JSONObject jSONObject);

    @Nullable
    Map<String, Object> getNativeAdBiddingData(@NotNull JSONObject jSONObject, @Nullable JSONObject jSONObject2);

    void initNativeAdForBidding(@Nullable String str, @Nullable String str2, @NotNull JSONObject jSONObject, @NotNull NativeAdSmashListener nativeAdSmashListener);

    void initNativeAds(@Nullable String str, @Nullable String str2, @NotNull JSONObject jSONObject, @NotNull NativeAdSmashListener nativeAdSmashListener);

    void loadNativeAd(@NotNull JSONObject jSONObject, @Nullable JSONObject jSONObject2, @NotNull NativeAdSmashListener nativeAdSmashListener);

    void loadNativeAdForBidding(@NotNull JSONObject jSONObject, @Nullable JSONObject jSONObject2, @Nullable String str, @NotNull NativeAdSmashListener nativeAdSmashListener);
}
