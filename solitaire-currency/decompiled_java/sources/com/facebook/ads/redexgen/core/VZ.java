package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class VZ {
    public static byte[] A00;
    public static final AtomicReference<String> A01;
    public static final AtomicReference<String> A02;

    public static String A00(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] ^ i12) ^ 54);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A00 = new byte[]{31, 34, 59, 52, 62, 52, 56, 62, 52, 57, 61, 52, 52, 58, 52, 61, 60, 34, 111, 120, 106, 126, 11, 69, 64, 74, 83, 123, 72, 75, 67, 67, 77, 74, 67, 11, 114, 60, 57, 51, 42, 2, 46, 36, 51, 62, 111, 44, 109, 102, 119, 116, 108, 113, 104, 92, 98, 103, 112, 92, 96, 108, 110, 110, 108, 109, 37, 57, 57, 61, 62, 119, 98, 98, 42, 63, 44, 61, 37, 104, 62, 99, 43, 44, 46, 40, 47, 34, 34, 38, 99, 46, 34, 32, 81, 77, 77, 73, 74, 3, 22, 22, 78, 78, 78, 28, 74, 23, 95, 88, 90, 92, 91, 86, 86, 82, 23, 90, 86, 84, 14, 14, 14};
    }

    static {
        A09();
        A01 = new AtomicReference<>();
        A02 = new AtomicReference<>();
    }

    public static String A01(SQ sq) {
        return A05(sq) + A00(47, 19, 53);
    }

    public static String A02(SQ sq) {
        String loggingEndpointPrefix = U7.A0X(sq);
        StringBuilder sbAppend = new StringBuilder().append(A07(sq, loggingEndpointPrefix));
        String loggingEndpointPrefix2 = A00(22, 14, 18);
        return sbAppend.append(loggingEndpointPrefix2).toString();
    }

    public static String A03(SQ sq) {
        return A05(sq) + A00(1, 21, 59);
    }

    public static String A04(SQ sq) {
        String syncEndpointPrefix = U7.A0Y(sq);
        StringBuilder sbAppend = new StringBuilder().append(A07(sq, syncEndpointPrefix));
        String syncEndpointPrefix2 = A00(36, 11, 107);
        return sbAppend.append(syncEndpointPrefix2).toString();
    }

    public static String A05(SQ sq) {
        String str = A01.get();
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String urlOverride = A00(66, 28, 123);
        return A06(sq, urlOverride);
    }

    public static String A06(SQ sq, String str) {
        String string;
        String strA9I = sq.A05().A9I();
        Locale locale = Locale.US;
        if (TextUtils.isEmpty(strA9I)) {
            string = A00(0, 0, 61);
        } else {
            StringBuilder sb = new StringBuilder();
            String prefix = A00(0, 1, 7);
            string = sb.append(prefix).append(strA9I).toString();
        }
        String prefix2 = String.format(locale, str, string);
        return prefix2;
    }

    public static String A07(SQ sq, String str) {
        String str2 = A02.get();
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String urlOverride = A00(94, 26, 15);
        return A08(A06(sq, urlOverride), str);
    }

    public static String A08(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str.replace(A00(120, 3, 79), str2);
    }
}
