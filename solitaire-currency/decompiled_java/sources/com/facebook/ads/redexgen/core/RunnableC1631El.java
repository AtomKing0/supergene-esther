package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.El, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RunnableC1631El implements Runnable {
    public final InterfaceC1630Ek A00;

    public RunnableC1631El(InterfaceC1630Ek interfaceC1630Ek) {
        this.A00 = interfaceC1630Ek;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC2066Vl.A02(this)) {
            return;
        }
        try {
            this.A00.AE4();
        } catch (Throwable th) {
            AbstractC2066Vl.A00(th, this);
        }
    }
}
