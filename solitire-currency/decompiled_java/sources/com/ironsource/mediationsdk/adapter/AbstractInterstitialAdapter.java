package com.ironsource.mediationsdk.adapter;

import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractInterstitialAdapter<AdNetworkAdapter> extends AbstractAdUnitAdapter<AdNetworkAdapter> implements InterstitialAdapterInterface {
    public AbstractInterstitialAdapter(AdNetworkAdapter adnetworkadapter) {
        super(adnetworkadapter);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void collectInterstitialBiddingData(@NotNull JSONObject config, @Nullable JSONObject jSONObject, @NotNull BiddingDataCallback biddingDataCallback) {
        t.i(config, "config");
        t.i(biddingDataCallback, "biddingDataCallback");
        Map<String, Object> interstitialBiddingData = getInterstitialBiddingData(config, jSONObject);
        if (interstitialBiddingData != null) {
            biddingDataCallback.onSuccess(interstitialBiddingData);
        } else {
            biddingDataCallback.onFailure("bidding data map is null");
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    @Nullable
    public Map<String, Object> getInterstitialBiddingData(@NotNull JSONObject config, @Nullable JSONObject jSONObject) {
        t.i(config, "config");
        return null;
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitial(@Nullable String str, @Nullable String str2, @NotNull JSONObject config, @NotNull InterstitialSmashListener listener) {
        t.i(config, "config");
        t.i(listener, "listener");
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitialForBidding(@Nullable String str, @Nullable String str2, @NotNull JSONObject config, @NotNull InterstitialSmashListener listener) {
        t.i(config, "config");
        t.i(listener, "listener");
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public boolean isInterstitialReady(@NotNull JSONObject config) {
        t.i(config, "config");
        return false;
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitial(@NotNull JSONObject config, @Nullable JSONObject jSONObject, @NotNull InterstitialSmashListener listener) {
        t.i(config, "config");
        t.i(listener, "listener");
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitialForBidding(@NotNull JSONObject config, @Nullable JSONObject jSONObject, @Nullable String str, @NotNull InterstitialSmashListener listener) {
        t.i(config, "config");
        t.i(listener, "listener");
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void showInterstitial(@NotNull JSONObject config, @NotNull InterstitialSmashListener listener) {
        t.i(config, "config");
        t.i(listener, "listener");
    }
}
