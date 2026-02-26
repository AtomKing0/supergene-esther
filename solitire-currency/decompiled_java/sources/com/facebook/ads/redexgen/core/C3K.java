package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3K, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C3K extends DP {
    public final /* synthetic */ D9 A00;

    public C3K(D9 d92) {
        this.A00 = d92;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC2010Tf
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(DQ dq) {
        if ((this.A00.A03 && this.A00.A02) || !this.A00.A05 || !this.A00.A04) {
            return;
        }
        this.A00.A05 = false;
        if (!this.A00.A0G(EnumC2428e1.A03) && !this.A00.A06) {
            if (!this.A00.A0G(EnumC2428e1.A02)) {
                return;
            }
            this.A00.A03();
            this.A00.A06(true, true);
            return;
        }
        this.A00.A06 = false;
        this.A00.A07.postDelayed(new DB(this), this.A00.A00);
    }
}
