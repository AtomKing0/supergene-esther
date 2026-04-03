package com.facebook.ads.redexgen.core;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2178Zv extends LinearLayout {
    public static byte[] A0A;
    public static final LinearLayout.LayoutParams A0B;
    public LinearLayout A00;
    public TextView A01;
    public String A02;
    public boolean A03;
    public final int A04;
    public final View.OnClickListener A05;
    public final RelativeLayout A06;
    public final C2387dL A07;
    public final KE A08;
    public final C2201aK A09;

    public static String A0e(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 11);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0f() {
        A0A = new byte[]{-96, -93, -93, -92, -77, -96, -88, -85, -78};
    }

    public abstract void A0i(int i10);

    static {
        A0f();
        A0B = new LinearLayout.LayoutParams(-2, -2);
    }

    public AbstractC2178Zv(C2387dL c2387dL, KE ke, int i10, C1850My c1850My, boolean z10, String str, US us, InterfaceC2118Xn interfaceC2118Xn, C2460eX c2460eX, XH xh, N3 n32, boolean z11, String str2) {
        super(c2387dL);
        this.A02 = A0e(0, 0, 37);
        XP.A0I(this);
        this.A07 = c2387dL;
        this.A04 = i10;
        this.A03 = z11;
        this.A02 = str2;
        this.A09 = new C2201aK(c2387dL);
        XP.A0K(this.A09, 0);
        XP.A0I(this.A09);
        if (z11) {
            this.A00 = new LinearLayout(c2387dL);
            this.A01 = new TextView(c2387dL);
            XP.A0I(this.A01);
        }
        if (ke == null) {
            this.A08 = new KE(c2387dL, str, c1850My, z10, us, interfaceC2118Xn, c2460eX, xh, n32);
        } else {
            this.A08 = ke;
        }
        XP.A0E(1001, this.A08);
        this.A05 = AbstractC2212aV.A03(this.A08, A0e(0, 9, 52));
        this.A06 = new RelativeLayout(c2387dL);
        this.A06.setLayoutParams(A0B);
        XP.A0I(this.A06);
    }

    public void A0g() {
    }

    public void A0h() {
        this.A09.setOnClickListener(this.A05);
    }

    public final KE getCTAButton() {
        return this.A08;
    }

    public View getExpandableLayout() {
        return null;
    }

    public final ImageView getIconView() {
        return this.A09;
    }

    public void setInfo(C1848Mw c1848Mw, C1851Mz c1851Mz, String str, String str2, InterfaceC2100Wv interfaceC2100Wv, InterfaceC2187a4 interfaceC2187a4) {
        this.A08.setCta(c1851Mz, str, new HashMap(), interfaceC2100Wv, interfaceC2187a4);
        new KZ(this.A09, this.A07).A05(this.A04, this.A04).A07(str2);
    }

    public void setTitleMaxLines(int i10) {
    }
}
