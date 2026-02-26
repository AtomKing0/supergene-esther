package com.applovin.impl;

import android.os.SystemClock;
import android.view.ViewGroup;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class u2 extends y2 implements m1 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final AtomicBoolean f7521t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final AtomicBoolean f7522u;

    public u2(Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        super(map, jSONObject, jSONObject2, null, jVar);
        this.f7521t = new AtomicBoolean();
        this.f7522u = new AtomicBoolean();
    }

    private long j0() {
        long jA = a("ad_expiration_ms", -1L);
        return jA < 0 ? b("ad_expiration_ms", ((Long) this.f4682a.a(g3.f5225a7)).longValue()) : jA;
    }

    @Override // com.applovin.impl.q2
    public q2 a(com.applovin.impl.mediation.g gVar) {
        return new u2(this, gVar);
    }

    @Override // com.applovin.impl.m1
    public long getTimeToLiveMillis() {
        return j0() - (SystemClock.elapsedRealtime() - H());
    }

    public MaxNativeAdView k0() {
        return this.f6645m.f();
    }

    public ViewGroup l0() {
        return this.f6645m.h();
    }

    public AtomicBoolean m0() {
        return this.f7521t;
    }

    public String n0() {
        return BundleUtils.getString(com.vungle.ads.internal.model.b.KEY_TEMPLATE, "", l());
    }

    public AtomicBoolean o0() {
        return this.f7522u;
    }

    public boolean p0() {
        return a("inacc", (Boolean) this.f4682a.a(g3.f5243s7)).booleanValue();
    }

    public boolean q0() {
        return this.f6645m == null;
    }

    @Override // com.applovin.impl.m1
    public void setExpired() {
        MaxNativeAd nativeAd = getNativeAd();
        if (nativeAd != null) {
            nativeAd.setExpired();
        }
    }

    public void a(MaxNativeAdView maxNativeAdView) {
        this.f6645m.a(maxNativeAdView);
    }

    public void a(ViewGroup viewGroup) {
        this.f6645m.a(viewGroup);
    }

    private u2(u2 u2Var, com.applovin.impl.mediation.g gVar) {
        super(u2Var.i(), u2Var.a(), u2Var.g(), gVar, u2Var.f4682a);
        this.f7521t = new AtomicBoolean();
        this.f7522u = new AtomicBoolean();
    }
}
