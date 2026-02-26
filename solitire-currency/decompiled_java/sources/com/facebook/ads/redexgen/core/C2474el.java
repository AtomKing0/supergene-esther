package com.facebook.ads.redexgen.core;

import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.el, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2474el {
    public int A00;
    public int A01;
    public int A02;
    public InterfaceC2464eb A03;
    public Map<String, String> A04;
    public final int A05;
    public final int A06;

    public C2474el(int i10, int i11, int i12, int i13, int i14, Map<String, String> requestHeaders, InterfaceC2464eb interfaceC2464eb) {
        this.A06 = i10;
        this.A00 = i11;
        this.A02 = i12;
        this.A05 = i13;
        this.A01 = i14;
        this.A04 = requestHeaders;
        this.A03 = interfaceC2464eb;
    }

    public final int A00() {
        return this.A00;
    }

    public final int A01() {
        return this.A01;
    }

    public final int A02() {
        return this.A02;
    }

    public final int A03() {
        return this.A05;
    }

    public final int A04() {
        return this.A06;
    }

    public final InterfaceC2464eb A05() {
        return this.A03;
    }

    public final Map<String, String> A06() {
        return this.A04;
    }
}
