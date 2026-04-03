package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.Timeline;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class EK {
    public EJ A00;
    public EU A01;

    public abstract boolean A0Y();

    public abstract EL A0b(C7D[] c7dArr, C2901mA c2901mA, C2911mL c2911mL, Timeline timeline) throws C9Y;

    public abstract void A0c(Object obj);

    public final EU A00() {
        return (EU) C3M.A02(this.A01);
    }

    public final void A01() {
        if (this.A00 != null) {
            this.A00.AFT();
        }
    }

    public final void A02(EJ ej, EU eu) {
        this.A00 = ej;
        this.A01 = eu;
    }
}
