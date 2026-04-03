package com.facebook.ads.redexgen.core;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1869Nr extends AbstractC2117Xm {
    public static byte[] A03;
    public C2387dL A00;
    public InterfaceC2116Xl A01;
    public final YQ A02;

    static {
        A05();
    }

    public static String A02(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 75);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A03 = new byte[]{-75, -34, -31, -27, -41, -110, -77, -42};
    }

    public C1869Nr(C2387dL c2387dL, InterfaceC2118Xn interfaceC2118Xn, C2030Ua c2030Ua, int i10) {
        super(c2387dL);
        this.A00 = c2387dL;
        setGravity(16);
        A04();
        this.A02 = new YQ(this.A00, i10);
        A03();
    }

    private void A03() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.A02.setContentDescription(A02(0, 8, 39));
        this.A02.setActionClickListener(new ViewOnClickListenerC2128Xx(this));
        addView(this.A02, layoutParams);
    }

    private void A04() {
        View view = new View(this.A00);
        view.setLayoutParams(new LinearLayout.LayoutParams(0, 0, 1.0f));
        addView(view);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public final void A06() {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public final void A07() {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public final void A08() {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public final void A09(float f10, int i10) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public final void A0A(C1850My c1850My, boolean z10) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public final boolean A0B() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public int getToolbarActionMode() {
        return this.A02.getToolbarActionMode();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public int getToolbarHeight() {
        return AbstractC2117Xm.A01;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public InterfaceC2116Xl getToolbarListener() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public void setAdReportingVisible(boolean z10) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public void setCTAClickListener(View.OnClickListener onClickListener) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public void setCTAClickListener(KE ke) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public void setFullscreen(boolean z10) {
    }

    public void setInitialUnskippableSeconds(int i10) {
        this.A02.setInitialUnskippableSeconds(i10);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public void setPageDetails(N9 n92, String str, int i10, NF nf) {
        this.A02.setInitialUnskippableSeconds(i10);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public void setPageDetailsVisible(boolean z10) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public void setProgress(float f10) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public void setProgressClickListener(View.OnClickListener onClickListener) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public void setProgressImage(XX xx) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public void setProgressImmediate(float f10) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public void setProgressSpinnerInvisible(boolean z10) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public void setToolbarActionMessage(String str) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public void setToolbarActionMode(int i10) {
        this.A02.setToolbarActionMode(i10);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2117Xm
    public void setToolbarListener(InterfaceC2116Xl interfaceC2116Xl) {
        this.A01 = interfaceC2116Xl;
    }
}
