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
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.core.domain.GetAndroidAdPlayerContext;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class UnityBannerAd extends UnityMediationAdapter implements MediationBannerAdapter {
    private String bannerPlacementId;
    private BannerView bannerView;
    private s1.a eventAdapter;
    private String gameId;
    private MediationBannerListener mediationBannerListener;
    private BannerView.IListener unityBannerListener = new a();

    class a extends BannerView.Listener {
        a() {
        }

        private void a(String str, BannerView bannerView) {
            if (bannerView != null) {
                Log.d(UnityMediationAdapter.TAG, String.format(str, bannerView.getPlacementId()));
            }
        }

        @Override // com.unity3d.services.banners.BannerView.Listener, com.unity3d.services.banners.BannerView.IListener
        public void onBannerClick(BannerView bannerView) {
            a("Unity Ads banner ad was clicked for placement ID: %s", bannerView);
            UnityBannerAd.this.eventAdapter.a(a.b.CLICKED);
            UnityBannerAd.this.eventAdapter.a(a.b.OPENED);
        }

        @Override // com.unity3d.services.banners.BannerView.Listener, com.unity3d.services.banners.BannerView.IListener
        public void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo) {
            UnityBannerAd.this.sendBannerFailedToLoad(com.google.ads.mediation.unity.a.i(bannerErrorInfo), bannerErrorInfo.errorMessage);
        }

        @Override // com.unity3d.services.banners.BannerView.Listener, com.unity3d.services.banners.BannerView.IListener
        public void onBannerLeftApplication(BannerView bannerView) {
            a("Unity Ads banner ad left application for placement ID: %s", bannerView);
            UnityBannerAd.this.eventAdapter.a(a.b.LEFT_APPLICATION);
        }

        @Override // com.unity3d.services.banners.BannerView.Listener, com.unity3d.services.banners.BannerView.IListener
        public void onBannerLoaded(BannerView bannerView) {
            a("Unity Ads finished loading banner ad for placement ID: %s", bannerView);
            UnityBannerAd.this.eventAdapter.a(a.b.LOADED);
        }

        @Override // com.unity3d.services.banners.BannerView.Listener, com.unity3d.services.banners.BannerView.IListener
        public void onBannerShown(BannerView bannerView) {
            a("Unity Ads banner ad was shown for placement ID: %s", bannerView);
            UnityBannerAd.this.eventAdapter.a(a.b.IMPRESSION);
        }
    }

    class b implements IUnityAdsInitializationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f8340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ UnityBannerSize f8341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f8342c;

        b(Activity activity, UnityBannerSize unityBannerSize, Context context) {
            this.f8340a = activity;
            this.f8341b = unityBannerSize;
            this.f8342c = context;
        }

        @Override // com.unity3d.ads.IUnityAdsInitializationListener
        public void onInitializationComplete() throws JSONException {
            Log.d(UnityMediationAdapter.TAG, String.format("Unity Ads is initialized for game ID '%s' and can now load banner ad with placement ID: %s", UnityBannerAd.this.gameId, UnityBannerAd.this.bannerPlacementId));
            if (UnityBannerAd.this.bannerView == null) {
                UnityBannerAd.this.bannerView = new BannerView(this.f8340a, UnityBannerAd.this.bannerPlacementId, this.f8341b);
            }
            com.google.ads.mediation.unity.a.k(MobileAds.getRequestConfiguration().getTagForChildDirectedTreatment(), this.f8342c);
            UnityBannerAd.this.bannerView.setListener(UnityBannerAd.this.unityBannerListener);
            UnityBannerAd.this.bannerView.load();
        }

        @Override // com.unity3d.ads.IUnityAdsInitializationListener
        public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
            AdError adErrorC = com.google.ads.mediation.unity.a.c(unityAdsInitializationError, String.format("Unity Ads initialization failed for game ID '%s' with error message: %s", UnityBannerAd.this.gameId, str));
            Log.w(UnityMediationAdapter.TAG, adErrorC.toString());
            if (UnityBannerAd.this.mediationBannerListener != null) {
                UnityBannerAd.this.mediationBannerListener.onAdFailedToLoad(UnityBannerAd.this, adErrorC);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendBannerFailedToLoad(int i10, String str) {
        AdError adErrorB = com.google.ads.mediation.unity.a.b(i10, str);
        Log.w(UnityMediationAdapter.TAG, adErrorB.toString());
        MediationBannerListener mediationBannerListener = this.mediationBannerListener;
        if (mediationBannerListener != null) {
            mediationBannerListener.onAdFailedToLoad(this, adErrorB);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    @NonNull
    public View getBannerView() {
        return this.bannerView;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onDestroy() {
        BannerView bannerView = this.bannerView;
        if (bannerView != null) {
            bannerView.destroy();
        }
        this.bannerView = null;
        this.mediationBannerListener = null;
        this.unityBannerListener = null;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(@NonNull Context context, @NonNull MediationBannerListener mediationBannerListener, @NonNull Bundle bundle, @NonNull AdSize adSize, @NonNull MediationAdRequest mediationAdRequest, @Nullable Bundle bundle2) throws JSONException {
        this.mediationBannerListener = mediationBannerListener;
        this.eventAdapter = new s1.a(mediationBannerListener, this);
        this.gameId = bundle.getString(GetAndroidAdPlayerContext.KEY_GAME_ID);
        String string = bundle.getString("zoneId");
        this.bannerPlacementId = string;
        if (!com.google.ads.mediation.unity.a.a(this.gameId, string)) {
            sendBannerFailedToLoad(101, "Missing or invalid server parameters.");
            return;
        }
        if (!(context instanceof Activity)) {
            sendBannerFailedToLoad(105, "Unity Ads requires an Activity context to load ads.");
            return;
        }
        Activity activity = (Activity) context;
        UnityBannerSize unityBannerSizeJ = com.google.ads.mediation.unity.a.j(context, adSize);
        if (unityBannerSizeJ == null) {
            sendBannerFailedToLoad(110, String.format("There is no matching Unity Ads ad size for Google ad size: %s", adSize));
        } else {
            f.a().b(context, this.gameId, new b(activity, unityBannerSizeJ, context));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onPause() {
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onResume() {
    }
}
