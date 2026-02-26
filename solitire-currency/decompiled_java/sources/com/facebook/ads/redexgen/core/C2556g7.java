package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.g7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2556g7 implements QI {
    public final /* synthetic */ C14346g A00;

    public C2556g7(C14346g c14346g) {
        this.A00 = c14346g;
    }

    @Override // com.facebook.ads.redexgen.core.QI
    public final void ACK(AbstractC1934Qg abstractC1934Qg) {
        abstractC1934Qg.A0d(true);
        if (abstractC1934Qg.A06 != null && abstractC1934Qg.A07 == null) {
            abstractC1934Qg.A06 = null;
        }
        abstractC1934Qg.A07 = null;
        if (!abstractC1934Qg.A0G() && !this.A00.A1x(abstractC1934Qg.A0H) && abstractC1934Qg.A0i()) {
            this.A00.removeDetachedView(abstractC1934Qg.A0H, false);
        }
    }
}
