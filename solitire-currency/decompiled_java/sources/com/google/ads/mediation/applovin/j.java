package com.google.ads.mediation.applovin;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.google.ads.mediation.applovin.d;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: compiled from: AppLovinWaterfallInterstitialAd.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    protected static final HashMap<String, WeakReference<j>> f8273e = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AppLovinSdk f8274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f8275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f8276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8277d;

    /* JADX INFO: compiled from: AppLovinWaterfallInterstitialAd.java */
    class a implements d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f8278a;

        a(Bundle bundle) {
            this.f8278a = bundle;
        }

        @Override // com.google.ads.mediation.applovin.d.b
        public void onInitializeSuccess() {
            j.this.zoneId = AppLovinUtils.retrieveZoneId(this.f8278a);
            HashMap<String, WeakReference<j>> map = j.f8273e;
            if (map.containsKey(j.this.zoneId) && map.get(j.this.zoneId).get() != null) {
                AdError adError = new AdError(105, e.ERROR_MSG_MULTIPLE_INTERSTITIAL_AD, AppLovinMediationAdapter.ERROR_DOMAIN);
                Log.e(e.TAG, adError.getMessage());
                j.this.interstitialAdLoadCallback.onFailure(adError);
                return;
            }
            map.put(j.this.zoneId, new WeakReference<>(j.this));
            j jVar = j.this;
            jVar.f8274a = jVar.appLovinInitializer.c(jVar.f8275b);
            j jVar2 = j.this;
            jVar2.f8276c = jVar2.f8276c;
            Log.d(e.TAG, "Requesting interstitial for zone: " + j.this.zoneId);
            if (TextUtils.isEmpty(j.this.zoneId)) {
                j.this.f8274a.getAdService().loadNextAd(AppLovinAdSize.INTERSTITIAL, j.this);
                return;
            }
            AppLovinAdService adService = j.this.f8274a.getAdService();
            j jVar3 = j.this;
            adService.loadNextAdForZoneId(jVar3.zoneId, jVar3);
        }
    }

    public j(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, @NonNull MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback, @NonNull d dVar, @NonNull com.google.ads.mediation.applovin.a aVar) {
        super(mediationInterstitialAdConfiguration, mediationAdLoadCallback, dVar, aVar);
        this.f8277d = false;
    }

    @Override // com.google.ads.mediation.applovin.e, com.applovin.sdk.AppLovinAdDisplayListener
    public void adHidden(AppLovinAd appLovinAd) {
        f();
        super.adHidden(appLovinAd);
    }

    @Override // com.google.ads.mediation.applovin.e, com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        if (this.f8277d) {
            f();
        }
        super.adReceived(appLovinAd);
    }

    void f() {
        if (TextUtils.isEmpty(this.zoneId)) {
            return;
        }
        HashMap<String, WeakReference<j>> map = f8273e;
        if (map.containsKey(this.zoneId) && equals(map.get(this.zoneId).get())) {
            map.remove(this.zoneId);
        }
    }

    @Override // com.google.ads.mediation.applovin.e, com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i10) {
        f();
        super.failedToReceiveAd(i10);
    }

    @Override // com.google.ads.mediation.applovin.e
    public void loadAd() {
        this.f8275b = this.interstitialAdConfiguration.getContext();
        Bundle serverParameters = this.interstitialAdConfiguration.getServerParameters();
        String string = serverParameters.getString(AppLovinUtils.ServerParameterKeys.SDK_KEY);
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(110, "Missing or invalid SDK Key.", AppLovinMediationAdapter.APPLOVIN_SDK_ERROR_DOMAIN);
            Log.e(e.TAG, adError.getMessage());
            this.interstitialAdLoadCallback.onFailure(adError);
        } else {
            if (AppLovinUtils.isMultiAdsEnabled()) {
                this.f8277d = true;
            }
            this.appLovinInitializer.b(this.f8275b, string, new a(serverParameters));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAd
    public void showAd(Context context) {
        this.f8274a.getSettings().setMuted(AppLovinUtils.shouldMuteAudio(this.f8276c));
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialogD = this.appLovinAdFactory.d(this.f8274a, context);
        appLovinInterstitialAdDialogD.setAdDisplayListener(this);
        appLovinInterstitialAdDialogD.setAdClickListener(this);
        appLovinInterstitialAdDialogD.setAdVideoPlaybackListener(this);
        if (this.appLovinInterstitialAd == null) {
            String str = e.TAG;
            Log.d(str, "Attempting to show interstitial before one was loaded.");
            if (TextUtils.isEmpty(this.zoneId)) {
                Log.d(str, "Showing interstitial preloaded by SDK.");
                appLovinInterstitialAdDialogD.show();
                return;
            }
            return;
        }
        Log.d(e.TAG, "Showing interstitial for zone: " + this.zoneId);
        appLovinInterstitialAdDialogD.showAndRender(this.appLovinInterstitialAd);
    }
}
