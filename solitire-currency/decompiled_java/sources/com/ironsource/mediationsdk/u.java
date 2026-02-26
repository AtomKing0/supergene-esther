package com.ironsource.mediationsdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.hj;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.adunit.adapter.AdapterDebugInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAPSDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterConsentInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterMetaDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNetworkDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.BannerAdapterInterface;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.s7;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class u implements AdapterAPSDataInterface, AdapterBaseInterface, AdapterConsentInterface, AdapterDebugInterface, AdapterMetaDataInterface, AdapterSettingsInterface, BannerSmashListener, s7, InterstitialSmashListener, NativeAdSmashListener, RewardedVideoSmashListener, AdapterNetworkDataInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AbstractAdapter f13907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference<NetworkInitializationListener> f13908b;

    public u(AbstractAdapter abstractAdapter) {
        this.f13907a = abstractAdapter;
    }

    @Override // com.ironsource.s7
    public Map<String, Object> a(AdData adData) {
        JSONObject jSONObjectA = hj.a(adData.getConfiguration());
        JSONObject jSONObjectA2 = hj.a(adData.getAdUnitData());
        IronSource.AD_UNIT ad_unit = (IronSource.AD_UNIT) adData.getAdUnitData().get("adUnit");
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return this.f13907a.getRewardedVideoBiddingData(jSONObjectA, jSONObjectA2);
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            return this.f13907a.getInterstitialBiddingData(jSONObjectA, jSONObjectA2);
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            return this.f13907a.getBannerBiddingData(jSONObjectA, jSONObjectA2);
        }
        if (ad_unit == IronSource.AD_UNIT.NATIVE_AD) {
            return this.f13907a.getNativeAdBiddingData(jSONObjectA, jSONObjectA2);
        }
        IronLog.INTERNAL.error("ad unit not supported - " + ad_unit);
        return null;
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface
    @NotNull
    public String getAdapterVersion() {
        return this.f13907a.getVersion();
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface
    public LoadWhileShowSupportState getBannerLoadWhileShowSupportedState(NetworkSettings networkSettings) {
        return this.f13907a.getBannerLoadWhileShowSupportState(networkSettings.getBannerSettings());
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface
    public LoadWhileShowSupportState getLoadWhileShowSupportedState(NetworkSettings networkSettings) {
        return this.f13907a.getLoadWhileShowSupportState(networkSettings.getRewardedVideoSettings());
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface
    @Nullable
    public String getNetworkSDKVersion() {
        return this.f13907a.getCoreSDKVersion();
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface
    public void init(@NotNull AdData adData, @NotNull Context context, @Nullable NetworkInitializationListener networkInitializationListener) {
        this.f13908b = new WeakReference<>(networkInitializationListener);
        String str = (String) adData.getAdUnitData().get("userId");
        IronSource.AD_UNIT ad_unit = (IronSource.AD_UNIT) adData.getAdUnitData().get("adUnit");
        a();
        JSONObject jSONObjectA = hj.a(adData.getConfiguration());
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            this.f13907a.initRewardedVideoWithCallback("", str, jSONObjectA, this);
            return;
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            Integer num = adData.getInt("instanceType");
            if (num == null || num.intValue() != 1) {
                this.f13907a.initInterstitialForBidding("", str, jSONObjectA, this);
                return;
            } else {
                this.f13907a.initInterstitial("", str, jSONObjectA, this);
                return;
            }
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            Integer num2 = adData.getInt("instanceType");
            if (num2 == null || num2.intValue() != 1) {
                this.f13907a.initBannerForBidding("", str, jSONObjectA, this);
                return;
            } else {
                this.f13907a.initBanners("", str, jSONObjectA, this);
                return;
            }
        }
        if (ad_unit != IronSource.AD_UNIT.NATIVE_AD) {
            IronLog.INTERNAL.error("ad unit not supported - " + ad_unit);
            return;
        }
        Integer num3 = adData.getInt("instanceType");
        if (num3 == null || num3.intValue() != 1) {
            this.f13907a.initNativeAdForBidding("", str, jSONObjectA, this);
        } else {
            this.f13907a.initNativeAds("", str, jSONObjectA, this);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface
    public boolean isUsingActivityBeforeImpression(@NotNull IronSource.AD_UNIT ad_unit) {
        return this.f13907a.isUsingActivityBeforeImpression(ad_unit);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerInitFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.f13908b.get();
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.f13908b.get();
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialInitFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.f13908b.get();
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.f13908b.get();
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener
    public void onNativeAdInitFailed(@Nullable IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.f13908b.get();
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener
    public void onNativeAdInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.f13908b.get();
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.f13908b.get();
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.f13908b.get();
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAPSDataInterface
    public void setAPSData(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        BannerAdapterInterface bannerAdapterInterface = this.f13907a;
        if (bannerAdapterInterface instanceof SetAPSInterface) {
            ((SetAPSInterface) bannerAdapterInterface).setAPSData(ad_unit, jSONObject);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.AdapterDebugInterface
    public void setAdapterDebug(boolean z10) {
        this.f13907a.setAdapterDebug(Boolean.valueOf(z10));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterConsentInterface
    public void setConsent(boolean z10) {
        this.f13907a.setConsent(z10);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterMetaDataInterface
    public void setMetaData(String str, List<String> list) {
        this.f13907a.setMetaData(str, list);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNetworkDataInterface
    public void setNetworkData(@NotNull AdapterNetworkData adapterNetworkData) {
        this.f13907a.setNetworkData(adapterNetworkData);
    }

    void a() {
        String pluginType = ConfigFile.getConfigFile().getPluginType();
        if (TextUtils.isEmpty(pluginType)) {
            return;
        }
        this.f13907a.setPluginData(pluginType);
    }

    @Override // com.ironsource.s7
    public void a(AdData adData, @NotNull BiddingDataCallback biddingDataCallback) {
        JSONObject jSONObjectA = hj.a(adData.getConfiguration());
        JSONObject jSONObjectA2 = hj.a(adData.getAdUnitData());
        IronSource.AD_UNIT ad_unit = (IronSource.AD_UNIT) adData.getAdUnitData().get("adUnit");
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            this.f13907a.collectRewardedVideoBiddingData(jSONObjectA, jSONObjectA2, biddingDataCallback);
            return;
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            this.f13907a.collectInterstitialBiddingData(jSONObjectA, jSONObjectA2, biddingDataCallback);
            return;
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            this.f13907a.collectBannerBiddingData(jSONObjectA, jSONObjectA2, biddingDataCallback);
            return;
        }
        if (ad_unit == IronSource.AD_UNIT.NATIVE_AD) {
            this.f13907a.collectNativeAdBiddingData(jSONObjectA, jSONObjectA2, biddingDataCallback);
            return;
        }
        IronLog.INTERNAL.error("ad unit not supported - " + ad_unit);
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdClicked() {
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLeftApplication() {
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdScreenDismissed() {
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdScreenPresented() {
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdShown() {
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdClicked() {
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdClosed() {
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdOpened() {
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdReady() {
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdShowSucceeded() {
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdVisible() {
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener
    public void onNativeAdClicked() {
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener
    public void onNativeAdShown() {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdClicked() {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdClosed() {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdEnded() {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdOpened() {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdRewarded() {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdStarted() {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdVisible() {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadSuccess() {
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialSmashListener
    public void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener
    public void onNativeAdLoadFailed(@Nullable IronSourceError ironSourceError) {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoAvailabilityChanged(boolean z10) {
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener
    public void onRewardedVideoLoadFailed(IronSourceError ironSourceError) {
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerSmashListener
    public void onBannerAdLoaded(View view, FrameLayout.LayoutParams layoutParams) {
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener
    public void onNativeAdLoaded(@Nullable AdapterNativeAdData adapterNativeAdData, @Nullable AdapterNativeAdViewBinder adapterNativeAdViewBinder) {
    }
}
