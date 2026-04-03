package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.f9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC2497f9 implements Runnable {
    public final /* synthetic */ C1565Bw A00;

    public RunnableC2497f9(C1565Bw c1565Bw) {
        this.A00 = c1565Bw;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            C1565Bw.A03(this.A00);
            throw null;
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
