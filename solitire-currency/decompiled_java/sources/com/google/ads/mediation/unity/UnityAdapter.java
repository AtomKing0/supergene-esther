package com.google.ads.mediation.unity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.ads.mediation.unity.a;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
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

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class UnityAdapter extends UnityMediationAdapter implements MediationInterstitialAdapter, MediationBannerAdapter {
    private WeakReference<Activity> activityWeakReference;
    private UnityBannerAd bannerAd;
    private s1.b eventAdapter;
    private MediationInterstitialListener mediationInterstitialListener;
    private String objectId;
    private String placementId;
    private final IUnityAdsLoadListener unityLoadListener = new a();
    private final IUnityAdsShowListener unityShowListener = new c();

    class a implements IUnityAdsLoadListener {
        a() {
        }

        @Override // com.unity3d.ads.IUnityAdsLoadListener
        public void onUnityAdsAdLoaded(String str) {
            Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads interstitial ad successfully loaded for placement ID: %s", str));
            UnityAdapter.this.placementId = str;
            UnityAdapter.this.eventAdapter.a(a.b.LOADED);
        }

        @Override // com.unity3d.ads.IUnityAdsLoadListener
        public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
            UnityAdapter.this.placementId = str;
            AdError adErrorD = com.google.ads.mediation.unity.a.d(unityAdsLoadError, str2);
            Log.w(UnityMediationAdapter.TAG, adErrorD.toString());
            if (UnityAdapter.this.mediationInterstitialListener != null) {
                UnityAdapter.this.mediationInterstitialListener.onAdFailedToLoad(UnityAdapter.this, adErrorD);
            }
        }
    }

    class b implements IUnityAdsInitializationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8336a;

        b(String str) {
            this.f8336a = str;
        }

        @Override // com.unity3d.ads.IUnityAdsInitializationListener
        public void onInitializationComplete() {
            Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads is initialized for game ID '%s' and can now load interstitial ad with placement ID: %s", this.f8336a, UnityAdapter.this.placementId));
        }

        @Override // com.unity3d.ads.IUnityAdsInitializationListener
        public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
            AdError adErrorC = com.google.ads.mediation.unity.a.c(unityAdsInitializationError, String.format("Unity Ads initialization failed for game ID '%s' with error message: %s", this.f8336a, str));
            Log.w(UnityMediationAdapter.TAG, adErrorC.toString());
            if (UnityAdapter.this.mediationInterstitialListener != null) {
                UnityAdapter.this.mediationInterstitialListener.onAdFailedToLoad(UnityAdapter.this, adErrorC);
            }
        }
    }

    class c implements IUnityAdsShowListener {
        c() {
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowClick(String str) {
            Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads interstitial ad was clicked for placement ID: %s", UnityAdapter.this.placementId));
            UnityAdapter.this.eventAdapter.a(a.b.CLICKED);
            UnityAdapter.this.eventAdapter.a(a.b.LEFT_APPLICATION);
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
            Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads interstitial ad finished playing for placement ID: %s", UnityAdapter.this.placementId));
            UnityAdapter.this.eventAdapter.a(a.b.CLOSED);
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
            Log.w(UnityMediationAdapter.TAG, com.google.ads.mediation.unity.a.e(unityAdsShowError, str2).toString());
            UnityAdapter.this.eventAdapter.a(a.b.OPENED);
            UnityAdapter.this.eventAdapter.a(a.b.CLOSED);
        }

        @Override // com.unity3d.ads.IUnityAdsShowListener
        public void onUnityAdsShowStart(String str) {
            Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads interstitial ad started for placement ID: %s", UnityAdapter.this.placementId));
            UnityAdapter.this.eventAdapter.a(a.b.OPENED);
        }
    }

    private void sendAdFailedToLoad(int i10, String str) {
        AdError adErrorB = com.google.ads.mediation.unity.a.b(i10, str);
        Log.w(UnityMediationAdapter.TAG, adErrorB.toString());
        MediationInterstitialListener mediationInterstitialListener = this.mediationInterstitialListener;
        if (mediationInterstitialListener != null) {
            mediationInterstitialListener.onAdFailedToLoad(this, adErrorB);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    @NonNull
    public View getBannerView() {
        return this.bannerAd.getBannerView();
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onDestroy() {
        this.mediationInterstitialListener = null;
        UnityBannerAd unityBannerAd = this.bannerAd;
        if (unityBannerAd != null) {
            unityBannerAd.onDestroy();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onPause() {
        UnityBannerAd unityBannerAd = this.bannerAd;
        if (unityBannerAd != null) {
            unityBannerAd.onPause();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onResume() {
        UnityBannerAd unityBannerAd = this.bannerAd;
        if (unityBannerAd != null) {
            unityBannerAd.onResume();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(@NonNull Context context, @NonNull MediationBannerListener mediationBannerListener, @NonNull Bundle bundle, @NonNull AdSize adSize, @NonNull MediationAdRequest mediationAdRequest, @Nullable Bundle bundle2) throws JSONException {
        UnityBannerAd unityBannerAd = new UnityBannerAd();
        this.bannerAd = unityBannerAd;
        unityBannerAd.requestBannerAd(context, mediationBannerListener, bundle, adSize, mediationAdRequest, bundle2);
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(@NonNull Context context, @NonNull MediationInterstitialListener mediationInterstitialListener, @NonNull Bundle bundle, @NonNull MediationAdRequest mediationAdRequest, @Nullable Bundle bundle2) throws JSONException {
        this.mediationInterstitialListener = mediationInterstitialListener;
        this.eventAdapter = new s1.b(mediationInterstitialListener, this);
        String string = bundle.getString(GetAndroidAdPlayerContext.KEY_GAME_ID);
        String string2 = bundle.getString("zoneId");
        this.placementId = string2;
        if (!com.google.ads.mediation.unity.a.a(string, string2)) {
            sendAdFailedToLoad(101, "Missing or invalid server parameters.");
            return;
        }
        if (!(context instanceof Activity)) {
            sendAdFailedToLoad(105, "Unity Ads requires an Activity context to load ads.");
            return;
        }
        this.activityWeakReference = new WeakReference<>((Activity) context);
        f.a().b(context, string, new b(string));
        com.google.ads.mediation.unity.a.k(MobileAds.getRequestConfiguration().getTagForChildDirectedTreatment(), context);
        this.objectId = UUID.randomUUID().toString();
        UnityAdsLoadOptions unityAdsLoadOptions = new UnityAdsLoadOptions();
        unityAdsLoadOptions.setObjectId(this.objectId);
        UnityAds.load(this.placementId, unityAdsLoadOptions, this.unityLoadListener);
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        WeakReference<Activity> weakReference = this.activityWeakReference;
        Activity activity = weakReference == null ? null : weakReference.get();
        if (activity != null) {
            if (this.placementId == null) {
                Log.w(UnityMediationAdapter.TAG, "Unity Ads received call to show before successfully loading an ad.");
            }
            UnityAdsShowOptions unityAdsShowOptions = new UnityAdsShowOptions();
            unityAdsShowOptions.setObjectId(this.objectId);
            UnityAds.show(activity, this.placementId, unityAdsShowOptions, this.unityShowListener);
            return;
        }
        Log.w(UnityMediationAdapter.TAG, "Failed to show interstitial ad for placement ID '" + this.placementId + "' from Unity Ads: Activity context is null.");
        this.eventAdapter.a(a.b.CLOSED);
    }
}
