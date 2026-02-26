package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class J6 extends AbstractRunnableC2074Vt {
    public final /* synthetic */ C1741Is A00;
    public final /* synthetic */ boolean A01;

    public J6(C1741Is c1741Is, boolean z10) {
        this.A00 = c1741Is;
        this.A01 = z10;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC2074Vt
    public final void A07() {
        AbstractC2117Xm abstractC2117XmA0C = this.A00.A0c.A0C();
        if (abstractC2117XmA0C == null) {
            return;
        }
        abstractC2117XmA0C.setPageDetailsVisible((this.A01 || abstractC2117XmA0C.A0B()) ? false : true);
        abstractC2117XmA0C.setToolbarActionMode(this.A00.getCloseButtonStyle());
    }
}
