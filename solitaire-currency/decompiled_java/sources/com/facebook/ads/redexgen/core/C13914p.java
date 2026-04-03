package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4p, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C13914p extends DV {
    public final /* synthetic */ C13894n A00;

    public C13914p(C13894n c13894n) {
        this.A00 = c13894n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC2010Tf
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(DW dw) {
        new Handler(Looper.getMainLooper()).post(new RunnableC2313c8(this));
    }
}
