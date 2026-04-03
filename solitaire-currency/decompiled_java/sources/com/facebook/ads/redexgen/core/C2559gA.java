package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gA, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2559gA implements InterfaceC1941Qn {
    public final /* synthetic */ C14346g A00;

    public C2559gA(C14346g c14346g) {
        this.A00 = c14346g;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1941Qn
    public final void AGP(AbstractC1934Qg abstractC1934Qg, QJ qj, QJ qj2) {
        this.A00.A1l(abstractC1934Qg, qj, qj2);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1941Qn
    public final void AGR(AbstractC1934Qg abstractC1934Qg, QJ qj, QJ qj2) {
        this.A00.A0r.A0Y(abstractC1934Qg);
        this.A00.A1m(abstractC1934Qg, qj, qj2);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1941Qn
    public final void AGT(AbstractC1934Qg abstractC1934Qg, QJ qj, QJ qj2) {
        abstractC1934Qg.A0d(false);
        if (this.A00.A0C) {
            if (this.A00.A05.A0R(abstractC1934Qg, abstractC1934Qg, qj, qj2)) {
                this.A00.A1O();
            }
        } else {
            if (!this.A00.A05.A0Q(abstractC1934Qg, qj, qj2)) {
                return;
            }
            this.A00.A1O();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1941Qn
    public final void AJo(AbstractC1934Qg abstractC1934Qg) {
        this.A00.A06.A1F(abstractC1934Qg.A0H, this.A00.A0r);
    }
}
