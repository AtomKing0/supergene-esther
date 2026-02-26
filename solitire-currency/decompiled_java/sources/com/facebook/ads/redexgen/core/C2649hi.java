package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2649hi implements InterfaceC1958Re {
    public final /* synthetic */ AbstractC2662hy A00;
    public final /* synthetic */ NG A01;
    public final /* synthetic */ NH A02;
    public final /* synthetic */ C2387dL A03;
    public final /* synthetic */ boolean A04;

    public C2649hi(NH nh, C2387dL c2387dL, boolean z10, AbstractC2662hy abstractC2662hy, NG ng) {
        this.A02 = nh;
        this.A03 = c2387dL;
        this.A04 = z10;
        this.A00 = abstractC2662hy;
        this.A01 = ng;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1958Re
    public final void ACM() {
        if (U7.A1l(this.A03) && this.A04) {
            this.A02.A02.add(AbstractC2299bu.A01(this.A03, this.A00, 1, new C2650hj(this)));
        } else {
            this.A01.ACG();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1958Re
    public final void ACN() {
        this.A01.ACF(AdError.CACHE_ERROR);
    }
}
