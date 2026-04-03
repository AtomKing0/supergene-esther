package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1943Qp implements Runnable {
    public final /* synthetic */ C1944Qq A00;

    public RunnableC1943Qp(C1944Qq c1944Qq) {
        this.A00 = c1944Qq;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A05 = 0L;
            this.A00.A06 = false;
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
