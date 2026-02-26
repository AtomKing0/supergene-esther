package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Db, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1595Db implements InterfaceC2401dZ {
    public final View A00;
    public final C2387dL A01;

    public C1595Db(C2387dL c2387dL, View view) {
        this.A01 = c2387dL;
        this.A00 = view;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2401dZ
    public final double A9N() {
        C2461eY result = C2460eX.A0E(this.A00, 0, this.A01);
        return result.A00();
    }
}
