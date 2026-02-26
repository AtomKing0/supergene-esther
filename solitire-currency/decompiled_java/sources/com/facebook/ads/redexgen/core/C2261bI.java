package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2261bI extends AbstractRunnableC2074Vt {
    public final /* synthetic */ C2361cu A00;

    public C2261bI(C2361cu c2361cu) {
        this.A00 = c2361cu;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC2074Vt
    public final void A07() {
        for (C1995Sq c1995Sq : C1994Sp.A02()) {
            C1994Sp.A0A(this.A00, c1995Sq.A02(), c1995Sq.A00(), c1995Sq.A01(), false);
        }
        C1994Sp.A02().clear();
    }
}
