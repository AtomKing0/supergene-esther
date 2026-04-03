package com.facebook.ads.redexgen.core;

import android.animation.ValueAnimator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2266bN implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ C1741Is A00;

    public C2266bN(C1741Is c1741Is) {
        this.A00 = c1741Is;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.A00.A0U.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.A00.A0U.requestLayout();
    }
}
