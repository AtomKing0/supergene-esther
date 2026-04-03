package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.g8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2557g8 implements InterfaceC1910Pi {
    public static byte[] A01;
    public final /* synthetic */ C14346g A00;

    static {
        A01();
    }

    public static String A00(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 107);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-10, 0, -9};
    }

    public C2557g8(C14346g c14346g) {
        this.A00 = c14346g;
    }

    private final void A02(C1911Pj c1911Pj) {
        throw new NullPointerException(A00(0, 3, 40));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1910Pi
    public final void AD2(C1911Pj c1911Pj) {
        A02(c1911Pj);
        throw null;
    }
}
