package com.facebook.ads.redexgen.core;

import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.TransitionSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class LV extends AbstractC2134Yd {
    public static String[] A03 = {"ps9u6Kn8p", "fRCCllxRFm9XYnsS5Nz0CDYYbd8rz98F", "veZY5LUK4HkumILqtvhVtf9OT9QK1Jmh", "8c6Edyt19YE2bwpDp37rWBgdyfN4I4si", "Dgwj6SSLqT", "biYcUlACC5CMDg3zbjwwDR7mq5XP76DA", "rp5V5gFYHfFnaijOqqdMDMWavMrEx7HP", "ycj43TNZcka4uMSCxDz6fuqQ2r9gi3g6"};
    public static final int A04 = (int) (AbstractC2090Wl.A02 * 8.0f);
    public final RelativeLayout A00;
    public final O2 A01;
    public final C2387dL A02;

    public LV(C2387dL c2387dL, US us, String str, N9 n92, InterfaceC2119Xo interfaceC2119Xo, InterfaceC2118Xn interfaceC2118Xn) {
        super(c2387dL, us, str, n92, interfaceC2119Xo, interfaceC2118Xn);
        this.A02 = c2387dL;
        this.A01 = O3.A00(c2387dL.A02());
        this.A00 = new RelativeLayout(getContext());
        addView(this.A00, new RelativeLayout.LayoutParams(-1, -1));
        XP.A0K(this.A00, -1728053248);
        this.A00.setOnClickListener(new ViewOnClickListenerC2139Yi(this));
    }

    public static RelativeLayout.LayoutParams A00(boolean z10) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, z10 ? -1 : -2);
        layoutParams.addRule(12);
        return layoutParams;
    }

    private void A01() {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(0);
        transitionSet.addTransition(new ChangeBounds()).addTransition(new Explode());
        XP.A0T(this, transitionSet);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2134Yd
    public final void A0N() {
        O6 o6A0A = this.A01.A0A();
        C2149Ys c2149Ys = new C2149Ys(this.A02);
        c2149Ys.setInfo(XX.HIDE_AD, this.A01.A0H(), this.A01.A0G());
        c2149Ys.setOnClickListener(new ViewOnClickListenerC2140Yj(this));
        O6 o6A0B = this.A01.A0B();
        C2149Ys c2149Ys2 = new C2149Ys(this.A02);
        c2149Ys2.setInfo(XX.REPORT_AD, this.A01.A0L(), this.A01.A0K());
        c2149Ys2.setOnClickListener(new ViewOnClickListenerC2141Yk(this));
        C2149Ys c2149Ys3 = new C2149Ys(this.A02);
        c2149Ys3.setInfo(XX.AD_CHOICES_ICON, this.A01.A0M(), "");
        c2149Ys3.setOnClickListener(new ViewOnClickListenerC2142Yl(this));
        LinearLayout.LayoutParams itemParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setClickable(true);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(A04 * 2, A04, A04 * 2, A04);
        XP.A0K(linearLayout, -1);
        if (!o6A0A.A05().isEmpty()) {
            linearLayout.addView(c2149Ys, itemParams);
        }
        if (!o6A0B.A05().isEmpty()) {
            linearLayout.addView(c2149Ys2, itemParams);
        }
        linearLayout.addView(c2149Ys3, itemParams);
        A01();
        this.A00.removeAllViews();
        this.A00.addView(linearLayout, A00(false));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2134Yd
    public final void A0O() {
        XP.A0G(this);
        this.A00.removeAllViews();
        XP.A0H(this);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2134Yd
    public final void A0P(O6 o62, O4 o42) {
        String strA0E;
        int i10;
        String strA01;
        if (o42 == O4.A05) {
            return;
        }
        boolean z10 = o42 == O4.A06;
        C2132Yb c2132Yb = new C2132Yb(this.A02, this.A0B);
        if (z10) {
            O2 o22 = this.A01;
            if (A03[4].length() != 10) {
                throw new RuntimeException();
            }
            A03[6] = "KfE81dulHFmzGO7NxqDM7oaE1pV2dKkX";
            strA0E = o22.A0F();
        } else {
            strA0E = this.A01.A0E();
        }
        C2132Yb c2132YbA0E = c2132Yb.A0I(strA0E).A0H(this.A01.A0D()).A0F(o62.A04()).A0E(z10 ? XX.REPORT_AD : XX.HIDE_AD);
        if (z10) {
            i10 = -552389;
        } else {
            i10 = -13272859;
        }
        C2132Yb c2132YbA0D = c2132YbA0E.A0D(i10);
        if (this.A0A != null) {
            N9 n92 = this.A0A;
            if (A03[1].charAt(11) != 'X') {
                strA01 = n92.A01();
            } else {
                A03[0] = "vLdx3pZGf";
                strA01 = n92.A01();
            }
        } else {
            strA01 = "";
        }
        C2133Yc adHiddenView = c2132YbA0D.A0G(strA01).A0M();
        XP.A0K(adHiddenView, -1);
        XP.A0R(this);
        this.A00.removeAllViews();
        this.A00.addView(adHiddenView, A00(true));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2134Yd
    public final void A0Q(O6 o62, O4 o42) {
        String strA0H;
        boolean z10 = o42 == O4.A06;
        C2387dL c2387dL = this.A02;
        InterfaceC2136Yf interfaceC2136Yf = this.A0B;
        if (z10) {
            strA0H = this.A01.A0L();
        } else {
            strA0H = this.A01.A0H();
        }
        C2152Yv c2152Yv = new C2152Yv(c2387dL, o62, interfaceC2136Yf, strA0H, z10 ? XX.REPORT_AD : XX.HIDE_AD);
        c2152Yv.setClickable(true);
        XP.A0K(c2152Yv, -1);
        c2152Yv.setPadding(A04 * 2, A04, A04 * 2, A04);
        A01();
        this.A00.removeAllViews();
        RelativeLayout relativeLayout = this.A00;
        String[] strArr = A03;
        if (strArr[3].charAt(9) == strArr[5].charAt(9)) {
            throw new RuntimeException();
        }
        A03[1] = "OoQvJ70CiRWXlhIiWSDPNsGTFrOY4nX1";
        relativeLayout.addView(c2152Yv, A00(false));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2134Yd
    public final boolean A0R() {
        return false;
    }
}
