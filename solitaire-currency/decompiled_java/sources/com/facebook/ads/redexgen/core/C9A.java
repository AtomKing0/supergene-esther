package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.os.Handler;
import androidx.media3.common.C;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9A, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C9A implements InterfaceC2912mM, GY, InterfaceC1626Eg<C2910mK>, InterfaceC1630Ek, InterfaceC1581Cn {
    public static byte[] A0e;
    public static String[] A0f = {"o2fAJH6DTExx5HfWJCXs", "", "TsjJo55j6Kq128TfeQrvBtnORCvXohBg", "QpymssT", "p1Azi7mByqrjPk9ZTQVOCdIp8WANOiZ", "P8K3es9juVbjT7QsA9zjw4fZ7CWDxkC3", "f2TCNbDOQ", "8xae32DDfRwM"};
    public static final C3064or A0g;
    public static final Map<String, String> A0h;
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public long A05;
    public InterfaceC2913mN A06;
    public C1576Ci A07;
    public InterfaceC1694Gw A08;
    public IcyHeaders A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public boolean A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public C1575Ch[] A0K;
    public C2904mE[] A0L;
    public final long A0M;
    public final Uri A0N;
    public final Handler A0O;
    public final C3W A0P;
    public final InterfaceC2999nl A0Q;
    public final C9P A0R;
    public final C9U A0S;
    public final CW A0T;
    public final InterfaceC1569Cb A0U;
    public final InterfaceC1574Cg A0V;
    public final EO A0W;
    public final InterfaceC1623Ed A0X;
    public final C2867lc A0Y;
    public final Runnable A0Z;
    public final Runnable A0a;
    public final String A0b;
    public final boolean A0c;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"})
    public final boolean A0d;

    public static String A0B(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0e, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 68);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0I() {
        A0e = new byte[]{-76, -81, -55, -33, -109, -77, -53, -38, -57, -86, -57, -38, -57, -29, 6, -8, -5, -4, 9, -47, -25, 9, 6, -2, 9, -4, 10, 10, 0, 13, -4, -28, -4, -5, 0, -8, -25, -4, 9, 0, 6, -5, -62, -27, -41, -38, -33, -28, -35, -106, -36, -33, -28, -33, -23, -34, -37, -38, -106, -40, -37, -36, -27, -24, -37, -106, -26, -24, -37, -26, -41, -24, -41, -22, -33, -27, -28, -106, -33, -23, -106, -39, -27, -29, -26, -30, -37, -22, -37, -92, -49, -14, -28, -25, -20, -15, -22, -93, -23, -20, -15, -20, -10, -21, -24, -25, -93, -27, -24, -23, -14, -11, -24, -93, -13, -11, -24, -13, -28, -11, -28, -9, -20, -14, -15, -93, -20, -10, -93, -26, -14, -16, -13, -17, -24, -9, -24, -79, -93, -40, -43, -52, -67, -93, -12, 3, 3, -1, -4, -10, -12, 7, -4, 2, 1, -62, 11, -64, -4, -10, 12, -6, -12, 10, 47, 54, 45, 45};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2912mM
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long AIP(com.facebook.ads.redexgen.core.InterfaceC2874lj[] r15, boolean[] r16, com.facebook.ads.redexgen.core.InterfaceC1585Cr[] r17, boolean[] r18, long r19) {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C9A.AIP(com.facebook.ads.redexgen.X.lj[], boolean[], com.facebook.ads.redexgen.X.Cr[], boolean[], long):long");
    }

    static {
        A0I();
        A0h = A0D();
        A0g = new C2D().A0y(A0B(161, 3, 77)).A11(A0B(144, 17, 79)).A14();
    }

    public C9A(Uri uri, InterfaceC2999nl interfaceC2999nl, InterfaceC1569Cb interfaceC1569Cb, C9U c9u, C9P c9p, InterfaceC1623Ed interfaceC1623Ed, CW cw, InterfaceC1574Cg interfaceC1574Cg, EO eo, String str, int i10, InterfaceExecutorC1645Ez interfaceExecutorC1645Ez) {
        C2867lc c2867lc;
        this.A0N = uri;
        this.A0Q = interfaceC2999nl;
        this.A0S = c9u;
        this.A0R = c9p;
        this.A0X = interfaceC1623Ed;
        this.A0T = cw;
        this.A0V = interfaceC1574Cg;
        this.A0W = eo;
        this.A0b = str;
        this.A0M = i10;
        if (interfaceExecutorC1645Ez != null) {
            c2867lc = new C2867lc(interfaceExecutorC1645Ez);
        } else {
            c2867lc = new C2867lc(A0B(13, 29, 83));
        }
        this.A0Y = c2867lc;
        this.A0U = interfaceC1569Cb;
        this.A0P = new C3W();
        this.A0Z = new Runnable() { // from class: com.facebook.ads.redexgen.X.Ce
            @Override // java.lang.Runnable
            public final void run() {
                this.A00.A0F();
            }
        };
        this.A0a = new Runnable() { // from class: com.facebook.ads.redexgen.X.Cf
            @Override // java.lang.Runnable
            public final void run() {
                this.A00.A0b();
            }
        };
        this.A0O = AbstractC13764a.A0Y();
        this.A0K = new C1575Ch[0];
        this.A0L = new C2904mE[0];
        this.A05 = C.TIME_UNSET;
        this.A03 = C.TIME_UNSET;
        this.A00 = 1;
        this.A0d = MetaExoPlayerUpgradeConfig.A03(EnumC2663i2.A0d) || MetaExoPlayerUpgradeConfig.A03(EnumC2663i2.A0e) || MetaExoPlayerUpgradeConfig.A03(EnumC2663i2.A1f);
        this.A0c = MetaExoPlayerUpgradeConfig.A03(EnumC2663i2.A0g);
    }

    private int A00() {
        int i10 = 0;
        for (C2904mE c2904mE : this.A0L) {
            int extractedSamplesCount = c2904mE.A0P();
            i10 += extractedSamplesCount;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long A03(boolean r8) {
        /*
            r7 = this;
            r1 = -9223372036854775808
            r5 = 0
        L3:
            com.facebook.ads.redexgen.X.mE[] r0 = r7.A0L
            int r0 = r0.length
            if (r5 >= r0) goto L4b
            if (r8 != 0) goto L36
            com.facebook.ads.redexgen.X.Ci r0 = r7.A07
            java.lang.Object r6 = com.facebook.ads.redexgen.core.C3M.A01(r0)
            java.lang.String[] r4 = com.facebook.ads.redexgen.core.C9A.A0f
            r0 = 6
            r3 = r4[r0]
            r0 = 7
            r0 = r4[r0]
            int r3 = r3.length()
            int r0 = r0.length()
            if (r3 == r0) goto L45
            java.lang.String[] r4 = com.facebook.ads.redexgen.core.C9A.A0f
            java.lang.String r3 = "FDopTuaFs"
            r0 = 6
            r4[r0] = r3
            java.lang.String r3 = "ze95XzERDUjm"
            r0 = 7
            r4[r0] = r3
            com.facebook.ads.redexgen.X.Ci r6 = (com.facebook.ads.redexgen.core.C1576Ci) r6
            boolean[] r0 = r6.A01
            boolean r0 = r0[r5]
            if (r0 == 0) goto L42
        L36:
            com.facebook.ads.redexgen.X.mE[] r0 = r7.A0L
            r0 = r0[r5]
            long r3 = r0.A0T()
            long r1 = java.lang.Math.max(r1, r3)
        L42:
            int r5 = r5 + 1
            goto L3
        L45:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L4b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C9A.A03(boolean):long");
    }

    private C2904mE A06(C1575Ch c1575Ch) {
        int length = this.A0L.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (c1575Ch.equals(this.A0K[i10])) {
                return this.A0L[i10];
            }
        }
        C2904mE c2904mEA0B = C2904mE.A0B(this.A0W, this.A0S, this.A0R);
        c2904mEA0B.A0d(this);
        int trackCount = length + 1;
        C1575Ch[] c1575ChArr = (C1575Ch[]) Arrays.copyOf(this.A0K, trackCount);
        c1575ChArr[length] = c1575Ch;
        this.A0K = (C1575Ch[]) AbstractC13764a.A1H(c1575ChArr);
        int trackCount2 = length + 1;
        C2904mE[] c2904mEArr = (C2904mE[]) Arrays.copyOf(this.A0L, trackCount2);
        c2904mEArr[length] = c2904mEA0B;
        this.A0L = (C2904mE[]) AbstractC13764a.A1H(c2904mEArr);
        return c2904mEA0B;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1626Eg
    /* JADX INFO: renamed from: A07, reason: merged with bridge method [inline-methods] */
    public final C1627Eh AE0(C2910mK c2910mK, long j10, long j11, IOException iOException, int i10) {
        C1627Eh c1627EhA01;
        C14949b c14949b = c2910mK.A08;
        CE ce = new CE(c2910mK.A05, c2910mK.A01, c14949b.A01(), c14949b.A02(), j10, j11, c14949b.A00());
        long jA8m = this.A0X.A8m(new C1622Ec(ce, new CG(1, -1, null, 0, null, AbstractC13764a.A0P(c2910mK.A00), AbstractC13764a.A0P(this.A03)), iOException, i10));
        if (jA8m == C.TIME_UNSET) {
            c1627EhA01 = C2867lc.A06;
        } else {
            int iA00 = A00();
            boolean z10 = iA00 > this.A02;
            if (A0U(c2910mK, iA00)) {
                c1627EhA01 = C2867lc.A01(z10, jA8m);
            } else {
                c1627EhA01 = C2867lc.A05;
            }
        }
        this.A0T.A07(ce, 1, -1, null, 0, null, c2910mK.A00, this.A03, iOException, !c1627EhA01.A02());
        return c1627EhA01;
    }

    public static Map<String, String> A0D() {
        HashMap map = new HashMap();
        map.put(A0B(1, 12, 34), A0B(0, 1, 63));
        Map<String, String> headers = Collections.unmodifiableMap(map);
        return headers;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    private void A0E() {
        C3M.A08(this.A0G);
        C3M.A01(this.A07);
        C3M.A01(this.A08);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0F() {
        Metadata metadataA05;
        if (this.A0H || this.A0G) {
            return;
        }
        boolean z10 = this.A0I;
        String[] strArr = A0f;
        if (strArr[1].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0f;
        strArr2[2] = "grMxxjGjFdBhxw9MDZtvFg4OZy35nlzN";
        strArr2[5] = "E38rNlujzeckGRbn7d7aukKxtTtuF9Uw";
        if (!z10 || this.A08 == null) {
            return;
        }
        for (C2904mE c2904mE : this.A0L) {
            if (c2904mE.A0U() == null) {
                return;
            }
        }
        this.A0P.A02();
        int length = this.A0L.length;
        C3030oH[] c3030oHArr = new C3030oH[length];
        boolean[] zArr = new boolean[length];
        for (int i10 = 0; i10 < length; i10++) {
            C3064or c3064orA14 = (C3064or) C3M.A01(this.A0L[i10].A0U());
            String str = c3064orA14.A0W;
            boolean zA0C = AbstractC13312h.A0C(str);
            boolean z11 = zA0C || AbstractC13312h.A0F(str);
            zArr[i10] = z11;
            this.A0A |= z11;
            IcyHeaders icyHeaders = this.A09;
            if (icyHeaders != null) {
                if (zA0C || this.A0K[i10].A01) {
                    Metadata metadata = c3064orA14.A0P;
                    if (metadata == null) {
                        metadataA05 = new Metadata(icyHeaders);
                    } else {
                        metadataA05 = metadata.A05(icyHeaders);
                    }
                    C2D c2dA0v = c3064orA14.A07().A0v(metadataA05);
                    if (A0f[0].length() != 20) {
                        throw new RuntimeException();
                    }
                    String[] strArr3 = A0f;
                    strArr3[2] = "WsODqr3j7Qd6qKAaI5Z8JETVOkriGcMH";
                    strArr3[5] = "rCf1buyjz0YjJBdswvkAeWhqIr4TjJn3";
                    c3064orA14 = c2dA0v.A14();
                }
                if (zA0C) {
                    int trackCount = c3064orA14.A04;
                    if (trackCount == -1) {
                        int trackCount2 = c3064orA14.A0D;
                        if (trackCount2 == -1) {
                            int trackCount3 = icyHeaders.A00;
                            if (trackCount3 != -1) {
                                C2D c2dA07 = c3064orA14.A07();
                                int trackCount4 = icyHeaders.A00;
                                c3064orA14 = c2dA07.A0a(trackCount4).A14();
                            }
                        }
                    }
                }
            }
            c3030oHArr[i10] = new C3030oH(c3064orA14);
        }
        this.A07 = new C1576Ci(new C2901mA(c3030oHArr), zArr);
        this.A0G = true;
        ((InterfaceC2913mN) C3M.A01(this.A06)).AEk(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0G() {
        this.A0O.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.Cd
            @Override // java.lang.Runnable
            public final void run() {
                this.A00.A0c();
            }
        });
    }

    private void A0H() {
        C2910mK c2910mK = new C2910mK(this, this.A0N, this.A0Q, this.A0U, this, this.A0P);
        if (this.A0G) {
            C3M.A08(A0S());
            if (this.A03 != C.TIME_UNSET && this.A05 >= this.A03) {
                this.A0D = true;
                this.A05 = C.TIME_UNSET;
                return;
            }
            c2910mK.A04(((InterfaceC1694Gw) C3M.A01(this.A08)).A8t(this.A05).A00.A00, this.A05);
            for (C2904mE c2904mE : this.A0L) {
                c2904mE.A0b(this.A05);
            }
            this.A05 = C.TIME_UNSET;
        }
        this.A02 = A00();
        this.A0T.A06(new CE(c2910mK.A05, c2910mK.A01, this.A0Y.A08(c2910mK, this, this.A0X.A8R(this.A00))), 1, -1, null, 0, null, c2910mK.A00, this.A03, 0);
    }

    private final void A0J() throws IOException {
        this.A0Y.A0B(this.A0X.A8R(this.A00));
    }

    private void A0K(int i10) {
        A0E();
        boolean[] zArr = this.A07.A03;
        if (!zArr[i10]) {
            C3064or c3064orA08 = this.A07.A00.A05(i10).A08(0);
            this.A0T.A03(AbstractC13312h.A01(c3064orA08.A0W), c3064orA08, 0, null, this.A04);
            zArr[i10] = true;
        }
    }

    private void A0L(int i10) {
        A0E();
        boolean[] zArr = this.A07.A02;
        if (this.A0F && zArr[i10]) {
            if (this.A0L[i10].A0g(false)) {
                return;
            }
            this.A05 = 0L;
            this.A0F = false;
            this.A0E = true;
            this.A04 = 0L;
            this.A02 = 0;
            for (C2904mE c2904mE : this.A0L) {
                c2904mE.A0Z();
            }
            ((InterfaceC2913mN) C3M.A01(this.A06)).ACs(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1626Eg
    /* JADX INFO: renamed from: A0M, reason: merged with bridge method [inline-methods] */
    public final void ADz(C2910mK c2910mK, long j10, long j11) {
        long largestQueuedTimestampUs;
        if (this.A03 == C.TIME_UNSET && this.A08 != null) {
            boolean zAAa = this.A08.AAa();
            long jA03 = A03(true);
            String[] strArr = A0f;
            if (strArr[1].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0f;
            strArr2[6] = "VBgm4XD5c";
            strArr2[7] = "eM9hzsMViOdm";
            if (jA03 == Long.MIN_VALUE) {
                largestQueuedTimestampUs = 0;
            } else {
                largestQueuedTimestampUs = 10000 + jA03;
            }
            this.A03 = largestQueuedTimestampUs;
            this.A0V.AFH(this.A03, zAAa, this.A0C);
        }
        C14949b c14949b = c2910mK.A08;
        this.A0T.A08(new CE(c2910mK.A05, c2910mK.A01, c14949b.A01(), c14949b.A02(), j10, j11, c14949b.A00()), 1, -1, null, 0, null, c2910mK.A00, this.A03, c2910mK, null);
        this.A0D = true;
        ((InterfaceC2913mN) C3M.A01(this.A06)).ACs(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1626Eg
    /* JADX INFO: renamed from: A0N, reason: merged with bridge method [inline-methods] */
    public final void AE3(C2910mK c2910mK, long j10, long j11, int i10) {
        CE ce;
        C14949b dataSource = c2910mK.A08;
        if (i10 == 0) {
            ce = new CE(c2910mK.A05, c2910mK.A01, j10);
        } else {
            ce = new CE(c2910mK.A05, c2910mK.A01, dataSource.A01(), dataSource.A02(), j10, j11, dataSource.A00());
        }
        this.A0T.A06(ce, 1, -1, null, 0, null, c2910mK.A00, this.A03, i10);
        String[] strArr = A0f;
        if (strArr[6].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0f;
        strArr2[6] = "RSQzFltms";
        strArr2[7] = "MablvJN0SXK9";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1626Eg
    /* JADX INFO: renamed from: A0O, reason: merged with bridge method [inline-methods] */
    public final void ADx(C2910mK c2910mK, long j10, long j11, boolean z10) {
        C14949b dataSource = c2910mK.A08;
        this.A0T.A05(new CE(c2910mK.A05, c2910mK.A01, dataSource.A01(), dataSource.A02(), j10, j11, dataSource.A00()), 1, -1, null, 0, null, c2910mK.A00, this.A03);
        if (!z10) {
            for (C2904mE c2904mE : this.A0L) {
                c2904mE.A0Z();
            }
            if (this.A01 > 0) {
                ((InterfaceC2913mN) C3M.A01(this.A06)).ACs(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: A0R, reason: merged with bridge method [inline-methods] */
    public void A0e(InterfaceC1694Gw interfaceC1694Gw) {
        this.A08 = interfaceC1694Gw;
        this.A03 = interfaceC1694Gw.A7l();
        this.A0C = !this.A0B && interfaceC1694Gw.A7l() == C.TIME_UNSET;
        this.A00 = this.A0C ? 7 : 1;
        this.A0V.AFH(this.A03, interfaceC1694Gw.AAa(), this.A0C);
        if (!this.A0G) {
            A0F();
        }
    }

    private boolean A0S() {
        return this.A05 != C.TIME_UNSET;
    }

    private boolean A0T() {
        return this.A0E || A0S();
    }

    private boolean A0U(C2910mK c2910mK, int i10) {
        if (this.A0B || (this.A08 != null && this.A08.A7l() != C.TIME_UNSET)) {
            this.A02 = i10;
            return true;
        }
        if (this.A0G && !A0T()) {
            this.A0F = true;
            return false;
        }
        this.A0E = this.A0G;
        this.A04 = 0L;
        this.A02 = 0;
        for (C2904mE c2904mE : this.A0L) {
            c2904mE.A0Z();
        }
        c2910mK.A04(0L, 0L);
        return true;
    }

    private boolean A0V(boolean[] zArr, long j10) {
        int length = this.A0L.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (!this.A0L[i10].A0f(j10, false) && (zArr[i10] || !this.A0A)) {
                return false;
            }
        }
        return true;
    }

    public final int A0X(int i10, long j10) {
        if (A0T()) {
            return 0;
        }
        A0K(i10);
        C2904mE c2904mE = this.A0L[i10];
        int iA0Q = c2904mE.A0Q(j10, this.A0D);
        c2904mE.A0a(iA0Q);
        if (iA0Q == 0) {
            A0L(i10);
        }
        return iA0Q;
    }

    public final int A0Y(int i10, C6N c6n, C2986nY c2986nY, int i11) {
        if (A0T()) {
            return -3;
        }
        A0K(i10);
        int result = this.A0L[i10].A0R(c6n, c2986nY, i11, this.A0D);
        if (result == -3) {
            A0L(i10);
        }
        return result;
    }

    public final H1 A0Z() {
        return A06(new C1575Ch(0, true));
    }

    public final void A0a() {
        if (this.A0G) {
            for (C2904mE c2904mE : this.A0L) {
                c2904mE.A0X();
            }
        }
        this.A0Y.A0C(this);
        this.A0O.removeCallbacksAndMessages(null);
        this.A06 = null;
        this.A0H = true;
    }

    public final /* synthetic */ void A0b() {
        if (!this.A0H) {
            ((InterfaceC2913mN) C3M.A01(this.A06)).ACs(this);
        }
    }

    public final /* synthetic */ void A0c() {
        this.A0B = true;
    }

    public final void A0d(int i10) throws IOException {
        this.A0L[i10].A0W();
        A0J();
    }

    public final boolean A0f(int i10) {
        return !A0T() && this.A0L[i10].A0g(this.A0D);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1589Cv
    @MetaExoPlayerCustomization("Added in D19760981 for cancel request")
    public final void A4k(long j10) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2912mM
    public final boolean A54(long j10) {
        if (this.A0D || this.A0Y.A0D() || this.A0F) {
            return false;
        }
        if (this.A0G && this.A01 == 0) {
            return false;
        }
        boolean zA04 = this.A0P.A04();
        boolean continuedLoading = this.A0Y.A0E();
        if (!continuedLoading) {
            A0H();
            return true;
        }
        return zA04;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2912mM
    public final void A5s(long j10, boolean z10) {
        A0E();
        if (A0S()) {
            return;
        }
        boolean[] zArr = this.A07.A01;
        int length = this.A0L.length;
        for (int i10 = 0; i10 < length; i10++) {
            C2904mE[] c2904mEArr = this.A0L;
            String[] strArr = A0f;
            String str = strArr[6];
            String str2 = strArr[7];
            int trackCount = str.length();
            if (trackCount == str2.length()) {
                throw new RuntimeException();
            }
            A0f[0] = "xFMIvf7swbs88yH1ASsn";
            c2904mEArr[i10].A0c(j10, z10, zArr[i10]);
        }
    }

    @Override // com.facebook.ads.redexgen.core.GY
    public final void A6G() {
        this.A0I = true;
        this.A0O.post(this.A0Z);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2912mM
    public final long A6j(long j10, C7I c7i) {
        A0E();
        if (!this.A08.AAa()) {
            return 0L;
        }
        C1693Gv c1693GvA8t = this.A08.A8t(j10);
        long j11 = c1693GvA8t.A00.A01;
        String[] strArr = A0f;
        if (strArr[6].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0f;
        strArr2[2] = "A6SKS5Ejxr3dBguC5asmpR7Eo1U8ekaX";
        strArr2[5] = "H67kjT3j1V6FB1MougrbLEHHMAKkStlF";
        return c7i.A00(j10, j11, c1693GvA8t.A01.A01);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1589Cv
    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "Added in D9949576 for unstall buffer")
    public final long A6y(long j10) {
        if (this.A0d && !this.A0G) {
            return 0L;
        }
        if (this.A0D) {
            return this.A03 - j10;
        }
        return A70() - j10;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0080  */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2912mM
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long A70() {
        /*
            Method dump skipped, instruction units count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C9A.A70():long");
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2912mM
    public final long A8T() {
        return A70();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2912mM
    public final C2901mA A9E() {
        A0E();
        return this.A07.A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2912mM
    public final void ABt() throws IOException {
        A0J();
        if (this.A0D && !this.A0G) {
            if (this.A0c) {
                throw C13322i.A01(A0B(90, 54, 63) + (this.A0N != null ? this.A0N.toString() : A0B(164, 4, 125)), null);
            }
            throw C13322i.A01(A0B(42, 48, 50), null);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1630Ek
    public final void AE4() {
        for (C2904mE c2904mE : this.A0L) {
            c2904mE.A0Y();
        }
        this.A0U.AGr();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1581Cn
    public final void AFb(C3064or c3064or) {
        this.A0O.post(this.A0Z);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2912mM
    public final void AGL(InterfaceC2913mN interfaceC2913mN, long j10) {
        this.A06 = interfaceC2913mN;
        this.A0P.A04();
        A0H();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2912mM
    public final long AGg() {
        if (!this.A0E) {
            return C.TIME_UNSET;
        }
        boolean z10 = this.A0D;
        if (A0f[0].length() == 20) {
            String[] strArr = A0f;
            strArr[1] = "";
            strArr[4] = "OLDtf0M6xpFiQAaUF2mFzXoKXa03XjZ";
            if (z10 || A00() > this.A02) {
                this.A0E = false;
                long j10 = this.A04;
                if (A0f[0].length() == 20) {
                    String[] strArr2 = A0f;
                    strArr2[6] = "30bUCuPdV";
                    strArr2[7] = "qvk1tPvPLdJz";
                    return j10;
                }
            } else {
                return C.TIME_UNSET;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2912mM
    public final void AGm(long j10) {
    }

    @Override // com.facebook.ads.redexgen.core.GY
    public final void AIN(final InterfaceC1694Gw interfaceC1694Gw) {
        this.A0O.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.Cc
            @Override // java.lang.Runnable
            public final void run() {
                this.A00.A0e(interfaceC1694Gw);
            }
        });
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2912mM
    public final long AIO(@MetaExoPlayerCustomization long j10, boolean z10) {
        A0E();
        boolean[] zArr = this.A07.A02;
        if (!this.A08.AAa()) {
            j10 = 0;
        }
        int i10 = 0;
        this.A0E = false;
        this.A04 = j10;
        if (A0S()) {
            this.A05 = j10;
            return j10;
        }
        if (this.A00 != 7 && A0V(zArr, j10)) {
            return j10;
        }
        this.A0F = false;
        this.A05 = j10;
        this.A0D = false;
        if (this.A0Y.A0E()) {
            C2904mE[] c2904mEArr = this.A0L;
            int length = c2904mEArr.length;
            while (i10 < length) {
                c2904mEArr[i10].A0V();
                String[] strArr = A0f;
                if (strArr[6].length() == strArr[7].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0f;
                strArr2[2] = "OrOS7Vhjp4VBbz175mMxq2SuFvjpl5bQ";
                strArr2[5] = "EAKZg7yj0ctHJiN4FHg90oFZJxg2ecfG";
                i10++;
            }
            this.A0Y.A09();
            return j10;
        }
        this.A0Y.A0A();
        C2904mE[] c2904mEArr2 = this.A0L;
        int length2 = c2904mEArr2.length;
        while (i10 < length2) {
            c2904mEArr2[i10].A0Z();
            String[] strArr3 = A0f;
            if (strArr3[2].charAt(7) != strArr3[5].charAt(7)) {
                throw new RuntimeException();
            }
            String[] strArr4 = A0f;
            strArr4[6] = "p5drqiHAR";
            strArr4[7] = "h8TdfbRbJweW";
            i10++;
        }
        return j10;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1589Cv
    @MetaExoPlayerCustomization("Added in D19875605 for error load during pause")
    public final void AIs(boolean z10) {
    }

    @Override // com.facebook.ads.redexgen.core.GY
    public final H1 AJh(int i10, int i11) {
        return A06(new C1575Ch(i10, false));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1589Cv
    @MetaExoPlayerCustomization("Added in D13267633 for lower priority during pause")
    public final void AJq(byte b10) {
    }
}
