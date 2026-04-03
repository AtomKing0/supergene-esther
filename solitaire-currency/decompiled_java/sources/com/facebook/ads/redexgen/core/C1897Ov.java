package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ov, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1897Ov implements X5 {
    public int A00;
    public final X5 A01;

    public C1897Ov(X5 x52, int i10) {
        this.A01 = x52;
        this.A00 = i10;
    }

    @Override // com.facebook.ads.redexgen.core.X5
    public final void AGO(String str) {
        if (this.A00 > 0) {
            this.A01.AGO(str);
            this.A00--;
        }
    }

    @Override // com.facebook.ads.redexgen.core.X5
    public final void flush() {
        this.A01.flush();
    }
}
