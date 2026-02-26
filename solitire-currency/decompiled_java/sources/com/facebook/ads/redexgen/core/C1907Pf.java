package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1907Pf extends AbstractRunnableC2074Vt {
    public final /* synthetic */ long A00;
    public final /* synthetic */ VR A01;
    public final /* synthetic */ VU A02;
    public final /* synthetic */ String A03;

    public C1907Pf(VU vu, String str, long j10, VR vr) {
        this.A02 = vu;
        this.A03 = str;
        this.A00 = j10;
        this.A01 = vr;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC2074Vt
    public final void A07() {
        this.A02.A0N(this.A03, this.A00, this.A01);
    }
}
