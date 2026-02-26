package com.google.ads.mediation.applovin;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.google.ads.mediation.applovin.d;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: AppLovinWaterfallRewardedRenderer.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    protected static final HashMap<String, WeakReference<k>> f8280c = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f8282b;

    /* JADX INFO: compiled from: AppLovinWaterfallRewardedRenderer.java */
    class a implements d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f8283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f8284b;

        a(Bundle bundle, Context context) {
            this.f8283a = bundle;
            this.f8284b = context;
        }

        @Override // com.google.ads.mediation.applovin.d.b
        public void onInitializeSuccess() {
            k.this.f8281a = AppLovinUtils.retrieveZoneId(this.f8283a);
            k kVar = k.this;
            kVar.appLovinSdk = kVar.appLovinInitializer.c(this.f8284b);
            boolean z10 = true;
            String str = String.format("Requesting rewarded video for zone '%s'", k.this.f8281a);
            String str2 = g.TAG;
            Log.d(str2, str);
            HashMap<String, WeakReference<k>> map = k.f8280c;
            if (!map.containsKey(k.this.f8281a)) {
                map.put(k.this.f8281a, new WeakReference<>(k.this));
                z10 = false;
            }
            if (z10) {
                AdError adError = new AdError(105, "Cannot load multiple rewarded ads with the same Zone ID. Display one ad before attempting to load another.", AppLovinMediationAdapter.ERROR_DOMAIN);
                Log.e(str2, adError.toString());
                k.this.adLoadCallback.onFailure(adError);
                return;
            }
            if (Objects.equals(k.this.f8281a, "")) {
                k kVar2 = k.this;
                kVar2.incentivizedInterstitial = kVar2.appLovinAdFactory.b(kVar2.appLovinSdk);
            } else {
                k kVar3 = k.this;
                kVar3.incentivizedInterstitial = kVar3.appLovinAdFactory.c(kVar3.f8281a, k.this.appLovinSdk);
            }
            k kVar4 = k.this;
            kVar4.incentivizedInterstitial.preload(kVar4);
        }
    }

    protected k(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback, @NonNull d dVar, @NonNull com.google.ads.mediation.applovin.a aVar, @NonNull h hVar) {
        super(mediationRewardedAdConfiguration, mediationAdLoadCallback, dVar, aVar, hVar);
        this.f8282b = false;
    }

    @Override // com.google.ads.mediation.applovin.g, com.applovin.sdk.AppLovinAdDisplayListener
    public void adHidden(@NonNull AppLovinAd appLovinAd) {
        f8280c.remove(this.f8281a);
        super.adHidden(appLovinAd);
    }

    @Override // com.google.ads.mediation.applovin.g, com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(@NonNull AppLovinAd appLovinAd) {
        AtomicBoolean atomicBoolean = AppLovinMediationAdapter.firstLoadDone;
        if (atomicBoolean.get()) {
            if (this.f8282b) {
                f8280c.remove(this.f8281a);
            }
            super.adReceived(appLovinAd);
        } else {
            Log.d(g.TAG, "(latency fix) skipping first load");
            atomicBoolean.set(true);
            f8280c.remove(this.f8281a);
        }
    }

    @Override // com.google.ads.mediation.applovin.g, com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i10) {
        f8280c.remove(this.f8281a);
        AtomicBoolean atomicBoolean = AppLovinMediationAdapter.firstLoadDone;
        if (atomicBoolean.get()) {
            super.failedToReceiveAd(i10);
        } else {
            Log.d(g.TAG, "(latency fix) skipping first load");
            atomicBoolean.set(true);
        }
    }

    @Override // com.google.ads.mediation.applovin.g
    public void loadAd() {
        Context context = this.adConfiguration.getContext();
        Bundle serverParameters = this.adConfiguration.getServerParameters();
        String string = serverParameters.getString(AppLovinUtils.ServerParameterKeys.SDK_KEY);
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(110, "Missing or invalid SDK Key.", AppLovinMediationAdapter.APPLOVIN_SDK_ERROR_DOMAIN);
            Log.e(g.TAG, adError.toString());
            this.adLoadCallback.onFailure(adError);
        } else {
            if (AppLovinUtils.isMultiAdsEnabled()) {
                this.f8282b = true;
            }
            this.appLovinInitializer.b(context, string, new a(serverParameters, context));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(@NonNull Context context) {
        this.appLovinSdk.getSettings().setMuted(AppLovinUtils.shouldMuteAudio(this.adConfiguration.getMediationExtras()));
        String str = this.f8281a;
        if (str != null) {
            Log.d(g.TAG, String.format("Showing rewarded video for zone '%s'", str));
        }
        if (this.incentivizedInterstitial.isAdReadyToDisplay()) {
            this.incentivizedInterstitial.show(context, this, this, this, this);
            return;
        }
        AdError adError = new AdError(106, "Ad not ready to show.", AppLovinMediationAdapter.ERROR_DOMAIN);
        Log.e(g.TAG, adError.toString());
        this.rewardedAdCallback.onAdFailedToShow(adError);
    }
}
