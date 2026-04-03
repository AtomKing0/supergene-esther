package com.facebook.ads.redexgen.core;

import java.io.File;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jQ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2744jQ implements InterfaceC1793Ks<File> {
    @Override // com.facebook.ads.redexgen.core.InterfaceC1793Ks
    public final C1792Kr<File> A3p(File file, LA la2) {
        if (file.exists()) {
            return new C1792Kr<>(true, file);
        }
        return new C1792Kr<>(false, null);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1793Ks
    public final void A55(File file, LA la2) {
    }
}
