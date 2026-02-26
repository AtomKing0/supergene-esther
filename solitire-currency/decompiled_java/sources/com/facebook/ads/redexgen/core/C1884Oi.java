package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Oi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1884Oi implements R6 {
    public final /* synthetic */ OD A00;

    public C1884Oi(OD od) {
        this.A00 = od;
    }

    @Override // com.facebook.ads.redexgen.core.R6
    public final boolean AAA() {
        if (this.A00.A0E.canGoBack()) {
            this.A00.A0E.goBack();
            return true;
        }
        return false;
    }
}
