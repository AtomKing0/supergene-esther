package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2644hb implements NP {
    public final /* synthetic */ NH A00;

    public C2644hb(NH nh) {
        this.A00 = nh;
    }

    @Override // com.facebook.ads.redexgen.core.NP
    public final void AEZ(AdError adError) {
        this.A00.A04.ACF(AdError.CACHE_ERROR);
    }

    @Override // com.facebook.ads.redexgen.core.NP
    public final void AEa() {
        this.A00.A04.ACG();
    }
}
