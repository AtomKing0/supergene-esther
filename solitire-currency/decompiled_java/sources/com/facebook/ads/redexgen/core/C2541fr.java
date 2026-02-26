package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2541fr extends AbstractRunnableC2061Vg {
    public final /* synthetic */ C2540fq A00;

    public C2541fr(C2540fq c2540fq) {
        this.A00 = c2540fq;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC2061Vg
    public final void A01() {
        if (this.A00.A01.A06() != null) {
            this.A00.A01.A06().onLoggingImpression(this.A00.A01.A07());
        }
    }
}
