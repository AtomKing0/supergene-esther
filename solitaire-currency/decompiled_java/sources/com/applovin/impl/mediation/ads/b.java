package com.applovin.impl.mediation.ads;

import android.view.ViewGroup;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.r7;
import com.applovin.impl.s7;
import com.applovin.impl.u2;

/* JADX INFO: loaded from: classes2.dex */
public class b implements s7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f6036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u2 f6037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s7 f6038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final r7 f6039d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a.InterfaceC0165a f6040e;

    public b(u2 u2Var, ViewGroup viewGroup, a.InterfaceC0165a interfaceC0165a, com.applovin.impl.sdk.j jVar) {
        this.f6036a = jVar;
        this.f6037b = u2Var;
        this.f6040e = interfaceC0165a;
        this.f6039d = new r7(viewGroup, jVar);
        s7 s7Var = new s7(viewGroup, jVar, this);
        this.f6038c = s7Var;
        s7Var.a(u2Var);
        jVar.I();
        if (com.applovin.impl.sdk.n.a()) {
            jVar.I().a("MaxNativeAdView", "Created new MaxNativeAdView (" + this + ")");
        }
    }

    public void a() {
        this.f6038c.b();
    }

    public u2 b() {
        return this.f6037b;
    }

    public void c() {
        this.f6036a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f6036a.I().a("MaxNativeAdView", "Handling view attached to window");
        }
        if (this.f6037b.m0().compareAndSet(false, true)) {
            this.f6036a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f6036a.I().a("MaxNativeAdView", "Scheduling impression for ad manually...");
            }
            if (this.f6037b.getNativeAd().isExpired()) {
                com.applovin.impl.sdk.n.h("MaxNativeAdView", "Attempting to display an expired native ad. Check if an ad is expired before displaying using `MaxAd.getNativeAd().isExpired()`");
            } else {
                this.f6036a.f().a(this.f6037b);
            }
            this.f6036a.Q().processRawAdImpression(this.f6037b, this.f6040e);
        }
    }

    @Override // com.applovin.impl.s7.a
    public void onLogVisibilityImpression() {
        a(this.f6039d.a(this.f6037b));
    }

    private void a(long j10) {
        if (this.f6037b.o0().compareAndSet(false, true)) {
            this.f6036a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f6036a.I().a("MaxNativeAdView", "Scheduling viewability impression for ad...");
            }
            this.f6036a.Q().processViewabilityAdImpressionPostback(this.f6037b, j10, this.f6040e);
        }
    }
}
