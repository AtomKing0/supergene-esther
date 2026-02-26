package com.facebook.ads.redexgen.core;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1583Cp implements InterfaceC2429e2 {
    public TransitionDrawable A00;
    public TransitionDrawable A01;
    public final int A03;
    public final Drawable A04;
    public final Drawable A05;
    public final View A07;
    public final Handler A06 = new Handler();
    public EnumC2428e1 A02 = EnumC2428e1.A04;

    public C1583Cp(View view, int i10, Drawable drawable, Drawable drawable2) {
        this.A03 = i10;
        this.A07 = view;
        this.A05 = drawable;
        this.A04 = drawable2;
        this.A01 = new TransitionDrawable(new Drawable[]{drawable, drawable2});
        this.A01.setCrossFadeEnabled(true);
        this.A00 = new TransitionDrawable(new Drawable[]{drawable2, drawable});
        this.A00.setCrossFadeEnabled(true);
        XP.A0Q(this.A07, this.A01);
    }

    private void A04(boolean z10) {
        this.A06.removeCallbacksAndMessages(null);
        if (z10) {
            this.A02 = EnumC2428e1.A05;
            XP.A0Q(this.A07, this.A00);
            this.A00.startTransition(this.A03);
            this.A06.postDelayed(new C1584Cq(this), this.A03);
            return;
        }
        XP.A0Q(this.A07, this.A05);
        this.A02 = EnumC2428e1.A04;
    }

    private void A05(boolean z10) {
        this.A06.removeCallbacksAndMessages(null);
        if (z10) {
            this.A02 = EnumC2428e1.A03;
            XP.A0Q(this.A07, this.A01);
            this.A01.startTransition(this.A03);
            this.A06.postDelayed(new C1587Ct(this), this.A03);
            return;
        }
        XP.A0Q(this.A07, this.A04);
        this.A02 = EnumC2428e1.A02;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2429e2
    public final void A42(boolean z10, boolean z11) {
        if (z11) {
            A04(z10);
        } else {
            A05(z10);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2429e2
    public final EnumC2428e1 A93() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2429e2
    public final void cancel() {
        EnumC2428e1 enumC2428e1;
        this.A06.removeCallbacksAndMessages(null);
        this.A01.resetTransition();
        this.A00.resetTransition();
        if (this.A02 == EnumC2428e1.A03) {
            enumC2428e1 = EnumC2428e1.A04;
        } else {
            enumC2428e1 = EnumC2428e1.A02;
        }
        this.A02 = enumC2428e1;
    }
}
