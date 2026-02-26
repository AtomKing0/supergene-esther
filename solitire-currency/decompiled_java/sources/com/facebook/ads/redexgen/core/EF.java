package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class EF extends AbstractRunnableC2074Vt {
    public final /* synthetic */ E1 A00;

    public EF(E1 e12) {
        this.A00 = e12;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC2074Vt
    public final void A07() {
        if (!this.A00.A04) {
            C2009Te c2009Te = this.A00.A0C;
            final int currentPositionInMillis = this.A00.getCurrentPositionInMillis();
            c2009Te.A02(new DY(currentPositionInMillis) { // from class: com.facebook.ads.redexgen.X.3Q
            });
            this.A00.A08.postDelayed(this, this.A00.A01);
        }
    }
}
