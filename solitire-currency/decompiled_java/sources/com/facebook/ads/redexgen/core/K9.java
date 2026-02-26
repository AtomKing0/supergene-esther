package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class K9 extends AbstractRunnableC2074Vt {
    public final /* synthetic */ AbstractC2192aB A00;

    public K9(AbstractC2192aB abstractC2192aB) {
        this.A00 = abstractC2192aB;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC2074Vt
    public final void A07() {
        if (!this.A00.isPressed()) {
            this.A00.setPressed(true);
            this.A00.postOnAnimationDelayed(this.A00.A0A, 250L);
        } else {
            this.A00.postDelayed(this, this.A00.A08);
        }
    }
}
