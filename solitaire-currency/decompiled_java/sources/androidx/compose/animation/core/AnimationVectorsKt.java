package androidx.compose.animation.core;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AnimationVectors.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnimationVectorsKt {
    @NotNull
    public static final AnimationVector1D AnimationVector(float f10) {
        return new AnimationVector1D(f10);
    }

    @NotNull
    public static final <T extends AnimationVector> T copy(@NotNull T t10) {
        t.i(t10, "<this>");
        T t11 = (T) newInstance(t10);
        int size$animation_core_release = t11.getSize$animation_core_release();
        for (int i10 = 0; i10 < size$animation_core_release; i10++) {
            t11.set$animation_core_release(i10, t10.get$animation_core_release(i10));
        }
        return t11;
    }

    public static final <T extends AnimationVector> void copyFrom(@NotNull T t10, @NotNull T source) {
        t.i(t10, "<this>");
        t.i(source, "source");
        int size$animation_core_release = t10.getSize$animation_core_release();
        for (int i10 = 0; i10 < size$animation_core_release; i10++) {
            t10.set$animation_core_release(i10, source.get$animation_core_release(i10));
        }
    }

    @NotNull
    public static final <T extends AnimationVector> T newInstance(@NotNull T t10) {
        t.i(t10, "<this>");
        return (T) t10.newVector$animation_core_release();
    }

    @NotNull
    public static final AnimationVector2D AnimationVector(float f10, float f11) {
        return new AnimationVector2D(f10, f11);
    }

    @NotNull
    public static final AnimationVector3D AnimationVector(float f10, float f11, float f12) {
        return new AnimationVector3D(f10, f11, f12);
    }

    @NotNull
    public static final AnimationVector4D AnimationVector(float f10, float f11, float f12, float f13) {
        return new AnimationVector4D(f10, f11, f12, f13);
    }
}
