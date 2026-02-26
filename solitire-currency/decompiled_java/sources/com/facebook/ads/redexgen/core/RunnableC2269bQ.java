package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bQ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC2269bQ implements Runnable {
    public final /* synthetic */ C1741Is A00;

    public RunnableC2269bQ(C1741Is c1741Is) {
        this.A00 = c1741Is;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A0C = true;
            this.A00.A0c.A0E().AFE(true);
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
