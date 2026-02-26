package com.facebook.ads.redexgen.core;

import android.os.Bundle;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9o, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C15079o extends AbstractC3042oU {
    public final boolean A00;
    public final boolean A01;
    public static final String A04 = AbstractC13764a.A0h(1);
    public static final String A03 = AbstractC13764a.A0h(2);
    public static final C1R<C15079o> A02 = new C1R() { // from class: com.facebook.ads.redexgen.X.oS
        @Override // com.facebook.ads.redexgen.core.C1R
        public final C1S A6X(Bundle bundle) {
            return C15079o.A00(bundle);
        }
    };

    public C15079o() {
        this.A01 = false;
        this.A00 = false;
    }

    public C15079o(boolean z10) {
        this.A01 = true;
        this.A00 = z10;
    }

    public static C15079o A00(Bundle bundle) {
        boolean rated = bundle.getInt(AbstractC3042oU.A02, -1) == 3;
        C3M.A07(rated);
        boolean rated2 = bundle.getBoolean(A04, false);
        if (rated2) {
            return new C15079o(bundle.getBoolean(A03, false));
        }
        return new C15079o();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C15079o)) {
            return false;
        }
        C15079o c15079o = (C15079o) obj;
        return this.A00 == c15079o.A00 && this.A01 == c15079o.A01;
    }

    public final int hashCode() {
        return BX.A00(Boolean.valueOf(this.A01), Boolean.valueOf(this.A00));
    }
}
