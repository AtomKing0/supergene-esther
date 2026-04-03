package com.facebook.ads.redexgen.core;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0K, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0K extends C12810h {
    public C14205s A00;
    public List<C2354cn> A01;

    public C0K(C2387dL c2387dL) {
        super(c2387dL);
        this.A00 = new C14205s(this, 1, null, null, null);
    }

    public final void A20(C2460eX c2460eX) {
        if (this.A00 != null) {
            this.A00.A0c(c2460eX);
        }
    }

    public C14205s getCarouselCardBehaviorHelper() {
        return this.A00;
    }

    public void setCardsInfo(ArrayList arrayList) {
        this.A01 = arrayList;
        this.A00.A0d(this.A01);
    }
}
