package com.google.ads.mediation.vungle;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.ads.mediation.vungle.c;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.VersionInfo;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.vungle.ads.b2;
import com.vungle.ads.q1;
import com.vungle.ads.s1;
import com.vungle.ads.u;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import u1.e;

/* JADX INFO: loaded from: classes2.dex */
public class VungleMediationAdapter extends RtbAdapter implements MediationRewardedAd, s1 {
    public static final int ERROR_CANNOT_GET_BID_TOKEN = 108;
    public static final int ERROR_CANNOT_PLAY_AD = 107;
    public static final String ERROR_DOMAIN = "com.google.ads.mediation.vungle";
    public static final int ERROR_INITIALIZATION_FAILURE = 105;
    public static final int ERROR_INVALID_SERVER_PARAMETERS = 101;
    public static final int ERROR_REQUIRES_ACTIVITY_CONTEXT = 103;
    public static final String TAG = "VungleMediationAdapter";
    public static final String VUNGLE_SDK_ERROR_DOMAIN = "com.vungle.ads";
    private com.vungle.ads.c adConfig;
    private MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback;
    private MediationRewardedAdCallback mediationRewardedAdCallback;
    private q1 rewardedAd;
    private u1.a rtbAppOpenAd;
    private u1.b rtbBannerAd;
    private u1.c rtbInterstitialAd;
    private u1.d rtbNativeAd;
    private e rtbRewardedAd;
    private e rtbRewardedInterstitialAd;
    private String userId;
    private final com.google.ads.mediation.vungle.b vungleFactory;
    private v1.a waterfallAppOpenAd;

    class a implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InitializationCompleteCallback f8399a;

        a(InitializationCompleteCallback initializationCompleteCallback) {
            this.f8399a = initializationCompleteCallback;
        }

        @Override // com.google.ads.mediation.vungle.c.a
        public void a(AdError adError) {
            Log.w(VungleMediationAdapter.TAG, adError.toString());
            this.f8399a.onInitializationFailed(adError.toString());
        }

