package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2160Zd implements InterfaceC1999Su {
    public final SQ A00;

    public C2160Zd(SQ sq) {
        this.A00 = sq;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1999Su
    public final void A4A(Throwable th) {
        C1994Sp.A0E(th);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1999Su
    public final void A9v(String str) {
        C2033Ud.A08(this.A00, str);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1999Su
    public final void A9w(String str) {
        C2033Ud.A09(this.A00, str);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1999Su
    public final void AAy(String str, int i10, C2001Sw c2001Sw) {
        C1994Sp.A06(this.A00, str, i10, c2001Sw);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1999Su
    public final void AAz(String str, int i10, C2001Sw c2001Sw) {
        C1994Sp.A06(this.A00, str, i10, c2001Sw);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1999Su
    public final void ABI(long j10, long j11, long j12, long j13, int i10, Exception exc) {
        T0.A03(this.A00, j10, j11, j12, j13, i10, exc);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1999Su
    public final void ABR(String str, int i10, C2001Sw c2001Sw) {
        C1994Sp.A07(this.A00, str, i10, c2001Sw);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1999Su
    public final void ABZ(String str, int i10, C2001Sw c2001Sw) {
        C1994Sp.A08(this.A00, str, i10, c2001Sw);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1999Su
    public final void ABq() {
        this.A00.A04().ABq();
    }
}
