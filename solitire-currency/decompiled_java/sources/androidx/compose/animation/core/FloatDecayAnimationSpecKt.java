package androidx.compose.animation.core;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FloatDecayAnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FloatDecayAnimationSpecKt {
    private static final float ExponentialDecayFriction = -4.2f;

    @NotNull
    public static final Animation<Float, AnimationVector1D> createAnimation(@NotNull FloatDecayAnimationSpec floatDecayAnimationSpec, float f10, float f11) {
        t.i(floatDecayAnimationSpec, "<this>");
        return AnimationKt.DecayAnimation(floatDecayAnimationSpec, f10, f11);
    }

    public static /* synthetic */ Animation createAnimation$default(FloatDecayAnimationSpec floatDecayAnimationSpec, float f10, float f11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        return createAnimation(floatDecayAnimationSpec, f10, f11);
    }
}
