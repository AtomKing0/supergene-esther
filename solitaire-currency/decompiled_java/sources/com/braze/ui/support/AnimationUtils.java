package com.braze.ui.support;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AnimationUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnimationUtils {

    @NotNull
    private static final Interpolator accelerateInterpolator = new AccelerateInterpolator();

    @NotNull
    private static final Interpolator decelerateInterpolator = new DecelerateInterpolator();

    @NotNull
    public static final Animation createVerticalAnimation(float f10, float f11, long j10, boolean z10) {
        return setAnimationParams(new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, f10, 1, f11), j10, z10);
    }

    @NotNull
    public static final Animation setAnimationParams(@NotNull Animation animation, long j10, boolean z10) {
        t.i(animation, "animation");
        animation.setDuration(j10);
        if (z10) {
            animation.setInterpolator(accelerateInterpolator);
        } else {
            animation.setInterpolator(decelerateInterpolator);
        }
        return animation;
    }
}
