package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC2342cb implements Runnable {
    public final /* synthetic */ C13673r A00;

    public RunnableC2342cb(C13673r c13673r) {
        this.A00 = c13673r;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            ((G2) this.A00).A09.A4b(((G2) this.A00).A0A.A7o());
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
