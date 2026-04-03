package com.facebook.ads.redexgen.core;

import android.animation.Animator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.e8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2435e8 implements Animator.AnimatorListener {
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ CY A02;

    public C2435e8(CY cy, int i10, int i11) {
        this.A02 = cy;
        this.A01 = i10;
        this.A00 = i11;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.A02.A07(this.A00, this.A01, false);
        if (this.A02.A00 != null) {
            this.A02.A00.removeAllListeners();
            this.A02.A00 = null;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        EnumC2428e1 enumC2428e1;
        CY cy = this.A02;
        if (this.A01 == this.A02.A04) {
            enumC2428e1 = EnumC2428e1.A02;
        } else {
            enumC2428e1 = EnumC2428e1.A04;
        }
        cy.A01 = enumC2428e1;
        if (this.A02.A00 != null) {
            this.A02.A00.removeAllListeners();
            this.A02.A00 = null;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
