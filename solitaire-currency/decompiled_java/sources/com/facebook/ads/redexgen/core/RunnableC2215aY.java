package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC2215aY implements Runnable {
    public final /* synthetic */ C1772Jx A00;

    public RunnableC2215aY(C1772Jx c1772Jx) {
        this.A00 = c1772Jx;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A02 = true;
            if (((AbstractC2221ae) this.A00).A06.A0E() != null) {
                ((AbstractC2221ae) this.A00).A06.A0E().AFE(true);
            }
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
