package com.facebook.ads.redexgen.core;

import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2006Tb {
    public static String A00;
    public static byte[] A01;
    public static String[] A02 = {"qZcb6NmBns1n3v1", "rTLETUx3xNnjwSb02Sx6jVZM5Fuzg7Of", "ujF8Yx1ooHYTWOANWsLoHgp9GHsWq5OG", "emoc9RIZRY17k1iV3jHEmbNdIKvpuqWe", "9dj0hHqqeHaqkXambHAPXjsskYxWzSoy", "H6Wp9lsP8ocDK9Bk7hE2Cfl7XjXVKK5i", "baRwZ59Bd0PN8tFBdjuxnLHZSOlJTNRT", "2xLvEFwTfIQTf34sGOrn6donSx3FaGAc"};
    public static final AtomicBoolean A03;
    public static final AtomicReference<String> A04;

    public static String A00(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 118);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A01 = new byte[]{-56, 3, -18, -22, -23, -10, -41, -23, 29, 12, 17, 13, 22, 11, 13, -10, 13, 28, 31, 23, 26, 19, -18, 23, 26, -23, 22, 12, 26, 23, 17, 12, -29, -18, -22, -5, -10, -41, 6, -18, -7, -11, -12, 9, -30, -18, -7, -11, -11, 9, -30, -71, -60, -64, -54, -63, -83, -53, -42, -46, -29, -26, -65, -63, -67, -68, -67, -86, -55, -59, -39, -42, -78, 64, 57, 79, 62, 69, 60, 60, 54, 79, 76, 79, 80, 88, 79, -9, 57, 69, 67, 4, 60, 55, 57, 59, 56, 69, 69, 65, 4, 55, 58, 73, 4, 63, 68, 74, 59, 72, 68, 55, 66, 4, 75, 55, 52, 50, 59, 50, 63, 54, 48, 25, 37, 37, 33, -33, 18, 24, 22, 31, 37, 31, 29, 15, 28, 9, 11, 17, 15, 24, 30, -20, -22, -36, -23, -42, -40, -34, -36, -27, -21, -42, -29, -40, -22, -21, -42, -23, -36, -35, -23, -36, -22, -33, 59, 41, 38, 35, 58, 45, 41, 59};
    }

    static {
        A08();
        A00 = A00(80, 7, 107);
        A03 = new AtomicBoolean();
        A04 = new AtomicReference<>();
    }

    public static String A01(SQ sq) {
        return WebSettings.getDefaultUserAgent(sq);
    }

    public static String A02(SQ sq) {
        FutureTask futureTask = new FutureTask(new CallableC2005Ta(sq));
        for (int i10 = 0; i10 < 3; i10++) {
            XJ.A00(futureTask);
            try {
                return (String) futureTask.get();
            } catch (Throwable th) {
                A09(sq, th);
                SystemClock.sleep(500L);
            }
        }
        return null;
    }

    public static String A03(SQ sq, T6 t62) {
        String strA07 = t62.A07();
        if (TextUtils.isEmpty(strA07) && !A03.getAndSet(true)) {
            InterfaceC1999Su interfaceC1999SuA08 = sq.A08();
            int i10 = AbstractC2000Sv.A1Z;
            String bundle = A00(73, 7, 122);
            C2001Sw c2001Sw = new C2001Sw(bundle);
            String bundle2 = A00(116, 7, 87);
            interfaceC1999SuA08.AAy(bundle2, i10, c2001Sw);
        }
        return strA07;
    }

    public static String A04(SQ sq, boolean z10) {
        if (sq == null) {
            return A00;
        }
        if (z10) {
            return System.getProperty(A00(123, 10, 59));
        }
        String str = A04.get();
        if (str != null) {
            return str;
        }
        long spUserAgentRefresh = U6.A01(sq);
        String strA00 = A00(143, 23, 1);
        String strA002 = A00(133, 10, 52);
        String strA003 = A00(88, 28, 96);
        if (spUserAgentRefresh > 0) {
            SharedPreferences sharedPreferences = sq.getSharedPreferences(ProcessUtils.getProcessSpecificName(strA003, sq), 0);
            String string = sharedPreferences.getString(strA002, null);
            long j10 = sharedPreferences.getLong(strA00, 0L);
            if (!TextUtils.isEmpty(string) && System.currentTimeMillis() - j10 < spUserAgentRefresh) {
                A04.set(string);
                String[] strArr = A02;
                String str2 = strArr[6];
                String browserUserAgent = strArr[3];
                if (str2.charAt(17) != browserUserAgent.charAt(17)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[6] = "raDju45r7vWAWvtCMjs7ezmbeHuUzRMZ";
                strArr2[3] = "IEXEfOXuBGyf1jRfSjx88B0PyUJh9Pa6";
                return string;
            }
        }
        String strA02 = null;
        try {
            strA02 = A01(sq);
            A04.set(strA02);
        } catch (Throwable t10) {
            A09(sq, t10);
        }
        if (strA02 == null) {
            strA02 = A02(sq);
        }
        if (strA02 == null) {
            return A00;
        }
        if (spUserAgentRefresh > 0) {
            SharedPreferences sharedPreferences2 = sq.getSharedPreferences(ProcessUtils.getProcessSpecificName(strA003, sq), 0);
            sharedPreferences2.edit().putString(strA002, A04.get()).apply();
            sharedPreferences2.edit().putLong(strA00, System.currentTimeMillis()).apply();
        }
        return strA02;
    }

    public static String A05(T6 t62, SQ sq) {
        if (U6.A04(sq)) {
            return A00(63, 5, 5) + A03(sq, t62) + A00(39, 6, 61) + t62.A06() + A00(45, 6, 61) + t62.A04() + A00(38, 1, 85);
        }
        return A00(0, 0, 76);
    }

    public static String A06(T6 t62, SQ sq, boolean z10) {
        return A04(sq, z10) + A00(0, 38, 50) + sq.A05().A9K() + A00(57, 6, 26) + T6.A04 + A00(38, 1, 85) + A05(t62, sq) + A00(68, 5, 13) + sq.A05().A9L() + A00(51, 6, 8) + Locale.getDefault().toString() + A00(87, 1, 36);
    }

    public static void A09(SQ sq, Throwable th) {
        sq.A08().AAy(A00(166, 8, 78), AbstractC2000Sv.A2i, new C2001Sw(th));
    }
}
