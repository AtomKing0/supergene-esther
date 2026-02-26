package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2812kW implements InterfaceC1694Gw {
    public final /* synthetic */ C2811kV A00;

    public C2812kW(C2811kV c2811kV) {
        this.A00 = c2811kV;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1694Gw
    public final long A7l() {
        return this.A00.A0B.A05(this.A00.A07);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1694Gw
    public final C1693Gv A8t(long j10) {
        long jA06 = this.A00.A0B.A06(j10);
        long j11 = this.A00.A09;
        long j12 = this.A00.A08;
        long targetGranule = this.A00.A09;
        long j13 = (j12 - targetGranule) * jA06;
        long targetGranule2 = this.A00.A07;
        long estimatedPosition = AbstractC13764a.A0T((j11 + (j13 / targetGranule2)) - 30000, this.A00.A09, this.A00.A08 - 1);
        return new C1693Gv(new C1695Gx(j10, estimatedPosition));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1694Gw
    public final boolean AAa() {
        return true;
    }
}
