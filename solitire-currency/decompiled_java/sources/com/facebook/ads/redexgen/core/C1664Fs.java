package com.facebook.ads.redexgen.core;

import android.view.animation.Animation;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1664Fs extends XO {
    public final /* synthetic */ C1663Fr A00;

    public C1664Fs(C1663Fr c1663Fr) {
        this.A00 = c1663Fr;
    }

    @Override // com.facebook.ads.redexgen.core.XO, android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        XP.A0F(this.A00.A01);
        this.A00.A00.ADh();
    }
}
