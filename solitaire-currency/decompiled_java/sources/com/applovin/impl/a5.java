package com.applovin.impl;

import android.net.Uri;
import com.applovin.sdk.AppLovinAdLoadListener;

/* JADX INFO: loaded from: classes2.dex */
public class a5 extends z4 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final com.applovin.impl.sdk.ad.a f4697l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f4698m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f4699n;

    public a5(com.applovin.impl.sdk.ad.a aVar, com.applovin.impl.sdk.j jVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheAppLovinAd", aVar, jVar, appLovinAdLoadListener);
        this.f4697l = aVar;
    }

    private String d(String str) {
        if (z6.h(com.applovin.impl.sdk.j.n())) {
            str = z6.c(str);
        }
        return this.f4697l.isOpenMeasurementEnabled() ? this.f7677a.W().a(str) : str;
    }

    private void l() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Caching HTML resources...");
        }
        this.f4697l.b(d(a(this.f4697l.f1(), this.f4697l.W(), this.f4697l)));
        this.f4697l.b(true);
        a(this.f4697l);
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Finish caching non-video resources for ad #" + this.f4697l.getAdIdNumber());
        }
        this.f7679c.f(this.f7678b, "Ad updated with cachedHTML = " + this.f4697l.f1());
    }

    private void m() {
        Uri uriC;
        if (k() || (uriC = c(this.f4697l.j1())) == null) {
            return;
        }
        this.f4697l.l1();
        this.f4697l.d(uriC);
    }

    public void b(boolean z10) {
        this.f4699n = z10;
    }

    public void c(boolean z10) {
        this.f4698m = z10;
    }

    @Override // com.applovin.impl.z4, java.lang.Runnable
    public void run() {
        super.run();
        boolean zH0 = this.f4697l.H0();
        boolean z10 = this.f4699n;
        if (zH0 || z10) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Begin caching for streaming ad #" + this.f4697l.getAdIdNumber() + "...");
            }
            i();
            if (zH0) {
                if (this.f4698m) {
                    e();
                }
                l();
                if (!this.f4698m) {
                    e();
                }
                m();
            } else {
                e();
                l();
            }
        } else {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Begin processing for non-streaming ad #" + this.f4697l.getAdIdNumber() + "...");
            }
            i();
            l();
            m();
            e();
        }
        j();
    }
}
