package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2336cV {
    public String A02;
    public String A03;
    public String A04;
    public final C1848Mw A06;
    public final N9 A07;
    public final C2387dL A08;
    public C1850My A01 = C1850My.A01(null);
    public int A00 = 1000;
    public boolean A05 = false;

    public C2336cV(C2387dL c2387dL, C1848Mw c1848Mw, N9 n92) {
        this.A08 = c2387dL;
        this.A06 = c1848Mw;
        this.A07 = n92;
    }

    public final C2336cV A09(int i10) {
        this.A00 = i10;
        return this;
    }

    public final C2336cV A0A(C1850My c1850My) {
        this.A01 = c1850My;
        return this;
    }

    public final C2336cV A0B(String str) {
        this.A04 = str;
        return this;
    }

    public final C2336cV A0C(String str) {
        this.A02 = str;
        return this;
    }

    public final C2336cV A0D(String str) {
        this.A03 = str;
        return this;
    }

    public final C2336cV A0E(boolean z10) {
        this.A05 = z10;
        return this;
    }

    public final C2338cX A0F() {
        return new C2338cX(this, null);
    }
}
