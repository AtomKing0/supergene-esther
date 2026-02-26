package androidx.compose.animation.core;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DecayAnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
final class DecayAnimationSpecImpl<T> implements DecayAnimationSpec<T> {

    @NotNull
    private final FloatDecayAnimationSpec floatDecaySpec;

    public DecayAnimationSpecImpl(@NotNull FloatDecayAnimationSpec floatDecaySpec) {
        t.i(floatDecaySpec, "floatDecaySpec");
        this.floatDecaySpec = floatDecaySpec;
    }

    @Override // androidx.compose.animation.core.DecayAnimationSpec
    @NotNull
    public <V extends AnimationVector> VectorizedDecayAnimationSpec<V> vectorize(@NotNull TwoWayConverter<T, V> typeConverter) {
        t.i(typeConverter, "typeConverter");
        return new VectorizedFloatDecaySpec(this.floatDecaySpec);
    }
}
