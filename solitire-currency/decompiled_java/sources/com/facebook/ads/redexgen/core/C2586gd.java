package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2586gd implements OG {
    private OH A00(OF of) {
        return (OH) of.A76();
    }

    public final void A01(OF of) {
        if (!of.A9J()) {
            of.AJ1(0, 0, 0, 0);
            return;
        }
        float fA8K = A8K(of);
        float fA8j = A8j(of);
        float elevation = OJ.A00(fA8K, fA8j, of.A8i());
        int vPadding = (int) Math.ceil(elevation);
        float elevation2 = OJ.A01(fA8K, fA8j, of.A8i());
        int iCeil = (int) Math.ceil(elevation2);
        of.AJ1(vPadding, iCeil, vPadding, iCeil);
    }

    @Override // com.facebook.ads.redexgen.core.OG
    public final ColorStateList A6t(OF of) {
        return A00(of).A05();
    }

    @Override // com.facebook.ads.redexgen.core.OG
    public final float A7n(OF of) {
        return of.A77().getElevation();
    }

    @Override // com.facebook.ads.redexgen.core.OG
    public final float A8K(OF of) {
        return A00(of).A03();
    }

    @Override // com.facebook.ads.redexgen.core.OG
    public final float A8P(OF of) {
        return A8j(of) * 2.0f;
    }

    @Override // com.facebook.ads.redexgen.core.OG
    public final float A8Q(OF of) {
        return A8j(of) * 2.0f;
    }

    @Override // com.facebook.ads.redexgen.core.OG
    public final float A8j(OF of) {
        return A00(of).A04();
    }

    @Override // com.facebook.ads.redexgen.core.OG
    public final void AA6() {
    }

    @Override // com.facebook.ads.redexgen.core.OG
    public final void AA8(OF of, Context context, ColorStateList colorStateList, float f10, float f11, float f12) {
        OH background = new OH(colorStateList, f10);
        of.AIa(background);
        View view = of.A77();
        view.setClipToOutline(true);
        view.setElevation(f11);
        AIn(of, f12);
    }

    @Override // com.facebook.ads.redexgen.core.OG
    public final void ACm(OF of) {
        AIn(of, A8K(of));
    }

    @Override // com.facebook.ads.redexgen.core.OG
    public final void AEl(OF of) {
        AIn(of, A8K(of));
    }

    @Override // com.facebook.ads.redexgen.core.OG
    public final void AIZ(OF of, ColorStateList colorStateList) {
        A00(of).A08(colorStateList);
    }

    @Override // com.facebook.ads.redexgen.core.OG
    public final void AIf(OF of, float f10) {
        of.A77().setElevation(f10);
    }

    @Override // com.facebook.ads.redexgen.core.OG
    public final void AIn(OF of, float f10) {
        A00(of).A07(f10, of.A9J(), of.A8i());
        A01(of);
    }

    @Override // com.facebook.ads.redexgen.core.OG
    public final void AIz(OF of, float f10) {
        A00(of).A06(f10);
    }
}
