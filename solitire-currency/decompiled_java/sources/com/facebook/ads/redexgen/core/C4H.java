package com.facebook.ads.redexgen.core;

import android.content.res.Configuration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4H, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C4H extends G2 {
    public static byte[] A07;
    public static String[] A08 = {"opNTFb7MfNeLnBf1OFt8H8u3IMVbRu1d", "IWQCWQwp5ID5RPcOdaIzYqbwlbVDrClG", "KvkPuVSJhScWrt17epNc", "F0ODCmRg5uMMagWpVfR8fmvJ1OUGt5pq", "F5r", "wG3QjEZJL94bFBL8PiZK", "A8E1xGSXICDDUeWE8x490gS0hcqgXwJC", "2T9PYA9x4VF1QbksNYikemvLXt0jGXOu"};
    public AbstractC2221ae A00;
    public C1590Cw A01;
    public final ImageView A02;
    public final R6 A03;
    public final AtomicBoolean A04;
    public final AtomicBoolean A05;
    public final AtomicBoolean A06;

    public static String A03(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 61);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A07 = new byte[]{-17, -25, -27, -20};
    }

    static {
        A07();
    }

    public C4H(C2387dL c2387dL, YY yy, US us, AbstractC2662hy abstractC2662hy, SF sf, InterfaceC2118Xn interfaceC2118Xn) {
        super(c2387dL, yy, us, abstractC2662hy, sf, interfaceC2118Xn);
        this.A03 = new C1668Fw(this);
        this.A05 = new AtomicBoolean(false);
        this.A04 = new AtomicBoolean(false);
        this.A06 = new AtomicBoolean(false);
        this.A02 = new ImageView(getContext());
        if (abstractC2662hy.A20().A0H().A04() > 0) {
            this.A01 = new C1590Cw(c2387dL, abstractC2662hy.A20().A0H().A04() * 1000);
        }
        this.A02.setScaleType(ImageView.ScaleType.CENTER);
        this.A02.setAdjustViewBounds(true);
        new KZ(this.A02, super.A04).A05(super.A02.A20().A0H().A00(), super.A02.A20().A0H().A01()).A06(new C1667Fv(this)).A07(super.A02.A20().A0H().A08());
    }

    private AbstractC2221ae A01(int i10) {
        if (this.A02.getParent() != null) {
            XP.A0H(this.A02);
        }
        C2224ah c2224ahA0N = new C2224ah(super.A04, super.A05, this.A09, super.A02, this.A02, this.A0B, this.A07).A0K(this.A08.getToolbarHeight()).A0R(this.A08).A0J(i10).A0N(super.A06);
        if (this.A01 != null) {
            c2224ahA0N.A0T(this.A01);
        }
        c2224ahA0N.A0M(MI.A00(super.A04, super.A05, A03(0, 0, 52), WQ.A00(super.A02.A20().A0J().A05()), new HashMap(), super.A02.A21()));
        C2225ai params = c2224ahA0N.A0W();
        return AbstractC2222af.A00(params, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06() {
        if (this.A05.get() && this.A04.get()) {
            A0c();
        }
    }

    private void A08(int i10) {
        XP.A0H(this.A00);
        this.A00 = A01(i10);
        this.A00.setAccidentalClickCappingListener(new MF() { // from class: com.facebook.ads.redexgen.X.Fx
            @Override // com.facebook.ads.redexgen.core.MF
            public final void ACB() {
                this.A00.A0k();
            }
        });
        C1850My colors = this.A00.getColors();
        XP.A0K(this, colors.A08(this.A00 != null && (this.A00.A1M() || (this.A00 instanceof AbstractC1771Jw))));
        this.A08.setFullscreen(this.A00.A1M());
        this.A08.A0A(colors, KE.A05(super.A02));
        addView(this.A00, 0, G2.A0E);
        setUpFullscreenMode(this.A00 != null && this.A00.A1M());
    }

    @Override // com.facebook.ads.redexgen.core.G2
    public final AbstractC2117Xm A0b() {
        AbstractC2117Xm c1869Nr;
        if (!A0j()) {
            c1869Nr = new FullScreenAdToolbar(super.A04, this.A09, super.A06, 1, super.A02.A1t(), super.A02.A1j());
        } else {
            c1869Nr = new C1869Nr(super.A04, this.A09, super.A06, 1);
        }
        if (super.A02.A2K()) {
            c1869Nr.setOnClickListener(new ViewOnClickListenerC2335cU(this));
        }
        return c1869Nr;
    }

    @Override // com.facebook.ads.redexgen.core.G2
    public final void A0e() {
        if (this.A00 != null) {
            super.A06.A04(UZ.A0Y, null);
            ME meA1A = this.A00.A1A(A03(0, 4, 63));
            if (super.A02.A2D()) {
                return;
            }
            ME actionOutcome = ME.A09;
            if (meA1A != actionOutcome) {
                ME actionOutcome2 = ME.A06;
                if (meA1A != actionOutcome2) {
                    A0d();
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.G2
    public final void A0f() {
        XP.A0J(this.A00);
        XP.A0J(this.A08);
        this.A04.set(true);
        A06();
        int iA04 = super.A02.A20().A0H().A04();
        int secondsForNextCta = super.A02.A20().A0H().A02();
        if (iA04 > 0) {
            if (this.A00 != null) {
                this.A00.A1F();
            }
            A0g(iA04, new C1666Fu(this), this.A01);
            if (secondsForNextCta == 0 || secondsForNextCta >= iA04) {
                super.A01 = true;
                this.A08.setToolbarActionMode(8);
                return;
            } else {
                if (secondsForNextCta <= 0) {
                    return;
                }
                this.A08.setProgressSpinnerInvisible(true);
                A0g(secondsForNextCta, new C1665Ft(this), null);
                return;
            }
        }
        this.A06.set(true);
        AbstractC2117Xm abstractC2117Xm = this.A08;
        int unskippableSeconds = getCloseButtonStyle();
        abstractC2117Xm.setToolbarActionMode(unskippableSeconds);
    }

    @Override // com.facebook.ads.redexgen.core.G2
    public final void A0h(R0 r02) {
        FrameLayout.LayoutParams layoutParams;
        r02.A0A(this.A03);
        int orientation = r02.A05().getResources().getConfiguration().orientation;
        A08(orientation);
        if (A0j()) {
            XP.A0H(this.A08);
        }
        if (A0j()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, G2.A0F, 0, 0);
        } else {
            int orientation2 = this.A08.getToolbarHeight();
            layoutParams = new FrameLayout.LayoutParams(-1, orientation2);
        }
        addView(this.A08, layoutParams);
        XP.A0F(this.A00);
        XP.A0F(this.A08);
    }

    @Override // com.facebook.ads.redexgen.core.G2
    public final boolean A0i() {
        if (this.A00 == null) {
            return false;
        }
        AbstractC2221ae abstractC2221ae = this.A00;
        if (A08[4].length() != 3) {
            throw new RuntimeException();
        }
        A08[4] = "kMg";
        return abstractC2221ae.A1N(false);
    }

    @Override // com.facebook.ads.redexgen.core.G2
    public final boolean A0j() {
        return super.A02.A1b() || super.A02.A1o();
    }

    public final /* synthetic */ void A0k() {
        A0d();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2119Xo
    public final void AEV(boolean z10) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2119Xo
    public final void AF0(boolean z10) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCloseButtonStyle() {
        if (this.A00 != null) {
            return this.A00.getCloseButtonStyle();
        }
        return 0;
    }

    @Override // com.facebook.ads.redexgen.core.G2, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!super.A02.A20().A0T() && !A0j()) {
            A08(configuration.orientation);
        }
    }

    @Override // com.facebook.ads.redexgen.core.G2, com.facebook.ads.redexgen.core.InterfaceC2119Xo
    public final void onDestroy() {
        if (U7.A1u(super.A04)) {
            super.A04.A0B().AJj(this.A02);
        }
        if (this.A00 != null) {
            AbstractC2221ae abstractC2221ae = this.A00;
            String[] strArr = A08;
            if (strArr[6].charAt(10) != strArr[1].charAt(10)) {
                throw new RuntimeException();
            }
            A08[4] = "hIQ";
            abstractC2221ae.A1B();
        }
        super.onDestroy();
    }
}
