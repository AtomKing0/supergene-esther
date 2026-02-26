package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorizedAnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f<V extends AnimationVector> {
    @NotNull
    public static AnimationVector a(VectorizedAnimationSpec vectorizedAnimationSpec, @NotNull AnimationVector initialValue, @NotNull AnimationVector targetValue, @NotNull AnimationVector initialVelocity) {
        t.i(initialValue, "initialValue");
        t.i(targetValue, "targetValue");
        t.i(initialVelocity, "initialVelocity");
        return vectorizedAnimationSpec.getVelocityFromNanos(vectorizedAnimationSpec.getDurationNanos(initialValue, targetValue, initialVelocity), initialValue, targetValue, initialVelocity);
    }
}
