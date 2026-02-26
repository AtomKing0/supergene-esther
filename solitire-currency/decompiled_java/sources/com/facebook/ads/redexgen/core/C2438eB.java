package com.facebook.ads.redexgen.core;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eB, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2438eB implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View A00;
    public final /* synthetic */ CU A01;

    public C2438eB(CU cu, View view) {
        this.A01 = cu;
        this.A00 = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int value = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.A00.setTranslationY(value);
    }
}
