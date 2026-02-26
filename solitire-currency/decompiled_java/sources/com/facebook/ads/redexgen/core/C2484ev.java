package com.facebook.ads.redexgen.core;

import android.provider.Settings;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ev, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2484ev {
    public static InterfaceC2464eb A00;
    public static byte[] A01;
    public static final Set<String> A02;
    public static final Set<String> A03;
    public static final AtomicBoolean A04;

    public static String A05(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] ^ i12) ^ 29);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A01 = new byte[]{51, 114, 121, 9, 84, 69, 113, 55, 55, 120, 5, 112, 1, 25, 51, 18, 114, 47, 24, 117, 44, 46, 36, 43, 114, 40, 55, 48, 114, 21, 47, 51, 43, 125, 74, 63, 96, 71, 122, 102, 66, 127, 106, 97, 126, 98, 39, 91, 97, 106, 72, 100, 122, 126, 62, 101, 90, 100, 35, 117, 94, 127, 49, 6, 81, 35, 43, 66, 103, 86, 39, 106, 95, 80, 119, 127, 122, 39, 97, 99, 103, 106, 98, 82, 86, 112, 105, 75, 92, 118, 82, 46, 25, 88, 115, 98, 97, 121, 100, 125, 127, 120, 113, 54, 116, 115, 112, 121, 100, 115, 54, 127, 120, 127, 98, 55, 83, 81, 83, 66, 61, 106, 101, 81, 105, 111, 64, 109, 32, 127, 106, 94, 89, 111, 101, 114, 94, 67, 62, 98, 123, 108, 70, 54, 1, 15, 7, 28, 30, 2, 15, 0, 11, 49, 3, 1, 10, 11, 49, 1, 0, 29, 22, 7, 4, 28, 1, 24, 33, 58, 15, 103, 18, 7, 59, 7, 63, 22, 108, 5, 96, 3, 3, 0, 49, 22, 37, 26, 39, 19, 29, 109, 57, 51, 4, 104, 95};
    }

    static {
        A07();
        A02 = new HashSet();
        A03 = new HashSet();
        A02.add(A05(6, 29, 93));
        A03.add(A05(168, 29, 72));
        A03.add(A05(35, 29, 17));
        A03.add(A05(64, 29, 14));
        A03.add(A05(116, 29, 22));
        A04 = new AtomicBoolean();
    }

    public static InterfaceC2466ed A00(SQ sq) {
        return A03(true, sq);
    }

    public static InterfaceC2466ed A01(SQ sq) {
        return A02(true, sq);
    }

    public static InterfaceC2466ed A02(boolean z10, SQ sq) {
        C2470eh c2470eh = new C2470eh();
        C2473ek networkModuleRequestConfigurationBuilder = A04(sq);
        if (!A0B(sq)) {
            c2470eh.A02(A03);
            c2470eh.A01(A02);
        }
        if (WS.A04()) {
            networkModuleRequestConfigurationBuilder.A08(WS.A02());
        }
        CI ciA00 = AbstractC2468ef.A00();
        C2470eh networkModuleConfigurationBuilder = c2470eh.A00(networkModuleRequestConfigurationBuilder.A09());
        return ciA00.A00(networkModuleConfigurationBuilder.A03(z10).A04(sq.A05().AAF()).A05(), sq.A08(), XU.A01());
    }

    public static InterfaceC2466ed A03(boolean z10, SQ sq) {
        return AbstractC2468ef.A00().A00(new C2470eh().A03(z10).A00(A04(sq).A09()).A04(sq.A05().AAF()).A05(), sq.A08(), XU.A01());
    }

    public static C2473ek A04(SQ sq) {
        A08(sq);
        C2473ek c2473ek = new C2473ek();
        if (A0B(sq) || WS.A04()) {
            c2473ek.A02(360000).A04(120000);
        } else {
            c2473ek.A02(U7.A09(sq)).A04(U7.A0B(sq));
        }
        c2473ek.A03(U7.A0A(sq)).A05(U7.A0C(sq)).A06(U7.A0D(sq));
        synchronized (C2484ev.class) {
            if (A00 != null && (A00 instanceof InterfaceC2464eb)) {
                c2473ek.A07(A00);
            }
        }
        return c2473ek;
    }

    public static void A06() {
        A04.set(true);
    }

    public static void A08(SQ sq) {
        if (!A04.get()) {
            sq.A08().AAy(A05(161, 7, 110), AbstractC2000Sv.A21, new C2001Sw(A05(93, 23, 11)));
        }
    }

    public static synchronized void A09(InterfaceC2464eb interfaceC2464eb) {
        A00 = interfaceC2464eb;
    }

    public static boolean A0A(SQ sq) {
        return Settings.Global.getInt(sq.getContentResolver(), A05(145, 16, 115), 0) != 0;
    }

    public static boolean A0B(SQ sq) {
        String strA9I = sq.A05().A9I();
        if (!TextUtils.isEmpty(strA9I)) {
            String urlPrefix = A05(3, 3, 58);
            if (!strA9I.endsWith(urlPrefix)) {
                String urlPrefix2 = A05(0, 3, 0);
                if (strA9I.endsWith(urlPrefix2)) {
                }
            }
            return true;
        }
        return false;
    }
}
