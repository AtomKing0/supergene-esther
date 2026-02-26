package com.google.ads.mediation.ironsource;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.VersionInfo;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.ironsourceads.InitListener;
import com.unity3d.ironsourceads.InitRequest;
import com.unity3d.ironsourceads.IronSourceAds;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class IronSourceMediationAdapter extends RtbAdapter {
    public static final String ADAPTER_ERROR_DOMAIN = "com.google.ads.mediation.ironsource";
    public static final int ERROR_AD_ALREADY_LOADED = 103;
    public static final int ERROR_BANNER_SIZE_MISMATCH = 105;
    public static final int ERROR_CALL_SHOW_BEFORE_LOADED_SUCCESS = 107;
    public static final int ERROR_INVALID_SERVER_PARAMETERS = 101;
    public static final int ERROR_REQUIRES_ACTIVITY_CONTEXT = 102;
    public static final int ERROR_SDK_NOT_INITIALIZED = 106;
    public static final String IRONSOURCE_SDK_ERROR_DOMAIN = "com.ironsource.mediationsdk";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f8294a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f8295b = new AtomicBoolean(true);
    public static final AtomicBoolean firstLoadDone = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f8296c = false;

    class a implements InitListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InitializationCompleteCallback f8297a;

        a(InitializationCompleteCallback initializationCompleteCallback) {
            this.f8297a = initializationCompleteCallback;
        }

        @Override // com.unity3d.ironsourceads.InitListener
        public void onInitFailed(@NonNull IronSourceError ironSourceError) {
            this.f8297a.onInitializationFailed(ironSourceError.getErrorMessage());
        }

        @Override // com.unity3d.ironsourceads.InitListener
        public void onInitSuccess() {
            IronSourceMediationAdapter.f8294a.set(true);
            this.f8297a.onInitializationSucceeded();
        }
    }

    public static void disableInitialization() {
        Log.i(c.f8309a, "IronSource adapter will not initialize.");
        f8296c = true;
    }

    public static void disableLatencyFix() {
        Log.d(c.f8309a, "disable latency fix, do not force fail first loads.");
        f8295b.set(false);
        firstLoadDone.set(true);
    }

    public static void enableInitialization() {
        Log.i(c.f8309a, "IronSource adapter will initialize.");
        f8296c = false;
    }

    public static void enableLatencyFix() {
        Log.d(c.f8309a, "enable latency fix, fail status on first load.");
        f8295b.set(true);
        firstLoadDone.set(false);
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void collectSignals(@NonNull RtbSignalData rtbSignalData, @NonNull SignalCallbacks signalCallbacks) {
        signalCallbacks.onSuccess(IronSource.getISDemandOnlyBiddingData(rtbSignalData.getContext()));
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    @NonNull
    public VersionInfo getSDKVersionInfo() {
        String sDKVersion = IronSourceUtils.getSDKVersion();
        String[] strArrSplit = sDKVersion.split("\\.");
        if (strArrSplit.length < 3) {
            Log.w(c.f8309a, String.format("Unexpected SDK version format: %s. Returning 0.0.0 for SDK version.", sDKVersion));
            return new VersionInfo(0, 0, 0);
        }
        int i10 = Integer.parseInt(strArrSplit[0]);
        int i11 = Integer.parseInt(strArrSplit[1]);
        int i12 = Integer.parseInt(strArrSplit[2]);
        if (strArrSplit.length >= 4) {
            i12 = (i12 * 100) + Integer.parseInt(strArrSplit[3]);
        }
        return new VersionInfo(i10, i11, i12);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    @NonNull
    public VersionInfo getVersionInfo() {
        String strD = r1.a.d();
        String[] strArrSplit = strD.split("\\.");
        if (strArrSplit.length < 4) {
            Log.w(c.f8309a, String.format("Unexpected adapter version format: %s. Returning 0.0.0 for adapter version.", strD));
            return new VersionInfo(0, 0, 0);
        }
        int i10 = Integer.parseInt(strArrSplit[0]);
        int i11 = Integer.parseInt(strArrSplit[1]);
        int i12 = (Integer.parseInt(strArrSplit[2]) * 100) + Integer.parseInt(strArrSplit[3]);
        if (strArrSplit.length >= 5) {
            i12 = (i12 * 100) + Integer.parseInt(strArrSplit[4]);
        }
        return new VersionInfo(i10, i11, i12);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void initialize(@NonNull Context context, @NonNull InitializationCompleteCallback initializationCompleteCallback, @NonNull List<MediationConfiguration> list) {
        if (f8296c) {
            Log.i(c.f8309a, "IronSource adapter will pass through initialization.");
            f8294a.set(true);
            IronSource.setISDemandOnlyInterstitialListener(d.c());
            IronSource.setISDemandOnlyRewardedVideoListener(f.b());
            initializationCompleteCallback.onInitializationSucceeded();
            return;
        }
        if (f8294a.get()) {
            initializationCompleteCallback.onInitializationSucceeded();
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<MediationConfiguration> it = list.iterator();
        while (it.hasNext()) {
            String string = it.next().getServerParameters().getString("appKey");
            if (!TextUtils.isEmpty(string)) {
                hashSet.add(string);
            }
        }
        int size = hashSet.size();
        if (size <= 0) {
            initializationCompleteCallback.onInitializationFailed(new AdError(101, "Missing or invalid app key.", ADAPTER_ERROR_DOMAIN).getMessage());
            return;
        }
        String str = (String) hashSet.iterator().next();
        if (TextUtils.isEmpty(str)) {
            initializationCompleteCallback.onInitializationFailed(new AdError(101, "Missing or invalid app key.", ADAPTER_ERROR_DOMAIN).getMessage());
            return;
        }
        if (size > 1) {
            Log.w(c.f8309a, String.format("Multiple '%s' entries found: %s. Using app key '%s' to initialize the IronSource SDK.", "appKey", hashSet, str));
        }
        IronSource.setMediationType("AdMob500");
        Log.d(c.f8309a, "Initializing IronSource SDK with app key: " + str);
        IronSourceAds.init(context, new InitRequest.Builder(str).withLegacyAdFormats(new ArrayList(Arrays.asList(IronSourceAds.AdFormat.BANNER, IronSourceAds.AdFormat.INTERSTITIAL, IronSourceAds.AdFormat.REWARDED))).build(), new a(initializationCompleteCallback));
        IronSource.setISDemandOnlyInterstitialListener(d.c());
        IronSource.setISDemandOnlyRewardedVideoListener(f.b());
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadBannerAd(@NonNull MediationBannerAdConfiguration mediationBannerAdConfiguration, @NonNull MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        if (f8294a.get()) {
            new com.google.ads.mediation.ironsource.a(mediationBannerAdConfiguration, mediationAdLoadCallback).h();
            return;
        }
        AdError adError = new AdError(106, "Failed to load IronSource banner ad since IronSource SDK is not initialized.", IRONSOURCE_SDK_ERROR_DOMAIN);
        Log.w(c.f8309a, adError.getMessage());
        mediationAdLoadCallback.onFailure(adError);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadInterstitialAd(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, @NonNull MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        if (f8294a.get()) {
            new d(mediationInterstitialAdConfiguration, mediationAdLoadCallback).g();
            return;
        }
        AdError adError = new AdError(106, "Failed to load IronSource interstitial ad since IronSource SDK is not initialized.", IRONSOURCE_SDK_ERROR_DOMAIN);
        Log.w(c.f8309a, adError.getMessage());
        mediationAdLoadCallback.onFailure(adError);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadRewardedAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        if (!f8294a.get()) {
            AdError adError = new AdError(106, "Failed to load IronSource rewarded ad since IronSource SDK is not initialized.", ADAPTER_ERROR_DOMAIN);
            Log.w(c.f8309a, adError.getMessage());
            mediationAdLoadCallback.onFailure(adError);
            return;
        }
        AtomicBoolean atomicBoolean = f8295b;
        if (atomicBoolean.get()) {
            atomicBoolean.set(false);
            AdError adError2 = new AdError(1158, "(latency fix) ABM intends fail on first load", ADAPTER_ERROR_DOMAIN);
            Log.w(c.f8309a, adError2.getMessage());
            mediationAdLoadCallback.onFailure(adError2);
        } else if (!firstLoadDone.get()) {
            AdError adError3 = new AdError(1158, "(latency fix) ABM first load still in progress; expect load failure", ADAPTER_ERROR_DOMAIN);
            Log.w(c.f8309a, adError3.getMessage());
            mediationAdLoadCallback.onFailure(adError3);
            return;
        }
        new f(mediationRewardedAdConfiguration, mediationAdLoadCallback).g();
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadRewardedInterstitialAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        Log.d(c.f8309a, "IronSource adapter was asked to load a rewarded interstitial ad. Using the rewarded ad request flow to load the ad to attempt to load a rewarded interstitial ad from IronSource.");
        loadRewardedAd(mediationRewardedAdConfiguration, mediationAdLoadCallback);
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbInterstitialAd(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, @NonNull MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        if (f8294a.get()) {
            new h(mediationInterstitialAdConfiguration, mediationAdLoadCallback).a();
            return;
        }
        AdError adError = new AdError(106, "Failed to load IronSource RTB interstitial ad since IronSource SDK is not initialized.", IRONSOURCE_SDK_ERROR_DOMAIN);
        Log.w(c.f8309a, adError.getMessage());
        mediationAdLoadCallback.onFailure(adError);
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbRewardedAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        if (f8294a.get()) {
            new i(mediationRewardedAdConfiguration, mediationAdLoadCallback).a();
            return;
        }
        AdError adError = new AdError(106, "Failed to load IronSource RTB rewarded ad since IronSource SDK is not initialized.", ADAPTER_ERROR_DOMAIN);
        Log.w(c.f8309a, adError.getMessage());
        mediationAdLoadCallback.onFailure(adError);
    }

    @VisibleForTesting
    public void setIsInitialized(boolean z10) {
        f8294a.set(z10);
    }
}
