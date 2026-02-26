package com.facebook.ads.redexgen.core;

import androidx.media3.common.C;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.le, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2869le implements InterfaceC1623Ed {
    public final int A00;

    public C2869le() {
        this(-1);
    }

    public C2869le(int i10) {
        this.A00 = i10;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1623Ed
    public final int A8R(int i10) {
        if (this.A00 == -1) {
            if (i10 == 7) {
                return 6;
            }
            return 3;
        }
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1623Ed
    public final long A8m(C1622Ec c1622Ec) {
        IOException iOException = c1622Ec.A03;
        if ((iOException instanceof C13322i) || (iOException instanceof FileNotFoundException) || (iOException instanceof C15009h) || (iOException instanceof C1633En) || C14014z.A00(iOException)) {
            return C.TIME_UNSET;
        }
        return Math.min((c1622Ec.A00 - 1) * 1000, 5000);
    }
}
