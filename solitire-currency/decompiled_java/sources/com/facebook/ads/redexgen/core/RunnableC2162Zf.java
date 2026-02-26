package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC2162Zf implements Runnable {
    public final /* synthetic */ C2163Zg A00;
    public final /* synthetic */ InterfaceC2164Zh A01;

    public RunnableC2162Zf(C2163Zg c2163Zg, InterfaceC2164Zh interfaceC2164Zh) {
        this.A00 = c2163Zg;
        this.A01 = interfaceC2164Zh;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A01.ACO();
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
