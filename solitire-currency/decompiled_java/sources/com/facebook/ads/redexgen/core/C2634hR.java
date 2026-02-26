package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2634hR extends AbstractRunnableC2074Vt {
    public final /* synthetic */ AbstractC2633hQ A00;
    public final /* synthetic */ V1 A01;

    public C2634hR(AbstractC2633hQ abstractC2633hQ, V1 v12) {
        this.A00 = abstractC2633hQ;
        this.A01 = v12;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC2074Vt
    public final void A07() {
        this.A00.A0B.A0F().A5Y(this.A01.A03().getErrorCode(), this.A01.A04());
        if (this.A00.A07 != null) {
            this.A00.A07.A0G(this.A01);
        }
    }
}
