package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iO, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2684iO extends AbstractRunnableC2074Vt {
    public final /* synthetic */ C2683iN A00;
    public final /* synthetic */ Map A01;
    public final /* synthetic */ Map A02;

    public C2684iO(C2683iN c2683iN, Map map, Map map2) {
        this.A00 = c2683iN;
        this.A02 = map;
        this.A01 = map2;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC2074Vt
    public final void A07() {
        if (!TextUtils.isEmpty(this.A00.A01.A7G())) {
            HashMap map = new HashMap();
            Map<String, String> extraData = this.A02;
            map.putAll(extraData);
            Map<String, String> extraData2 = this.A01;
            map.putAll(extraData2);
            this.A00.A0A.A0A().ABT(this.A00.A01.A7G(), map);
        }
    }
}
