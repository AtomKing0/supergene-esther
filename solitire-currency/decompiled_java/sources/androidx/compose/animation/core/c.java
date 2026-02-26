package androidx.compose.animation.core;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FloatAnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c {
    public static float a(FloatAnimationSpec floatAnimationSpec, float f10, float f11, float f12) {
        return floatAnimationSpec.getVelocityFromNanos(floatAnimationSpec.getDurationNanos(f10, f11, f12), f10, f11, f12);
    }

    @NotNull
    public static VectorizedFloatAnimationSpec c(FloatAnimationSpec floatAnimationSpec, @NotNull TwoWayConverter converter) {
        t.i(converter, "converter");
        return new VectorizedFloatAnimationSpec(floatAnimationSpec);
    }
}
