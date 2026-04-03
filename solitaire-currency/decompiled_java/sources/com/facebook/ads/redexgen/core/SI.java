package com.facebook.ads.redexgen.core;

import androidx.media3.extractor.ts.TsExtractor;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SI {
    public static int A00;
    public static int A01;
    public static int A02;
    public static int A03;
    public static int A04;
    public static int A05;
    public static int A06;
    public static int A07;
    public static byte[] A08;
    public static final String A09;

    public static String A00(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 103);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A08 = new byte[]{-47, -17, -15, -10, -13, -82, -14, -9, 1, -7, -82, -12, -17, -9, -6, 3, 0, -13, -68, -72, -42, -40, -35, -38, -107, -39, -34, -24, -32, -107, -24, -22, -40, -40, -38, -24, -24, -93, -7, 23, 25, 30, 27, -42, 26, 37, 45, 36, 34, 37, 23, 26, -42, 28, 23, 31, 34, 43, 40, 27, -28, -80, -50, -48, -43, -46, -115, -43, -42, -31, -101, -63, -33, -31, -26, -29, -98, -21, -25, -15, -15, -84, 19, 22, 17, 21, 36, 23, 19, 38, 27, 40, 23, 17, 37, 27, 44, 23, 17, 20, 43, 38, 23, 37, -33, -30, -35, -31, -16, -29, -33, -14, -25, -12, -29, -35, -14, -9, -18, -29, 29, 32, 27, 34, 43, 46, 41, 29, 48, 27, 48, 53, 44, 33, -10, -7, -12, 7, -6, 6, 10, -6, 8, 9, -12, -2, -7, 67, 86, 86, 71, 79, 82, 86, 30, 28, 30, 35, 32, 63, 61, 63, 68, 65, 59, 63, 75, 74, 80, 65, 84, 80, -35, -40, -32, -29, -20, -23, -36, -42, -23, -36, -40, -22, -26, -27, 23, 27, 15, 21, 19, 28, 31, 17, 20, 15, 36, 25, 29, 21, 70, 67, 61};
    }

    static {
        A01();
        A09 = SI.class.getSimpleName();
        A05 = AbstractC2000Sv.A0o;
        A06 = AbstractC2000Sv.A0s;
        A02 = AbstractC2000Sv.A0l;
        A01 = AbstractC2000Sv.A0k;
        A03 = AbstractC2000Sv.A0m;
        A00 = AbstractC2000Sv.A0i;
        A04 = AbstractC2000Sv.A0n;
        A07 = AbstractC2000Sv.A0t;
    }

    public static void A02(SQ sq, S8 s82, int i10, String str, long j10) {
        if (!A06(sq)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(A00(120, 14, 85), s82.A01);
            jSONObject.put(A00(134, 13, 46), s82.A02);
            if (j10 > 0) {
                jSONObject.put(A00(191, 9, 73), XG.A07(System.currentTimeMillis() - j10));
            }
            C2001Sw c2001Sw = new C2001Sw(str);
            c2001Sw.A07(jSONObject);
            c2001Sw.A05(1);
            sq.A08().AAz(A00(154, 5, 84), i10, c2001Sw);
        } catch (Throwable deLogException) {
            sq.A08().A4A(deLogException);
        }
    }

    public static void A03(SQ sq, SD sd, String str, int i10, String str2, Long l10, Long l11) {
        if (A06(sq)) {
            A05(sq, sd.A06, sd.A07, sd.A08, A00(186, 5, 71), str, i10, str2, l10, l11, null);
        }
    }

    public static void A04(SQ sq, SH sh, boolean z10) {
        if (!A06(sq)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(A00(120, 14, 85), sh.A01);
            jSONObject.put(A00(134, 13, 46), sh.A03);
            jSONObject.put(A00(104, 16, 23), sh.A02);
            jSONObject.put(A00(159, 13, 117), sh.A00);
            if (U7.A2M(sq)) {
                jSONObject.put(A00(200, 3, 106), sh.A04);
            }
            String strA00 = z10 ? A00(61, 10, 6) : A00(71, 11, 23);
            int i10 = z10 ? A05 : A06;
            C2001Sw c2001Sw = new C2001Sw(strA00);
            c2001Sw.A07(jSONObject);
            c2001Sw.A05(1);
            sq.A08().AAz(A00(154, 5, 84), i10, c2001Sw);
        } catch (Throwable th) {
            sq.A08().A4A(th);
        }
    }

    public static void A05(SQ sq, String str, String str2, String str3, String str4, String str5, int i10, String str6, Long l10, Long l11, Integer num) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(A00(120, 14, 85), str);
            jSONObject.put(A00(134, 13, 46), str2);
            jSONObject.put(A00(104, 16, 23), str4);
            if (str6 != null) {
                jSONObject.put(A00(TsExtractor.TS_STREAM_TYPE_AC4, 14, 16), str6);
            }
            if (l10 != null) {
                jSONObject.put(A00(82, 22, 75), String.valueOf(l10));
            }
            if (l11 != null) {
                jSONObject.put(A00(191, 9, 73), String.valueOf(l11));
            }
            if (num != null) {
                jSONObject.put(A00(147, 7, 123), String.valueOf(num));
            }
            jSONObject.put(A00(159, 13, 117), str5);
            if (U7.A2M(sq)) {
                jSONObject.put(A00(200, 3, 106), str3);
            }
            String strA00 = A00(19, 19, 14);
            if (i10 == A03) {
                strA00 = A00(38, 23, 79);
            } else if (i10 == A01) {
                strA00 = A00(0, 19, 39);
            }
            C2001Sw c2001Sw = new C2001Sw(strA00);
            c2001Sw.A07(jSONObject);
            c2001Sw.A05(1);
            sq.A08().AAz(A00(154, 5, 84), i10, c2001Sw);
        } catch (Throwable th) {
            sq.A08().A4A(th);
        }
    }

    public static boolean A06(SQ sq) {
        int iA06;
        if (sq.A05().AAF()) {
            iA06 = 1;
        } else {
            iA06 = U9.A06(sq);
        }
        if (iA06 == 0) {
            return false;
        }
        return iA06 <= 0 || sq.A09().A00() <= 1.0d / ((double) iA06);
    }
}
