package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2628hL implements InterfaceC1831Me {
    public C1930Qc A00;

    public final void A00(C1930Qc c1930Qc) {
        this.A00 = c1930Qc;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1831Me
    public final void AEG(C2683iN c2683iN) {
        if (this.A00 != null && this.A00.A16() != null) {
            this.A00.A16().ACD();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1831Me
    public final void AEI(C2683iN c2683iN) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1831Me
    public final void AEK(C2683iN c2683iN, V1 v12) {
    }
}
