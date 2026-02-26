package com.google.ads.mediation.ironsource;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.ironsource.mediationsdk.IronSource;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: IronSourceRewardedAd.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements MediationRewardedAd {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    static final ConcurrentHashMap<String, WeakReference<f>> f8316e = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final g f8317f = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MediationRewardedAdCallback f8318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> f8319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f8320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f8321d;

    public f(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.f8321d = mediationRewardedAdConfiguration.getServerParameters().getString("instanceId", "0");
        this.f8320c = mediationRewardedAdConfiguration.getContext();
        this.f8319b = mediationAdLoadCallback;
    }

    static f a(@NonNull String str) {
        ConcurrentHashMap<String, WeakReference<f>> concurrentHashMap = f8316e;
        if (concurrentHashMap.containsKey(str)) {
            return concurrentHashMap.get(str).get();
        }
        return null;
    }

    static g b() {
        return f8317f;
    }

    private boolean e() {
        AdError adErrorF = r1.a.f(this.f8320c, this.f8321d);
        if (adErrorF != null) {
            h(adErrorF);
            return false;
        }
        if (r1.a.c(this.f8321d, f8316e)) {
            return true;
        }
        h(new AdError(103, String.format("An IronSource Rewarded ad is already loading for instance ID: %s", this.f8321d), IronSourceMediationAdapter.ADAPTER_ERROR_DOMAIN));
        return false;
    }

    private boolean f() {
        if (!e()) {
            return false;
        }
        f8316e.put(this.f8321d, new WeakReference<>(this));
        Log.d(c.f8309a, String.format("Loading IronSource rewarded ad with instance ID: %s", this.f8321d));
        return true;
    }

    private void h(@NonNull AdError adError) {
        Log.w(c.f8309a, adError.toString());
        this.f8319b.onFailure(adError);
    }

    static void i(@NonNull String str) {
        f8316e.remove(str);
    }

    public MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> c() {
        return this.f8319b;
    }

    MediationRewardedAdCallback d() {
        return this.f8318a;
    }

    public void g() {
        if (f()) {
            IronSource.loadISDemandOnlyRewardedVideo((Activity) this.f8320c, this.f8321d);
        }
    }

    void j(@NonNull MediationRewardedAdCallback mediationRewardedAdCallback) {
        this.f8318a = mediationRewardedAdCallback;
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(@NonNull Context context) {
        Log.d(c.f8309a, String.format("Showing IronSource rewarded ad for instance ID: %s", this.f8321d));
        IronSource.showISDemandOnlyRewardedVideo(this.f8321d);
    }
}
