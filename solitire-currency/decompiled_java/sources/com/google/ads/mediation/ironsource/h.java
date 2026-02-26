package com.google.ads.mediation.ironsource;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.applovin.mediation.AppLovinExtras;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.interstitial.InterstitialAd;
import com.unity3d.ironsourceads.interstitial.InterstitialAdListener;
import com.unity3d.ironsourceads.interstitial.InterstitialAdLoader;
import com.unity3d.ironsourceads.interstitial.InterstitialAdLoaderListener;
import com.unity3d.ironsourceads.interstitial.InterstitialAdRequest;

/* JADX INFO: compiled from: IronSourceRtbInterstitialAd.java */
/* JADX INFO: loaded from: classes2.dex */
public class h implements MediationInterstitialAd, InterstitialAdLoaderListener, InterstitialAdListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    private MediationInterstitialAdCallback f8322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> f8323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f8324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f8325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private InterstitialAd f8326e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f8327f;

    public h(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, @NonNull MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        this.f8324c = mediationInterstitialAdConfiguration.getServerParameters().getString("instanceId", "");
        this.f8325d = mediationInterstitialAdConfiguration.getBidResponse();
        this.f8327f = mediationInterstitialAdConfiguration.getWatermark();
        this.f8323b = mediationAdLoadCallback;
    }

    private void b(@NonNull AdError adError) {
        Log.e(c.f8309a, adError.toString());
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f8322a;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdFailedToShow(adError);
        }
    }

    public void a() {
        if (TextUtils.isEmpty(this.f8324c)) {
            this.f8323b.onFailure(r1.a.a(101, "Missing or invalid instance ID."));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(AppLovinExtras.Keys.KEY_WATERMARK, this.f8327f);
            InterstitialAdLoader.loadAd(new InterstitialAdRequest.Builder(this.f8324c, this.f8325d).withExtraParams(bundle).build(), this);
        }
    }

    @Override // com.unity3d.ironsourceads.interstitial.InterstitialAdListener
    public void onInterstitialAdClicked(@NonNull InterstitialAd interstitialAd) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f8322a;
        if (mediationInterstitialAdCallback == null) {
            return;
        }
        mediationInterstitialAdCallback.reportAdClicked();
    }

    @Override // com.unity3d.ironsourceads.interstitial.InterstitialAdListener
    public void onInterstitialAdDismissed(@NonNull InterstitialAd interstitialAd) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f8322a;
        if (mediationInterstitialAdCallback == null) {
            return;
        }
        mediationInterstitialAdCallback.onAdClosed();
    }

    @Override // com.unity3d.ironsourceads.interstitial.InterstitialAdListener
    public void onInterstitialAdFailedToShow(@NonNull InterstitialAd interstitialAd, @NonNull IronSourceError ironSourceError) {
        b(r1.a.b(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage()));
    }

    @Override // com.unity3d.ironsourceads.interstitial.InterstitialAdLoaderListener
    public void onInterstitialAdLoadFailed(@NonNull IronSourceError ironSourceError) {
        Log.e(c.f8309a, ironSourceError.toString());
        this.f8323b.onFailure(r1.a.b(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage()));
    }

    @Override // com.unity3d.ironsourceads.interstitial.InterstitialAdLoaderListener
    public void onInterstitialAdLoaded(@NonNull InterstitialAd interstitialAd) {
        this.f8326e = interstitialAd;
        this.f8322a = this.f8323b.onSuccess(this);
    }

    @Override // com.unity3d.ironsourceads.interstitial.InterstitialAdListener
    public void onInterstitialAdShown(@NonNull InterstitialAd interstitialAd) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f8322a;
        if (mediationInterstitialAdCallback == null) {
            return;
        }
        mediationInterstitialAdCallback.onAdOpened();
        this.f8322a.reportAdImpression();
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAd
    public void showAd(@NonNull Context context) {
        InterstitialAd interstitialAd = this.f8326e;
        if (interstitialAd == null) {
            b(r1.a.a(107, "ad is null"));
            return;
        }
        try {
            interstitialAd.setListener(this);
            this.f8326e.show((Activity) context);
        } catch (ClassCastException unused) {
            b(r1.a.a(102, "IronSource requires an Activity context to load ads."));
        }
    }
}
