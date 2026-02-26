package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2172Zp {
    public static byte[] A01;
    public final Map<String, String> A00;

    static {
        A01();
    }

    public static String A00(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 55);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-25, -6, -10, -12, -29, -31, -22, -21, -16, -10, -11, -37, -42, -36, -54, -49};
    }

    public C2172Zp() {
        this.A00 = new HashMap();
    }

    public C2172Zp(Map<String, String> extraData) {
        this.A00 = extraData;
    }

    public final C2172Zp A02(XH xh) {
        if (xh != null) {
            this.A00.put(A00(11, 5, 48), AbstractC2096Wr.A01(xh.A04()));
        }
        return this;
    }

    public final C2172Zp A03(C2460eX c2460eX) {
        if (c2460eX != null) {
            this.A00.putAll(c2460eX.A0S());
        }
        return this;
    }

    public final C2172Zp A04(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.A00.put(A00(0, 11, 75), str);
        }
        return this;
    }

    public final Map<String, String> A05() {
        return this.A00;
    }
}
