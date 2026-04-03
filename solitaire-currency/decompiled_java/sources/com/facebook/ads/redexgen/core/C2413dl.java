package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2413dl implements LA {
    public static byte[] A01;
    public static String[] A02 = {"DkadTd3hzRbbbOHMxE7l2HcIgF77c2Wg", "0ZuZJmAU8cZIcQf3szyGmXM5AilOTJtQ", "s7OtZpyonCiYFMYFU1WCjmQvHXym6FPj", "3vySfQzjuhiXchKud6RTPthf0ulaYdWV", "CDvhYqwZm7dYJUP65EPDHmFcAmisUun7", "F", "FueLju8lXT0mR7zmJE5", "4fFvsSsvSh6WJapTHyxRGbQ9SIVR6447"};
    public final /* synthetic */ C2361cu A00;

    public static String A00(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 23);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-89, -85, -97, -91, -93};
        String[] strArr = A02;
        if (strArr[4].charAt(11) == strArr[0].charAt(11)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[4] = "8YVOAkqjlCZIfPO923uAjm7vB9HJVDjx";
        strArr2[0] = "zjuPMStvlm1D7VGZIKzQB2odE0473uv0";
        A01 = bArr;
    }

    static {
        A01();
    }

    public C2413dl(C2361cu c2361cu) {
        this.A00 = c2361cu;
    }

    @Override // com.facebook.ads.redexgen.core.LA
    public final void AAq(Throwable th) {
        this.A00.A08().AAy(A00(0, 5, 39), AbstractC2000Sv.A1e, new C2001Sw(th));
    }

    @Override // com.facebook.ads.redexgen.core.LA
    public final void AB4(Throwable th) {
        this.A00.A08().AAy(A00(0, 5, 39), AbstractC2000Sv.A1g, new C2001Sw(th));
    }

    @Override // com.facebook.ads.redexgen.core.LA
    public final void AGk(String str, int i10, String str2, Long l10, Long l11, C1796Kv c1796Kv) {
        SI.A05(this.A00, c1796Kv.A06, c1796Kv.A08, c1796Kv.A09, c1796Kv.A07, c1796Kv.A03, i10, str2, l10, l11, null);
    }

    @Override // com.facebook.ads.redexgen.core.LA
    public final void AGl(String str, boolean z10, C1796Kv c1796Kv) {
        SI.A04(this.A00, new SH(c1796Kv.A06, c1796Kv.A08, c1796Kv.A07, c1796Kv.A03, str), z10);
    }
}
