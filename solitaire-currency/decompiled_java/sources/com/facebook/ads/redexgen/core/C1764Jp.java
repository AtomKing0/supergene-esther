package com.facebook.ads.redexgen.core;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1764Jp extends AbstractC2221ae implements Wf {
    public static byte[] A05;
    public static final int A06;
    public final AbstractC2662hy A00;
    public final C2086Wh A01;
    public final InterfaceC2118Xn A02;
    public final C2253bA A03;
    public final C2353cm A04;

    public static String A00(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 86);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{38, 42, 30, 36, 34};
    }

    static {
        A01();
        A06 = Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public C1764Jp(C2225ai c2225ai, boolean z10) {
        int id;
        int iA01;
        super(c2225ai, z10);
        this.A02 = c2225ai.A0D();
        this.A00 = c2225ai.A05();
        this.A03 = new C2253bA(c2225ai.A06(), c2225ai.A02());
        this.A03.A01(getTitleDescContainer(), z10);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.setMargins(AbstractC2221ae.A07, AbstractC2221ae.A07, AbstractC2221ae.A07, AbstractC2221ae.A07);
        getCtaButton().setLayoutParams(layoutParams);
        if (c2225ai.A0I()) {
            this.A04 = new C2353cm(c2225ai.A06());
            this.A04.setPageDetails(c2225ai.A05().A23());
            XP.A0E(1007, this.A04);
            RelativeLayout.LayoutParams pageDetailsParams = new RelativeLayout.LayoutParams(-2, -2);
            pageDetailsParams.addRule(2, getCtaButton().getId());
            pageDetailsParams.setMargins(AbstractC2221ae.A07, AbstractC2221ae.A07 - (AbstractC2221ae.A07 / 2), AbstractC2221ae.A07, 0);
            this.A04.setLayoutParams(pageDetailsParams);
            id = this.A04.getId();
            iA01 = c2225ai.A01() - (AbstractC2221ae.A07 / 2);
        } else {
            id = getCtaButton().getId();
            iA01 = c2225ai.A01();
            this.A04 = null;
        }
        FrameLayout insideContainerLayout = new FrameLayout(c2225ai.A06());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(10);
        layoutParams2.addRule(2, id);
        layoutParams2.setMargins(0, iA01, 0, 0);
        insideContainerLayout.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 17;
        layoutParams3.setMargins(AbstractC2221ae.A07, 0, AbstractC2221ae.A07, 0);
        insideContainerLayout.addView(this.A03, layoutParams3);
        addView(insideContainerLayout);
        if (this.A04 != null) {
            addView(this.A04);
        }
        addView(getCtaButton());
        getCtaButton().A0F(c2225ai.A05(), c2225ai.A0C());
        View viewA02 = c2225ai.A02();
        this.A01 = C2086Wh.A00(c2225ai.A06(), this.A00, this);
        C2085Wg c2085WgA02 = this.A01.A02(this.A00);
        c2225ai.A06().A0H().A00(c2085WgA02.A01);
        getCtaButton().setCreativeAsCtaLoggingHelper(this.A01);
        if (viewA02 != null && c2085WgA02.A00) {
            viewA02.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.ao
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.A00.A1O(view);
                }
            });
        } else if (viewA02 != null && U7.A1I(getAdContextWrapper())) {
            AbstractC2175Zs.A00(viewA02, U7.A1J(getAdContextWrapper()), new ViewOnClickListenerC2232ap(this));
        }
        if (U7.A17(c2225ai.A06())) {
            getTitleDescContainer().setCTAClickListener(getCtaButton());
            if (c2225ai.A0C() != null) {
                c2225ai.A0C().setCTAClickListener(getCtaButton());
            }
        }
        if (this.A04 != null && U7.A18(c2225ai.A06())) {
            this.A04.setOnClickListener(getCtaButton());
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2221ae
    public final boolean A0C() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2221ae
    public final boolean A0D() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2221ae
    public final void A1B() {
        super.A1B();
        this.A01.A03();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2221ae
    public final void A1G(C1841Mp c1841Mp, String str, double d10, Bundle bundle) {
        super.A1G(c1841Mp, str, d10, bundle);
        if (d10 > 0.0d) {
            int mediaHeight = (int) (((double) (A06 - (AbstractC2221ae.A07 * 2))) / d10);
            this.A03.A00(mediaHeight);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2221ae
    public final boolean A1M() {
        return false;
    }

    public final /* synthetic */ void A1O(View view) {
        getCtaButton().A0E(A00(0, 5, 103));
    }
}
