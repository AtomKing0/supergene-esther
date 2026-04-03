package com.facebook.ads.redexgen.core;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Il, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1734Il implements InterfaceC2171Zo {
    public final WeakReference<C5Q> A00;

    public C1734Il(C5Q c5q) {
        this.A00 = new WeakReference<>(c5q);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2171Zo
    public final void ADT(C2170Zn c2170Zn) {
        C5Q c5q = this.A00.get();
        if (c5q != null) {
            c5q.A06 = c2170Zn.A00() != null;
            c5q.A02();
        }
    }
}
