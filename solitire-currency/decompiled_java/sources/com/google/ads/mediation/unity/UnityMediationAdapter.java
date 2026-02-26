package com.google.ads.mediation.unity;

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
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.ads.UnityAds;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public class UnityMediationAdapter extends RtbAdapter {
    public static final String ADAPTER_ERROR_DOMAIN = "com.google.ads.mediation.unity";
    static final int ERROR_AD_NOT_READY = 106;
    static final int ERROR_BANNER_SIZE_MISMATCH = 110;
    static final int ERROR_CONTEXT_NOT_ACTIVITY = 105;
    static final int ERROR_FINISH = 109;
    static final int ERROR_INITIALIZATION_FAILURE = 111;
    static final int ERROR_INVALID_SERVER_PARAMETERS = 101;
    static final String ERROR_MSG_CONTEXT_NULL = "Activity context is null.";
    static final String ERROR_MSG_INITIALIZATION_FAILURE = "Unity Ads initialization failed: [%s] %s";
    static final String ERROR_MSG_MISSING_PARAMETERS = "Missing or invalid server parameters.";
    static final String ERROR_MSG_NON_ACTIVITY = "Unity Ads requires an Activity context to load ads.";
    static final int ERROR_NULL_CONTEXT = 104;
    static final int ERROR_PLACEMENT_STATE_DISABLED = 103;
    static final int ERROR_PLACEMENT_STATE_NO_FILL = 102;
    static final int ERROR_UNITY_ADS_NOT_SUPPORTED = 107;
    static final String KEY_GAME_ID = "gameId";
    static final String KEY_PLACEMENT_ID = "zoneId";
    static final String KEY_WATERMARK = "watermark";
    public static final String SDK_ERROR_DOMAIN = "com.unity3d.ads";
    static final String TAG = "UnityMediationAdapter";
    private UnityMediationBannerAd bannerAd;
    private UnityMediationBannerAd bannerRtbAd;
    private g interstitialAd;
    private g interstitialRtbAd;
    private j rewardedAd;
    private j rewardedRtbAd;
    private final b unityAdsLoader;
    private final d unityBannerViewFactory;
    private final f unityInitializer;

    class a implements IUnityAdsInitializationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ InitializationCompleteCallback f8344a;

        a(InitializationCompleteCallback initializationCompleteCallback) {
            this.f8344a = initializationCompleteCallback;
        }

        @Override // com.unity3d.ads.IUnityAdsInitializationListener
        public void onInitializationComplete() {
            Log.d(UnityMediationAdapter.TAG, "Unity Ads initialized successfully.");
            this.f8344a.onInitializationSucceeded();
        }

        @Override // com.unity3d.ads.IUnityAdsInitializationListener
        public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
            AdError adErrorC = com.google.ads.mediation.unity.a.c(unityAdsInitializationError, String.format(UnityMediationAdapter.ERROR_MSG_INITIALIZATION_FAILURE, unityAdsInitializationError, str));
            Log.d(UnityMediationAdapter.TAG, adErrorC.toString());
            this.f8344a.onInitializationFailed(adErrorC.toString());
        }
    }

    public UnityMediationAdapter() {
        this.unityInitializer = f.a();
        this.unityBannerViewFactory = new d();
        this.unityAdsLoader = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$collectSignals$0(SignalCallbacks signalCallbacks, String str) {
        if (str == null) {
            str = "";
        }
        signalCallbacks.onSuccess(str);
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void collectSignals(@NonNull RtbSignalData rtbSignalData, @NonNull final SignalCallbacks signalCallbacks) {
        UnityAds.getToken(new IUnityAdsTokenListener() { // from class: com.google.ads.mediation.unity.h
            @Override // com.unity3d.ads.IUnityAdsTokenListener
            public final void onUnityAdsTokenReady(String str) {
                UnityMediationAdapter.lambda$collectSignals$0(signalCallbacks, str);
            }
        });
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    @NonNull
    public VersionInfo getSDKVersionInfo() {
        String version = UnityAds.getVersion();
        String[] strArrSplit = version.split("\\.");
        if (strArrSplit.length >= 3) {
            return new VersionInfo(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]));
        }
        Log.w(TAG, String.format("Unexpected SDK version format: %s. Returning 0.0.0 for SDK version.", version));
        return new VersionInfo(0, 0, 0);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    @NonNull
    public VersionInfo getVersionInfo() {
        String[] strArrSplit = "4.12.2.0".split("\\.");
        if (strArrSplit.length >= 4) {
            return new VersionInfo(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), (Integer.parseInt(strArrSplit[2]) * 100) + Integer.parseInt(strArrSplit[3]));
        }
        Log.w(TAG, String.format("Unexpected adapter version format: %s. Returning 0.0.0 for adapter version.", "4.12.2.0"));
        return new VersionInfo(0, 0, 0);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void initialize(@NonNull Context context, @NonNull InitializationCompleteCallback initializationCompleteCallback, @NonNull List<MediationConfiguration> list) throws JSONException {
        String str;
        HashSet hashSet = new HashSet();
        Iterator<MediationConfiguration> it = list.iterator();
        while (it.hasNext()) {
            String string = it.next().getServerParameters().getString("gameId");
            if (!TextUtils.isEmpty(string)) {
                hashSet.add(string);
            }
        }
        int size = hashSet.size();
        if (size > 0) {
            str = (String) hashSet.iterator().next();
            if (size > 1) {
                Log.w(TAG, String.format("Multiple '%s' entries found: %s. Using '%s' to initialize the UnityAds SDK", "gameId", hashSet, str));
            }
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            initializationCompleteCallback.onInitializationFailed(new AdError(101, "Missing or invalid Game ID.", ADAPTER_ERROR_DOMAIN).toString());
        } else {
            this.unityInitializer.b(context, str, new a(initializationCompleteCallback));
        }
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadBannerAd(@NonNull MediationBannerAdConfiguration mediationBannerAdConfiguration, @NonNull MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) throws JSONException {
        UnityMediationBannerAd unityMediationBannerAd = new UnityMediationBannerAd(mediationBannerAdConfiguration, mediationAdLoadCallback, this.unityInitializer, this.unityBannerViewFactory, this.unityAdsLoader);
        this.bannerAd = unityMediationBannerAd;
        unityMediationBannerAd.loadAd();
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) throws JSONException {
        g gVar = new g(mediationInterstitialAdConfiguration, mediationAdLoadCallback, this.unityInitializer, this.unityAdsLoader);
        this.interstitialAd = gVar;
        gVar.f();
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadRewardedAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) throws JSONException {
        j jVar = new j(mediationRewardedAdConfiguration, mediationAdLoadCallback, this.unityInitializer, this.unityAdsLoader);
        this.rewardedAd = jVar;
        jVar.i();
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbBannerAd(@NonNull MediationBannerAdConfiguration mediationBannerAdConfiguration, @NonNull MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) throws JSONException {
        UnityMediationBannerAd unityMediationBannerAd = new UnityMediationBannerAd(mediationBannerAdConfiguration, mediationAdLoadCallback, this.unityInitializer, this.unityBannerViewFactory, this.unityAdsLoader);
        this.bannerRtbAd = unityMediationBannerAd;
        unityMediationBannerAd.loadAd();
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public final void loadRtbInterstitialAd(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, @NonNull MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) throws JSONException {
        g gVar = new g(mediationInterstitialAdConfiguration, mediationAdLoadCallback, this.unityInitializer, this.unityAdsLoader);
        this.interstitialRtbAd = gVar;
        gVar.f();
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbRewardedAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) throws JSONException {
        j jVar = new j(mediationRewardedAdConfiguration, mediationAdLoadCallback, this.unityInitializer, this.unityAdsLoader);
        this.rewardedRtbAd = jVar;
        jVar.i();
    }

    @VisibleForTesting
    UnityMediationAdapter(f fVar, d dVar, b bVar) {
        this.unityInitializer = fVar;
        this.unityBannerViewFactory = dVar;
        this.unityAdsLoader = bVar;
    }
}
