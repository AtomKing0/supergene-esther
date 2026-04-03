package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import com.ironsource.kq;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.LogListener;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.InitializationListener;
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoManualListener;
import com.ironsource.mediationsdk.sdk.SegmentListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class IronSource {

    public enum AD_UNIT {
        REWARDED_VIDEO("rewardedVideo"),
        INTERSTITIAL("interstitial"),
        BANNER("banner"),
        NATIVE_AD(kq.f12892i);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f13250a;

        AD_UNIT(String str) {
            this.f13250a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f13250a;
        }
    }

    public static void addImpressionDataListener(@NotNull ImpressionDataListener impressionDataListener) {
        p.m().b(impressionDataListener);
    }

    public static void clearRewardedVideoServerParameters() {
        p.m().b();
    }

    @Deprecated
    public static IronSourceBannerLayout createBanner(Activity activity, ISBannerSize iSBannerSize) {
        return p.m().b(activity, iSBannerSize);
    }

    public static ISDemandOnlyBannerLayout createBannerForDemandOnly(Activity activity, ISBannerSize iSBannerSize) {
        return p.m().a(activity, iSBannerSize);
    }

    @Deprecated
    public static void destroyBanner(IronSourceBannerLayout ironSourceBannerLayout) {
        p.m().a(ironSourceBannerLayout);
    }

    public static void destroyISDemandOnlyBanner(String str) {
        p.m().c(str);
    }

    public static String getAdvertiserId(Context context) {
        return p.m().b(context);
    }

    public static synchronized String getISDemandOnlyBiddingData(Context context) {
        return p.m().a(context);
    }

    public static InterstitialPlacement getInterstitialPlacementInfo(String str) {
        return p.m().g(str);
    }

    public static Placement getRewardedVideoPlacementInfo(String str) {
        return p.m().i(str);
    }

    public static void init(Context context, String str) {
        init(context, str, (AD_UNIT[]) null);
    }

    @Deprecated
    public static void initISDemandOnly(@NotNull Context context, String str, AD_UNIT... ad_unitArr) {
        p.m().a(context, str, ad_unitArr);
    }

    @Deprecated
    public static boolean isBannerPlacementCapped(String str) {
        return p.m().q(str);
    }

    public static boolean isISDemandOnlyInterstitialReady(String str) {
        return p.m().f(str);
    }

    public static boolean isISDemandOnlyRewardedVideoAvailable(String str) {
        return p.m().j(str);
    }

    public static boolean isInterstitialPlacementCapped(String str) {
        return p.m().r(str);
    }

    public static boolean isInterstitialReady() {
        return p.m().F();
    }

    public static boolean isRewardedVideoAvailable() {
        return p.m().K();
    }

    public static boolean isRewardedVideoPlacementCapped(String str) {
        return p.m().s(str);
    }

    public static void launchTestSuite(@NotNull Context context) {
        p.m().c(context);
    }

    @Deprecated
    public static void loadBanner(IronSourceBannerLayout ironSourceBannerLayout) {
        p.m().b(ironSourceBannerLayout);
    }

    public static void loadISDemandOnlyBanner(@NotNull Activity activity, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str) {
        p.m().a(activity, iSDemandOnlyBannerLayout, str);
    }

    public static void loadISDemandOnlyBannerWithAdm(@NotNull Activity activity, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str, String str2) {
        p.m().a(activity, iSDemandOnlyBannerLayout, str, str2);
    }

    public static void loadISDemandOnlyInterstitial(@NotNull Activity activity, String str) {
        p.m().a(activity, str);
    }

    @Deprecated
    public static void loadISDemandOnlyInterstitialWithAdm(@NotNull Activity activity, String str, String str2) {
        p.m().b(activity, str, str2);
    }

    public static void loadISDemandOnlyRewardedVideo(@NotNull Activity activity, String str) {
        p.m().b(activity, str);
    }

    @Deprecated
    public static void loadISDemandOnlyRewardedVideoWithAdm(@NotNull Activity activity, String str, String str2) {
        p.m().a(activity, str, str2);
    }

    public static void loadInterstitial() {
        p.m().P();
    }

    public static void loadRewardedVideo() {
        p.m().Q();
    }

    public static void onPause(Activity activity) {
        p.m().a(activity);
    }

    public static void onResume(Activity activity) {
        p.m().b(activity);
    }

    public static void removeImpressionDataListener(@NotNull ImpressionDataListener impressionDataListener) {
        p.m().a(impressionDataListener);
    }

    public static void removeInterstitialListener() {
        p.m().d();
    }

    public static void removeRewardedVideoListener() {
        p.m().c();
    }

    public static void setAdRevenueData(@NotNull String str, @NotNull JSONObject jSONObject) {
        p.m().a(str, jSONObject);
    }

    public static void setAdaptersDebug(boolean z10) {
        p.m().a(z10);
    }

    public static void setConsent(boolean z10) {
        p.m().b(z10);
    }

    public static boolean setDynamicUserId(String str) {
        return p.m().e(str);
    }

    public static void setISDemandOnlyInterstitialListener(ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        p.m().a(iSDemandOnlyInterstitialListener);
    }

    public static void setISDemandOnlyRewardedVideoListener(ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
        p.m().a(iSDemandOnlyRewardedVideoListener);
    }

    public static void setLevelPlayInterstitialListener(LevelPlayInterstitialListener levelPlayInterstitialListener) {
        p.m().a(levelPlayInterstitialListener);
    }

    public static void setLevelPlayRewardedVideoListener(LevelPlayRewardedVideoListener levelPlayRewardedVideoListener) {
        p.m().a(levelPlayRewardedVideoListener);
    }

    public static void setLevelPlayRewardedVideoManualListener(LevelPlayRewardedVideoManualListener levelPlayRewardedVideoManualListener) {
        p.m().a(levelPlayRewardedVideoManualListener);
    }

    public static void setLogListener(LogListener logListener) {
        p.m().a(logListener);
    }

    public static void setMediationType(String str) {
        p.m().h(str);
    }

    public static void setMetaData(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        p.m().a(str, arrayList);
    }

    public static void setNetworkData(@NotNull String str, @NotNull JSONObject jSONObject) {
        p.m().b(str, jSONObject);
    }

    public static void setRewardedVideoServerParameters(Map<String, String> map) {
        p.m().a(map);
    }

    public static void setSegment(IronSourceSegment ironSourceSegment) {
        p.m().a(ironSourceSegment);
    }

    public static void setSegmentListener(SegmentListener segmentListener) {
        p.m().a(segmentListener);
    }

    public static void setUserId(String str) {
        p.m().t(str);
    }

    public static void setWaterfallConfiguration(@NotNull WaterfallConfiguration waterfallConfiguration, @NotNull AD_UNIT ad_unit) {
        p.m().a(ad_unit, waterfallConfiguration);
    }

    public static void shouldTrackNetworkState(Context context, boolean z10) {
        p.m().a(context, z10);
    }

    public static void showISDemandOnlyInterstitial(String str) {
        p.m().b(str);
    }

    public static void showISDemandOnlyRewardedVideo(String str) {
        p.m().a(str);
    }

    public static void showInterstitial() {
        p.m().c((Activity) null);
    }

    public static void showRewardedVideo() {
        p.m().d((Activity) null);
    }

    public static void init(Context context, String str, InitializationListener initializationListener) {
        init(context, str, initializationListener, null);
    }

    @Deprecated
    public static void loadBanner(IronSourceBannerLayout ironSourceBannerLayout, String str) {
        p.m().a(ironSourceBannerLayout, str);
    }

    public static void setMetaData(String str, List<String> list) {
        p.m().a(str, list);
    }

    public static void showInterstitial(@NotNull Activity activity) {
        p.m().c(activity);
    }

    public static void showRewardedVideo(@NotNull Activity activity) {
        p.m().d(activity);
    }

    public static void init(Context context, String str, InitializationListener initializationListener, AD_UNIT... ad_unitArr) {
        p.m().a(context, str, false, initializationListener, ad_unitArr);
    }

    public static void showInterstitial(@NotNull Activity activity, String str) {
        p.m().c(activity, str);
    }

    public static void showRewardedVideo(@NotNull Activity activity, String str) {
        p.m().f(activity, str);
    }

    public static void init(Context context, String str, AD_UNIT... ad_unitArr) {
        p.m().a(context, str, false, (InitializationListener) null, ad_unitArr);
    }

    public static void showInterstitial(String str) {
        p.m().c(null, str);
    }

    public static void showRewardedVideo(String str) {
        p.m().f(null, str);
    }
}
