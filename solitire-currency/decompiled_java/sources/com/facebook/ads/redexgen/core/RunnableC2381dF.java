package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC2381dF implements Runnable {
    public final /* synthetic */ C1625Ef A00;

    public RunnableC2381dF(C1625Ef c1625Ef) {
        this.A00 = c1625Ef;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            if (this.A00.A0B() != 0) {
                this.A00.A05.scrollBy(this.A00.A01, 0);
                this.A00.A04.postDelayed(this, 16L);
            }
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
