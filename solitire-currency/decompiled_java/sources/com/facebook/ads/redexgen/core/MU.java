package com.facebook.ads.redexgen.core;

import com.facebook.ads.internal.protocol.AdPlacementType;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class MU {
    public static MP A00;

    public final MP A00(final C2387dL c2387dL, AdPlacementType adPlacementType) {
        if (A00 != null) {
            return A00;
        }
        switch (MT.A00[adPlacementType.ordinal()]) {
            case 1:
                return new C7L();
            case 2:
                if (U7.A1N(c2387dL)) {
                    return new C7K();
                }
                return new C7L();
            case 3:
                return new C2688iS();
            case 4:
                return new C2683iN(c2387dL);
            case 5:
                return new C2683iN(c2387dL) { // from class: com.facebook.ads.redexgen.X.7F
                    @Override // com.facebook.ads.redexgen.core.C2683iN, com.facebook.ads.redexgen.core.MP
                    public final AdPlacementType A8c() {
                        return AdPlacementType.NATIVE_BANNER;
                    }
                };
            case 6:
                return new C7B();
            default:
                return null;
        }
    }
}
