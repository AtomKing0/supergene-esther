package com.facebook.ads.redexgen.core;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class K0 implements InterfaceC2171Zo {
    public final WeakReference<C14095h> A00;

    public K0(C14095h c14095h) {
        this.A00 = new WeakReference<>(c14095h);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2171Zo
    public final void ADT(C2170Zn c2170Zn) {
        C14095h c14095h = this.A00.get();
        if (c14095h != null) {
            c14095h.A04 = c2170Zn.A00() != null;
            c14095h.A02();
        }
    }
}
