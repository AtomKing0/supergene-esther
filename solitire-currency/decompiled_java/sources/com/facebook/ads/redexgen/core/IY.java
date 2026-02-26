package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.DrmInitData;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class IY {
    public static String[] A0C = {"uuzqWXLhVU5h", "MCiAyNDofRMgV8twnC7AiCrYM6kNh0jg", "HJXujHHcElJRTDtcfeo3Sy7Hv18RGZgy", "Amjr7hMXQx0e32VF8yWASHBDx37PervK", "NgKcffCH0RNam7yPBBIvJezNpINfNkiL", "oMs9elp", "apSAFH841DSL3paVepKSIoWcAWyBkdVZ", "h51QMR"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public IP A04;
    public C1738Ip A05;
    public boolean A06;
    public final H1 A08;
    public final C1737Io A09 = new C1737Io();
    public final C4J A07 = new C4J();
    public final C4J A0B = new C4J(1);
    public final C4J A0A = new C4J();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 15
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final int A04(int i10, int i11) {
        C4J c4j;
        int length;
        C1736In c1736InA07 = A07();
        if (c1736InA07 == null) {
            return 0;
        }
        if (c1736InA07.A00 != 0) {
            c4j = this.A09.A0H;
            length = c1736InA07.A00;
        } else {
            byte[] bArr = (byte[]) AbstractC13764a.A0f(c1736InA07.A04);
            this.A0A.A0j(bArr, bArr.length);
            c4j = this.A0A;
            length = bArr.length;
        }
        boolean zA06 = this.A09.A06(this.A01);
        boolean z10 = zA06 || i11 != 0;
        this.A0B.A0l()[0] = (byte) ((z10 ? 128 : 0) | length);
        this.A0B.A0f(0);
        this.A08.AI8(this.A0B, 1, 1);
        this.A08.AI8(c4j, length, 1);
        if (!z10) {
            return length + 1;
        }
        if (!zA06) {
            this.A07.A0d(8);
            byte[] bArrA0l = this.A07.A0l();
            bArrA0l[0] = 0;
            bArrA0l[1] = 1;
            bArrA0l[2] = (byte) ((i11 >> 8) & 255);
            bArrA0l[3] = (byte) (i11 & 255);
            bArrA0l[4] = (byte) ((i10 >> 24) & 255);
            bArrA0l[5] = (byte) ((i10 >> 16) & 255);
            bArrA0l[6] = (byte) ((i10 >> 8) & 255);
            bArrA0l[7] = (byte) (i10 & 255);
            this.A08.AI8(this.A07, 8, 1);
            return length + 1 + 8;
        }
        C4J c4j2 = this.A09.A0H;
        int iA0M = c4j2.A0M();
        c4j2.A0g(-2);
        int i12 = (iA0M * 6) + 2;
        if (i11 != 0) {
            this.A07.A0d(i12);
            byte[] bArrA0l2 = this.A07.A0l();
            c4j2.A0k(bArrA0l2, 0, i12);
            int i13 = (((bArrA0l2[2] & 255) << 8) | (bArrA0l2[3] & 255)) + i11;
            bArrA0l2[2] = (byte) ((i13 >> 8) & 255);
            bArrA0l2[3] = (byte) (i13 & 255);
            c4j2 = this.A07;
        }
        this.A08.AI8(c4j2, i12, 1);
        return length + 1 + i12;
    }

    public IY(H1 h12, C1738Ip c1738Ip, IP ip) {
        this.A08 = h12;
        this.A05 = c1738Ip;
        this.A04 = ip;
        A0C(c1738Ip, ip);
    }

    public final int A02() {
        int i10;
        if (!this.A06) {
            i10 = this.A05.A04[this.A01];
        } else {
            boolean[] zArr = this.A09.A0G;
            int flags = this.A01;
            i10 = zArr[flags] ? 1 : 0;
        }
        if (A07() == null) {
            return i10;
        }
        String[] strArr = A0C;
        String str = strArr[3];
        String str2 = strArr[2];
        int iCharAt = str.charAt(20);
        int flags2 = str2.charAt(20);
        if (iCharAt != flags2) {
            throw new RuntimeException();
        }
        A0C[4] = "Hkeae3ogmEOju43arfP4ZrrsYFDfrpvf";
        return i10 | 1073741824;
    }

    public final int A03() {
        if (!this.A06) {
            return this.A05.A05[this.A01];
        }
        return this.A09.A0B[this.A01];
    }

    public final long A05() {
        if (!this.A06) {
            return this.A05.A06[this.A01];
        }
        return this.A09.A0E[this.A02];
    }

    public final long A06() {
        if (!this.A06) {
            return this.A05.A07[this.A01];
        }
        return this.A09.A00(this.A01);
    }

    public final C1736In A07() {
        C1736In c1736InA00;
        if (!this.A06) {
            return null;
        }
        int i10 = ((IP) AbstractC13764a.A0f(this.A09.A06)).A02;
        if (this.A09.A07 != null) {
            c1736InA00 = this.A09.A07;
        } else {
            c1736InA00 = this.A05.A03.A00(i10);
        }
        if (c1736InA00 == null || !c1736InA00.A03) {
            return null;
        }
        C1736In encryptionBox = c1736InA00;
        return encryptionBox;
    }

    public final void A08() {
        this.A09.A01();
        this.A01 = 0;
        this.A02 = 0;
        this.A00 = 0;
        this.A03 = 0;
        this.A06 = false;
    }

    public final void A09() {
        C1736In c1736InA07 = A07();
        if (c1736InA07 == null) {
            return;
        }
        C4J c4j = this.A09.A0H;
        if (c1736InA07.A00 != 0) {
            c4j.A0g(c1736InA07.A00);
        }
        if (this.A09.A06(this.A01)) {
            c4j.A0g(c4j.A0M() * 6);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0006 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A0A(long r5) {
        /*
            r4 = this;
            int r3 = r4.A01
        L2:
            com.facebook.ads.redexgen.X.Io r0 = r4.A09
            int r0 = r0.A00
            if (r3 >= r0) goto L1f
            com.facebook.ads.redexgen.X.Io r0 = r4.A09
            long r1 = r0.A00(r3)
            int r0 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r0 > 0) goto L1f
            com.facebook.ads.redexgen.X.Io r0 = r4.A09
            boolean[] r0 = r0.A0G
            boolean r0 = r0[r3]
            if (r0 == 0) goto L1c
            r4.A03 = r3
        L1c:
            int r3 = r3 + 1
            goto L2
        L1f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.IY.A0A(long):void");
    }

    public final void A0B(DrmInitData drmInitData) {
        C1736In encryptionBox = this.A05.A03.A00(((IP) AbstractC13764a.A0f(this.A09.A06)).A02);
        this.A08.A6W(this.A05.A03.A07.A07().A0u(drmInitData.A01(encryptionBox != null ? encryptionBox.A02 : null)).A14());
    }

    public final void A0C(C1738Ip c1738Ip, IP ip) {
        this.A05 = c1738Ip;
        this.A04 = ip;
        this.A08.A6W(c1738Ip.A03.A07);
        A08();
    }

    public final boolean A0D() {
        this.A01++;
        if (!this.A06) {
            return false;
        }
        this.A00++;
        if (this.A00 != this.A09.A0C[this.A02]) {
            return true;
        }
        this.A02++;
        this.A00 = 0;
        return false;
    }
}
