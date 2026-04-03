package com.facebook.ads.redexgen.core;

import com.facebook.ads.CacheFlag;
import java.util.EnumSet;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6y, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14526y extends AbstractC2633hQ {
    public C14526y(C2387dL c2387dL, NT nt) {
        super(c2387dL, nt);
    }

    private C2631hO A00(Runnable runnable) {
        return new C2631hO(this, runnable);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2633hQ
    public final AbstractC1840Mo A0I() {
        C2688iS successfullyLoadedAdapter = (C2688iS) this.A01;
        if (successfullyLoadedAdapter != null) {
            return successfullyLoadedAdapter.A09();
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2633hQ
    public final void A0P() {
        C2688iS interstitialAdapter = (C2688iS) this.A01;
        interstitialAdapter.A0B();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2633hQ
    public final void A0R(MP mp, TE te, TC tc, NU nu) {
        C2688iS c2688iS = (C2688iS) mp;
        C2632hP c2632hP = new C2632hP(this, nu, c2688iS);
        A0H().postDelayed(c2632hP, te.A05().A05());
        EnumSet<CacheFlag> enumSet = this.A08.A0B;
        if (enumSet == null) {
            enumSet = CacheFlag.ALL;
        }
        c2688iS.A0A(this.A0B, A00(c2632hP), nu, enumSet, this.A08.A04, this.A08.A05, this.A08.A02);
    }
}
