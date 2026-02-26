package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Im, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1735Im {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final C3064or A07;
    public final long[] A08;
    public final long[] A09;
    public final C1736In[] A0A;

    public C1735Im(int i10, int i11, long j10, long j11, long j12, C3064or c3064or, int i12, C1736In[] c1736InArr, int i13, long[] jArr, long[] jArr2) {
        this.A00 = i10;
        this.A03 = i11;
        this.A06 = j10;
        this.A05 = j11;
        this.A04 = j12;
        this.A07 = c3064or;
        this.A02 = i12;
        this.A0A = c1736InArr;
        this.A01 = i13;
        this.A08 = jArr;
        this.A09 = jArr2;
    }

    public final C1736In A00(int i10) {
        if (this.A0A == null) {
            return null;
        }
        return this.A0A[i10];
    }
}
