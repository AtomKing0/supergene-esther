package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.ColorInfo;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1y, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13241y {
    public int A00;
    public int A01;
    public int A02;
    public byte[] A03;

    public C13241y() {
        this.A01 = -1;
        this.A00 = -1;
        this.A02 = -1;
    }

    public C13241y(ColorInfo colorInfo) {
        this.A01 = colorInfo.A02;
        this.A00 = colorInfo.A01;
        this.A02 = colorInfo.A03;
        this.A03 = colorInfo.A04;
    }

    public final C13241y A00(int i10) {
        this.A00 = i10;
        return this;
    }

    public final C13241y A01(int i10) {
        this.A01 = i10;
        return this;
    }

    public final C13241y A02(int i10) {
        this.A02 = i10;
        return this;
    }

    public final ColorInfo A03() {
        return new ColorInfo(this.A01, this.A00, this.A02, this.A03);
    }
}
