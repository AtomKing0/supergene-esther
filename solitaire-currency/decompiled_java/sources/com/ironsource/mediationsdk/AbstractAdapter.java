package com.ironsource.mediationsdk;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.i9;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNetworkDataInterface;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.AdUnitAdapterInterface;
import com.ironsource.mediationsdk.sdk.BannerAdapterInterface;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractAdapter implements RewardedVideoAdapterInterface, InterstitialAdapterInterface, BannerAdapterInterface, NativeAdAdapterInterface, AdapterNetworkDataInterface {
    private static Boolean mAdapterDebug;
    private String mPluginType;
    private final String mProviderName;
    private String mProviderNetworkKey;
    private final Map<IronSource.AD_UNIT, AdUnitAdapterInterface> mAdUnitAdapters = new HashMap();
    protected LoadWhileShowSupportState mLWSSupportState = LoadWhileShowSupportState.NONE;
    protected LoadWhileShowSupportState mBannerLoadWhileShowSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;

    public AbstractAdapter(String str) {
        this.mProviderName = str;
    }

    private BannerAdapterInterface getBannerAdapter() {
        return (BannerAdapterInterface) this.mAdUnitAdapters.get(IronSource.AD_UNIT.BANNER);
    }

    private InterstitialAdapterInterface getInterstitialAdapter() {
        return (InterstitialAdapterInterface) this.mAdUnitAdapters.get(IronSource.AD_UNIT.INTERSTITIAL);
    }

    private NativeAdAdapterInterface getNativeAdAdapter() {
        return (NativeAdAdapterInterface) this.mAdUnitAdapters.get(IronSource.AD_UNIT.NATIVE_AD);
    }

    private RewardedVideoAdapterInterface getRewardedVideoAdapter() {
        return (RewardedVideoAdapterInterface) this.mAdUnitAdapters.get(IronSource.AD_UNIT.REWARDED_VIDEO);
    }

    public static void postBackgroundThread(Runnable runnable) {
        IronSourceThreadManager.INSTANCE.postAdapterBackgroundTask(runnable);
    }

    public static void postOnUIThread(Runnable runnable) {
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(runnable);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void collectBannerBiddingData(JSONObject jSONObject, JSONObject jSONObject2, @NotNull BiddingDataCallback biddingDataCallback) {
        BannerAdapterInterface bannerAdapter = getBannerAdapter();
        if (bannerAdapter != null) {
            bannerAdapter.collectBannerBiddingData(jSONObject, jSONObject2, biddingDataCallback);
            return;
        }
        Map<String, Object> bannerBiddingData = getBannerBiddingData(jSONObject, jSONObject2);
        if (bannerBiddingData != null) {
            biddingDataCallback.onSuccess(bannerBiddingData);
        } else {
            biddingDataCallback.onFailure("bidding data map is null");
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void collectInterstitialBiddingData(JSONObject jSONObject, JSONObject jSONObject2, @NotNull BiddingDataCallback biddingDataCallback) {
        InterstitialAdapterInterface interstitialAdapter = getInterstitialAdapter();
        if (interstitialAdapter != null) {
            interstitialAdapter.collectInterstitialBiddingData(jSONObject, jSONObject2, biddingDataCallback);
            return;
        }
        Map<String, Object> interstitialBiddingData = getInterstitialBiddingData(jSONObject, jSONObject2);
        if (interstitialBiddingData != null) {
            biddingDataCallback.onSuccess(interstitialBiddingData);
        } else {
            biddingDataCallback.onFailure("bidding data map is null");
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void collectNativeAdBiddingData(@NotNull JSONObject jSONObject, JSONObject jSONObject2, @NotNull BiddingDataCallback biddingDataCallback) {
        NativeAdAdapterInterface nativeAdAdapter = getNativeAdAdapter();
        if (nativeAdAdapter != null) {
            nativeAdAdapter.collectNativeAdBiddingData(jSONObject, jSONObject2, biddingDataCallback);
            return;
        }
        Map<String, Object> nativeAdBiddingData = getNativeAdBiddingData(jSONObject, jSONObject2);
        if (nativeAdBiddingData != null) {
            biddingDataCallback.onSuccess(nativeAdBiddingData);
        } else {
            biddingDataCallback.onFailure("bidding data map is null");
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void collectRewardedVideoBiddingData(JSONObject jSONObject, JSONObject jSONObject2, @NotNull BiddingDataCallback biddingDataCallback) {
        RewardedVideoAdapterInterface rewardedVideoAdapter = getRewardedVideoAdapter();
        if (rewardedVideoAdapter != null) {
            rewardedVideoAdapter.collectRewardedVideoBiddingData(jSONObject, jSONObject2, biddingDataCallback);
            return;
        }
        Map<String, Object> rewardedVideoBiddingData = getRewardedVideoBiddingData(jSONObject, jSONObject2);
        if (rewardedVideoBiddingData != null) {
            biddingDataCallback.onSuccess(rewardedVideoBiddingData);
        } else {
            biddingDataCallback.onFailure("bidding data map is null");
        }
    }

    public void destroyBanner(JSONObject jSONObject) {
        BannerAdapterInterface bannerAdapter = getBannerAdapter();
        if (bannerAdapter != null) {
            bannerAdapter.destroyBanner(jSONObject);
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void destroyNativeAd(@NotNull JSONObject jSONObject) {
        NativeAdAdapterInterface nativeAdAdapter = getNativeAdAdapter();
        if (nativeAdAdapter != null) {
            nativeAdAdapter.destroyNativeAd(jSONObject);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public int getAdaptiveHeight(int i10) {
        BannerAdapterInterface bannerAdapter = getBannerAdapter();
        if (bannerAdapter != null) {
            return bannerAdapter.getAdaptiveHeight(i10);
        }
        return -1;
    }

    public Map<String, Object> getBannerBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        BannerAdapterInterface bannerAdapter = getBannerAdapter();
        if (bannerAdapter != null) {
            return bannerAdapter.getBannerBiddingData(jSONObject, jSONObject2);
        }
        return null;
    }

    public LoadWhileShowSupportState getBannerLoadWhileShowSupportState(JSONObject jSONObject) {
        return this.mBannerLoadWhileShowSupportState;
    }

    public abstract String getCoreSDKVersion();

    public String getDynamicUserId() {
        return p.m().l();
    }

    public Map<String, Object> getInterstitialBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        InterstitialAdapterInterface interstitialAdapter = getInterstitialAdapter();
        if (interstitialAdapter != null) {
            return interstitialAdapter.getInterstitialBiddingData(jSONObject, jSONObject2);
        }
        return null;
    }

    public LoadWhileShowSupportState getLoadWhileShowSupportState(JSONObject jSONObject) {
        return this.mLWSSupportState;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public Map<String, Object> getNativeAdBiddingData(@NotNull JSONObject jSONObject, JSONObject jSONObject2) {
        NativeAdAdapterInterface nativeAdAdapter = getNativeAdAdapter();
        if (nativeAdAdapter != null) {
            return nativeAdAdapter.getNativeAdBiddingData(jSONObject, jSONObject2);
        }
        return null;
    }

    public String getPluginType() {
        return this.mPluginType;
    }

    public String getProviderName() {
        return this.mProviderName;
    }

    public String getProviderNetworkKey() {
        return this.mProviderNetworkKey;
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public Map<String, Object> getRewardedVideoBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        RewardedVideoAdapterInterface rewardedVideoAdapter = getRewardedVideoAdapter();
        if (rewardedVideoAdapter != null) {
            return rewardedVideoAdapter.getRewardedVideoBiddingData(jSONObject, jSONObject2);
        }
        return null;
    }

    public abstract String getVersion();

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initAndLoadRewardedVideo(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        try {
            RewardedVideoAdapterInterface rewardedVideoAdapter = getRewardedVideoAdapter();
            if (rewardedVideoAdapter != null) {
                rewardedVideoAdapter.initAndLoadRewardedVideo(str, str2, jSONObject, jSONObject2, rewardedVideoSmashListener);
            } else if (rewardedVideoSmashListener != null) {
                rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            }
        } catch (Error e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error("provider -" + this.mProviderName + " error - " + e10.getMessage());
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        }
    }

    public void initBannerForBidding(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        try {
            BannerAdapterInterface bannerAdapter = getBannerAdapter();
            if (bannerAdapter != null) {
                bannerAdapter.initBannerForBidding(str, str2, jSONObject, bannerSmashListener);
            } else if (bannerSmashListener != null) {
                bannerSmashListener.onBannerInitFailed(new IronSourceError(510, "method not implemented"));
            }
        } catch (Error e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error("provider -" + this.mProviderName + " error - " + e10.getMessage());
            StringBuilder sb = new StringBuilder();
            sb.append("error - ");
            sb.append(e10.getMessage());
            bannerSmashListener.onBannerInitFailed(new IronSourceError(510, sb.toString()));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void initBanners(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        try {
            BannerAdapterInterface bannerAdapter = getBannerAdapter();
            if (bannerAdapter != null) {
                bannerAdapter.initBanners(str, str2, jSONObject, bannerSmashListener);
            } else if (bannerSmashListener != null) {
                bannerSmashListener.onBannerInitFailed(new IronSourceError(510, "method not implemented"));
            }
        } catch (Error e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error("provider -" + this.mProviderName + " error - " + e10.getMessage());
            StringBuilder sb = new StringBuilder();
            sb.append("error - ");
            sb.append(e10.getMessage());
            bannerSmashListener.onBannerInitFailed(new IronSourceError(510, sb.toString()));
        }
    }

    public void initInterstitial(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        try {
            InterstitialAdapterInterface interstitialAdapter = getInterstitialAdapter();
            if (interstitialAdapter != null) {
                interstitialAdapter.initInterstitial(str, str2, jSONObject, interstitialSmashListener);
            } else if (interstitialSmashListener != null) {
                interstitialSmashListener.onInterstitialInitFailed(new IronSourceError(510, "method not implemented"));
            }
        } catch (Error e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error("provider -" + this.mProviderName + " error - " + e10.getMessage());
            StringBuilder sb = new StringBuilder();
            sb.append("error - ");
            sb.append(e10.getMessage());
            interstitialSmashListener.onInterstitialInitFailed(new IronSourceError(510, sb.toString()));
        }
    }

    public void initInterstitialForBidding(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        try {
            InterstitialAdapterInterface interstitialAdapter = getInterstitialAdapter();
            if (interstitialAdapter != null) {
                interstitialAdapter.initInterstitialForBidding(str, str2, jSONObject, interstitialSmashListener);
            } else if (interstitialSmashListener != null) {
                interstitialSmashListener.onInterstitialInitFailed(new IronSourceError(510, "method not implemented"));
            }
        } catch (Error e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error("provider -" + this.mProviderName + " error - " + e10.getMessage());
            StringBuilder sb = new StringBuilder();
            sb.append("error - ");
            sb.append(e10.getMessage());
            interstitialSmashListener.onInterstitialInitFailed(new IronSourceError(510, sb.toString()));
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void initNativeAdForBidding(String str, String str2, @NotNull JSONObject jSONObject, @NotNull NativeAdSmashListener nativeAdSmashListener) {
        NativeAdAdapterInterface nativeAdAdapter = getNativeAdAdapter();
        if (nativeAdAdapter != null) {
            nativeAdAdapter.initNativeAdForBidding(str, str2, jSONObject, nativeAdSmashListener);
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void initNativeAds(String str, String str2, @NotNull JSONObject jSONObject, @NotNull NativeAdSmashListener nativeAdSmashListener) {
        NativeAdAdapterInterface nativeAdAdapter = getNativeAdAdapter();
        if (nativeAdAdapter != null) {
            nativeAdAdapter.initNativeAds(str, str2, jSONObject, nativeAdSmashListener);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initRewardedVideoForDemandOnly(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        RewardedVideoAdapterInterface rewardedVideoAdapter = getRewardedVideoAdapter();
        if (rewardedVideoAdapter != null) {
            rewardedVideoAdapter.initRewardedVideoForDemandOnly(str, str2, jSONObject, rewardedVideoSmashListener);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initRewardedVideoWithCallback(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        try {
            RewardedVideoAdapterInterface rewardedVideoAdapter = getRewardedVideoAdapter();
            if (rewardedVideoAdapter != null) {
                rewardedVideoAdapter.initRewardedVideoWithCallback(str, str2, jSONObject, rewardedVideoSmashListener);
            } else if (rewardedVideoSmashListener != null) {
                rewardedVideoSmashListener.onRewardedVideoInitFailed(new IronSourceError(510, "method not implemented"));
            }
        } catch (Error e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error("provider -" + this.mProviderName + " error - " + e10.getMessage());
            StringBuilder sb = new StringBuilder();
            sb.append("error - ");
            sb.append(e10.getMessage());
            rewardedVideoSmashListener.onRewardedVideoInitFailed(new IronSourceError(510, sb.toString()));
        }
    }

    protected boolean isAdaptersDebugEnabled() {
        Boolean bool = mAdapterDebug;
        return bool != null && bool.booleanValue();
    }

    public boolean isInterstitialReady(JSONObject jSONObject) {
        InterstitialAdapterInterface interstitialAdapter = getInterstitialAdapter();
        if (interstitialAdapter != null) {
            return interstitialAdapter.isInterstitialReady(jSONObject);
        }
        return false;
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        RewardedVideoAdapterInterface rewardedVideoAdapter = getRewardedVideoAdapter();
        if (rewardedVideoAdapter != null) {
            return rewardedVideoAdapter.isRewardedVideoAvailable(jSONObject);
        }
        return false;
    }

    public boolean isUsingActivityBeforeImpression(@NotNull IronSource.AD_UNIT ad_unit) {
        return true;
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBanner(JSONObject jSONObject, JSONObject jSONObject2, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener) {
        BannerAdapterInterface bannerAdapter = getBannerAdapter();
        if (bannerAdapter != null) {
            bannerAdapter.loadBanner(jSONObject, jSONObject2, ironSourceBannerLayout, bannerSmashListener);
        }
    }

    public void loadBannerForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener) {
        BannerAdapterInterface bannerAdapter = getBannerAdapter();
        if (bannerAdapter != null) {
            bannerAdapter.loadBannerForBidding(jSONObject, jSONObject2, str, ironSourceBannerLayout, bannerSmashListener);
        }
    }

    public void loadBannerForDemandOnlyForBidding(JSONObject jSONObject, String str, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, BannerSmashListener bannerSmashListener) {
        BannerAdapterInterface bannerAdapter = getBannerAdapter();
        if (bannerAdapter != null) {
            bannerAdapter.loadBannerForDemandOnlyForBidding(jSONObject, str, iSDemandOnlyBannerLayout, bannerSmashListener);
        }
    }

    public void loadInterstitial(JSONObject jSONObject, JSONObject jSONObject2, InterstitialSmashListener interstitialSmashListener) {
        InterstitialAdapterInterface interstitialAdapter = getInterstitialAdapter();
        if (interstitialAdapter != null) {
            interstitialAdapter.loadInterstitial(jSONObject, jSONObject2, interstitialSmashListener);
        }
    }

    public void loadInterstitialForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, InterstitialSmashListener interstitialSmashListener) {
        InterstitialAdapterInterface interstitialAdapter = getInterstitialAdapter();
        if (interstitialAdapter != null) {
            interstitialAdapter.loadInterstitialForBidding(jSONObject, jSONObject2, str, interstitialSmashListener);
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void loadNativeAd(@NotNull JSONObject jSONObject, JSONObject jSONObject2, @NotNull NativeAdSmashListener nativeAdSmashListener) {
        NativeAdAdapterInterface nativeAdAdapter = getNativeAdAdapter();
        if (nativeAdAdapter != null) {
            nativeAdAdapter.loadNativeAd(jSONObject, jSONObject2, nativeAdSmashListener);
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void loadNativeAdForBidding(@NotNull JSONObject jSONObject, JSONObject jSONObject2, String str, @NotNull NativeAdSmashListener nativeAdSmashListener) {
        NativeAdAdapterInterface nativeAdAdapter = getNativeAdAdapter();
        if (nativeAdAdapter != null) {
            nativeAdAdapter.loadNativeAdForBidding(jSONObject, jSONObject2, str, nativeAdSmashListener);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideo(JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        RewardedVideoAdapterInterface rewardedVideoAdapter = getRewardedVideoAdapter();
        if (rewardedVideoAdapter != null) {
            rewardedVideoAdapter.loadRewardedVideo(jSONObject, jSONObject2, rewardedVideoSmashListener);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideoForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, RewardedVideoSmashListener rewardedVideoSmashListener) {
        RewardedVideoAdapterInterface rewardedVideoAdapter = getRewardedVideoAdapter();
        if (rewardedVideoAdapter != null) {
            rewardedVideoAdapter.loadRewardedVideoForBidding(jSONObject, jSONObject2, str, rewardedVideoSmashListener);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void onBannerViewBound(@NotNull JSONObject jSONObject) {
        BannerAdapterInterface bannerAdapter = getBannerAdapter();
        if (bannerAdapter != null) {
            bannerAdapter.onBannerViewBound(jSONObject);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void onBannerViewWillBind(@NotNull JSONObject jSONObject) {
        BannerAdapterInterface bannerAdapter = getBannerAdapter();
        if (bannerAdapter != null) {
            bannerAdapter.onBannerViewWillBind(jSONObject);
        }
    }

    @Override // com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String str) {
        Iterator<AdUnitAdapterInterface> it = this.mAdUnitAdapters.values().iterator();
        while (it.hasNext()) {
            it.next().onNetworkInitCallbackFailed(str);
        }
    }

    @Override // com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        Iterator<AdUnitAdapterInterface> it = this.mAdUnitAdapters.values().iterator();
        while (it.hasNext()) {
            it.next().onNetworkInitCallbackSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.ReleaseMemoryAdapterInterface
    public void releaseMemory(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("adUnit = " + ad_unit);
        AdUnitAdapterInterface adUnitAdapterInterface = this.mAdUnitAdapters.get(ad_unit);
        if (adUnitAdapterInterface != null) {
            adUnitAdapterInterface.releaseMemory(ad_unit, jSONObject);
            return;
        }
        ironLog.verbose(ad_unit + " adapter is null");
    }

    protected void setAdapterDebug(Boolean bool) {
        mAdapterDebug = bool;
    }

    protected void setBannerAdapter(BannerAdapterInterface bannerAdapterInterface) {
        this.mAdUnitAdapters.put(IronSource.AD_UNIT.BANNER, bannerAdapterInterface);
    }

    protected void setInterstitialAdapter(InterstitialAdapterInterface interstitialAdapterInterface) {
        this.mAdUnitAdapters.put(IronSource.AD_UNIT.INTERSTITIAL, interstitialAdapterInterface);
    }

    protected void setNativeAdAdapter(NativeAdAdapterInterface nativeAdAdapterInterface) {
        this.mAdUnitAdapters.put(IronSource.AD_UNIT.NATIVE_AD, nativeAdAdapterInterface);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNetworkDataInterface
    public void setNetworkData(@NotNull AdapterNetworkData adapterNetworkData) {
        IronLog.INTERNAL.verbose("setNetworkData not implemented | adapter=" + getClass().getSimpleName() + ", networkData=" + adapterNetworkData);
    }

    public void setNewConsent(boolean z10) {
        setConsent(z10);
    }

    public void setPluginData(String str) {
        this.mPluginType = str;
    }

    public void setProviderNetworkKey(String str) {
        this.mProviderNetworkKey = str;
    }

    protected void setRewardedVideoAdapter(RewardedVideoAdapterInterface rewardedVideoAdapterInterface) {
        this.mAdUnitAdapters.put(IronSource.AD_UNIT.REWARDED_VIDEO, rewardedVideoAdapterInterface);
    }

    public void showInterstitial(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        InterstitialAdapterInterface interstitialAdapter = getInterstitialAdapter();
        if (interstitialAdapter != null) {
            interstitialAdapter.showInterstitial(jSONObject, interstitialSmashListener);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void showRewardedVideo(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        RewardedVideoAdapterInterface rewardedVideoAdapter = getRewardedVideoAdapter();
        if (rewardedVideoAdapter != null) {
            rewardedVideoAdapter.showRewardedVideo(jSONObject, rewardedVideoSmashListener);
        }
    }

    protected void setConsent(boolean z10) {
    }

    protected void setMetaData(String str, List<String> list) {
    }

    public void earlyInit(String str, String str2, JSONObject jSONObject) {
    }
}
