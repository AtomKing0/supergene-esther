package androidx.compose.animation.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.l0;
import kotlin.collections.w;
import kotlin.jvm.internal.t;
import n9.i;
import n9.o;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorizedAnimationSpec.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VectorizedAnimationSpecKt {
    private static final int InfiniteIterations = Integer.MAX_VALUE;

    /* JADX INFO: Access modifiers changed from: private */
    public static final long clampPlayTime(VectorizedDurationBasedAnimationSpec<?> vectorizedDurationBasedAnimationSpec, long j10) {
        return o.p(j10 - ((long) vectorizedDurationBasedAnimationSpec.getDelayMillis()), 0L, vectorizedDurationBasedAnimationSpec.getDurationMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <V extends AnimationVector> Animations createSpringAnimations(V v10, float f10, float f11) {
        return v10 != null ? new Animations(v10, f10, f11) { // from class: androidx.compose.animation.core.VectorizedAnimationSpecKt.createSpringAnimations.1

            @NotNull
            private final List<FloatSpringSpec> anims;

            /* JADX WARN: Incorrect types in method signature: (TV;FF)V */
            {
                i iVarU = o.u(0, v10.getSize$animation_core_release());
                ArrayList arrayList = new ArrayList(w.v(iVarU, 10));
                Iterator<Integer> it = iVarU.iterator();
                while (it.hasNext()) {
                    arrayList.add(new FloatSpringSpec(f10, f11, v10.get$animation_core_release(((l0) it).nextInt())));
                }
                this.anims = arrayList;
            }

            @Override // androidx.compose.animation.core.Animations
            @NotNull
            public FloatSpringSpec get(int i10) {
                return this.anims.get(i10);
            }
        } : new Animations(f10, f11) { // from class: androidx.compose.animation.core.VectorizedAnimationSpecKt.createSpringAnimations.2

            @NotNull
            private final FloatSpringSpec anim;

            {
                this.anim = new FloatSpringSpec(f10, f11, 0.0f, 4, null);
            }

            @Override // androidx.compose.animation.core.Animations
            @NotNull
            public FloatSpringSpec get(int i10) {
                return this.anim;
            }
        };
    }

    public static final <V extends AnimationVector> long getDurationMillis(@NotNull VectorizedAnimationSpec<V> vectorizedAnimationSpec, @NotNull V initialValue, @NotNull V targetValue, @NotNull V initialVelocity) {
        t.i(vectorizedAnimationSpec, "<this>");
        t.i(initialValue, "initialValue");
        t.i(targetValue, "targetValue");
        t.i(initialVelocity, "initialVelocity");
        return vectorizedAnimationSpec.getDurationNanos(initialValue, targetValue, initialVelocity) / 1000000;
    }

    @NotNull
    public static final <V extends AnimationVector> V getValueFromMillis(@NotNull VectorizedAnimationSpec<V> vectorizedAnimationSpec, long j10, @NotNull V start, @NotNull V end, @NotNull V startVelocity) {
        t.i(vectorizedAnimationSpec, "<this>");
        t.i(start, "start");
        t.i(end, "end");
        t.i(startVelocity, "startVelocity");
        return (V) vectorizedAnimationSpec.getValueFromNanos(j10 * 1000000, start, end, startVelocity);
    }
}
