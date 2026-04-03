package androidx.compose.animation.core;

import kotlin.jvm.internal.m;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Animatable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatableKt {
    @NotNull
    public static final Animatable<Float, AnimationVector1D> Animatable(float f10, float f11) {
        return new Animatable<>(Float.valueOf(f10), VectorConvertersKt.getVectorConverter(m.f29832a), Float.valueOf(f11));
    }

    public static /* synthetic */ Animatable Animatable$default(float f10, float f11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f11 = 0.01f;
        }
        return Animatable(f10, f11);
    }
}
