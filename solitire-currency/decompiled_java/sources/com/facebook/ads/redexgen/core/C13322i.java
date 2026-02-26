package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2i, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C13322i extends IOException {
    public int A00;
    public boolean A01;

    @Deprecated
    public C13322i() {
    }

    @Deprecated
    public C13322i(String str) {
        super(str);
    }

    public C13322i(String str, Throwable th, boolean z10, int i10) {
        super(str, th);
        this.A01 = z10;
        this.A00 = i10;
    }

    public static C13322i A00(String str) {
        return new C13322i(str, null, false, 1);
    }

    public static C13322i A01(String str, Throwable th) {
        return new C13322i(str, th, true, 1);
    }

    public static C13322i A02(String str, Throwable th) {
        return new C13322i(str, th, true, 0);
    }
}
