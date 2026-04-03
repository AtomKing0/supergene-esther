package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class K1 extends AbstractRunnableC2074Vt {
    public final /* synthetic */ AbstractC2192aB A00;

    public K1(AbstractC2192aB abstractC2192aB) {
        this.A00 = abstractC2192aB;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC2074Vt
    public final void A07() {
        this.A00.setPressed(false);
        this.A00.postOnAnimationDelayed(this.A00.A09, this.A00.A08);
    }
}
