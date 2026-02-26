package com.facebook.ads.redexgen.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.b3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2246b3 extends AnimatorListenerAdapter {
    public final /* synthetic */ JU A00;
    public final /* synthetic */ boolean A01;

    public C2246b3(JU ju, boolean z10) {
        this.A00 = ju;
        this.A01 = z10;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.A00.A0O.setTranslationY(0.0f);
        this.A00.A0W();
        if (!this.A01 && this.A00.A0L != null) {
            this.A00.A0L.destroy();
        }
        if (this.A00.A0m != null) {
            if (!this.A00.A0H.A1a()) {
                this.A00.A0m.setVisibility(this.A01 ? 8 : 0);
            } else {
                this.A00.A0m.setVisibility(8);
            }
        }
    }
}
