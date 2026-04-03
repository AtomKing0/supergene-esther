package com.facebook.ads.redexgen.core;

import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Da, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1594Da extends RelativeLayout implements InterfaceC2404dc {
    public E1 A00;

    public AbstractC1594Da(C2387dL c2387dL) {
        super(c2387dL);
    }

    public AbstractC1594Da(C2387dL c2387dL, AttributeSet attributeSet, int i10) {
        super(c2387dL, attributeSet, i10);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-1, -1);
        setLayoutParams(params);
    }

    public void A07() {
    }

    public void A08() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2404dc
    public final void AAm(E1 e12) {
        this.A00 = e12;
        A07();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2404dc
    public final void AJk(E1 e12) {
        A08();
        this.A00 = null;
    }

    public E1 getVideoView() {
        return this.A00;
    }
}
