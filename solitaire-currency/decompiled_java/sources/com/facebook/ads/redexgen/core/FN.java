package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class FN implements InterfaceC2345ce {
    public final /* synthetic */ C13673r A00;

    public FN(C13673r c13673r) {
        this.A00 = c13673r;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2345ce
    public final void A9d() {
        if (this.A00.A03 instanceof C14055d) {
            ((C14055d) this.A00.A03).A1W();
            C2030Ua.A02(UZ.A0e, null, ((G2) this.A00).A02.A25(), ((G2) this.A00).A04.A0A());
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2345ce
    public final void AJF() {
        if (this.A00.A03 instanceof C14055d) {
            ((C14055d) this.A00.A03).A1a(this.A00.A0M);
            C2030Ua.A02(UZ.A0e, null, ((G2) this.A00).A02.A25(), ((G2) this.A00).A04.A0A());
        }
        this.A00.A0k();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2345ce
    public final void AJT() {
        this.A00.A0c();
        if (this.A00.A03 instanceof C14055d) {
            ((C14055d) this.A00.A03).getAdDetailsView().setVisibility(8);
        }
    }
}
