package com.google.ads.mediation.ironsource;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: IronSourceBannerAd.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements MediationBannerAd {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @VisibleForTesting
    static final ConcurrentHashMap<String, WeakReference<a>> f8299i = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final b f8300j = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MediationBannerAdCallback f8301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> f8302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FrameLayout f8303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ISDemandOnlyBannerLayout f8304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AdSize f8305e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ISBannerSize f8306f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f8307g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f8308h;

    public a(@NonNull MediationBannerAdConfiguration mediationBannerAdConfiguration, @NonNull MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        this.f8308h = mediationBannerAdConfiguration.getServerParameters().getString("instanceId", "0");
        this.f8307g = mediationBannerAdConfiguration.getContext();
        this.f8305e = mediationBannerAdConfiguration.getAdSize();
        this.f8302b = mediationAdLoadCallback;
    }

    static void a(@NonNull String str) {
        for (String str2 : f8299i.keySet()) {
            if (!str2.equals(str)) {
                Log.d(c.f8309a, String.format("IronSource Banner Destroy ad with instance ID: %s", str2));
                IronSource.destroyISDemandOnlyBanner(str2);
                j(str2);
            }
        }
    }

    static a d(@NonNull String str) {
        ConcurrentHashMap<String, WeakReference<a>> concurrentHashMap = f8299i;
        if (concurrentHashMap.containsKey(str)) {
            return concurrentHashMap.get(str).get();
        }
        return null;
    }

    private boolean g() {
        AdError adErrorF = r1.a.f(this.f8307g, this.f8308h);
        if (adErrorF != null) {
            i(adErrorF);
            return false;
        }
        if (!r1.a.c(this.f8308h, f8299i)) {
            i(new AdError(103, "An IronSource banner is already loaded for instance ID: " + this.f8308h, IronSourceMediationAdapter.ADAPTER_ERROR_DOMAIN));
            return false;
        }
        ISBannerSize iSBannerSizeE = r1.a.e(this.f8307g, this.f8305e);
        this.f8306f = iSBannerSizeE;
        if (iSBannerSizeE != null) {
            return true;
        }
        i(new AdError(105, "There is no matching IronSource banner ad size for Google ad size: " + this.f8305e, IronSourceMediationAdapter.ADAPTER_ERROR_DOMAIN));
        return false;
    }

    private void i(@NonNull AdError adError) {
        Log.w(c.f8309a, adError.toString());
        MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback = this.f8302b;
        if (mediationAdLoadCallback != null) {
            mediationAdLoadCallback.onFailure(adError);
        }
    }

    static void j(@NonNull String str) {
        f8299i.remove(str);
    }

    MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> b() {
        return this.f8302b;
    }

    MediationBannerAdCallback c() {
        return this.f8301a;
    }

    FrameLayout e() {
        return this.f8303c;
    }

    ISDemandOnlyBannerLayout f() {
        return this.f8304d;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAd
    @NonNull
    public View getView() {
        return this.f8303c;
    }

    public void h() {
        if (g()) {
            Activity activity = (Activity) this.f8307g;
            f8299i.put(this.f8308h, new WeakReference<>(this));
            this.f8303c = new FrameLayout(this.f8307g);
            ISDemandOnlyBannerLayout iSDemandOnlyBannerLayoutCreateBannerForDemandOnly = IronSource.createBannerForDemandOnly(activity, this.f8306f);
            this.f8304d = iSDemandOnlyBannerLayoutCreateBannerForDemandOnly;
            iSDemandOnlyBannerLayoutCreateBannerForDemandOnly.setBannerDemandOnlyListener(f8300j);
            Log.d(c.f8309a, String.format("Loading IronSource banner ad with instance ID: %s", this.f8308h));
            IronSource.loadISDemandOnlyBanner(activity, this.f8304d, this.f8308h);
        }
    }

    void k(MediationBannerAdCallback mediationBannerAdCallback) {
        this.f8301a = mediationBannerAdCallback;
    }
}
