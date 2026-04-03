package com.google.ads.mediation.unity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.core.domain.GetAndroidAdPlayerContext;
import java.lang.ref.WeakReference;
import java.util.UUID;
import org.json.JSONException;

/* JADX INFO: compiled from: UnityInterstitialAd.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements MediationInterstitialAd, IUnityAdsLoadListener, IUnityAdsShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f8370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MediationInterstitialAdConfiguration f8372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> f8373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f f8374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final b f8375f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private MediationInterstitialAdCallback f8376g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f8377h;

    /* JADX INFO: compiled from: UnityInterstitialAd.java */
    class a implements IUnityAdsInitializationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f8379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f8380c;

        a(String str, Context context, String str2) {
            this.f8378a = str;
            this.f8379b = context;
            this.f8380c = str2;
        }

        @Override // com.unity3d.ads.IUnityAdsInitializationListener
        public void onInitializationComplete() throws JSONException {
            Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads is initialized for game ID '%s' and can now load interstitial ad with placement ID: %s", this.f8378a, g.this.f8377h));
            com.google.ads.mediation.unity.a.k(MobileAds.getRequestConfiguration().getTagForChildDirectedTreatment(), this.f8379b);
            g.this.f8371b = UUID.randomUUID().toString();
            UnityAdsLoadOptions unityAdsLoadOptionsB = g.this.f8375f.b(g.this.f8371b);
            String str = this.f8380c;
            if (str != null) {
                unityAdsLoadOptionsB.setAdMarkup(str);
            }
            g.this.f8375f.d(g.this.f8377h, unityAdsLoadOptionsB, g.this);
        }

        @Override // com.unity3d.ads.IUnityAdsInitializationListener
        public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
            AdError adErrorC = com.google.ads.mediation.unity.a.c(unityAdsInitializationError, String.format("Unity Ads initialization failed for game ID '%s' with error message: %s", this.f8378a, str));
            Log.w(UnityMediationAdapter.TAG, adErrorC.toString());
            g.this.f8373d.onFailure(adErrorC);
        }
    }

    public g(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, @NonNull MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback, @NonNull f fVar, @NonNull b bVar) {
        this.f8372c = mediationInterstitialAdConfiguration;
        this.f8373d = mediationAdLoadCallback;
        this.f8374e = fVar;
        this.f8375f = bVar;
    }

    public void f() throws JSONException {
        Context context = this.f8372c.getContext();
        Bundle serverParameters = this.f8372c.getServerParameters();
        String string = serverParameters.getString(GetAndroidAdPlayerContext.KEY_GAME_ID);
        String string2 = serverParameters.getString("zoneId");
        this.f8377h = string2;
        if (!com.google.ads.mediation.unity.a.a(string, string2)) {
            this.f8373d.onFailure(new AdError(101, "Missing or invalid server parameters.", UnityMediationAdapter.ADAPTER_ERROR_DOMAIN));
        } else if (!(context instanceof Activity)) {
            this.f8373d.onFailure(new AdError(105, "Unity Ads requires an Activity context to load ads.", UnityMediationAdapter.ADAPTER_ERROR_DOMAIN));
        } else {
            this.f8370a = new WeakReference<>((Activity) context);
            this.f8374e.b(context, string, new a(string, context, this.f8372c.getBidResponse()));
        }
    }

    @Override // com.unity3d.ads.IUnityAdsLoadListener
    public void onUnityAdsAdLoaded(String str) {
        Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads interstitial ad successfully loaded for placement ID: %s", str));
        this.f8377h = str;
        this.f8376g = this.f8373d.onSuccess(this);
    }

    @Override // com.unity3d.ads.IUnityAdsLoadListener
    public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
        this.f8377h = str;
        AdError adErrorD = com.google.ads.mediation.unity.a.d(unityAdsLoadError, str2);
        Log.w(UnityMediationAdapter.TAG, adErrorD.toString());
        this.f8373d.onFailure(adErrorD);
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowClick(String str) {
        Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads interstitial ad was clicked for placement ID: %s", str));
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f8376g;
        if (mediationInterstitialAdCallback == null) {
            return;
        }
        mediationInterstitialAdCallback.reportAdClicked();
        this.f8376g.onAdLeftApplication();
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads interstitial ad finished playing for placement ID: %s", str));
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f8376g;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdClosed();
        }
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
        AdError adErrorE = com.google.ads.mediation.unity.a.e(unityAdsShowError, str2);
        Log.w(UnityMediationAdapter.TAG, adErrorE.toString());
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f8376g;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdFailedToShow(adErrorE);
        }
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowStart(String str) {
        Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads interstitial ad started for placement ID: %s", str));
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f8376g;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdOpened();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAd
    public void showAd(Context context) {
        WeakReference<Activity> weakReference = this.f8370a;
        Activity activity = weakReference == null ? null : weakReference.get();
        if (activity != null) {
            if (this.f8377h == null) {
                Log.w(UnityMediationAdapter.TAG, "Unity Ads received call to show before successfully loading an ad.");
            }
            UnityAdsShowOptions unityAdsShowOptionsC = this.f8375f.c(this.f8371b);
            unityAdsShowOptionsC.set("watermark", this.f8372c.getWatermark());
            this.f8375f.e(activity, this.f8377h, unityAdsShowOptionsC, this);
            return;
        }
        Log.w(UnityMediationAdapter.TAG, "Failed to show interstitial ad for placement ID '" + this.f8377h + "' from Unity Ads: Activity context is null.");
        if (this.f8376g != null) {
            this.f8376g.onAdFailedToShow(new AdError(104, "Activity context is null.", UnityMediationAdapter.ADAPTER_ERROR_DOMAIN));
        }
    }
}
