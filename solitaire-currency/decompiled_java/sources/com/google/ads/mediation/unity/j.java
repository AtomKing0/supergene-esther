package com.google.ads.mediation.unity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.core.domain.GetAndroidAdPlayerContext;
import java.util.UUID;
import org.json.JSONException;

/* JADX INFO: compiled from: UnityRewardedAd.java */
/* JADX INFO: loaded from: classes2.dex */
public class j implements MediationRewardedAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediationRewardedAdConfiguration f8383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> f8384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f8385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.ads.mediation.unity.b f8386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private MediationRewardedAdCallback f8387e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private String f8388f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private String f8389g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @VisibleForTesting
    final IUnityAdsLoadListener f8390h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @VisibleForTesting
    final IUnityAdsShowListener f8391i = new b();

    /* JADX INFO: compiled from: UnityRewardedAd.java */
    class a implements IUnityAdsLoadListener {
        a() {
        }

        @Override // com.unity3d.ads.IUnityAdsLoadListener
        public void onUnityAdsAdLoaded(String str) {
            Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads rewarded ad successfully loaded placement ID: %s", str));
            j.this.f8388f = str;
            j jVar = j.this;
            jVar.f8387e = (MediationRewardedAdCallback) jVar.f8384b.onSuccess(j.this);
        }

        @Override // com.unity3d.ads.IUnityAdsLoadListener
        public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
            j.this.f8388f = str;
            AdError adErrorD = com.google.ads.mediation.unity.a.d(unityAdsLoadError, str2);
            Log.w(UnityMediationAdapter.TAG, adErrorD.toString());
            j.this.f8384b.onFailure(adErrorD);
        }
    }

    /* JADX INFO: compiled from: UnityRewardedAd.java */
    class b implements IUnityAdsShowListener {
        b() {
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowClick(String str) {
            if (j.this.f8387e != null) {
                j.this.f8387e.reportAdClicked();
            }
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
            if (j.this.f8387e == null) {
                return;
            }
            if (unityAdsShowCompletionState == UnityAds.UnityAdsShowCompletionState.COMPLETED) {
                j.this.f8387e.onVideoComplete();
                j.this.f8387e.onUserEarnedReward(new i());
            }
            j.this.f8387e.onAdClosed();
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
            if (j.this.f8387e != null) {
                j.this.f8387e.onAdFailedToShow(com.google.ads.mediation.unity.a.e(unityAdsShowError, str2));
            }
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowStart(String str) {
            if (j.this.f8387e == null) {
                return;
            }
            j.this.f8387e.onAdOpened();
            j.this.f8387e.reportAdImpression();
            j.this.f8387e.onVideoStart();
        }
    }

    /* JADX INFO: compiled from: UnityRewardedAd.java */
    private class c implements IUnityAdsInitializationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f8394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f8395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f8396c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private final String f8397d;

        c(Context context, String str, String str2, @Nullable String str3) {
            this.f8394a = context;
            this.f8395b = str;
            this.f8396c = str2;
            this.f8397d = str3;
        }

        @Override // com.unity3d.ads.IUnityAdsInitializationListener
        public void onInitializationComplete() throws JSONException {
            Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads is initialized for game ID '%s' and can now load rewarded ad with placement ID: %s", this.f8395b, this.f8396c));
            com.google.ads.mediation.unity.a.k(j.this.f8383a.taggedForChildDirectedTreatment(), this.f8394a);
            j.this.f8389g = UUID.randomUUID().toString();
            UnityAdsLoadOptions unityAdsLoadOptionsB = j.this.f8386d.b(j.this.f8389g);
            String str = this.f8397d;
            if (str != null) {
                unityAdsLoadOptionsB.setAdMarkup(str);
            }
            j.this.f8386d.d(this.f8396c, unityAdsLoadOptionsB, j.this.f8390h);
        }

        @Override // com.unity3d.ads.IUnityAdsInitializationListener
        public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
            AdError adErrorC = com.google.ads.mediation.unity.a.c(unityAdsInitializationError, String.format("Unity Ads initialization failed for game ID '%s' with error message: %s", this.f8395b, str));
            Log.w(UnityMediationAdapter.TAG, adErrorC.toString());
            j.this.f8384b.onFailure(adErrorC);
        }
    }

    public j(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback, @NonNull f fVar, @NonNull com.google.ads.mediation.unity.b bVar) {
        this.f8383a = mediationRewardedAdConfiguration;
        this.f8384b = mediationAdLoadCallback;
        this.f8385c = fVar;
        this.f8386d = bVar;
    }

    public void i() throws JSONException {
        Context context = this.f8383a.getContext();
        if (!(context instanceof Activity)) {
            AdError adError = new AdError(105, "Unity Ads requires an Activity context to load ads.", UnityMediationAdapter.ADAPTER_ERROR_DOMAIN);
            Log.w(UnityMediationAdapter.TAG, adError.toString());
            this.f8384b.onFailure(adError);
            return;
        }
        Bundle serverParameters = this.f8383a.getServerParameters();
        String string = serverParameters.getString(GetAndroidAdPlayerContext.KEY_GAME_ID);
        String string2 = serverParameters.getString("zoneId");
        if (com.google.ads.mediation.unity.a.a(string, string2)) {
            this.f8385c.b(context, string, new c(context, string, string2, this.f8383a.getBidResponse()));
        } else {
            AdError adError2 = new AdError(101, "Missing or invalid server parameters.", UnityMediationAdapter.ADAPTER_ERROR_DOMAIN);
            Log.w(UnityMediationAdapter.TAG, adError2.toString());
            this.f8384b.onFailure(adError2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(@NonNull Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (this.f8388f == null) {
                Log.w(UnityMediationAdapter.TAG, "Unity Ads received call to show before successfully loading an ad.");
            }
            UnityAdsShowOptions unityAdsShowOptionsC = this.f8386d.c(this.f8389g);
            unityAdsShowOptionsC.set("watermark", this.f8383a.getWatermark());
            this.f8386d.e(activity, this.f8388f, unityAdsShowOptionsC, this.f8391i);
            return;
        }
        AdError adError = new AdError(105, "Unity Ads requires an Activity context to load ads.", UnityMediationAdapter.ADAPTER_ERROR_DOMAIN);
        Log.e(UnityMediationAdapter.TAG, adError.toString());
        MediationRewardedAdCallback mediationRewardedAdCallback = this.f8387e;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdFailedToShow(adError);
        }
    }
}
