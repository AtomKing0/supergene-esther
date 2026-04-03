package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class PV extends VX {
    public final int A00;
    public final String A01;

    public PV(String str, int i10, TE te) {
        super(VW.A03, te, null);
        this.A00 = i10;
        this.A01 = str;
    }

    @Override // com.facebook.ads.redexgen.core.VX
    public final /* bridge */ /* synthetic */ TE A00() {
        return super.A00();
    }

    public final int A03() {
        return this.A00;
    }

    public final String A04() {
        return this.A01;
    }
}
