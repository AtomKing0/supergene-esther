package com.facebook.ads.redexgen.core;

import android.view.View;
import com.facebook.ads.NativeAdLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ye, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2135Ye {
    public static String[] A00 = {"B", "b", "N7Y4O4Xp0bXRpwQYmrnUbbD5XPNn0nfl", "PsTgqcCc8jcMoxm2RXWy1mA6rhf59", "zMLnehec4ICfDGOtTSDp3symXOGZpaRx", "AnvCnC9uV", "JoTWE5M61fQkMjrwCjPz5KG5vu8cqeKb", "O6aKPphMSjoWO4xDWlhiQ7T2kp0fs"};
    public static final int A01 = (int) (AbstractC2090Wl.A02 * 200.0f);
    public static final int A03 = (int) (AbstractC2090Wl.A02 * 200.0f);
    public static final int A02 = (int) (AbstractC2090Wl.A02 * 50.0f);

    public static EnumC1830Md A00(NativeAdLayout nativeAdLayout) {
        if (nativeAdLayout == null) {
            return EnumC1830Md.A04;
        }
        if (A03(nativeAdLayout)) {
            return EnumC1830Md.A05;
        }
        return EnumC1830Md.A03;
    }

    public static AbstractC2134Yd A01(C2387dL c2387dL, US us, String str, View view) {
        if (view == null) {
            return null;
        }
        int w10 = view.getWidth();
        int height = view.getHeight();
        if (w10 >= A01 && height >= A01) {
            return new LS(c2387dL, us, str);
        }
        if (w10 >= A03) {
            int i10 = A02;
            String[] strArr = A00;
            if (strArr[6].charAt(28) == strArr[4].charAt(28)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A00;
            strArr2[7] = "MXaU9iKOIfaGo19ccmM4SYJQh1BEv";
            strArr2[3] = "urarsFS1owFx4szCeqq2cq67A77KP";
            if (height >= i10) {
                return new LU(c2387dL, us, str);
            }
        }
        return null;
    }

    public static LV A02(C2387dL c2387dL, US us, String str, N9 n92, InterfaceC2119Xo interfaceC2119Xo, InterfaceC2118Xn interfaceC2118Xn) {
        return new LV(c2387dL, us, str, n92, interfaceC2119Xo, interfaceC2118Xn);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean A03(com.facebook.ads.NativeAdLayout r6) {
        /*
            int r5 = r6.getWidth()
            int r4 = r6.getHeight()
            int r0 = com.facebook.ads.redexgen.core.AbstractC2135Ye.A01
            if (r5 < r0) goto L10
            int r0 = com.facebook.ads.redexgen.core.AbstractC2135Ye.A01
            if (r4 >= r0) goto L2a
        L10:
            int r3 = com.facebook.ads.redexgen.core.AbstractC2135Ye.A03
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AbstractC2135Ye.A00
            r0 = 1
            r1 = r2[r0]
            r0 = 0
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L2c
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L2a:
            r0 = 0
            goto L3f
        L2c:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AbstractC2135Ye.A00
            java.lang.String r1 = "e"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "I"
            r0 = 0
            r2[r0] = r1
            if (r5 < r3) goto L3e
            int r0 = com.facebook.ads.redexgen.core.AbstractC2135Ye.A02
            if (r4 >= r0) goto L2a
        L3e:
            r0 = 1
        L3f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC2135Ye.A03(com.facebook.ads.NativeAdLayout):boolean");
    }
}
