package com.facebook.ads.redexgen.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RunnableC1927Pz implements Runnable {
    public static Comparator<C1926Py> A04;
    public static byte[] A05;
    public static String[] A06 = {"ZWObiMwNkhaZGfEgqHenCxQvRQCezgXM", "iKaB5ntiNbaiz6tgW", "JplxjEE1IYbCInXXNCkbxZV0", "UEoPOy6vCmPnpiXEMXmcZKvRtDoHf0nN", "JvUlYJe7lgtJoJN1gtwvhyIs", "RcG3r4ysor4dcgCWVGn8CFYsdgQ7jZkt", "cxmAjzJ", "EyohaYHYoMvb6y9gFGiucolIeU60NsdM"};
    public static final ThreadLocal<RunnableC1927Pz> A07;
    public long A00;
    public long A01;
    public ArrayList<C14346g> A02 = new ArrayList<>();
    public ArrayList<C1926Py> A03 = new ArrayList<>();

    public static String A01(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] ^ i12) ^ 104);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{105, 109, 27, 117, 94, 72, 79, 94, 95, 27, 107, 73, 94, 93, 94, 79, 88, 83, 100, 96, 22, 102, 68, 83, 80, 83, 66, 85, 94};
    }

    static {
        A03();
        A07 = new ThreadLocal<>();
        A04 = new C1925Px();
    }

    private AbstractC1934Qg A00(C14346g c14346g, int i10, long j10) {
        if (A08(c14346g, i10)) {
            return null;
        }
        QW qw = c14346g.A0r;
        try {
            c14346g.A1M();
            AbstractC1934Qg abstractC1934QgA0I = qw.A0I(i10, false, j10);
            if (abstractC1934QgA0I != null) {
                if (abstractC1934QgA0I.A0e() && !abstractC1934QgA0I.A0f()) {
                    qw.A0T(abstractC1934QgA0I.A0H);
                } else {
                    qw.A0Z(abstractC1934QgA0I, false);
                }
            }
            return abstractC1934QgA0I;
        } finally {
            c14346g.A1o(false);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:16:0x0054 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A02() {
        /*
            r10 = this;
            java.util.ArrayList<com.facebook.ads.redexgen.X.6g> r0 = r10.A02
            int r9 = r0.size()
            r4 = 0
            r3 = 0
        L8:
            r2 = 0
            if (r3 >= r9) goto L26
            java.util.ArrayList<com.facebook.ads.redexgen.X.6g> r0 = r10.A02
            java.lang.Object r1 = r0.get(r3)
            com.facebook.ads.redexgen.X.6g r1 = (com.facebook.ads.redexgen.core.C14346g) r1
            int r0 = r1.getWindowVisibility()
            if (r0 != 0) goto L23
            com.facebook.ads.redexgen.X.gJ r0 = r1.A02
            r0.A04(r1, r2)
            com.facebook.ads.redexgen.X.gJ r0 = r1.A02
            int r0 = r0.A00
            int r4 = r4 + r0
        L23:
            int r3 = r3 + 1
            goto L8
        L26:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Py> r0 = r10.A03
            r0.ensureCapacity(r4)
            r8 = 0
            r7 = 0
        L2d:
            if (r7 >= r9) goto L8f
            java.util.ArrayList<com.facebook.ads.redexgen.X.6g> r0 = r10.A02
            java.lang.Object r6 = r0.get(r7)
            com.facebook.ads.redexgen.X.6g r6 = (com.facebook.ads.redexgen.core.C14346g) r6
            int r0 = r6.getWindowVisibility()
            if (r0 == 0) goto L40
        L3d:
            int r7 = r7 + 1
            goto L2d
        L40:
            com.facebook.ads.redexgen.X.gJ r5 = r6.A02
            int r0 = r5.A01
            int r4 = java.lang.Math.abs(r0)
            int r0 = r5.A02
            int r0 = java.lang.Math.abs(r0)
            int r4 = r4 + r0
            r3 = 0
        L50:
            int r0 = r5.A00
            int r0 = r0 * 2
            if (r3 >= r0) goto L3d
            java.util.ArrayList<com.facebook.ads.redexgen.X.Py> r0 = r10.A03
            int r0 = r0.size()
            if (r8 < r0) goto L86
            com.facebook.ads.redexgen.X.Py r0 = new com.facebook.ads.redexgen.X.Py
            r0.<init>()
            java.util.ArrayList<com.facebook.ads.redexgen.X.Py> r1 = r10.A03
            r1.add(r0)
        L68:
            int[] r2 = r5.A03
            int r1 = r3 + 1
            r2 = r2[r1]
            if (r2 > r4) goto L84
            r1 = 1
        L71:
            r0.A04 = r1
            r0.A02 = r4
            r0.A00 = r2
            r0.A03 = r6
            int[] r1 = r5.A03
            r1 = r1[r3]
            r0.A01 = r1
            int r8 = r8 + 1
            int r3 = r3 + 2
            goto L50
        L84:
            r1 = 0
            goto L71
        L86:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Py> r0 = r10.A03
            java.lang.Object r0 = r0.get(r8)
            com.facebook.ads.redexgen.X.Py r0 = (com.facebook.ads.redexgen.core.C1926Py) r0
            goto L68
        L8f:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Py> r1 = r10.A03
            java.util.Comparator<com.facebook.ads.redexgen.X.Py> r0 = com.facebook.ads.redexgen.core.RunnableC1927Pz.A04
            java.util.Collections.sort(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.RunnableC1927Pz.A02():void");
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A04(long r6) {
        /*
            r5 = this;
            r4 = 0
        L1:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Py> r0 = r5.A03
            int r0 = r0.size()
            if (r4 >= r0) goto L31
            java.util.ArrayList<com.facebook.ads.redexgen.X.Py> r0 = r5.A03
            java.lang.Object r3 = r0.get(r4)
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.RunnableC1927Pz.A06
            r0 = 7
            r1 = r1[r0]
            r0 = 15
            char r1 = r1.charAt(r0)
            r0 = 103(0x67, float:1.44E-43)
            if (r1 == r0) goto L24
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L24:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.RunnableC1927Pz.A06
            java.lang.String r1 = "gpZ2KV2"
            r0 = 6
            r2[r0] = r1
            com.facebook.ads.redexgen.X.Py r3 = (com.facebook.ads.redexgen.core.C1926Py) r3
            com.facebook.ads.redexgen.X.6g r0 = r3.A03
            if (r0 != 0) goto L32
        L31:
            return
        L32:
            r5.A06(r3, r6)
            r3.A00()
            int r4 = r4 + 1
            goto L1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.RunnableC1927Pz.A04(long):void");
    }

    private final void A05(long j10) {
        A02();
        A04(j10);
    }

    private void A06(C1926Py c1926Py, long j10) {
        AbstractC1934Qg abstractC1934QgA00 = A00(c1926Py.A03, c1926Py.A01, c1926Py.A04 ? Long.MAX_VALUE : j10);
        if (abstractC1934QgA00 != null && abstractC1934QgA00.A09 != null && abstractC1934QgA00.A0e() && !abstractC1934QgA00.A0f()) {
            C14346g c14346g = abstractC1934QgA00.A09.get();
            if (A06[3].charAt(4) != 'O') {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[0] = "y01bdO2VJYUoPT1JEr7HCeGbjhjinZRt";
            strArr[5] = "ogbTL45N3M3fzw26YptkCantwmvhDLLM";
            A07(c14346g, j10);
        }
    }

    private void A07(C14346g c14346g, long j10) {
        if (c14346g == null) {
            return;
        }
        if (c14346g.A0C && c14346g.A01.A06() != 0) {
            c14346g.A1P();
        }
        C2568gJ c2568gJ = c14346g.A02;
        c2568gJ.A04(c14346g, true);
        if (c2568gJ.A00 != 0) {
            try {
                OQ.A01(A01(0, 18, 83));
                c14346g.A0s.A05(c14346g.A04);
                for (int i10 = 0; i10 < c2568gJ.A00 * 2; i10 += 2) {
                    A00(c14346g, c2568gJ.A03[i10], j10);
                }
            } finally {
                OQ.A00();
            }
        }
    }

    public static boolean A08(C14346g c14346g, int i10) {
        int iA06 = c14346g.A01.A06();
        for (int i11 = 0; i11 < iA06; i11++) {
            AbstractC1934Qg abstractC1934QgA0F = C14346g.A0F(c14346g.A01.A0A(i11));
            int childCount = abstractC1934QgA0F.A03;
            if (childCount == i10 && !abstractC1934QgA0F.A0f()) {
                return true;
            }
        }
        return false;
    }

    public final void A09(C14346g c14346g) {
        this.A02.add(c14346g);
    }

    public final void A0A(C14346g c14346g) {
        this.A02.remove(c14346g);
    }

    public final void A0B(C14346g c14346g, int i10, int i11) {
        if (c14346g.isAttachedToWindow()) {
            long j10 = this.A01;
            String[] strArr = A06;
            if (strArr[0].charAt(20) != strArr[5].charAt(20)) {
                throw new RuntimeException();
            }
            A06[6] = "T8Y6UBY";
            if (j10 == 0) {
                this.A01 = c14346g.getNanoTime();
                c14346g.post(this);
            }
        }
        c14346g.A02.A03(i10, i11);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            OQ.A01(A01(18, 11, 94));
            if (this.A02.isEmpty()) {
                this.A01 = 0L;
                if (A06[6].length() != 7) {
                    throw new RuntimeException();
                }
                A06[7] = "jOxF3Mzmcdx8L8GgZmI4I6pGAsyGGZV3";
                OQ.A00();
                return;
            }
            int size = this.A02.size();
            long jMax = 0;
            for (int i10 = 0; i10 < size; i10++) {
                C14346g c14346g = this.A02.get(i10);
                if (c14346g.getWindowVisibility() == 0) {
                    jMax = Math.max(c14346g.getDrawingTime(), jMax);
                }
            }
            if (jMax == 0) {
                return;
            }
            A05(TimeUnit.MILLISECONDS.toNanos(jMax) + this.A00);
        } finally {
            this.A01 = 0L;
            OQ.A00();
        }
    }
}
