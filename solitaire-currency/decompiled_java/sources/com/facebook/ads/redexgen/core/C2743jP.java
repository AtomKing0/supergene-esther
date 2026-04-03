package com.facebook.ads.redexgen.core;

import java.io.File;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jP, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2743jP implements InterfaceC1793Ks<String> {
    @Override // com.facebook.ads.redexgen.core.InterfaceC1793Ks
    public final C1792Kr<String> A3p(File file, LA la2) {
        String strA05 = LB.A05(file);
        return new C1792Kr<>(strA05 != null, strA05);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1793Ks
    public final void A55(File file, LA la2) {
    }
}
