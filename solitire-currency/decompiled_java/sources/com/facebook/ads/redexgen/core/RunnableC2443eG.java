package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC2443eG implements Runnable {
    public final /* synthetic */ C2446eJ A00;

    public RunnableC2443eG(C2446eJ c2446eJ) {
        this.A00 = c2446eJ;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A00.A0A();
            this.A00.A01.removeCallbacks(this);
            this.A00.A01.postDelayed(this, 250L);
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
