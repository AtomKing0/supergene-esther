package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9q, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C15099q extends AbstractC3042oU {
    public static byte[] A01;
    public static final C1R<C15099q> A02;
    public static final String A03;
    public final float A00;

    public static String A02(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] ^ i12) ^ 75);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{22, 3, 20, 5, 3, 8, 18, 70, 11, 19, 21, 18, 70, 4, 3, 70, 15, 8, 70, 18, 14, 3, 70, 20, 7, 8, 1, 3, 70, 9, 0, 70, 61, 86, 74, 70, 87, 86, 86, 59};
    }

    static {
        A03();
        A03 = AbstractC13764a.A0h(1);
        A02 = new C1R() { // from class: com.facebook.ads.redexgen.X.of
            @Override // com.facebook.ads.redexgen.core.C1R
            public final C1S A6X(Bundle bundle) {
                return C15099q.A00(bundle);
            }
        };
    }

    public C15099q() {
        this.A00 = -1.0f;
    }

    public C15099q(float f10) {
        C3M.A09(f10 >= 0.0f && f10 <= 100.0f, A02(0, 40, 45));
        this.A00 = f10;
    }

    public static C15099q A00(Bundle bundle) {
        C3M.A07(bundle.getInt(AbstractC3042oU.A02, -1) == 1);
        float f10 = bundle.getFloat(A03, -1.0f);
        return f10 == -1.0f ? new C15099q() : new C15099q(f10);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C15099q) && this.A00 == ((C15099q) obj).A00;
    }

    public final int hashCode() {
        return BX.A00(Float.valueOf(this.A00));
    }
}
