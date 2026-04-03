package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7a, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C14547a extends AbstractC2724j4<LT> {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 115);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{83, 90, 81, 81};
    }

    public C14547a(String str) {
        super(str);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2724j4
    /* JADX INFO: renamed from: A05, reason: merged with bridge method [inline-methods] */
    public final LN A04(LT lt) {
        return new LN(this, lt == null ? A00(0, 4, 114) : lt.A03());
    }
}
