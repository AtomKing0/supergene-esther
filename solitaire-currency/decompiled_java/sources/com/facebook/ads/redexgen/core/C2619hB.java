package com.facebook.ads.redexgen.core;

import android.content.Context;
import com.facebook.ads.AdSettings;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hB, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2619hB implements TL {
    @Override // com.facebook.ads.redexgen.core.TL
    public final String A71() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.TL
    public final String A7F() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.TL
    public final C1983Se A7e(SQ sq) {
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.TL
    public final String A8O() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.TL
    public final String A98() {
        if (AdSettings.getTestAdType() != AdSettings.TestAdType.DEFAULT) {
            return AdSettings.getTestAdType().getAdTypeString();
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.TL
    public final boolean AAR() {
        return AdSettings.isMixedAudience();
    }

    @Override // com.facebook.ads.redexgen.core.TL
    public final boolean AAX() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.TL
    public final Boolean AAb() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.TL
    public final boolean isTestMode(Context context) {
        return AdSettings.isTestMode(context);
    }
}
