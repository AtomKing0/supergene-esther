package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kU, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2810kU implements InterfaceC1745Iw {
    public long A00 = -1;
    public long A01 = -1;
    public C1678Gg A02;
    public C1679Gh A03;

    public C2810kU(C1679Gh c1679Gh, C1678Gg c1678Gg) {
        this.A03 = c1679Gh;
        this.A02 = c1678Gg;
    }

    public final void A00(long j10) {
        this.A00 = j10;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1745Iw
    public final InterfaceC1694Gw A5R() {
        C3M.A08(this.A00 != -1);
        return new C2850lK(this.A03, this.A00);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1745Iw
    public final long AGd(InterfaceC2853lN interfaceC2853lN) {
        if (this.A01 < 0) {
            return -1L;
        }
        long result = -(this.A01 + 2);
        this.A01 = -1L;
        return result;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1745Iw
    public final void AJR(long j10) {
        long[] jArr = this.A02.A01;
        this.A01 = jArr[AbstractC13764a.A0L(jArr, j10, true, true)];
    }
}
