package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.d4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2371d4 {
    public KE A00;
    public final C1838Ml A01;
    public final C1848Mw A02;
    public final N0 A03;
    public final N9 A04;
    public final C2387dL A05;
    public final C2030Ua A06;
    public static final int A09 = (int) (AbstractC2090Wl.A02 * 4.0f);
    public static final int A07 = (int) (AbstractC2090Wl.A02 * 72.0f);
    public static final int A08 = (int) (AbstractC2090Wl.A02 * 8.0f);

    public C2371d4(C2387dL c2387dL, US us, AbstractC2662hy abstractC2662hy) {
        this.A05 = c2387dL;
        this.A06 = new C2030Ua(abstractC2662hy.A25(), us);
        this.A01 = abstractC2662hy.A1z();
        this.A02 = abstractC2662hy.A20().A0I();
        this.A04 = abstractC2662hy.A23();
        this.A03 = abstractC2662hy.A20().A0K();
    }

    private View A00(KE ke) {
        C2207aQ c2207aQ = new C2207aQ(this.A05, this.A01.A01(), true, false, false);
        c2207aQ.A04(this.A02.A0F(), this.A02.A04(), null, false, true);
        c2207aQ.setAlignment(17);
        C2201aK c2201aK = new C2201aK(this.A05);
        XP.A0K(c2201aK, 0);
        c2201aK.setRadius(50);
        new KZ(c2201aK, this.A05).A04().A07(this.A04.A01());
        LinearLayout linearLayout = new LinearLayout(this.A05);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.addView(c2201aK, new LinearLayout.LayoutParams(A07, A07));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, A08, 0, A08);
        linearLayout.addView(c2207aQ, layoutParams);
        if (ke != null) {
            XP.A0H(ke);
            linearLayout.addView(ke, layoutParams);
            if (TextUtils.isEmpty(ke.getText())) {
                XP.A0F(ke);
            }
        }
        return linearLayout;
    }

    private C14346g A01() {
        C14346g c14346g = new C14346g(this.A05);
        c14346g.setLayoutManager(new C2567gI(this.A05, 0, false));
        c14346g.setAdapter(new C1621Eb(this.A05, this.A03.A02(), A09, this.A00));
        return c14346g;
    }

    private final EnumC2370d3 A02() {
        if (!this.A03.A02().isEmpty()) {
            return EnumC2370d3.A03;
        }
        return EnumC2370d3.A02;
    }

    public final Pair<EnumC2370d3, View> A03(KE ke) {
        View viewA01;
        this.A00 = ke;
        EnumC2370d3 enumC2370d3A02 = A02();
        switch (C2369d2.A00[enumC2370d3A02.ordinal()]) {
            case 1:
                viewA01 = A01();
                break;
            default:
                viewA01 = A00(this.A00);
                break;
        }
        AbstractC2032Uc.A04(viewA01, this.A06, UZ.A0S);
        return new Pair<>(enumC2370d3A02, viewA01);
    }
}
