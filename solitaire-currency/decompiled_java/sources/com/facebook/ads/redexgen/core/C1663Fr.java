package com.facebook.ads.redexgen.core;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1663Fr extends AbstractRunnableC2074Vt {
    public final /* synthetic */ InterfaceC2337cW A00;
    public final /* synthetic */ C2338cX A01;

    public C1663Fr(C2338cX c2338cX, InterfaceC2337cW interfaceC2337cW) {
        this.A01 = c2338cX;
        this.A00 = interfaceC2337cW;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC2074Vt
    public final void A07() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setAnimationListener(new C1664Fs(this));
        this.A01.startAnimation(alphaAnimation);
    }
}
