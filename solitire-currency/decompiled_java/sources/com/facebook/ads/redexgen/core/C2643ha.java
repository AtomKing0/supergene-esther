package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ha, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2643ha implements InterfaceC1958Re {
    public final /* synthetic */ NH A00;

    public C2643ha(NH nh) {
        this.A00 = nh;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1958Re
    public final void ACM() {
        this.A00.A04.ACG();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1958Re
    public final void ACN() {
        this.A00.A04.ACF(AdError.CACHE_ERROR);
    }
}
