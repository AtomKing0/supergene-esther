package com.facebook.ads.redexgen.core;

import android.graphics.Paint;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2426dz extends Paint {
    public final /* synthetic */ C2427e0 A00;
    public final /* synthetic */ boolean A01;

    public C2426dz(C2427e0 c2427e0, boolean z10) {
        this.A00 = c2427e0;
        this.A01 = z10;
        setStyle(Paint.Style.FILL_AND_STROKE);
        setStrokeCap(Paint.Cap.ROUND);
        setStrokeWidth(3.0f);
        setAntiAlias(true);
        setColor(this.A01 ? -1 : -10066330);
    }
}
