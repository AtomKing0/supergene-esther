package com.facebook.ads.redexgen.core;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2007Tc implements InterfaceC2040Uk {
    public WeakReference<C1930Qc> A00;

    public C2007Tc(C1930Qc c1930Qc) {
        this.A00 = new WeakReference<>(c1930Qc);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2040Uk
    public final void AEW(boolean z10) {
        if (this.A00.get() != null) {
            this.A00.get().A1f(z10, false);
        }
    }
}
