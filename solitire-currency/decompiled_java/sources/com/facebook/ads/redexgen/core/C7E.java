package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7E, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C7E extends AbstractC2637hU {
    public final /* synthetic */ C7B A00;
    public final /* synthetic */ AbstractC2670iA A01;
    public final /* synthetic */ AnonymousClass73 A02;
    public final /* synthetic */ boolean A03;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7E(C7B c7b, boolean z10, boolean z11, AnonymousClass73 anonymousClass73, AbstractC2670iA abstractC2670iA) {
        super(z10);
        this.A00 = c7b;
        this.A03 = z11;
        this.A02 = anonymousClass73;
        this.A01 = abstractC2670iA;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2637hU
    public final void A00() {
        this.A00.A01.AF7(this.A01, AdError.CACHE_ERROR);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2637hU
    public final void A01(boolean z10) {
        if (!U7.A1o(this.A00.A04) || !this.A03) {
            if (this.A00.A05 == EnumC2057Vb.A0I) {
                this.A00.A04.A0F().ADn();
            }
            this.A00.A0C.set(true);
            this.A00.A01.AF4(this.A01);
            return;
        }
        this.A00.A06 = AbstractC2299bu.A01(this.A00.A04, this.A02, 0, new C2679iJ(this));
    }
}
