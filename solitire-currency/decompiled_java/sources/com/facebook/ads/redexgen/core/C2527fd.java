package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2527fd extends AbstractRunnableC2061Vg {
    public final /* synthetic */ C2524fa A00;
    public final /* synthetic */ V1 A01;

    public C2527fd(C2524fa c2524fa, V1 v12) {
        this.A00 = c2524fa;
        this.A01 = v12;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC2061Vg
    public final void A01() {
        if (this.A00.A00.A00() != null) {
            this.A00.A00.A00().onAdError(WT.A00(this.A01));
        }
    }
}
