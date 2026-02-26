package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.s;

/* JADX INFO: compiled from: VectorizedAnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class VectorizedKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    public static final int $stable = 8;
    private final int delayMillis;
    private final int durationMillis;

    @NotNull
    private final Map<Integer, s<V, Easing>> keyframes;
    private V valueVector;
    private V velocityVector;

    /* JADX WARN: Multi-variable type inference failed */
    public VectorizedKeyframesSpec(@NotNull Map<Integer, ? extends s<? extends V, ? extends Easing>> keyframes, int i10, int i11) {
        t.i(keyframes, "keyframes");
        this.keyframes = keyframes;
        this.durationMillis = i10;
        this.delayMillis = i11;
    }

    private final void init(V v10) {
        if (this.valueVector == null) {
            this.valueVector = (V) AnimationVectorsKt.newInstance(v10);
            this.velocityVector = (V) AnimationVectorsKt.newInstance(v10);
        }
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDelayMillis() {
        return this.delayMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDurationMillis() {
        return this.durationMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec, androidx.compose.animation.core.VectorizedAnimationSpec
    public /* synthetic */ long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return g.a(this, animationVector, animationVector2, animationVector3);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public /* synthetic */ AnimationVector getEndVelocity(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return f.a(this, animationVector, animationVector2, animationVector3);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    @NotNull
    public V getValueFromNanos(long j10, @NotNull V initialValue, @NotNull V targetValue, @NotNull V initialVelocity) {
        t.i(initialValue, "initialValue");
        t.i(targetValue, "targetValue");
        t.i(initialVelocity, "initialVelocity");
        int iClampPlayTime = (int) VectorizedAnimationSpecKt.clampPlayTime(this, j10 / 1000000);
        if (this.keyframes.containsKey(Integer.valueOf(iClampPlayTime))) {
            return (V) ((s) r0.h(this.keyframes, Integer.valueOf(iClampPlayTime))).c();
        }
        if (iClampPlayTime >= getDurationMillis()) {
            return targetValue;
        }
        if (iClampPlayTime <= 0) {
            return initialValue;
        }
        int durationMillis = getDurationMillis();
        Easing linearEasing = EasingKt.getLinearEasing();
        int i10 = 0;
        V vC = initialValue;
        int i11 = 0;
        for (Map.Entry<Integer, s<V, Easing>> entry : this.keyframes.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            s<V, Easing> value = entry.getValue();
            if (iClampPlayTime > iIntValue && iIntValue >= i11) {
                vC = value.c();
                linearEasing = value.d();
                i11 = iIntValue;
            } else if (iClampPlayTime < iIntValue && iIntValue <= durationMillis) {
                targetValue = value.c();
                durationMillis = iIntValue;
            }
        }
        float fTransform = linearEasing.transform((iClampPlayTime - i11) / (durationMillis - i11));
        init(initialValue);
        int size$animation_core_release = vC.getSize$animation_core_release();
        while (true) {
            V v10 = null;
            if (i10 >= size$animation_core_release) {
                break;
            }
            V v11 = this.valueVector;
            if (v11 == null) {
                t.A("valueVector");
            } else {
                v10 = v11;
            }
            v10.set$animation_core_release(i10, VectorConvertersKt.lerp(vC.get$animation_core_release(i10), targetValue.get$animation_core_release(i10), fTransform));
            i10++;
        }
        V v12 = this.valueVector;
        if (v12 != null) {
            return v12;
        }
        t.A("valueVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    @NotNull
    public V getVelocityFromNanos(long j10, @NotNull V initialValue, @NotNull V targetValue, @NotNull V initialVelocity) {
        t.i(initialValue, "initialValue");
        t.i(targetValue, "targetValue");
        t.i(initialVelocity, "initialVelocity");
        long jClampPlayTime = VectorizedAnimationSpecKt.clampPlayTime(this, j10 / 1000000);
        if (jClampPlayTime <= 0) {
            return initialVelocity;
        }
        AnimationVector valueFromMillis = VectorizedAnimationSpecKt.getValueFromMillis(this, jClampPlayTime - 1, initialValue, targetValue, initialVelocity);
        AnimationVector valueFromMillis2 = VectorizedAnimationSpecKt.getValueFromMillis(this, jClampPlayTime, initialValue, targetValue, initialVelocity);
        init(initialValue);
        int size$animation_core_release = valueFromMillis.getSize$animation_core_release();
        int i10 = 0;
        while (true) {
            V v10 = null;
            if (i10 >= size$animation_core_release) {
                break;
            }
            V v11 = this.velocityVector;
            if (v11 == null) {
                t.A("velocityVector");
            } else {
                v10 = v11;
            }
            v10.set$animation_core_release(i10, (valueFromMillis.get$animation_core_release(i10) - valueFromMillis2.get$animation_core_release(i10)) * 1000.0f);
            i10++;
        }
        V v12 = this.velocityVector;
        if (v12 != null) {
            return v12;
        }
        t.A("velocityVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedFiniteAnimationSpec, androidx.compose.animation.core.VectorizedAnimationSpec
    public /* synthetic */ boolean isInfinite() {
        return h.a(this);
    }

    public /* synthetic */ VectorizedKeyframesSpec(Map map, int i10, int i11, int i12, k kVar) {
        this(map, i10, (i12 & 4) != 0 ? 0 : i11);
    }
}
