package com.applovin.impl;

import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;

/* JADX INFO: loaded from: classes2.dex */
class d6 extends w4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e7 f5029g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AppLovinAdLoadListener f5030h;

    d6(e7 e7Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super("TaskResolveVastWrapper", jVar);
        this.f5030h = appLovinAdLoadListener;
        this.f5029g = e7Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        String strA = m7.a(this.f5029g);
        if (!StringUtils.isValidString(strA)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.b(this.f7678b, "Resolving VAST failed. Could not find resolution URL");
            }
            a(-1);
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "Resolving VAST ad with depth " + this.f5029g.d() + " at " + strA);
        }
        try {
            this.f7677a.j0().a(new a(com.applovin.impl.sdk.network.a.a(this.f7677a).b(strA).c("GET").a(b8.f4910f).a(((Integer) this.f7677a.a(l4.f5715p4)).intValue()).c(((Integer) this.f7677a.a(l4.f5723q4)).intValue()).a(false).a(), this.f7677a));
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.a(this.f7678b, "Unable to resolve VAST wrapper", th);
            }
            a(-1);
        }
    }

    class a extends z5 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
            super(aVar, jVar);
        }

        @Override // com.applovin.impl.z5, com.applovin.impl.m0.e
        public void a(String str, b8 b8Var, int i10) {
            this.f7677a.j0().a(v5.a(b8Var, d6.this.f5029g, d6.this.f5030h, d6.this.f7677a));
        }

        @Override // com.applovin.impl.z5, com.applovin.impl.m0.e
        public void a(String str, int i10, String str2, b8 b8Var) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.b(this.f7678b, "Unable to resolve VAST wrapper. Server returned " + i10);
            }
            d6.this.a(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.b(this.f7678b, "Failed to resolve VAST wrapper due to error code " + i10);
        }
        if (i10 == -1009) {
            AppLovinAdLoadListener appLovinAdLoadListener = this.f5030h;
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(i10);
                return;
            }
            return;
        }
        m7.a(this.f5029g, this.f5030h, i10 == -1001 ? f7.TIMED_OUT : f7.GENERAL_WRAPPER_ERROR, i10, this.f7677a);
    }
}
