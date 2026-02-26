package com.facebook.ads.redexgen.core;

import android.content.Context;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2098Wt implements SS {
    public static C2098Wt A07;
    public static byte[] A08;
    public LL A00;
    public SJ A01;
    public SR A02;
    public InterfaceC1986Sh A03;
    public TP A04;
    public InterfaceC2034Ue A05;
    public InterfaceC1557Bn A06;

    static {
        A07();
    }

    public static String A06(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 118);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A08 = new byte[]{15, 13, 13, 18, 13, 17, 14, 58, 13, 31, 45, 45, 35, 41, 40, -38, 30, 27, 46, 27, -38, 35, 40, 35, 46, 35, 27, 38, 35, 52, 31, 30, 28, 15, 26, 25, 28, 30, -3, 15, 29, 29, 19, 25, 24, -18, 11, 30, 11, -13, 24, 19, 30, 19, 11, 22, 19, 36, 15, 14};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized void A0C(C2361cu c2361cu) {
        if (this.A06 != null) {
            return;
        }
        this.A03 = A01(c2361cu);
        this.A06 = A05(c2361cu, this.A03, A03(c2361cu));
        A09(c2361cu, A00(c2361cu, this.A06));
        A0A(c2361cu, this.A06);
        A0B(c2361cu, this.A06);
        if (this.A06 != null) {
            this.A06.A6V();
        }
    }

    public static InterfaceC1963Rj A00(C2361cu c2361cu, InterfaceC1557Bn interfaceC1557Bn) {
        if (!U7.A1m(c2361cu) || interfaceC1557Bn == null) {
            return null;
        }
        return AbstractC1964Rk.A00().A00(interfaceC1557Bn);
    }

    public static InterfaceC1986Sh A01(C2361cu c2361cu) {
        return AbstractC1987Si.A00().A00(c2361cu, new YJ());
    }

    public static synchronized C2098Wt A02() {
        if (A07 == null) {
            A07 = new C2098Wt();
        }
        return A07;
    }

    public static InterfaceC2466ed A03(C2361cu c2361cu) {
        if (!U7.A1i(c2361cu)) {
            return null;
        }
        return C2484ev.A01(c2361cu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.SS
    /* JADX INFO: renamed from: A04, reason: merged with bridge method [inline-methods] */
    public final synchronized InterfaceC1557Bn A97() {
        return this.A06;
    }

    public static InterfaceC1557Bn A05(C2361cu c2361cu, InterfaceC1986Sh interfaceC1986Sh, InterfaceC2466ed interfaceC2466ed) {
        if (!U7.A2e(c2361cu) || interfaceC2466ed == null || ProcessUtils.isRemoteRenderingProcess()) {
            return null;
        }
        return AbstractC2506fI.A00().A00(c2361cu, interfaceC1986Sh, interfaceC2466ed, VZ.A04(c2361cu), new X8(new VR(c2361cu, A06(0, 0, 9), null, V6.A08, 0, new VB(), X7.A01(U7.A0N(c2361cu)), null, null, new C2619hB()), c2361cu), C2504fG.A00().A00());
    }

    public static void A08() {
        VF.A05(A06(32, 28, 52), A06(8, 24, 68), A06(0, 8, 99));
    }

    public static void A09(C2361cu c2361cu, InterfaceC1963Rj interfaceC1963Rj) {
        if (!U7.A1m(c2361cu) || interfaceC1963Rj == null) {
            return;
        }
        AbstractC1961Rh.A00().A00(interfaceC1963Rj, c2361cu);
    }

    public static void A0A(C2361cu c2361cu, InterfaceC1557Bn interfaceC1557Bn) {
        if (!U7.A0m(c2361cu) || interfaceC1557Bn == null) {
            return;
        }
        new S4(c2361cu, interfaceC1557Bn, new S5(), DynamicLoaderImpl.getBidderTokenProviderApi().A00());
    }

    public static void A0B(C2361cu c2361cu, InterfaceC1557Bn interfaceC1557Bn) {
        if (interfaceC1557Bn == null) {
            return;
        }
        UB.A00(c2361cu, interfaceC1557Bn);
    }

    @Override // com.facebook.ads.redexgen.core.SS
    public final US A6f(C2361cu c2361cu) {
        return VG.A01(c2361cu);
    }

    @Override // com.facebook.ads.redexgen.core.SS
    public final synchronized SR A6w(SQ sq) {
        if (this.A02 == null) {
            this.A02 = new XI(this);
        }
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.core.SS
    public final synchronized SJ A78() {
        if (this.A01 == null) {
            this.A01 = new C2410di();
        }
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.SS
    public final synchronized InterfaceC1986Sh A7d(SQ sq) {
        if (this.A03 == null) {
            this.A03 = A01(sq.A02());
        }
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.core.SS
    public final synchronized InterfaceC1999Su A7f(SQ sq) {
        return new C2160Zd(sq);
    }

    @Override // com.facebook.ads.redexgen.core.SS
    public final synchronized ST A7p(final SQ sq) {
        return new YI(sq) { // from class: com.facebook.ads.redexgen.X.6K
            @Override // com.facebook.ads.redexgen.core.ST
            public final boolean A9e() {
                return CM.A09();
            }

            @Override // com.facebook.ads.redexgen.core.ST
            public final void ABq() {
                TK.A06(RB.A09(super.A00));
            }

            @Override // com.facebook.ads.redexgen.core.ST
            public final void ACE() {
                TK.A07(RB.A09(super.A00));
            }

            @Override // com.facebook.ads.redexgen.core.ST
            public final void ACe(C2361cu c2361cu) {
                AbstractC1863Nl.A01(c2361cu);
            }
        };
    }

    @Override // com.facebook.ads.redexgen.core.SS
    public final synchronized LL A84(SQ sq) {
        if (!U7.A13(sq)) {
            return null;
        }
        if (this.A00 == null) {
            this.A00 = LM.A00().A00(new YH(sq));
        }
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.SS
    public final synchronized SV A8q(SQ sq) {
        return new XN(sq);
    }

    @Override // com.facebook.ads.redexgen.core.SS
    public final C2361cu A8r(Context context) {
        C2361cu sdkContext = SP.A00();
        if (sdkContext == null) {
            C2361cu sdkContext2 = new C2361cu(context, this);
            SP.A01(sdkContext2);
            return sdkContext2;
        }
        return sdkContext;
    }

    @Override // com.facebook.ads.redexgen.core.SS
    public final synchronized InterfaceC2034Ue A8s(C2361cu c2361cu) {
        if (this.A05 == null) {
            this.A05 = new VO(c2361cu);
        }
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.core.SS
    public final synchronized TP A8y() {
        if (this.A04 == null) {
            this.A04 = new TP();
            A08();
        }
        return this.A04;
    }
}
