package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2848lI implements InterfaceC1694Gw {
    public final long A00;
    public final C1693Gv A01;

    public C2848lI(long j10) {
        this(j10, 0L);
    }

    public C2848lI(long j10, long j11) {
        this.A00 = j10;
        this.A01 = new C1693Gv(j11 == 0 ? C1695Gx.A04 : new C1695Gx(0L, j11));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1694Gw
    public final long A7l() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1694Gw
    public final C1693Gv A8t(long j10) {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1694Gw
    public final boolean AAa() {
        return false;
    }
}
