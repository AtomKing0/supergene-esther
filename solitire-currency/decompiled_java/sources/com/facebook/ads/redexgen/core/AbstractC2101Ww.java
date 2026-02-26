package com.facebook.ads.redexgen.core;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ww, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2101Ww {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A02(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] ^ i12) ^ 108);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{62, 50, 48, 115, 59, 60, 62, 56, 63, 50, 50, 54, 115, 54, 60, 41, 60, 51, 60};
    }

    public static PackageInfo A00(SQ sq) {
        return A01(sq, A02(0, 19, 49));
    }

    public static PackageInfo A01(SQ sq, String str) {
        PackageManager packageManager;
        if (TextUtils.isEmpty(str) || (packageManager = sq.getPackageManager()) == null) {
            return null;
        }
        try {
            return packageManager.getPackageInfo(str, 1);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        } catch (RuntimeException unused2) {
            return null;
        }
    }

    public static boolean A04(SQ sq, String str) {
        PackageInfo packageInfo = A01(sq, str);
        return packageInfo != null;
    }
}
