package com.facebook.ads.redexgen.core;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2108Xd {
    public static C2108Xd A02;
    public final C1888Om A00;
    public final C2110Xf A01;

    public C2108Xd(C2387dL c2387dL, Executor executor, TE te) {
        this.A01 = new C2110Xf(c2387dL);
        this.A00 = new C1888Om(executor, te, c2387dL);
    }

    private void A00() {
        this.A01.A03(this.A00);
    }

    public static void A01(C2387dL c2387dL, Executor executor, TE te) {
        if (!U7.A1X(c2387dL)) {
            return;
        }
        if (A02 == null) {
            A02 = new C2108Xd(c2387dL, executor, te);
            A02.A00();
        } else {
            A02.A02(te);
        }
    }

    private void A02(TE te) {
        this.A00.A07(te);
    }
}
