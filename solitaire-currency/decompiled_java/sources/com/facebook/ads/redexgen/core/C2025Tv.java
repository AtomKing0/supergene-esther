package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2025Tv implements InterfaceC2171Zo {
    public final /* synthetic */ TD A00;

    public C2025Tv(TD td) {
        this.A00 = td;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2171Zo
    public final void ADT(C2170Zn c2170Zn) {
        this.A00.A0D.set(c2170Zn.A00() != null);
        if (this.A00.A0E.get() && this.A00.A02 != null) {
            this.A00.A02.AEW(c2170Zn.A00() != null);
        }
    }
}
