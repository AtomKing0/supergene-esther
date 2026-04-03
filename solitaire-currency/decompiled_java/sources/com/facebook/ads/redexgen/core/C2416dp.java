package com.facebook.ads.redexgen.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.media3.exoplayer.ExoPlayer;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2416dp extends AnimatorListenerAdapter {
    public final /* synthetic */ C13482y A00;

    public C2416dp(C13482y c13482y) {
        this.A00 = c13482y;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.A00.A00.A04.postDelayed(new D5(this), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }
}
