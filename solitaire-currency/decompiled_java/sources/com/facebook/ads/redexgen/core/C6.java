package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6 implements InterfaceC2501fD {
    @Override // com.facebook.ads.redexgen.core.InterfaceC2501fD
    public final long A5e() {
        return System.nanoTime();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2501fD
    public final void AJK(Object obj, long j10) throws InterruptedException {
        obj.wait(j10);
    }
}
