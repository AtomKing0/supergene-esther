package com.facebook.ads.redexgen.core;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ko, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1789Ko extends AbstractRunnableC2074Vt {
    public final WeakReference<C2460eX> A00;

    public C1789Ko(C2460eX c2460eX) {
        this.A00 = new WeakReference<>(c2460eX);
    }

    public C1789Ko(WeakReference<C2460eX> weakReference) {
        this.A00 = weakReference;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC2074Vt
    public final void A07() {
        C2460eX viewabilityChecker = this.A00.get();
        if (viewabilityChecker != null) {
            viewabilityChecker.A0U();
        }
    }
}
