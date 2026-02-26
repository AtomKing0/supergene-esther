package com.facebook.ads.redexgen.core;

import android.os.SystemClock;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AV {
    public static byte[] A06;
    public static String[] A07 = {"eoBlep8s1FBIN6Rt", "z5PVad8lFvymSbVcRUVN6mCVOAyUTpZZ", "CSzRbjHFCczJ9I", "vibjkM4Umklha9WpeyLj2yq757BqeZSZ", "UWrS", "", "nE8lp", "HlO2gnmnWOpwEq19Q9DE2Hcik4TJ8nc9"};
    public static final AV A08;

    @Nullable
    public MediaCodecPoolTracker A01;

    @Nullable
    public Boolean A02;
    public volatile Map<String, Set<AO>> A04 = new HashMap();
    public final AU A03 = new AU(this);
    public int A00 = 0;
    public volatile long A05 = -1;

    public static String A05(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 74);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A06 = new byte[]{-63, -71, -56, -75, -126, -72, -75, -54, -123, -72, -126, -75, -54, -123, -126, -72, -71, -73, -61, -72, -71, -58};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0082 A[Catch: all -> 0x009f, TRY_LEAVE, TryCatch #3 {all -> 0x009f, blocks: (B:41:0x0078, B:44:0x007e, B:46:0x0082), top: B:56:0x0078 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A0C(boolean r5, com.facebook.ads.redexgen.core.C2659hv r6, com.facebook.ads.redexgen.core.EnumC2656hq r7, java.lang.String r8, com.facebook.ads.redexgen.core.AO r9) {
        /*
            r4 = this;
            boolean r0 = r4.A0I(r5, r6)
            if (r0 == 0) goto L78
            boolean r0 = A0G(r8, r6)
            if (r0 == 0) goto L78
            r3 = 1
            monitor-enter(r4)
            int r1 = r4.A00     // Catch: java.lang.Throwable -> L75
            int r0 = r6.A05     // Catch: java.lang.Throwable -> L75
            if (r1 >= r0) goto L4d
            java.util.Map<java.lang.String, java.util.Set<com.facebook.ads.redexgen.X.AO>> r0 = r4.A04     // Catch: java.lang.Throwable -> L75
            java.lang.Object r2 = r0.get(r8)     // Catch: java.lang.Throwable -> L75
            java.util.Set r2 = (java.util.Set) r2     // Catch: java.lang.Throwable -> L75
            if (r2 != 0) goto L27
            java.util.Set r2 = r4.A06()     // Catch: java.lang.Throwable -> L75
            java.util.Map<java.lang.String, java.util.Set<com.facebook.ads.redexgen.X.AO>> r0 = r4.A04     // Catch: java.lang.Throwable -> L75
            r0.put(r8, r2)     // Catch: java.lang.Throwable -> L75
        L27:
            boolean r0 = r2.contains(r9)     // Catch: java.lang.Throwable -> L75
            if (r0 == 0) goto L2f
            r3 = 0
            goto L4d
        L2f:
            if (r5 == 0) goto L35
            boolean r0 = r6.A0M     // Catch: java.lang.Throwable -> L75
            if (r0 != 0) goto L3b
        L35:
            if (r5 != 0) goto L4d
            boolean r0 = r6.A0L     // Catch: java.lang.Throwable -> L75
            if (r0 == 0) goto L4d
        L3b:
            int r1 = r2.size()     // Catch: java.lang.Throwable -> L75
            int r0 = r6.A04     // Catch: java.lang.Throwable -> L75
            if (r1 >= r0) goto L4d
            r2.add(r9)     // Catch: java.lang.Throwable -> L75
            int r0 = r4.A00     // Catch: java.lang.Throwable -> L75
            int r0 = r0 + 1
            r4.A00 = r0     // Catch: java.lang.Throwable -> L75
            r3 = 0
        L4d:
            if (r3 != 0) goto L73
            r0 = -1
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.IllegalStateException -> L69 java.lang.Throwable -> L6d
            r4.A05 = r2     // Catch: java.lang.IllegalStateException -> L69 java.lang.Throwable -> L6d
            r9.reset()     // Catch: java.lang.IllegalStateException -> L69 java.lang.Throwable -> L6d
            com.facebook.ads.redexgen.X.hr r3 = r4.A03()     // Catch: java.lang.IllegalStateException -> L69 java.lang.Throwable -> L6d
            int r2 = r9.hashCode()     // Catch: java.lang.IllegalStateException -> L69 java.lang.Throwable -> L6d
            r3.A09(r7, r2)     // Catch: java.lang.IllegalStateException -> L69 java.lang.Throwable -> L6d
            r4.A05 = r0     // Catch: java.lang.Throwable -> L75
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L75
            return
        L69:
            r4.A0B(r8, r9)     // Catch: java.lang.Throwable -> L6d
            goto L71
        L6d:
            r2 = move-exception
            r4.A05 = r0     // Catch: java.lang.Throwable -> L75
            throw r2     // Catch: java.lang.Throwable -> L75
        L71:
            r4.A05 = r0     // Catch: java.lang.Throwable -> L75
        L73:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L75
            goto L78
        L75:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L75
            throw r0
        L78:
            boolean r0 = r6.A0Q     // Catch: java.lang.Throwable -> L9f
            if (r0 == 0) goto L82
            if (r5 != 0) goto L85
            boolean r0 = r6.A0P     // Catch: java.lang.Throwable -> L9f
            if (r0 != 0) goto L85
        L82:
            r9.stop()     // Catch: java.lang.Throwable -> L9f
        L85:
            com.facebook.ads.redexgen.X.hr r1 = r4.A03()
            int r0 = r9.hashCode()
            r1.A08(r7, r0)
            r9.AGr()
            com.facebook.ads.redexgen.X.hr r1 = r4.A03()
            int r0 = r9.hashCode()
            r1.A07(r7, r0)
            return
        L9f:
            r2 = move-exception
            com.facebook.ads.redexgen.X.hr r1 = r4.A03()
            int r0 = r9.hashCode()
            r1.A08(r7, r0)
            r9.AGr()
            com.facebook.ads.redexgen.X.hr r1 = r4.A03()
            int r0 = r9.hashCode()
            r1.A07(r7, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AV.A0C(boolean, com.facebook.ads.redexgen.X.hv, com.facebook.ads.redexgen.X.hq, java.lang.String, com.facebook.ads.redexgen.X.AO):void");
    }

    static {
        A08();
        A08 = new AV();
    }

    private AO A01(boolean z10, C2659hv c2659hv, EnumC2656hq enumC2656hq, String str) throws Exception {
        if (A0I(z10, c2659hv) && A0G(str, c2659hv)) {
            synchronized (this) {
                Set<AO> set = this.A04.get(str);
                if (set != null && !set.isEmpty()) {
                    this.A00--;
                    Iterator<AO> it = set.iterator();
                    AO ret = it.next();
                    it.remove();
                    A03().A0A(z10, str, enumC2656hq, ret.hashCode());
                    return ret;
                }
            }
        }
        try {
            C2654ho c2654hoA05 = A03().A05(z10, str, enumC2656hq);
            AO aoA03 = this.A03.A03(z10, str);
            A03().A06(c2654hoA05, aoA03.hashCode());
            return aoA03;
        } catch (Exception e10) {
            throw new MediaCodecInitializationException(str, e10);
        }
    }

    public static AV A02() {
        AV av = A08;
        String[] strArr = A07;
        if (strArr[6].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[6] = "gdX1n";
        strArr2[4] = "uqN6";
        return av;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaCodecPoolTracker A03() {
        if (this.A01 != null) {
            return this.A01;
        }
        return NoOpMediaCodecPoolTracker.A02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Set<AO> A06() {
        if (this.A02 != null && this.A02.booleanValue()) {
            return new CopyOnWriteArraySet();
        }
        return new HashSet();
    }

    private void A09(MediaCodecPoolTracker mediaCodecPoolTracker) {
        if (this.A01 == null) {
            this.A01 = mediaCodecPoolTracker;
        }
    }

    private void A0A(C2659hv c2659hv) {
        if (this.A02 == null) {
            synchronized (this) {
                if (this.A02 == null) {
                    this.A02 = Boolean.valueOf(c2659hv.A0R);
                    if (this.A02.booleanValue()) {
                        this.A04 = new ConcurrentHashMap();
                    }
                }
            }
        }
    }

    private void A0B(String str, AO ao) {
        Set<AO> set = this.A04.get(str);
        if (set != null && set.remove(ao)) {
            int i10 = this.A00;
            String[] strArr = A07;
            if (strArr[3].charAt(31) != strArr[1].charAt(31)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[3] = "FxBrmOrzGAHEl951IE67fieu752sH0JZ";
            strArr2[1] = "QwM4isUBZzXVsf3PyxWpFGvjBfZOcOMZ";
            this.A00 = i10 - 1;
        }
    }

    public static boolean A0E(String str) {
        return str.equals(A05(0, 22, 10));
    }

    public static boolean A0G(String str, C2659hv c2659hv) {
        if (A0E(str) && c2659hv.A0A) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0I(boolean z10, C2659hv c2659hv) {
        if (c2659hv.A0C && this.A05 != -1 && SystemClock.elapsedRealtime() - this.A05 > 5000) {
            return false;
        }
        return A0J(z10, c2659hv);
    }

    public static boolean A0J(boolean z10, C2659hv c2659hv) {
        return (z10 && c2659hv.A0M) || (!z10 && c2659hv.A0L);
    }

    public final AO A0K(boolean z10, C2659hv c2659hv, MediaCodecPoolTracker mediaCodecPoolTracker, EnumC2656hq enumC2656hq, String str) throws Exception {
        A09(mediaCodecPoolTracker);
        A0A(c2659hv);
        if (c2659hv.A0J) {
            AO aoA02 = this.A03.A02(z10, c2659hv, enumC2656hq, str);
            String[] strArr = A07;
            if (strArr[5].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[3] = "ttyEUrXfsAwEm9Eniby4AXTGkmRMb34Z";
            strArr2[1] = "BAFCEyHtTeugEvQpUcdazZ0OUcRhptwZ";
            return aoA02;
        }
        return A01(z10, c2659hv, enumC2656hq, str);
    }

    public final void A0L(boolean z10, C2659hv c2659hv, MediaCodecPoolTracker mediaCodecPoolTracker, EnumC2656hq enumC2656hq, String str, AO ao) throws Throwable {
        A09(mediaCodecPoolTracker);
        if (c2659hv.A0J) {
            this.A03.A0A(z10, c2659hv, enumC2656hq, str, ao);
        } else {
            A0C(z10, c2659hv, enumC2656hq, str, ao);
        }
    }
}
