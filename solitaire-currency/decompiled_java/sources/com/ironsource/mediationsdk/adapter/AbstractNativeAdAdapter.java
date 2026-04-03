package com.ironsource.mediationsdk.adapter;

import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.NativeAdProperties;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractNativeAdAdapter<AdNetworkAdapter> extends AbstractAdUnitAdapter<AdNetworkAdapter> implements NativeAdAdapterInterface {
    public AbstractNativeAdAdapter(AdNetworkAdapter adnetworkadapter) {
        super(adnetworkadapter);
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void collectNativeAdBiddingData(@NotNull JSONObject config, @Nullable JSONObject jSONObject, @NotNull BiddingDataCallback biddingDataCallback) {
        t.i(config, "config");
        t.i(biddingDataCallback, "biddingDataCallback");
        Map<String, Object> nativeAdBiddingData = getNativeAdBiddingData(config, jSONObject);
        if (nativeAdBiddingData != null) {
            biddingDataCallback.onSuccess(nativeAdBiddingData);
        } else {
            biddingDataCallback.onFailure("bidding data map is null");
        }
    }

    public void destroyNativeAd(@NotNull JSONObject config) {
        t.i(config, "config");
    }

    @Nullable
    public Map<String, Object> getNativeAdBiddingData(@NotNull JSONObject config, @Nullable JSONObject jSONObject) {
        t.i(config, "config");
        return null;
    }

    @NotNull
    public final NativeAdProperties getNativeAdProperties(@NotNull JSONObject config) {
        t.i(config, "config");
        return new NativeAdProperties(config);
    }

    public void initNativeAdForBidding(@Nullable String str, @Nullable String str2, @NotNull JSONObject config, @NotNull NativeAdSmashListener listener) {
        t.i(config, "config");
        t.i(listener, "listener");
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void initNativeAds(@Nullable String str, @Nullable String str2, @NotNull JSONObject config, @NotNull NativeAdSmashListener listener) {
        t.i(config, "config");
        t.i(listener, "listener");
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void loadNativeAd(@NotNull JSONObject config, @Nullable JSONObject jSONObject, @NotNull NativeAdSmashListener listener) {
        t.i(config, "config");
        t.i(listener, "listener");
    }

    public void loadNativeAdForBidding(@NotNull JSONObject config, @Nullable JSONObject jSONObject, @Nullable String str, @NotNull NativeAdSmashListener listener) {
        t.i(config, "config");
        t.i(listener, "listener");
    }
}
