package com.facebook.ads.redexgen.core;

import android.os.Bundle;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9s, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C15119s extends AbstractC3042oU {
    public final boolean A00;
    public final boolean A01;
    public static final String A04 = AbstractC13764a.A0h(1);
    public static final String A03 = AbstractC13764a.A0h(2);
    public static final C1R<C15119s> A02 = new C1R() { // from class: com.facebook.ads.redexgen.X.op
        @Override // com.facebook.ads.redexgen.core.C1R
        public final C1S A6X(Bundle bundle) {
            return C15119s.A00(bundle);
        }
    };

    public C15119s() {
        this.A01 = false;
        this.A00 = false;
    }

    public C15119s(boolean z10) {
        this.A01 = true;
        this.A00 = z10;
    }

    public static C15119s A00(Bundle bundle) {
        boolean isRated = bundle.getInt(AbstractC3042oU.A02, -1) == 0;
        C3M.A07(isRated);
        boolean isRated2 = bundle.getBoolean(A04, false);
        if (isRated2) {
            return new C15119s(bundle.getBoolean(A03, false));
        }
        return new C15119s();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C15119s)) {
            return false;
        }
        C15119s c15119s = (C15119s) obj;
        return this.A00 == c15119s.A00 && this.A01 == c15119s.A01;
    }

    public final int hashCode() {
        return BX.A00(Boolean.valueOf(this.A01), Boolean.valueOf(this.A00));
    }
}
