package com.facebook.ads.redexgen.core;

import android.os.SystemClock;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1546Bc implements InterfaceC2569gK {
    public static final C1546Bc A00 = new C1546Bc();

    public static C1546Bc A00() {
        return A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2569gK
    public final long AC6() {
        return SystemClock.elapsedRealtime();
    }
}
