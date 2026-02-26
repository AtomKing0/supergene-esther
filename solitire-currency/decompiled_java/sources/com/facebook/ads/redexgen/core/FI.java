package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class FI implements InterfaceC2278bZ {
    public final /* synthetic */ FH A00;

    public FI(FH fh) {
        this.A00 = fh;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2278bZ
    public final void AFm(View view) {
        if (this.A00.A09) {
            this.A00.A07 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2278bZ
    public final void AFo(View view) {
        AbstractC1740Ir abstractC1740Ir = (AbstractC1740Ir) view;
        abstractC1740Ir.A1R();
        if (this.A00.A09) {
            this.A00.A07 = true;
        }
        if (this.A00.A04.A0Z() && ((Integer) abstractC1740Ir.getTag(-1593835536)).intValue() == 0) {
            this.A00.A04.A0U();
        }
    }
}
