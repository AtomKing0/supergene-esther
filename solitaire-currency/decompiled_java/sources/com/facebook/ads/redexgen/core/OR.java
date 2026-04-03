package com.facebook.ads.redexgen.core;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class OR {
    public static String[] A00 = {"nDiC2V", "xvPzB4voGkHgvzabNn8fejRwCVSwo6Ah", "OJIGMHO1ySc0mzACRtkWxwocBaSnW5m2", "JbsfTTx", "hwYl", "U04BYM1NuctRYg5sssH2", "d2TQ", "mxYxJu"};
    public static final int[] A01 = new int[0];
    public static final long[] A02 = new long[0];
    public static final Object[] A03 = new Object[0];

    public static int A00(int i10) {
        return A01(i10 * 8) / 8;
    }

    public static int A01(int i10) {
        int i11 = 4;
        while (A00[5].length() == 20) {
            A00[5] = "sf2HjvEbKVwFe9jamb5q";
            if (i11 >= 32) {
                return i10;
            }
            int i12 = 1 << i11;
            if (i10 <= i12 - 12) {
                int i13 = (1 << i11) - 12;
                return i13;
            }
            i11++;
        }
        throw new RuntimeException();
    }

    public static int A02(int[] iArr, int i10, int i11) {
        int midVal = 0;
        int i12 = i10 - 1;
        while (midVal <= i12) {
            int i13 = midVal + i12;
            String[] strArr = A00;
            String str = strArr[1];
            String str2 = strArr[2];
            int hi = str.charAt(26);
            int lo = str2.charAt(26);
            if (hi != lo) {
                throw new RuntimeException();
            }
            A00[3] = "GyF3CdngjgIBS8WP";
            int hi2 = i13 >>> 1;
            int lo2 = iArr[hi2];
            if (lo2 < i11) {
                midVal = hi2 + 1;
            } else if (lo2 > i11) {
                i12 = hi2 - 1;
            } else {
                return hi2;
            }
        }
        int lo3 = ~midVal;
        return lo3;
    }

    public static int A03(long[] jArr, int i10, long j10) {
        int i11 = 0;
        int i12 = i10 - 1;
        while (i11 <= i12) {
            int lo = i11 + i12;
            int i13 = lo >>> 1;
            long j11 = jArr[i13];
            if (j11 < j10) {
                i11 = i13 + 1;
            } else {
                String[] strArr = A00;
                String str = strArr[4];
                String str2 = strArr[6];
                int hi = str.length();
                int lo2 = str2.length();
                if (hi != lo2) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A00;
                strArr2[4] = "jlrm";
                strArr2[6] = "MXd0";
                if (j11 > j10) {
                    i12 = i13 - 1;
                } else {
                    return i13;
                }
            }
        }
        int lo3 = ~i11;
        return lo3;
    }

    public static boolean A04(@Nullable Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
