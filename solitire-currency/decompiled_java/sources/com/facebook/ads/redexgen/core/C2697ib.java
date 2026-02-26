package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ib, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2697ib extends AbstractRunnableC2074Vt {
    public final /* synthetic */ C2695iZ A00;
    public final /* synthetic */ C5G A01;

    public C2697ib(C2695iZ c2695iZ, C5G c5g) {
        this.A00 = c2695iZ;
        this.A01 = c5g;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC2074Vt
    public final void A07() {
        this.A00.A00.A0A();
        if (this.A00.A00.A0C != null) {
            this.A01.setAdViewabilityChecker(this.A00.A00.A0C);
            this.A00.A00.A0C.A0U();
        }
    }
}
