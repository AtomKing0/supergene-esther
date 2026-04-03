package com.google.ads.mediation.ironsource;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.ironsource.mediationsdk.IronSource;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: IronSourceInterstitialAd.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements MediationInterstitialAd {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    static final ConcurrentHashMap<String, WeakReference<d>> f8310e = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final e f8311f = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MediationInterstitialAdCallback f8312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> f8313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f8314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f8315d;

    public d(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, @NonNull MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        this.f8315d = mediationInterstitialAdConfiguration.getServerParameters().getString("instanceId", "0");
        this.f8314c = mediationInterstitialAdConfiguration.getContext();
        this.f8313b = mediationAdLoadCallback;
    }

    static d a(@NonNull String str) {
        ConcurrentHashMap<String, WeakReference<d>> concurrentHashMap = f8310e;
        if (concurrentHashMap.containsKey(str)) {
            return concurrentHashMap.get(str).get();
        }
        return null;
    }

    static e c() {
        return f8311f;
    }

    private boolean e() {
        AdError adErrorF = r1.a.f(this.f8314c, this.f8315d);
        if (adErrorF != null) {
            h(adErrorF);
            return false;
        }
        if (r1.a.c(this.f8315d, f8310e)) {
            return true;
        }
        h(new AdError(103, String.format("An IronSource interstitial ad is already loading for instance ID: %s", this.f8315d), IronSourceMediationAdapter.ADAPTER_ERROR_DOMAIN));
        return false;
    }

    private boolean f() {
        if (!e()) {
            return false;
        }
        f8310e.put(this.f8315d, new WeakReference<>(this));
        Log.d(c.f8309a, String.format("Loading IronSource interstitial ad with instance ID: %s", this.f8315d));
        return true;
    }

    private void h(@NonNull AdError adError) {
        Log.e(c.f8309a, adError.toString());
        MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback = this.f8313b;
        if (mediationAdLoadCallback != null) {
            mediationAdLoadCallback.onFailure(adError);
        }
    }

    static void i(@NonNull String str) {
        f8310e.remove(str);
    }

    MediationInterstitialAdCallback b() {
        return this.f8312a;
    }

    public MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> d() {
        return this.f8313b;
    }

    public void g() {
        if (f()) {
            IronSource.loadISDemandOnlyInterstitial((Activity) this.f8314c, this.f8315d);
        }
    }

    void j(@NonNull MediationInterstitialAdCallback mediationInterstitialAdCallback) {
        this.f8312a = mediationInterstitialAdCallback;
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAd
    public void showAd(@NonNull Context context) {
        IronSource.showISDemandOnlyInterstitial(this.f8315d);
    }
}
