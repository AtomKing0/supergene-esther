package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class EV implements InterfaceC2485ew {
    public final /* synthetic */ C2384dI A00;

    public EV(C2384dI c2384dI) {
        this.A00 = c2384dI;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2485ew
    public final void AGQ() {
        if (this.A00.A02 != null) {
            this.A00.A02.A4b(this.A00.A03.A8w());
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2485ew
    public final void AGS(C2487ey c2487ey) {
        if (this.A00.A02 == null) {
            return;
        }
        if (c2487ey != null && c2487ey.A00()) {
            this.A00.A02.A4b(this.A00.A03.A8x());
        } else {
            this.A00.A02.A4b(this.A00.A03.A8w());
        }
    }
}
