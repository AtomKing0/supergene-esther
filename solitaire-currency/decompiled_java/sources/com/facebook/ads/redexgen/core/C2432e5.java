package com.facebook.ads.redexgen.core;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.e5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2432e5 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View A00;
    public final /* synthetic */ C1582Co A01;

    public C2432e5(C1582Co c1582Co, View view) {
        this.A01 = c1582Co;
        this.A00 = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = this.A00.getLayoutParams();
        layoutParams.height = iIntValue;
        this.A00.setLayoutParams(layoutParams);
    }
}
