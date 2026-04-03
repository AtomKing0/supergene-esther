package com.applovin.mediation;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.ads.mediation.applovin.AppLovinMediationAdapter;
import com.google.ads.mediation.applovin.d;
import com.google.ads.mediation.applovin.e;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ApplovinAdapter extends AppLovinMediationAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, OnContextChangedListener {
    private static final boolean LOGGING_ENABLED = true;
    private static final HashMap<String, WeakReference<ApplovinAdapter>> appLovinInterstitialAds = new HashMap<>();
    private AppLovinAdView adView;
    private AppLovinAd appLovinInterstitialAd;
    private Context context;
    private boolean enableMultipleAdLoading = false;
    private MediationInterstitialListener mediationInterstitialListener;
    private Bundle networkExtras;
    private AppLovinSdk sdk;
    private String zoneId;

    /* JADX INFO: renamed from: com.applovin.mediation.ApplovinAdapter$1, reason: invalid class name */
    class AnonymousClass1 implements d.b {
        final /* synthetic */ Context val$context;
        final /* synthetic */ MediationInterstitialListener val$interstitialListener;
        final /* synthetic */ Bundle val$networkExtras;
        final /* synthetic */ Bundle val$serverParameters;

        AnonymousClass1(Bundle bundle, MediationInterstitialListener mediationInterstitialListener, Context context, Bundle bundle2) {
            this.val$serverParameters = bundle;
            this.val$interstitialListener = mediationInterstitialListener;
            this.val$context = context;
            this.val$networkExtras = bundle2;
        }

        @Override // com.google.ads.mediation.applovin.d.b
        public void onInitializeSuccess() {
            ApplovinAdapter.this.zoneId = AppLovinUtils.retrieveZoneId(this.val$serverParameters);
            if (ApplovinAdapter.appLovinInterstitialAds.containsKey(ApplovinAdapter.this.zoneId) && ((WeakReference) ApplovinAdapter.appLovinInterstitialAds.get(ApplovinAdapter.this.zoneId)).get() != null) {
                AdError adError = new AdError(105, e.ERROR_MSG_MULTIPLE_INTERSTITIAL_AD, AppLovinMediationAdapter.ERROR_DOMAIN);
                ApplovinAdapter.log(6, adError.getMessage());
                this.val$interstitialListener.onAdFailedToLoad(ApplovinAdapter.this, adError);
                return;
            }
            ApplovinAdapter.appLovinInterstitialAds.put(ApplovinAdapter.this.zoneId, new WeakReference(ApplovinAdapter.this));
            ApplovinAdapter.this.sdk = d.a().c(this.val$context);
            ApplovinAdapter.this.context = this.val$context;
            ApplovinAdapter.this.networkExtras = this.val$networkExtras;
            ApplovinAdapter.this.mediationInterstitialListener = this.val$interstitialListener;
            ApplovinAdapter.log(3, "Requesting interstitial for zone: " + ApplovinAdapter.this.zoneId);
            AppLovinAdLoadListener appLovinAdLoadListener = new AppLovinAdLoadListener() { // from class: com.applovin.mediation.ApplovinAdapter.1.1
                @Override // com.applovin.sdk.AppLovinAdLoadListener
                public void adReceived(AppLovinAd appLovinAd) {
                    ApplovinAdapter.log(3, "Interstitial did load ad: for zone: " + ApplovinAdapter.this.zoneId);
                    ApplovinAdapter.this.appLovinInterstitialAd = appLovinAd;
                    if (ApplovinAdapter.this.enableMultipleAdLoading) {
                        ApplovinAdapter.this.unregister();
                    }
                    AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.mediation.ApplovinAdapter.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ApplovinAdapter.this.mediationInterstitialListener.onAdLoaded(ApplovinAdapter.this);
                        }
                    });
                }

                @Override // com.applovin.sdk.AppLovinAdLoadListener
                public void failedToReceiveAd(int i10) {
                    final AdError adError2 = AppLovinUtils.getAdError(i10);
                    ApplovinAdapter.log(5, adError2.getMessage());
                    ApplovinAdapter.this.unregister();
                    AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.mediation.ApplovinAdapter.1.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ApplovinAdapter.this.mediationInterstitialListener.onAdFailedToLoad(ApplovinAdapter.this, adError2);
                        }
                    });
                }
            };
            if (TextUtils.isEmpty(ApplovinAdapter.this.zoneId)) {
                ApplovinAdapter.this.sdk.getAdService().loadNextAd(AppLovinAdSize.INTERSTITIAL, appLovinAdLoadListener);
            } else {
                ApplovinAdapter.this.sdk.getAdService().loadNextAdForZoneId(ApplovinAdapter.this.zoneId, appLovinAdLoadListener);
            }
        }
    }

    public static void log(int i10, String str) {
        Log.println(i10, "AppLovinAdapter", str);
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    @NonNull
    public View getBannerView() {
        return this.adView;
    }

    @Override // com.google.android.gms.ads.mediation.OnContextChangedListener
    public void onContextChanged(@NonNull Context context) {
        log(3, "Context changed: " + context);
        this.context = context;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(@NonNull final Context context, @NonNull final MediationBannerListener mediationBannerListener, @NonNull final Bundle bundle, @NonNull AdSize adSize, @NonNull MediationAdRequest mediationAdRequest, @Nullable Bundle bundle2) {
        if (AppLovinUtils.isChildUser()) {
            mediationBannerListener.onAdFailedToLoad(this, AppLovinUtils.getChildUserError());
            return;
        }
        String string = bundle.getString(AppLovinUtils.ServerParameterKeys.SDK_KEY);
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(110, "Missing or invalid SDK Key.", AppLovinMediationAdapter.ERROR_DOMAIN);
            log(6, adError.getMessage());
            mediationBannerListener.onAdFailedToLoad(this, adError);
            return;
        }
        final AppLovinAdSize appLovinAdSizeAppLovinAdSizeFromAdMobAdSize = AppLovinUtils.appLovinAdSizeFromAdMobAdSize(context, adSize);
        if (appLovinAdSizeAppLovinAdSizeFromAdMobAdSize != null) {
            d.a().b(context, string, new d.b() { // from class: com.applovin.mediation.ApplovinAdapter.2
                @Override // com.google.ads.mediation.applovin.d.b
                public void onInitializeSuccess() {
                    ApplovinAdapter.this.sdk = d.a().c(context);
                    ApplovinAdapter.this.zoneId = AppLovinUtils.retrieveZoneId(bundle);
                    ApplovinAdapter.log(3, "Requesting banner of size " + appLovinAdSizeAppLovinAdSizeFromAdMobAdSize + " for zone: " + ApplovinAdapter.this.zoneId);
                    ApplovinAdapter.this.adView = new AppLovinAdView(ApplovinAdapter.this.sdk, appLovinAdSizeAppLovinAdSizeFromAdMobAdSize, context);
                    AppLovinBannerAdListener appLovinBannerAdListener = new AppLovinBannerAdListener(ApplovinAdapter.this.zoneId, ApplovinAdapter.this.adView, ApplovinAdapter.this, mediationBannerListener);
                    ApplovinAdapter.this.adView.setAdDisplayListener(appLovinBannerAdListener);
                    ApplovinAdapter.this.adView.setAdClickListener(appLovinBannerAdListener);
                    ApplovinAdapter.this.adView.setAdViewEventListener(appLovinBannerAdListener);
                    if (TextUtils.isEmpty(ApplovinAdapter.this.zoneId)) {
                        ApplovinAdapter.this.sdk.getAdService().loadNextAd(appLovinAdSizeAppLovinAdSizeFromAdMobAdSize, appLovinBannerAdListener);
                    } else {
                        ApplovinAdapter.this.sdk.getAdService().loadNextAdForZoneId(ApplovinAdapter.this.zoneId, appLovinBannerAdListener);
                    }
                }
            });
            return;
        }
        AdError adError2 = new AdError(101, "Failed to request banner with unsupported size.", AppLovinMediationAdapter.ERROR_DOMAIN);
        log(6, adError2.getMessage());
        mediationBannerListener.onAdFailedToLoad(this, adError2);
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(@NonNull Context context, @NonNull MediationInterstitialListener mediationInterstitialListener, @NonNull Bundle bundle, @NonNull MediationAdRequest mediationAdRequest, @Nullable Bundle bundle2) {
        if (AppLovinUtils.isChildUser()) {
            mediationInterstitialListener.onAdFailedToLoad(this, AppLovinUtils.getChildUserError());
            return;
        }
        String string = bundle.getString(AppLovinUtils.ServerParameterKeys.SDK_KEY);
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(110, "Missing or invalid SDK Key.", AppLovinMediationAdapter.ERROR_DOMAIN);
            log(6, adError.getMessage());
            mediationInterstitialListener.onAdFailedToLoad(this, adError);
        } else {
            if (AppLovinUtils.isMultiAdsEnabled()) {
                this.enableMultipleAdLoading = true;
            }
            d.a().b(context, string, new AnonymousClass1(bundle, mediationInterstitialListener, context, bundle2));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        this.sdk.getSettings().setMuted(AppLovinUtils.shouldMuteAudio(this.networkExtras));
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialogCreate = AppLovinInterstitialAd.create(this.sdk, this.context);
        AppLovinInterstitialAdListener appLovinInterstitialAdListener = new AppLovinInterstitialAdListener(this, this.mediationInterstitialListener);
        appLovinInterstitialAdDialogCreate.setAdDisplayListener(appLovinInterstitialAdListener);
        appLovinInterstitialAdDialogCreate.setAdClickListener(appLovinInterstitialAdListener);
        appLovinInterstitialAdDialogCreate.setAdVideoPlaybackListener(appLovinInterstitialAdListener);
        if (this.appLovinInterstitialAd != null) {
            log(3, "Showing interstitial for zone: " + this.zoneId);
            appLovinInterstitialAdDialogCreate.showAndRender(this.appLovinInterstitialAd);
            return;
        }
        log(3, "Attempting to show interstitial before one was loaded.");
        if (TextUtils.isEmpty(this.zoneId)) {
            log(3, "Showing interstitial preloaded by SDK.");
            appLovinInterstitialAdDialogCreate.show();
        } else {
            this.mediationInterstitialListener.onAdOpened(this);
            this.mediationInterstitialListener.onAdClosed(this);
        }
    }

    void unregister() {
        if (TextUtils.isEmpty(this.zoneId)) {
            return;
        }
        HashMap<String, WeakReference<ApplovinAdapter>> map = appLovinInterstitialAds;
        if (map.containsKey(this.zoneId) && equals(map.get(this.zoneId).get())) {
            map.remove(this.zoneId);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onDestroy() {
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onPause() {
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onResume() {
    }
}
