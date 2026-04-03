package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.c6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC2311c6 implements Runnable {
    public final /* synthetic */ C13894n A00;

    public RunnableC2311c6(C13894n c13894n) {
        this.A00 = c13894n;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A07 = true;
            this.A00.A0M.AFE(true);
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
