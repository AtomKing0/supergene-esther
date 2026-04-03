package com.facebook.ads.redexgen.core;

import android.media.MediaCodec;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class AY extends Exception {
    public static byte[] A05;
    public final AR A00;
    public final AY A01;
    public final String A02;
    public final String A03;
    public final boolean A04;

    static {
        A05();
    }

    public static String A03(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] ^ i12) ^ 113);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A05 = new byte[]{0, 12, 49, 16, 22, 26, 17, 16, 7, 85, 28, 27, 28, 1, 85, 19, 20, 28, 25, 16, 17, 79, 85, 101, 68, 66, 78, 69, 68, 83, 1, 72, 79, 72, 85, 1, 71, 64, 72, 77, 68, 69, 27, 1, 122, 63, 78, 66, 29, 17, 19, 80, 24, 31, 29, 27, 28, 17, 17, 21, 80, 31, 26, 13, 80, 31, 16, 26, 12, 17, 23, 26, 6, 80, 19, 27, 26, 23, 31, 77, 80, 27, 6, 17, 14, 18, 31, 7, 27, 12, 80, 19, 27, 26, 23, 31, 29, 17, 26, 27, 29, 80, 51, 27, 26, 23, 31, 61, 17, 26, 27, 29, 44, 27, 16, 26, 27, 12, 27, 12, 33, 36, 47, 45, 21};
    }

    public AY(C3064or c3064or, Throwable th, boolean z10, int i10) {
        this(A03(23, 22, 80) + i10 + A03(45, 3, 19) + c3064or, th, c3064or.A0W, z10, null, A02(i10), null);
    }

    public AY(C3064or c3064or, Throwable th, boolean z10, AR ar) {
        this(A03(2, 21, 4) + ar.A03 + A03(0, 2, 93) + c3064or, th, c3064or.A0W, z10, ar, AbstractC13764a.A02 >= 21 ? A04(th) : null, null);
    }

    public AY(String str, Throwable th, String str2, boolean z10, AR ar, String str3, AY ay) {
        super(str, th);
        this.A03 = str2;
        this.A04 = z10;
        this.A00 = ar;
        this.A02 = str3;
        this.A01 = ay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AY A00(AY ay) {
        return new AY(getMessage(), getCause(), this.A03, this.A04, this.A00, this.A02, ay);
    }

    public static String A02(int i10) {
        String strA03 = i10 < 0 ? A03(121, 4, 59) : A03(0, 0, 98);
        StringBuilder sb = new StringBuilder();
        String sign = A03(48, 73, 15);
        return sb.append(sign).append(strA03).append(Math.abs(i10)).toString();
    }

    public static String A04(Throwable th) {
        if (th instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        return null;
    }
}
