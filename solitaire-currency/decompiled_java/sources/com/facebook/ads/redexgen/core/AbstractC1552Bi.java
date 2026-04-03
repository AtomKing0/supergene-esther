package com.facebook.ads.redexgen.core;

import com.facebook.ads.sync.SyncModifiableBundle;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1552Bi implements InterfaceC2508fK {
    public final By A00;
    public final EnumC2513fP A01;

    public AbstractC1552Bi(By by, EnumC2513fP enumC2513fP) {
        this.A00 = by;
        this.A01 = enumC2513fP;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2508fK
    public void A45(Map<InterfaceC2491f2, EnumC2513fP> map, Map<SyncModifiableBundle, EnumC2500fC> map2) {
        map.put(this.A00, this.A01);
    }
}
