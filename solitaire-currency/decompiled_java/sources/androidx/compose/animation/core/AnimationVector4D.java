package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnimationVectors.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class AnimationVector4D extends AnimationVector {
    public static final int $stable = 8;
    private final int size;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    private float f749v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    private float f750v2;

    /* JADX INFO: renamed from: v3, reason: collision with root package name */
    private float f751v3;

    /* JADX INFO: renamed from: v4, reason: collision with root package name */
    private float f752v4;

    public AnimationVector4D(float f10, float f11, float f12, float f13) {
        super(null);
        this.f749v1 = f10;
        this.f750v2 = f11;
        this.f751v3 = f12;
        this.f752v4 = f13;
        this.size = 4;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof AnimationVector4D)) {
            return false;
        }
        AnimationVector4D animationVector4D = (AnimationVector4D) obj;
        if (!(animationVector4D.f749v1 == this.f749v1)) {
            return false;
        }
        if (!(animationVector4D.f750v2 == this.f750v2)) {
            return false;
        }
        if (animationVector4D.f751v3 == this.f751v3) {
            return (animationVector4D.f752v4 > this.f752v4 ? 1 : (animationVector4D.f752v4 == this.f752v4 ? 0 : -1)) == 0;
        }
        return false;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public float get$animation_core_release(int i10) {
        if (i10 == 0) {
            return this.f749v1;
        }
        if (i10 == 1) {
            return this.f750v2;
        }
        if (i10 == 2) {
            return this.f751v3;
        }
        if (i10 != 3) {
            return 0.0f;
        }
        return this.f752v4;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public int getSize$animation_core_release() {
        return this.size;
    }

    public final float getV1() {
        return this.f749v1;
    }

    public final float getV2() {
        return this.f750v2;
    }

    public final float getV3() {
        return this.f751v3;
    }

    public final float getV4() {
        return this.f752v4;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f749v1) * 31) + Float.floatToIntBits(this.f750v2)) * 31) + Float.floatToIntBits(this.f751v3)) * 31) + Float.floatToIntBits(this.f752v4);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void reset$animation_core_release() {
        this.f749v1 = 0.0f;
        this.f750v2 = 0.0f;
        this.f751v3 = 0.0f;
        this.f752v4 = 0.0f;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void set$animation_core_release(int i10, float f10) {
        if (i10 == 0) {
            this.f749v1 = f10;
            return;
        }
        if (i10 == 1) {
            this.f750v2 = f10;
        } else if (i10 == 2) {
            this.f751v3 = f10;
        } else {
            if (i10 != 3) {
                return;
            }
            this.f752v4 = f10;
        }
    }

    public final void setV1$animation_core_release(float f10) {
        this.f749v1 = f10;
    }

    public final void setV2$animation_core_release(float f10) {
        this.f750v2 = f10;
    }

    public final void setV3$animation_core_release(float f10) {
        this.f751v3 = f10;
    }

    public final void setV4$animation_core_release(float f10) {
        this.f752v4 = f10;
    }

    @NotNull
    public String toString() {
        return "AnimationVector4D: v1 = " + this.f749v1 + ", v2 = " + this.f750v2 + ", v3 = " + this.f751v3 + ", v4 = " + this.f752v4;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    @NotNull
    public AnimationVector4D newVector$animation_core_release() {
        return new AnimationVector4D(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
