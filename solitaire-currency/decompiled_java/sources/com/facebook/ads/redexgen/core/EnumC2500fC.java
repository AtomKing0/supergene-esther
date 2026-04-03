package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum EnumC2500fC {
    A03(A01(37, 3, 126)),
    A04(A01(40, 7, 55));

    public static byte[] A01;
    public String A00;

    public static String A01(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] ^ i12) ^ 117);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{48, 50, 58, 108, 75, 83, 68, 73, 76, 65, 5, 86, 64, 87, 83, 64, 87, 5, 87, 64, 86, 85, 74, 75, 86, 64, 31, 5, 0, 86, 51, 40, 45, 40, 41, 49, 40, 106, 104, 96, 55, 44, 41, 44, 45, 53, 44};
    }

    static {
        A02();
    }

    EnumC2500fC(String str) {
        this.A00 = str;
    }

    public static EnumC2500fC A00(String str) {
        for (EnumC2500fC enumC2500fC : values()) {
            if (enumC2500fC.A00.equals(str)) {
                return enumC2500fC;
            }
        }
        throw new IllegalArgumentException(String.format(Locale.US, A01(3, 27, 80), str));
    }
}
