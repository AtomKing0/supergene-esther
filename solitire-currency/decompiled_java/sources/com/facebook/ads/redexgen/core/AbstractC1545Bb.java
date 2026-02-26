package com.facebook.ads.redexgen.core;

import android.util.Log;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1545Bb implements InterfaceC2563gE {
    public int A00;

    @Override // com.facebook.ads.redexgen.core.InterfaceC2563gE
    public final void A9l(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2563gE
    public final void A9m(String str, String str2, Throwable th) {
        Log.i(str, str2, th);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2563gE
    public final boolean AAP(int i10) {
        return this.A00 <= i10;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2563gE
    public final void AIo(int i10) {
        this.A00 = i10;
    }
}
