package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.g1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2551g1 extends AbstractC1883Oh {
    public final AbstractC1883Oh A00 = new C2552g2(this);
    public final C14346g A01;

    public C2551g1(C14346g c14346g) {
        this.A01 = c14346g;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1883Oh
    public final void A07(View view, AccessibilityEvent accessibilityEvent) {
        super.A07(view, accessibilityEvent);
        accessibilityEvent.setClassName(C14346g.class.getName());
        if ((view instanceof C14346g) && !A0B()) {
            C14346g c14346g = (C14346g) view;
            if (c14346g.getLayoutManager() != null) {
                c14346g.getLayoutManager().A1v(accessibilityEvent);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1883Oh
    public final void A08(View view, PS ps) {
        super.A08(view, ps);
        ps.A0O(C14346g.class.getName());
        if (!A0B() && this.A01.getLayoutManager() != null) {
            this.A01.getLayoutManager().A1H(ps);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1883Oh
    public final boolean A09(View view, int i10, Bundle bundle) {
        if (super.A09(view, i10, bundle)) {
            return true;
        }
        if (!A0B() && this.A01.getLayoutManager() != null) {
            return this.A01.getLayoutManager().A1X(i10, bundle);
        }
        return false;
    }

    public final AbstractC1883Oh A0A() {
        return this.A00;
    }

    public final boolean A0B() {
        return this.A01.A1r();
    }
}
