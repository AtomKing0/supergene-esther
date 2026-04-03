package com.google.ads.mediation.unity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.core.domain.GetAndroidAdPlayerContext;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class UnityMediationBannerAd implements MediationBannerAd, BannerView.IListener {
    static final String ERROR_MSG_INITIALIZATION_FAILED_FOR_GAME_ID = "Unity Ads initialization failed for game ID '%s' with error message: %s";
    static final String ERROR_MSG_NO_MATCHING_AD_SIZE = "There is no matching Unity Ads ad size for Google ad size: ";
    private String bannerPlacementId;
    private String gameId;

    @Nullable
    private MediationBannerAdCallback mediationBannerAdCallback;
    private final MediationBannerAdConfiguration mediationBannerAdConfiguration;
    private final MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationBannerAdLoadCallback;
    private final b unityAdsLoader;
    private final d unityBannerViewFactory;

    @Nullable
    private e unityBannerViewWrapper;
    private final f unityInitializer;

    class a implements IUnityAdsInitializationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f8346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f8347b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ UnityBannerSize f8348c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f8349d;

        a(Context context, Activity activity, UnityBannerSize unityBannerSize, String str) {
            this.f8346a = context;
            this.f8347b = activity;
            this.f8348c = unityBannerSize;
            this.f8349d = str;
        }

        @Override // com.unity3d.ads.IUnityAdsInitializationListener
        public void onInitializationComplete() throws JSONException {
            Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads is initialized for game ID '%s' and can now load banner ad with placement ID: %s", UnityMediationBannerAd.this.gameId, UnityMediationBannerAd.this.bannerPlacementId));
            com.google.ads.mediation.unity.a.k(MobileAds.getRequestConfiguration().getTagForChildDirectedTreatment(), this.f8346a);
            if (UnityMediationBannerAd.this.unityBannerViewWrapper == null) {
                UnityMediationBannerAd unityMediationBannerAd = UnityMediationBannerAd.this;
                unityMediationBannerAd.unityBannerViewWrapper = unityMediationBannerAd.unityBannerViewFactory.a(this.f8347b, UnityMediationBannerAd.this.bannerPlacementId, this.f8348c);
            }
            UnityMediationBannerAd.this.unityBannerViewWrapper.c(UnityMediationBannerAd.this);
            UnityAdsLoadOptions unityAdsLoadOptionsA = UnityMediationBannerAd.this.unityAdsLoader.a();
            unityAdsLoadOptionsA.set("watermark", UnityMediationBannerAd.this.mediationBannerAdConfiguration.getWatermark());
            String str = this.f8349d;
            if (str != null) {
                unityAdsLoadOptionsA.setAdMarkup(str);
            }
            UnityMediationBannerAd.this.unityBannerViewWrapper.b(unityAdsLoadOptionsA);
        }

        @Override // com.unity3d.ads.IUnityAdsInitializationListener
        public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
            AdError adErrorC = com.google.ads.mediation.unity.a.c(unityAdsInitializationError, String.format(UnityMediationBannerAd.ERROR_MSG_INITIALIZATION_FAILED_FOR_GAME_ID, UnityMediationBannerAd.this.gameId, str));
            Log.w(UnityMediationAdapter.TAG, adErrorC.toString());
            UnityMediationBannerAd.this.mediationBannerAdLoadCallback.onFailure(adErrorC);
        }
    }

    public UnityMediationBannerAd(@NonNull MediationBannerAdConfiguration mediationBannerAdConfiguration, @NonNull MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback, @NonNull f fVar, @NonNull d dVar, @NonNull b bVar) {
        this.mediationBannerAdConfiguration = mediationBannerAdConfiguration;
        this.mediationBannerAdLoadCallback = mediationAdLoadCallback;
        this.unityBannerViewFactory = dVar;
        this.unityInitializer = fVar;
        this.unityAdsLoader = bVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAd
    @NonNull
    public View getView() {
        return this.unityBannerViewWrapper.a();
    }

    public void loadAd() throws JSONException {
        Context context = this.mediationBannerAdConfiguration.getContext();
        Bundle serverParameters = this.mediationBannerAdConfiguration.getServerParameters();
        AdSize adSize = this.mediationBannerAdConfiguration.getAdSize();
        this.gameId = serverParameters.getString(GetAndroidAdPlayerContext.KEY_GAME_ID);
        String string = serverParameters.getString("zoneId");
        this.bannerPlacementId = string;
        if (!com.google.ads.mediation.unity.a.a(this.gameId, string)) {
            AdError adError = new AdError(101, "Missing or invalid server parameters.", UnityMediationAdapter.ADAPTER_ERROR_DOMAIN);
            Log.w(UnityMediationAdapter.TAG, adError.toString());
            this.mediationBannerAdLoadCallback.onFailure(adError);
            return;
        }
        if (!(context instanceof Activity)) {
            AdError adError2 = new AdError(105, "Unity Ads requires an Activity context to load ads.", UnityMediationAdapter.ADAPTER_ERROR_DOMAIN);
            Log.w(UnityMediationAdapter.TAG, adError2.toString());
            this.mediationBannerAdLoadCallback.onFailure(adError2);
            return;
        }
        Activity activity = (Activity) context;
        UnityBannerSize unityBannerSizeJ = com.google.ads.mediation.unity.a.j(context, adSize);
        if (unityBannerSizeJ != null) {
            this.unityInitializer.b(context, this.gameId, new a(context, activity, unityBannerSizeJ, this.mediationBannerAdConfiguration.getBidResponse()));
            return;
        }
        AdError adError3 = new AdError(110, ERROR_MSG_NO_MATCHING_AD_SIZE + adSize, UnityMediationAdapter.ADAPTER_ERROR_DOMAIN);
        Log.w(UnityMediationAdapter.TAG, adError3.toString());
        this.mediationBannerAdLoadCallback.onFailure(adError3);
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerClick(BannerView bannerView) {
        Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads banner ad was clicked for placement ID: %s", bannerView.getPlacementId()));
        MediationBannerAdCallback mediationBannerAdCallback = this.mediationBannerAdCallback;
        if (mediationBannerAdCallback == null) {
            return;
        }
        mediationBannerAdCallback.reportAdClicked();
        this.mediationBannerAdCallback.onAdOpened();
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo) {
        AdError adErrorB = com.google.ads.mediation.unity.a.b(com.google.ads.mediation.unity.a.i(bannerErrorInfo), bannerErrorInfo.errorMessage);
        Log.w(UnityMediationAdapter.TAG, adErrorB.toString());
        this.mediationBannerAdLoadCallback.onFailure(adErrorB);
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerLeftApplication(BannerView bannerView) {
        Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads banner ad left application for placement ID: %s", bannerView.getPlacementId()));
        MediationBannerAdCallback mediationBannerAdCallback = this.mediationBannerAdCallback;
        if (mediationBannerAdCallback == null) {
            return;
        }
        mediationBannerAdCallback.onAdLeftApplication();
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerLoaded(BannerView bannerView) {
        Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads finished loading banner ad for placement ID: %s", bannerView.getPlacementId()));
        this.mediationBannerAdCallback = this.mediationBannerAdLoadCallback.onSuccess(this);
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerShown(BannerView bannerView) {
        Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads banner ad was shown for placement ID: %s", bannerView.getPlacementId()));
        MediationBannerAdCallback mediationBannerAdCallback = this.mediationBannerAdCallback;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.reportAdImpression();
        }
    }
}