        @Override // com.google.ads.mediation.vungle.c.a
        public void onInitializeSuccess() {
            this.f8399a.onInitializationSucceeded();
        }
    }

    class b implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f8401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f8402b;

        b(Context context, String str) {
            this.f8401a = context;
            this.f8402b = str;
        }

        @Override // com.google.ads.mediation.vungle.c.a
        public void a(AdError adError) {
            Log.w(VungleMediationAdapter.TAG, adError.toString());
            VungleMediationAdapter.this.mediationAdLoadCallback.onFailure(adError);
        }

        @Override // com.google.ads.mediation.vungle.c.a
        public void onInitializeSuccess() {
            VungleMediationAdapter vungleMediationAdapter = VungleMediationAdapter.this;
            vungleMediationAdapter.rewardedAd = vungleMediationAdapter.vungleFactory.e(this.f8401a, this.f8402b, VungleMediationAdapter.this.adConfig);
            VungleMediationAdapter.this.rewardedAd.setAdListener(VungleMediationAdapter.this);
            if (!TextUtils.isEmpty(VungleMediationAdapter.this.userId)) {
                VungleMediationAdapter.this.rewardedAd.setUserId(VungleMediationAdapter.this.userId);
            }
            VungleMediationAdapter.this.rewardedAd.load(null);
        }
    }

    public static class c implements RewardItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f8405b;

        public c(String str, int i10) {
            this.f8404a = str;
            this.f8405b = i10;
        }

        @Override // com.google.android.gms.ads.rewarded.RewardItem
        public int getAmount() {
            return this.f8405b;
        }

        @Override // com.google.android.gms.ads.rewarded.RewardItem
        @NonNull
        public String getType() {
            return this.f8404a;
        }
    }

    public VungleMediationAdapter() {
        this.vungleFactory = new com.google.ads.mediation.vungle.b();
    }

    @NonNull
    public static AdError getAdError(@NonNull b2 b2Var) {
        return new AdError(b2Var.getCode(), b2Var.getErrorMessage(), VUNGLE_SDK_ERROR_DOMAIN);
    }

    static String getAdapterVersion() {
        return "7.4.2.0";
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void collectSignals(@NonNull RtbSignalData rtbSignalData, @NonNull SignalCallbacks signalCallbacks) {
        String strB = d.f8413b.b(rtbSignalData.getContext());
        if (TextUtils.isEmpty(strB)) {
            AdError adError = new AdError(108, "Liftoff Monetize returned an empty bid token.", ERROR_DOMAIN);
            Log.w(TAG, adError.toString());
            signalCallbacks.onFailure(adError);
        } else {
            Log.d(TAG, "Liftoff Monetize bidding token=" + strB);
            signalCallbacks.onSuccess(strB);
        }
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    @NonNull
    public VersionInfo getSDKVersionInfo() {
        String sdkVersion = d.f8413b.getSdkVersion();
        String[] strArrSplit = sdkVersion.split("\\.");
        if (strArrSplit.length >= 3) {
            return new VersionInfo(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]));
        }
        Log.w(TAG, String.format("Unexpected SDK version format: %s. Returning 0.0.0 for SDK version.", sdkVersion));
        return new VersionInfo(0, 0, 0);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    @NonNull
    public VersionInfo getVersionInfo() {
        String adapterVersion = getAdapterVersion();
        String[] strArrSplit = adapterVersion.split("\\.");
        if (strArrSplit.length >= 4) {
            return new VersionInfo(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), (Integer.parseInt(strArrSplit[2]) * 100) + Integer.parseInt(strArrSplit[3]));
        }
        Log.w(TAG, String.format("Unexpected adapter version format: %s. Returning 0.0.0 for adapter version.", adapterVersion));
        return new VersionInfo(0, 0, 0);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void initialize(@NonNull Context context, @NonNull InitializationCompleteCallback initializationCompleteCallback, @NonNull List<MediationConfiguration> list) {
        if (d.f8413b.isInitialized()) {
            initializationCompleteCallback.onInitializationSucceeded();
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<MediationConfiguration> it = list.iterator();
        while (it.hasNext()) {
            String string = it.next().getServerParameters().getString("appid");
            if (!TextUtils.isEmpty(string)) {
                hashSet.add(string);
            }
        }
        int size = hashSet.size();
        if (size > 0) {
            String str = (String) hashSet.iterator().next();
            if (size > 1) {
                Log.w(TAG, String.format("Multiple '%s' entries found: %s. Using '%s' to initialize the Vungle SDK.", "appid", hashSet, str));
            }
            com.google.ads.mediation.vungle.c.a().b(str, context, new a(initializationCompleteCallback));
            return;
        }
        if (initializationCompleteCallback != null) {
            AdError adError = new AdError(101, "Missing or Invalid App ID.", ERROR_DOMAIN);
            Log.w(TAG, adError.toString());
            initializationCompleteCallback.onInitializationFailed(adError.toString());
        }
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadAppOpenAd(@NonNull MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration, @NonNull MediationAdLoadCallback<MediationAppOpenAd, MediationAppOpenAdCallback> mediationAdLoadCallback) {
        com.google.ads.mediation.vungle.c.a().c(mediationAppOpenAdConfiguration.taggedForChildDirectedTreatment());
        v1.a aVar = new v1.a(mediationAppOpenAdConfiguration, mediationAdLoadCallback, this.vungleFactory);
        this.waterfallAppOpenAd = aVar;
        aVar.h();
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadNativeAd(@NonNull MediationNativeAdConfiguration mediationNativeAdConfiguration, @NonNull MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback) {
        Log.d(TAG, "loadNativeAd()...");
        com.google.ads.mediation.vungle.c.a().c(mediationNativeAdConfiguration.taggedForChildDirectedTreatment());
        u1.d dVar = new u1.d(mediationNativeAdConfiguration, mediationAdLoadCallback, this.vungleFactory);
        this.rtbNativeAd = dVar;
        dVar.h();
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadRewardedAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.mediationAdLoadCallback = mediationAdLoadCallback;
        Bundle mediationExtras = mediationRewardedAdConfiguration.getMediationExtras();
        Bundle serverParameters = mediationRewardedAdConfiguration.getServerParameters();
        if (mediationExtras != null) {
            this.userId = mediationExtras.getString("userId");
        }
        String string = serverParameters.getString("appid");
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(101, "Failed to load waterfall rewarded ad from Liftoff Monetize. Missing or invalid App ID configured for this ad source instance in the AdMob or Ad Manager UI.", ERROR_DOMAIN);
            Log.w(TAG, adError.toString());
            mediationAdLoadCallback.onFailure(adError);
            return;
        }
        String string2 = serverParameters.getString("placementID");
        if (TextUtils.isEmpty(string2)) {
            AdError adError2 = new AdError(101, "Failed to load waterfall rewarded ad from Liftoff Monetize. Missing or Invalid Placement ID configured for this ad source instance in the AdMob or Ad Manager UI.", ERROR_DOMAIN);
            Log.w(TAG, adError2.toString());
            mediationAdLoadCallback.onFailure(adError2);
            return;
        }
        this.adConfig = this.vungleFactory.a();
        if (mediationExtras != null && mediationExtras.containsKey("adOrientation")) {
            this.adConfig.setAdOrientation(mediationExtras.getInt("adOrientation", 2));
        }
        com.google.ads.mediation.vungle.c.a().c(mediationRewardedAdConfiguration.taggedForChildDirectedTreatment());
        Context context = mediationRewardedAdConfiguration.getContext();
        com.google.ads.mediation.vungle.c.a().b(string, context, new b(context, string2));
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadRewardedInterstitialAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        String str = TAG;
        Log.d(str, "loadRewardedInterstitialAd()...");
        Log.d(str, "Liftoff Monetize adapter was asked to load a rewarded interstitial ad. Using the rewarded ad request flow to load the ad to attempt to load a rewarded interstitial ad from Liftoff Monetize.");
        loadRewardedAd(mediationRewardedAdConfiguration, mediationAdLoadCallback);
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbAppOpenAd(@NonNull MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration, @NonNull MediationAdLoadCallback<MediationAppOpenAd, MediationAppOpenAdCallback> mediationAdLoadCallback) {
        com.google.ads.mediation.vungle.c.a().c(mediationAppOpenAdConfiguration.taggedForChildDirectedTreatment());
        u1.a aVar = new u1.a(mediationAppOpenAdConfiguration, mediationAdLoadCallback, this.vungleFactory);
        this.rtbAppOpenAd = aVar;
        aVar.h();
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbBannerAd(@NonNull MediationBannerAdConfiguration mediationBannerAdConfiguration, @NonNull MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        Log.d(TAG, "loadRtbBannerAd()...");
        com.google.ads.mediation.vungle.c.a().c(mediationBannerAdConfiguration.taggedForChildDirectedTreatment());
        u1.b bVar = new u1.b(mediationBannerAdConfiguration, mediationAdLoadCallback, this.vungleFactory);
        this.rtbBannerAd = bVar;
        bVar.d();
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbInterstitialAd(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, @NonNull MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        Log.d(TAG, "loadRtbInterstitialAd()...");
        com.google.ads.mediation.vungle.c.a().c(mediationInterstitialAdConfiguration.taggedForChildDirectedTreatment());
        u1.c cVar = new u1.c(mediationInterstitialAdConfiguration, mediationAdLoadCallback, this.vungleFactory);
        this.rtbInterstitialAd = cVar;
        cVar.e();
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbNativeAd(@NonNull MediationNativeAdConfiguration mediationNativeAdConfiguration, @NonNull MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback) {
        Log.d(TAG, "loadRtbNativeAd()...");
        com.google.ads.mediation.vungle.c.a().c(mediationNativeAdConfiguration.taggedForChildDirectedTreatment());
        u1.d dVar = new u1.d(mediationNativeAdConfiguration, mediationAdLoadCallback, this.vungleFactory);
        this.rtbNativeAd = dVar;
        dVar.h();
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbRewardedAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        Log.d(TAG, "loadRtbRewardedAd()...");
        com.google.ads.mediation.vungle.c.a().c(mediationRewardedAdConfiguration.taggedForChildDirectedTreatment());
        e eVar = new e(mediationRewardedAdConfiguration, mediationAdLoadCallback, this.vungleFactory);
        this.rtbRewardedAd = eVar;
        eVar.e();
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbRewardedInterstitialAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        String str = TAG;
        Log.d(str, "loadRtbRewardedInterstitialAd()...");
        Log.d(str, "Liftoff Monetize adapter was asked to load a rewarded interstitial ad. Using the rewarded ad request flow to load the ad to attempt to load a rewarded interstitial ad from Liftoff Monetize.");
        com.google.ads.mediation.vungle.c.a().c(mediationRewardedAdConfiguration.taggedForChildDirectedTreatment());
        e eVar = new e(mediationRewardedAdConfiguration, mediationAdLoadCallback, this.vungleFactory);
        this.rtbRewardedInterstitialAd = eVar;
        eVar.e();
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdClicked(@NonNull u uVar) {
        Log.d(TAG, "Liftoff Monetize waterfall rewarded ad was clicked.");
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mediationRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.reportAdClicked();
        }
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdEnd(@NonNull u uVar) {
        Log.d(TAG, "Liftoff Monetize waterfall rewarded ad has ended.");
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mediationRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdClosed();
        }
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdFailedToLoad(@NonNull u uVar, @NonNull b2 b2Var) {
        AdError adError = getAdError(b2Var);
        Log.w(TAG, "Failed to load waterfall rewarded ad from Liftoff Monetize with error: " + adError.toString());
        MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback = this.mediationAdLoadCallback;
        if (mediationAdLoadCallback != null) {
            mediationAdLoadCallback.onFailure(adError);
        }
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdFailedToPlay(@NonNull u uVar, @NonNull b2 b2Var) {
        AdError adError = getAdError(b2Var);
        Log.w(TAG, "Failed to play waterfall rewarded ad from Liftoff Monetize with error: " + adError.toString());
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mediationRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdFailedToShow(adError);
        }
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdImpression(@NonNull u uVar) {
        this.mediationRewardedAdCallback.onVideoStart();
        this.mediationRewardedAdCallback.reportAdImpression();
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdLoaded(@NonNull u uVar) {
        Log.d(TAG, "Loaded waterfall rewarded ad from Liftoff Monetize.");
        MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback = this.mediationAdLoadCallback;
        if (mediationAdLoadCallback != null) {
            this.mediationRewardedAdCallback = mediationAdLoadCallback.onSuccess(this);
        }
    }

    @Override // com.vungle.ads.s1
    public void onAdRewarded(@NonNull u uVar) {
        Log.d(TAG, "Received reward from Liftoff Monetize waterfall rewarded ad.");
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mediationRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onVideoComplete();
            this.mediationRewardedAdCallback.onUserEarnedReward(new c("vungle", 1));
        }
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdStart(@NonNull u uVar) {
        Log.d(TAG, "Liftoff Monetize waterfall rewarded ad has started.");
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mediationRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdOpened();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(@NonNull Context context) {
        q1 q1Var = this.rewardedAd;
        if (q1Var != null) {
            q1Var.play(context);
        } else if (this.mediationRewardedAdCallback != null) {
            AdError adError = new AdError(107, "Failed to show waterfall rewarded ad from Liftoff Monetize.", ERROR_DOMAIN);
            Log.w(TAG, adError.toString());
            this.mediationRewardedAdCallback.onAdFailedToShow(adError);
        }
    }

    @VisibleForTesting
    VungleMediationAdapter(com.google.ads.mediation.vungle.b bVar) {
        this.vungleFactory = bVar;
    }

    @Override // com.vungle.ads.s1, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdLeftApplication(@NonNull u uVar) {
    }
}
