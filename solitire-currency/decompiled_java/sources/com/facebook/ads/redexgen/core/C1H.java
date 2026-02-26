package com.facebook.ads.redexgen.core;

import android.graphics.Rect;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1H, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1H implements A6 {
    public static byte[] A09;
    public static String[] A0A = {"5g", "bfnfjiUri9kvxuLEKnZU3kJc1ieY23zz", "NIX", "B1MUzprhDDigVQ4p3NlPN3VyWdkPEAJB", "UzK", "rOCmuOM4l5uJjn2akKGm2JxYL79BUlOr", "kAulvLpzcmVynuK8kNGYEaaJbNqcwElD", "7ScKsdjGN77oK2tO1d"};
    public static final String A0B;
    public long A00;
    public InterfaceC3108pr A01;
    public final InterfaceC3107pq A02;
    public final C3100pi A03;
    public final C3100pi A04;
    public final List<Rect> A05;
    public final Map<String, C3099ph> A06;
    public final boolean A07;
    public final boolean A08;

    public static String A02(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i10, i10 + i11);
        int i13 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0A;
            if (strArr[3].charAt(2) == strArr[1].charAt(2)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[5] = "GBjOApmdB9meVYu3h8dWYwSrfWPE5QmB";
            strArr2[6] = "rSzbUr5mB5cqWCHa6t40U5C3uIAdU8ry";
            if (i13 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] ^ i12) ^ 73);
            i13++;
        }
    }

    public static void A03() {
        A09 = new byte[]{20, 40, 41, 51, 96, 54, 41, 37, 55, 48, 47, 41, 46, 52, 96, 40, 33, 51, 96, 46, 47, 52, 96, 34, 37, 37, 46, 96, 45, 37, 33, 51, 53, 50, 37, 36, 96, 47, 50, 96, 41, 51, 96, 33, 96, 39, 50, 47, 53, 48, 96, 55, 40, 41, 35, 40, 96, 55, 41, 44, 44, 96, 46, 37, 54, 37, 50, 96, 50, 37, 52, 53, 50, 46, 96, 33, 96, 45, 37, 33, 51, 53, 50, 37, 45, 37, 46, 52, 96, 51, 41, 46, 35, 37, 96, 41, 52, 103, 51, 96, 45, 33, 36, 37, 96, 53, 48, 96, 47, 38, 96, 51, 53, 34, 54, 41, 37, 55, 51, 96, 52, 40, 33, 52, 96, 35, 47, 53, 44, 36, 96, 34, 37, 96, 47, 38, 38, 51, 35, 50, 37, 37, 46, 16, 27, 9, 45, 29, 31, 16, 61, 38, 63, 63, 115, 37, 58, 54, 36, 115, 35, 33, 60, 35, 54, 33, 39, 42, 115, 53, 60, 33, 115, 33, 54, 62, 60, 37, 54, 55, 115, 58, 39, 54, 62, 115, 30, 2, 11, 25, 63, 8, 29, 2, 31, 25};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 9
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Override // com.facebook.ads.redexgen.core.A6
    public final void A6H(List<C3111pu<?, ?>> list) {
        if (list != null && !list.isEmpty()) {
            A06(list);
        }
        A05(this.A04);
        A04(this.A04);
        A05(this.A03);
        A04(this.A03);
        if (0 != 0) {
            new C3097pf(toString(), this, this.A05, this.A04.A00(), this.A03.A00());
            throw new NullPointerException(A02(143, 7, 55));
        }
    }

    static {
        A03();
        A0B = C1H.class.getSimpleName();
    }

    public C1H(InterfaceC3107pq interfaceC3107pq) {
        this(interfaceC3107pq, false, false);
    }

    public C1H(InterfaceC3107pq interfaceC3107pq, boolean z10, boolean z11) {
        this.A06 = new HashMap();
        this.A04 = new C3100pi();
        this.A03 = new C3100pi();
        this.A05 = new ArrayList(1);
        this.A02 = interfaceC3107pq;
        this.A08 = z10;
        this.A07 = z11;
    }

    public static Rect A00(C3099ph c3099ph) {
        if (c3099ph == null || c3099ph.A02.top == Integer.MIN_VALUE || c3099ph.A02.left == Integer.MIN_VALUE || c3099ph.A02.right == Integer.MIN_VALUE || c3099ph.A02.bottom == Integer.MIN_VALUE) {
            throw new IllegalStateException(A02(0, 143, 9));
        }
        return c3099ph.A02;
    }

    private C3099ph A01(C3111pu c3111pu, Rect rect, Rect rect2) {
        C3099ph c3099phA03 = this.A06.get(c3111pu.A02);
        if (this.A04.A06(c3111pu)) {
            if (c3099phA03 != null) {
                c3099phA03.A01 = EnumC3103pl.A04;
            } else {
                c3099phA03 = C3099ph.A03(this.A00);
                this.A06.put(c3111pu.A02, c3099phA03);
            }
        }
        C3099ph viewProperties = (C3099ph) Preconditions.checkNotNull(c3099phA03);
        viewProperties.A02.set(rect2);
        c3099phA03.A03.add(new Rect(rect));
        return c3099phA03;
    }

    private void A04(C3100pi c3100pi) {
        for (C3111pu c3111pu : c3100pi.A01()) {
            C3099ph c3099ph = this.A06.get(c3111pu.A02);
            if (c3099ph == null) {
                if (0 != 0) {
                    String str = A02(150, 36, 26) + c3111pu.A02;
                    throw new NullPointerException(A02(186, 10, 36));
                }
            } else {
                c3099ph.A01 = EnumC3103pl.A03;
                c3099ph.A03.clear();
                if (A07(c3111pu)) {
                    c3111pu.A03(this);
                }
                if (this.A08) {
                    this.A06.remove(c3099ph);
                }
            }
        }
    }

    private void A05(C3100pi c3100pi) {
        for (C3111pu visible : c3100pi.A00()) {
            if (A07(visible)) {
                visible.A03(this);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.pu != com.instagram.common.viewpoint.core.ViewpointData<?, ?> */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0004 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A06(java.util.List<com.facebook.ads.redexgen.core.C3111pu<?, ?>> r7) {
        /*
            r6 = this;
            java.util.Iterator r5 = r7.iterator()
        L4:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L6f
            java.lang.Object r3 = r5.next()
            com.facebook.ads.redexgen.X.pu r3 = (com.facebook.ads.redexgen.core.C3111pu) r3
            java.util.Map<java.lang.String, com.facebook.ads.redexgen.X.ph> r1 = r6.A06
            java.lang.String r0 = r3.A02
            java.lang.Object r0 = r1.get(r0)
            com.facebook.ads.redexgen.X.ph r0 = (com.facebook.ads.redexgen.core.C3099ph) r0
            if (r0 == 0) goto L4
            boolean r4 = r3.A04
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C1H.A0A
            r0 = 0
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 2
            if (r1 == r0) goto L30
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L30:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1H.A0A
            java.lang.String r1 = "nPwsVC"
            r0 = 7
            r2[r0] = r1
            if (r4 == 0) goto L4
            com.facebook.ads.redexgen.X.pl r4 = r3.A01
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1H.A0A
            r0 = 5
            r1 = r2[r0]
            r0 = 6
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L60
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1H.A0A
            java.lang.String r1 = "zj"
            r0 = 0
            r2[r0] = r1
            if (r4 == 0) goto L4
        L56:
            com.facebook.ads.redexgen.X.pl r1 = r3.A01
            com.facebook.ads.redexgen.X.pl r0 = com.facebook.ads.redexgen.core.EnumC3103pl.A03
            if (r1 == r0) goto L4
            r3.A03(r6)
            goto L4
        L60:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1H.A0A
            java.lang.String r1 = "4Gl"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "t26"
            r0 = 2
            r2[r0] = r1
            if (r4 == 0) goto L4
            goto L56
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1H.A06(java.util.List):void");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.pu != com.instagram.common.viewpoint.core.ViewpointData<?, ?> */
    public static boolean A07(C3111pu<?, ?> c3111pu) {
        if (c3111pu.A04) {
            EnumC3112pv enumC3112pv = c3111pu.A00;
            EnumC3112pv enumC3112pv2 = EnumC3112pv.A04;
            String[] strArr = A0A;
            if (strArr[5].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            A0A[7] = "iICfc1p4CYNR1vFaz";
            if (enumC3112pv == enumC3112pv2) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a1  */
    @Override // com.facebook.ads.redexgen.core.A6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A3y(com.facebook.ads.redexgen.core.C3111pu r8, android.graphics.Rect r9, android.graphics.Rect r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1H.A3y(com.facebook.ads.redexgen.X.pu, android.graphics.Rect, android.graphics.Rect, boolean):void");
    }

    @Override // com.facebook.ads.redexgen.core.A6
    public final void A4Z(long j10, List<Rect> list) {
        this.A00 = j10;
        this.A05.clear();
        Iterator<Rect> it = list.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            String[] strArr = A0A;
            if (strArr[3].charAt(2) == strArr[1].charAt(2)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[4] = "xWg";
            strArr2[2] = "l5f";
            if (zHasNext) {
                this.A05.add(new Rect(it.next()));
            } else {
                Iterator it2 = this.A04.A01().iterator();
                while (true) {
                    boolean zHasNext2 = it2.hasNext();
                    if (A0A[0].length() == 2) {
                        String[] strArr3 = A0A;
                        strArr3[3] = "KXc0LwnJCEJYYpq44EYPYXvj71LHxLBt";
                        strArr3[1] = "SZ9db6jeJg1WeryC8zmRUBHGUrGxU8hd";
                        if (!zHasNext2) {
                            break;
                        }
                        this.A06.remove(((C3111pu) it2.next()).A02);
                    } else {
                        if (!zHasNext2) {
                            break;
                        }
                        this.A06.remove(((C3111pu) it2.next()).A02);
                    }
                }
                Collection<C3111pu> collectionA01 = this.A03.A01();
                if (A0A[0].length() != 2) {
                    throw new RuntimeException();
                }
                A0A[0] = "Au";
                for (C3111pu viewpointData : collectionA01) {
                    this.A06.remove(viewpointData.A02);
                }
                Iterator<C3099ph> it3 = this.A06.values().iterator();
                while (it3.hasNext()) {
                    it3.next().A03.clear();
                }
                this.A04.A04();
                this.A03.A04();
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC3102pk
    public final void A85(C3111pu c3111pu, Rect rect) {
        rect.setEmpty();
        Iterator it = ((C3099ph) Preconditions.checkNotNull(this.A06.get(c3111pu.A02))).A03.iterator();
        while (it.hasNext()) {
            rect.union((Rect) it.next());
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC3102pk
    public final EnumC3103pl A9M(C3111pu c3111pu) {
        EnumC3103pl enumC3103pl = ((C3099ph) Preconditions.checkNotNull(this.A06.get(c3111pu.A02))).A01;
        if (c3111pu.A04) {
            if (c3111pu.A00 == EnumC3112pv.A04) {
                EnumC3103pl viewState = EnumC3103pl.A03;
                return viewState;
            }
            EnumC3103pl viewState2 = EnumC3103pl.A04;
            if (enumC3103pl == viewState2 && !c3111pu.A04()) {
                EnumC3103pl viewState3 = EnumC3103pl.A02;
                return viewState3;
            }
        }
        return enumC3103pl;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC3102pk
    public final void A9O(Rect rect) {
        rect.setEmpty();
        Iterator<Rect> it = this.A05.iterator();
        while (it.hasNext()) {
            rect.union(it.next());
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC3102pk
    public final float A9P(C3111pu c3111pu) {
        C3099ph c3099ph = this.A06.get(c3111pu.A02);
        if (c3099ph != null) {
            Rect rectA00 = A00(c3099ph);
            int iHeight = rectA00.height() * rectA00.width();
            int totalVisibleArea = 0;
            for (Rect rect : c3099ph.A03) {
                totalVisibleArea += rect.height() * rect.width();
            }
            return totalVisibleArea / iHeight;
        }
        return 0.0f;
    }

    @Override // com.facebook.ads.redexgen.core.A6
    public final void AJA(InterfaceC3108pr interfaceC3108pr) {
        this.A01 = interfaceC3108pr;
    }
}
