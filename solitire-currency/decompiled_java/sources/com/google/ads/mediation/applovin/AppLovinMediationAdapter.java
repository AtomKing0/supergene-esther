package com.google.ads.mediation.applovin;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.mediation.BuildConfig;
import com.applovin.mediation.rtb.AppLovinRtbInterstitialRenderer;
import com.applovin.mediation.rtb.AppLovinRtbRewardedRenderer;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.google.ads.mediation.applovin.d;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdFormat;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinMediationAdapter extends RtbAdapter {
    public static final String APPLOVIN_SDK_ERROR_DOMAIN = "com.applovin.sdk";
    public static final int ERROR_AD_ALREADY_REQUESTED = 105;
    public static final int ERROR_AD_FORMAT_UNSUPPORTED = 108;
    public static final int ERROR_BANNER_SIZE_MISMATCH = 101;
    public static final int ERROR_CHILD_USER = 112;
    public static final String ERROR_DOMAIN = "com.google.ads.mediation.applovin";
    public static final int ERROR_EMPTY_BID_TOKEN = 104;
    public static final int ERROR_INVALID_SERVER_PARAMETERS = 110;

    @VisibleForTesting
    static final String ERROR_MSG_BANNER_SIZE_MISMATCH = "Failed to request banner with unsupported size.";

    @VisibleForTesting
    static final String ERROR_MSG_MISSING_SDK = "Missing or invalid SDK Key.";
    public static final int ERROR_PRESENTATON_AD_NOT_READY = 106;
    private static final String TAG = "AppLovinMediationAdapter";
    private final com.google.ads.mediation.applovin.a appLovinAdFactory;
    private final d appLovinInitializer;
    private final h appLovinSdkUtilsWrapper;
    private final i appLovinSdkWrapper;
    private c bannerAd;
    private k rewardedRenderer;
    private AppLovinRtbInterstitialRenderer rtbInterstitialRenderer;
    private AppLovinRtbRewardedRenderer rtbRewardedRenderer;
    private j waterfallInterstitialAd;
    private static final AtomicBoolean isFirstLoad = new AtomicBoolean(true);
    public static final AtomicBoolean firstLoadDone = new AtomicBoolean(false);

    class a implements d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InitializationCompleteCallback f8245a;

        a(InitializationCompleteCallback initializationCompleteCallback) {
            this.f8245a = initializationCompleteCallback;
        }

        @Override // com.google.ads.mediation.applovin.d.b
        public void onInitializeSuccess() {
            this.f8245a.onInitializationSucceeded();
        }
    }

    public AppLovinMediationAdapter() {
        this.appLovinInitializer = d.a();
        this.appLovinAdFactory = new com.google.ads.mediation.applovin.a();
        this.appLovinSdkWrapper = new i();
        this.appLovinSdkUtilsWrapper = new h();
    }

    public static void disableLatencyFix() {
        Log.d(TAG, "disable latency fix, not force fail first loads.");
        isFirstLoad.set(false);
        firstLoadDone.set(true);
    }

    public static void enableLatencyFix() {
        Log.d(TAG, "enable latency fix, fail status on first load.");
        isFirstLoad.set(true);
        firstLoadDone.set(false);
    }

    @NonNull
    public static AppLovinSdkSettings getSdkSettings(@NonNull Context context) {
        return AppLovinSdk.getInstance(context).getSettings();
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void collectSignals(@NonNull RtbSignalData rtbSignalData, @NonNull SignalCallbacks signalCallbacks) {
        if (AppLovinUtils.isChildUser()) {
            signalCallbacks.onFailure(AppLovinUtils.getChildUserError());
            return;
        }
        if (rtbSignalData.getConfiguration().getFormat() == AdFormat.NATIVE) {
            AdError adError = new AdError(108, "Requested to collect signal for unsupported native ad format. Ignoring...", ERROR_DOMAIN);
            Log.e(TAG, adError.getMessage());
            signalCallbacks.onFailure(adError);
            return;
        }
        String str = TAG;
        Log.i(str, "Extras for signal collection: " + rtbSignalData.getNetworkExtras());
        String bidToken = this.appLovinInitializer.c(rtbSignalData.getContext()).getAdService().getBidToken();
        if (TextUtils.isEmpty(bidToken)) {
            AdError adError2 = new AdError(104, "Failed to generate bid token.", ERROR_DOMAIN);
            Log.e(str, adError2.getMessage());
            signalCallbacks.onFailure(adError2);
        } else {
            Log.i(str, "Generated bid token: " + bidToken);
            signalCallbacks.onSuccess(bidToken);
        }
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    @NonNull
    public VersionInfo getSDKVersionInfo() {
        String strB = this.appLovinSdkWrapper.b();
        String[] strArrSplit = strB.split("\\.");
        if (strArrSplit.length >= 3) {
            return new VersionInfo(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]));
        }
        Log.w(TAG, String.format("Unexpected SDK version format: %s. Returning 0.0.0 for SDK version.", strB));
        return new VersionInfo(0, 0, 0);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    @NonNull
    public VersionInfo getVersionInfo() {
        return getVersionInfo(BuildConfig.ADAPTER_VERSION);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void initialize(@NonNull Context context, @NonNull InitializationCompleteCallback initializationCompleteCallback, @NonNull List<MediationConfiguration> list) {
        if (AppLovinUtils.isChildUser()) {
            initializationCompleteCallback.onInitializationFailed(AppLovinUtils.ERROR_MSG_CHILD_USER);
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<MediationConfiguration> it = list.iterator();
        while (it.hasNext()) {
            String string = it.next().getServerParameters().getString(AppLovinUtils.ServerParameterKeys.SDK_KEY);
            if (!TextUtils.isEmpty(string)) {
                hashSet.add(string);
            }
        }
        if (hashSet.isEmpty()) {
            AdError adError = new AdError(110, ERROR_MSG_MISSING_SDK, ERROR_DOMAIN);
            Log.w(TAG, adError.getMessage());
            initializationCompleteCallback.onInitializationFailed(adError.getMessage());
        } else {
            String str = (String) hashSet.iterator().next();
            if (hashSet.size() > 1) {
                Log.w(TAG, String.format("Found more than one AppLovin SDK key. Using %s. Please update your app's ad unit mappings on Admob/GAM UI to use a single SDK key for ad serving to work as expected.", str));
            }
            this.appLovinInitializer.b(context, str, new a(initializationCompleteCallback));
        }
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadBannerAd(@NonNull MediationBannerAdConfiguration mediationBannerAdConfiguration, @NonNull MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        if (AppLovinUtils.isChildUser()) {
            mediationAdLoadCallback.onFailure(AppLovinUtils.getChildUserError());
            return;
        }
        c cVarL = c.l(mediationBannerAdConfiguration, mediationAdLoadCallback, this.appLovinInitializer, this.appLovinAdFactory);
        this.bannerAd = cVarL;
        cVarL.k();
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadInterstitialAd(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, @NonNull MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        if (AppLovinUtils.isChildUser()) {
            mediationAdLoadCallback.onFailure(AppLovinUtils.getChildUserError());
            return;
        }
        j jVar = new j(mediationInterstitialAdConfiguration, mediationAdLoadCallback, this.appLovinInitializer, this.appLovinAdFactory);
        this.waterfallInterstitialAd = jVar;
        jVar.loadAd();
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadRewardedAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        if (AppLovinUtils.isChildUser()) {
            mediationAdLoadCallback.onFailure(AppLovinUtils.getChildUserError());
            return;
        }
        AtomicBoolean atomicBoolean = isFirstLoad;
        if (atomicBoolean.get()) {
            atomicBoolean.set(false);
            AdError adError = new AdError(106, "(latency fix) ABM intends fail on first load", ERROR_DOMAIN);
            Log.e(TAG, adError.toString());
            mediationAdLoadCallback.onFailure(adError);
            return;
        }
        if (firstLoadDone.get()) {
            k kVar = new k(mediationRewardedAdConfiguration, mediationAdLoadCallback, this.appLovinInitializer, this.appLovinAdFactory, this.appLovinSdkUtilsWrapper);
            this.rewardedRenderer = kVar;
            kVar.loadAd();
        } else {
            AdError adError2 = new AdError(106, "(latency fix) ABM first load still in progress; expect load failure", ERROR_DOMAIN);
            Log.e(TAG, adError2.toString());
            mediationAdLoadCallback.onFailure(adError2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbInterstitialAd(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, @NonNull MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        if (AppLovinUtils.isChildUser()) {
            mediationAdLoadCallback.onFailure(AppLovinUtils.getChildUserError());
            return;
        }
        AppLovinRtbInterstitialRenderer appLovinRtbInterstitialRenderer = new AppLovinRtbInterstitialRenderer(mediationInterstitialAdConfiguration, mediationAdLoadCallback, this.appLovinInitializer, this.appLovinAdFactory);
        this.rtbInterstitialRenderer = appLovinRtbInterstitialRenderer;
        appLovinRtbInterstitialRenderer.loadAd();
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbRewardedAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        if (AppLovinUtils.isChildUser()) {
            mediationAdLoadCallback.onFailure(AppLovinUtils.getChildUserError());
            return;
        }
        AppLovinRtbRewardedRenderer appLovinRtbRewardedRenderer = new AppLovinRtbRewardedRenderer(mediationRewardedAdConfiguration, mediationAdLoadCallback, this.appLovinInitializer, this.appLovinAdFactory, this.appLovinSdkUtilsWrapper);
        this.rtbRewardedRenderer = appLovinRtbRewardedRenderer;
        appLovinRtbRewardedRenderer.loadAd();
    }

    @NonNull
    @VisibleForTesting
    VersionInfo getVersionInfo(String str) {
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length >= 4) {
            return new VersionInfo(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), (Integer.parseInt(strArrSplit[2]) * 100) + Integer.parseInt(strArrSplit[3]));
        }
        Log.w(TAG, String.format("Unexpected adapter version format: %s. Returning 0.0.0 for adapter version.", str));
        return new VersionInfo(0, 0, 0);
    }

    @VisibleForTesting
    AppLovinMediationAdapter(d dVar, com.google.ads.mediation.applovin.a aVar, i iVar, h hVar) {
        this.appLovinInitializer = dVar;
        this.appLovinAdFactory = aVar;
        this.appLovinSdkWrapper = iVar;
        this.appLovinSdkUtilsWrapper = hVar;
    }
}
