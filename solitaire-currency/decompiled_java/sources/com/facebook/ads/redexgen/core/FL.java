package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FL extends FrameLayout implements InterfaceC2119Xo {
    public static byte[] A0B;
    public static final RelativeLayout.LayoutParams A0C;
    public R0 A00;
    public Intent A01;
    public Bundle A02;
    public InterfaceC2119Xo A03;
    public final AbstractC2662hy A04;
    public final AbstractC2662hy A05;
    public final R0 A06;
    public final C2387dL A07;
    public final US A08;
    public final XC A09;
    public final InterfaceC2118Xn A0A;

    public static String A08(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] ^ i12) ^ 32);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A0B = new byte[]{117, 105, 100, 102, 96, 104, 96, 107, 113};
    }

    static {
        A0A();
        A0C = new RelativeLayout.LayoutParams(-1, -1);
    }

    public FL(C2387dL c2387dL, US us, AbstractC2662hy abstractC2662hy, AbstractC2662hy abstractC2662hy2, InterfaceC2118Xn interfaceC2118Xn, R0 r02) {
        super(c2387dL);
        this.A07 = c2387dL;
        this.A08 = us;
        this.A05 = abstractC2662hy;
        this.A04 = abstractC2662hy2;
        this.A0A = interfaceC2118Xn;
        this.A06 = r02;
        this.A09 = new XC(this);
        this.A09.A05(XB.A02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C1803Lc A05(C2366cz c2366cz, YY yy) {
        return new C1803Lc(this.A07, this.A08, this.A0A, this.A04, this.A04.A1A(), yy, true, c2366cz);
    }

    private C13673r A06() {
        if (this.A04.A20().A0H().A07() != null) {
            this.A05.A1M(this.A04.A20().A0H().A07().A0N());
            this.A05.A1N(this.A04.A20().A0H().A07().A0P());
        }
        LX lx = new LX();
        C2366cz c2366czA07 = A07(lx, this.A04);
        C13673r c13673r = new C13673r(this.A07, lx, this.A08, this.A05, new SF(this.A07), this.A0A);
        c13673r.setVideoLeadingPlayableAdListener(new FM(this, c2366czA07, lx));
        return c13673r;
    }

    private C2366cz A07(YY yy, AbstractC2662hy abstractC2662hy) {
        NB nbA07 = abstractC2662hy.A20().A0H().A07();
        if (nbA07 == null || !nbA07.A0M()) {
            return null;
        }
        HashMap map = new HashMap();
        map.put(A08(0, 9, 37), yy.A8d());
        return new C2366cz(this.A07, abstractC2662hy, nbA07, this.A08, null, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09() {
        if (this.A03 != null) {
            this.A03.onDestroy();
            if (this.A03 instanceof View) {
                ((View) this.A03).setVisibility(8);
                removeView((View) this.A03);
            }
        }
    }

    private final void A0B(Intent intent, Bundle bundle, R0 r02) {
        this.A03 = A06();
        this.A03.AAl(intent, bundle, r02);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2119Xo
    public final void AAl(Intent intent, Bundle bundle, R0 r02) {
        this.A01 = intent;
        this.A02 = bundle;
        this.A00 = r02;
        this.A0A.A3x(this, A0C);
        A0B(intent, bundle, r02);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2119Xo
    public final void AEV(boolean z10) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2119Xo
    public final void AF0(boolean z10) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2119Xo
    public final void AIB(Bundle bundle) {
    }

    public InterfaceC2119Xo getContentView() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2119Xo
    public String getCurrentClientToken() {
        return this.A05.A25();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2119Xo
    public final boolean onActivityResult(int i10, int i11, Intent intent) {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2119Xo
    public final void onDestroy() {
    }

    public void setListener(InterfaceC2118Xn interfaceC2118Xn) {
    }
}
