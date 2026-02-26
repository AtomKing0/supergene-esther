package com.facebook.ads.redexgen.core;

import android.os.Message;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2623hF extends AbstractRunnableC2061Vg {
    public final /* synthetic */ Message A00;
    public final /* synthetic */ AbstractC2621hD A01;

    public C2623hF(AbstractC2621hD abstractC2621hD, Message message) {
        this.A01 = abstractC2621hD;
        this.A00 = message;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC2061Vg
    public final void A01() {
        this.A01.A05.A9b(this.A00);
    }
}
