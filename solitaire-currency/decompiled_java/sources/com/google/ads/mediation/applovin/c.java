package com.google.ads.mediation.applovin;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.google.ads.mediation.applovin.d;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;

/* JADX INFO: compiled from: AppLovinBannerAd.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements MediationBannerAd, AppLovinAdLoadListener, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdViewEventListener {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f8248j = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f8249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AppLovinSdk f8250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f8251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d f8253e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.ads.mediation.applovin.a f8254f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MediationBannerAdConfiguration f8255g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> f8256h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MediationBannerAdCallback f8257i;

    /* JADX INFO: compiled from: AppLovinBannerAd.java */
    class a implements d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f8258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppLovinAdSize f8259b;

        a(Bundle bundle, AppLovinAdSize appLovinAdSize) {
            this.f8258a = bundle;
            this.f8259b = appLovinAdSize;
        }

        @Override // com.google.ads.mediation.applovin.d.b
        public void onInitializeSuccess() {
            c cVar = c.this;
            cVar.f8250b = cVar.f8253e.c(c.this.f8251c);
            c.this.f8252d = AppLovinUtils.retrieveZoneId(this.f8258a);
            Log.d(c.f8248j, "Requesting banner of size " + this.f8259b + " for zone: " + c.this.f8252d);
            c cVar2 = c.this;
            cVar2.f8249a = cVar2.f8254f.a(c.this.f8250b, this.f8259b, c.this.f8251c);
            c.this.f8249a.e(c.this);
            c.this.f8249a.d(c.this);
            c.this.f8249a.f(c.this);
            if (TextUtils.isEmpty(c.this.f8252d)) {
                c.this.f8250b.getAdService().loadNextAd(this.f8259b, c.this);
            } else {
                c.this.f8250b.getAdService().loadNextAdForZoneId(c.this.f8252d, c.this);
            }
        }
    }

    private c(@NonNull MediationBannerAdConfiguration mediationBannerAdConfiguration, @NonNull MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback, @NonNull d dVar, @NonNull com.google.ads.mediation.applovin.a aVar) {
        this.f8255g = mediationBannerAdConfiguration;
        this.f8256h = mediationAdLoadCallback;
        this.f8253e = dVar;
        this.f8254f = aVar;
    }

    public static c l(@NonNull MediationBannerAdConfiguration mediationBannerAdConfiguration, @NonNull MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback, @NonNull d dVar, @NonNull com.google.ads.mediation.applovin.a aVar) {
        return new c(mediationBannerAdConfiguration, mediationAdLoadCallback, dVar, aVar);
    }

    @Override // com.applovin.sdk.AppLovinAdClickListener
    public void adClicked(AppLovinAd appLovinAd) {
        Log.d(f8248j, "Banner clicked.");
        MediationBannerAdCallback mediationBannerAdCallback = this.f8257i;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.reportAdClicked();
        }
    }

    @Override // com.applovin.adview.AppLovinAdViewEventListener
    public void adClosedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        Log.d(f8248j, "Banner closed fullscreen.");
        MediationBannerAdCallback mediationBannerAdCallback = this.f8257i;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.onAdClosed();
        }
    }

    @Override // com.applovin.sdk.AppLovinAdDisplayListener
    public void adDisplayed(AppLovinAd appLovinAd) {
        Log.d(f8248j, "Banner displayed.");
        MediationBannerAdCallback mediationBannerAdCallback = this.f8257i;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.onAdOpened();
        }
    }

    @Override // com.applovin.adview.AppLovinAdViewEventListener
    public void adFailedToDisplay(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        Log.w(f8248j, "Banner failed to display: " + appLovinAdViewDisplayErrorCode);
    }

    @Override // com.applovin.sdk.AppLovinAdDisplayListener
    public void adHidden(AppLovinAd appLovinAd) {
        Log.d(f8248j, "Banner dismissed.");
    }

    @Override // com.applovin.adview.AppLovinAdViewEventListener
    public void adLeftApplication(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        Log.d(f8248j, "Banner left application.");
        MediationBannerAdCallback mediationBannerAdCallback = this.f8257i;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.onAdLeftApplication();
        }
    }

    @Override // com.applovin.adview.AppLovinAdViewEventListener
    public void adOpenedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        Log.d(f8248j, "Banner opened fullscreen.");
        MediationBannerAdCallback mediationBannerAdCallback = this.f8257i;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.onAdOpened();
        }
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        Log.d(f8248j, "Banner did load ad for zone: " + this.f8252d);
        this.f8249a.c(appLovinAd);
        this.f8257i = this.f8256h.onSuccess(this);
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i10) {
        AdError adError = AppLovinUtils.getAdError(i10);
        Log.w(f8248j, "Failed to load banner ad with error: " + i10);
        this.f8256h.onFailure(adError);
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAd
    @NonNull
    public View getView() {
        return this.f8249a.a();
    }

    public void k() {
        this.f8251c = this.f8255g.getContext();
        Bundle serverParameters = this.f8255g.getServerParameters();
        AdSize adSize = this.f8255g.getAdSize();
        String string = serverParameters.getString(AppLovinUtils.ServerParameterKeys.SDK_KEY);
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(110, "Missing or invalid SDK Key.", AppLovinMediationAdapter.ERROR_DOMAIN);
            Log.e(f8248j, adError.getMessage());
            this.f8256h.onFailure(adError);
            return;
        }
        AppLovinAdSize appLovinAdSizeAppLovinAdSizeFromAdMobAdSize = AppLovinUtils.appLovinAdSizeFromAdMobAdSize(this.f8251c, adSize);
        if (appLovinAdSizeAppLovinAdSizeFromAdMobAdSize != null) {
            this.f8253e.b(this.f8251c, string, new a(serverParameters, appLovinAdSizeAppLovinAdSizeFromAdMobAdSize));
            return;
        }
        AdError adError2 = new AdError(101, "Failed to request banner with unsupported size.", AppLovinMediationAdapter.ERROR_DOMAIN);
        Log.e(f8248j, adError2.getMessage());
        this.f8256h.onFailure(adError2);
    }
}
