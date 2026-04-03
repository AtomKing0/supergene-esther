package com.ironsource.mediationsdk.adapter;

import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout;
import com.ironsource.mediationsdk.sdk.BannerAdapterInterface;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractBannerAdapter<AdNetworkAdapter> extends AbstractAdUnitAdapter<AdNetworkAdapter> implements BannerAdapterInterface {
    public AbstractBannerAdapter(AdNetworkAdapter adnetworkadapter) {
        super(adnetworkadapter);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void collectBannerBiddingData(@NotNull JSONObject config, @Nullable JSONObject jSONObject, @NotNull BiddingDataCallback biddingDataCallback) {
        t.i(config, "config");
        t.i(biddingDataCallback, "biddingDataCallback");
        Map<String, Object> bannerBiddingData = getBannerBiddingData(config, jSONObject);
        if (bannerBiddingData != null) {
            biddingDataCallback.onSuccess(bannerBiddingData);
        } else {
            biddingDataCallback.onFailure("bidding data map is null");
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void destroyBanner(@NotNull JSONObject config) {
        t.i(config, "config");
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public int getAdaptiveHeight(int i10) {
        return -1;
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    @Nullable
    public Map<String, Object> getBannerBiddingData(@NotNull JSONObject config, @Nullable JSONObject jSONObject) {
        t.i(config, "config");
        return null;
    }

    @Nullable
    public LoadWhileShowSupportState getBannerLoadWhileShowSupportState(@Nullable JSONObject jSONObject) {
        return LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void initBannerForBidding(@Nullable String str, @Nullable String str2, @NotNull JSONObject config, @NotNull BannerSmashListener listener) {
        t.i(config, "config");
        t.i(listener, "listener");
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void initBanners(@Nullable String str, @Nullable String str2, @NotNull JSONObject config, @NotNull BannerSmashListener listener) {
        t.i(config, "config");
        t.i(listener, "listener");
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBanner(@NotNull JSONObject config, @Nullable JSONObject jSONObject, @NotNull IronSourceBannerLayout banner, @NotNull BannerSmashListener listener) {
        t.i(config, "config");
        t.i(banner, "banner");
        t.i(listener, "listener");
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBannerForBidding(@NotNull JSONObject config, @Nullable JSONObject jSONObject, @Nullable String str, @NotNull IronSourceBannerLayout banner, @NotNull BannerSmashListener listener) {
        t.i(config, "config");
        t.i(banner, "banner");
        t.i(listener, "listener");
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBannerForDemandOnlyForBidding(@NotNull JSONObject config, @Nullable String str, @Nullable ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, @NotNull BannerSmashListener listener) {
        t.i(config, "config");
        t.i(listener, "listener");
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void onBannerViewBound(@NotNull JSONObject config) {
        t.i(config, "config");
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void onBannerViewWillBind(@NotNull JSONObject config) {
        t.i(config, "config");
    }
}
