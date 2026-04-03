package com.facebook.ads.redexgen.core;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class GQ {
    public static byte[] A04;
    public static String[] A05 = {"uP2VmRjmPrkQ", "gRGWgf4lLYF9Rif8PQPDNbGokb9BUMtV", "bSjOyzwe8Lqn79dPeHIi8kfJVgfNJaEZ", "7R1XMZQjg8S2TiXm1wE8kLqT1leJFKD3", "sD", "qKJRf3b", "Q40N8hoONMcQBFaHNU", "iAP6W7CwppN1UlUQVXHbR"};
    public GK A00;
    public final int A01;
    public final C2860lV A02;
    public final GP A03;

    public static String A02(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] ^ i12) ^ 35);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{7, 32, 56, 47, 34, 39, 42, 110, 45, 47, 61, 43};
    }

    static {
        A03();
    }

    public GQ(GL gl, GP gp, long j10, long j11, long j12, long j13, long j14, long j15, int i10) {
        this.A03 = gp;
        this.A01 = i10;
        this.A02 = new C2860lV(gl, j10, j11, j12, j13, j14, j15);
    }

    private final int A00(InterfaceC2853lN interfaceC2853lN, long j10, C1691Gt c1691Gt) {
        if (j10 != interfaceC2853lN.A8f()) {
            c1691Gt.A00 = j10;
            return 1;
        }
        if (A05[5].length() != 7) {
            throw new RuntimeException();
        }
        A05[4] = "eb0wJDSKJb6zWnRAqReB9UTGfXv";
        return 0;
    }

    private final GK A01(long j10) {
        return new GK(j10, this.A02.A05(j10), this.A02.A05, this.A02.A02, this.A02.A04, this.A02.A01, this.A02.A00);
    }

    private final void A04(boolean z10, long j10) {
        this.A00 = null;
        this.A03.AFA();
    }

    private final boolean A05(InterfaceC2853lN interfaceC2853lN, long j10) throws IOException {
        long jA8f = j10 - interfaceC2853lN.A8f();
        if (jA8f >= 0 && jA8f <= 262144) {
            interfaceC2853lN.AJJ((int) jA8f);
            return true;
        }
        return false;
    }

    public final int A06(InterfaceC2853lN interfaceC2853lN, C1691Gt c1691Gt) throws IOException {
        while (true) {
            GK gk = (GK) C3M.A02(this.A00);
            long jA01 = gk.A01();
            long jA00 = gk.A00();
            long jA02 = gk.A02();
            if (jA00 - jA01 <= this.A01) {
                A04(false, jA01);
                String[] strArr = A05;
                if (strArr[3].charAt(1) != strArr[1].charAt(1)) {
                    throw new RuntimeException();
                }
                A05[5] = "cjf3Phs";
                return A00(interfaceC2853lN, jA01, c1691Gt);
            }
            if (!A05(interfaceC2853lN, jA02)) {
                return A00(interfaceC2853lN, jA02, c1691Gt);
            }
            interfaceC2853lN.AI1();
            GN gnAIC = this.A03.AIC(interfaceC2853lN, gk.A04());
            switch (gnAIC.A00) {
                case -3:
                    A04(false, jA02);
                    return A00(interfaceC2853lN, jA02, c1691Gt);
                case -2:
                    gk.A0D(gnAIC.A02, gnAIC.A01);
                    break;
                case -1:
                    gk.A0C(gnAIC.A02, gnAIC.A01);
                    break;
                case 0:
                    A05(interfaceC2853lN, gnAIC.A01);
                    long floorPosition = gnAIC.A01;
                    A04(true, floorPosition);
                    return A00(interfaceC2853lN, gnAIC.A01, c1691Gt);
                default:
                    throw new IllegalStateException(A02(0, 12, 109));
            }
        }
    }

    public final C2860lV A07() {
        return this.A02;
    }

    public final void A08(long j10) {
        if (this.A00 != null && this.A00.A03() == j10) {
            return;
        }
        this.A00 = A01(j10);
    }

    public final boolean A09() {
        return this.A00 != null;
    }
}
