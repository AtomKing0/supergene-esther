package com.facebook.ads.redexgen.core;

import com.facebook.ads.sync.SyncModifiableBundle;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1553Bj implements InterfaceC2508fK {
    public final EnumC2500fC A00;
    public final AbstractC13251z A01;

    public AbstractC1553Bj(AbstractC13251z abstractC13251z, EnumC2500fC enumC2500fC) {
        this.A01 = abstractC13251z;
        this.A00 = enumC2500fC;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2508fK
    public void A45(Map<InterfaceC2491f2, EnumC2513fP> map, Map<SyncModifiableBundle, EnumC2500fC> map2) {
        map2.put(null, this.A00);
    }
}
