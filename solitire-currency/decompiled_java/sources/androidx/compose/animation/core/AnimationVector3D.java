package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnimationVectors.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class AnimationVector3D extends AnimationVector {
    public static final int $stable = 8;
    private final int size;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    private float f746v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    private float f747v2;

    /* JADX INFO: renamed from: v3, reason: collision with root package name */
    private float f748v3;

    public AnimationVector3D(float f10, float f11, float f12) {
        super(null);
        this.f746v1 = f10;
        this.f747v2 = f11;
        this.f748v3 = f12;
        this.size = 3;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof AnimationVector3D)) {
            return false;
        }
        AnimationVector3D animationVector3D = (AnimationVector3D) obj;
        if (!(animationVector3D.f746v1 == this.f746v1)) {
            return false;
        }
        if (animationVector3D.f747v2 == this.f747v2) {
            return (animationVector3D.f748v3 > this.f748v3 ? 1 : (animationVector3D.f748v3 == this.f748v3 ? 0 : -1)) == 0;
        }
        return false;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public float get$animation_core_release(int i10) {
        if (i10 == 0) {
            return this.f746v1;
        }
        if (i10 == 1) {
            return this.f747v2;
        }
        if (i10 != 2) {
            return 0.0f;
        }
        return this.f748v3;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public int getSize$animation_core_release() {
        return this.size;
    }

    public final float getV1() {
        return this.f746v1;
    }

    public final float getV2() {
        return this.f747v2;
    }

    public final float getV3() {
        return this.f748v3;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.f746v1) * 31) + Float.floatToIntBits(this.f747v2)) * 31) + Float.floatToIntBits(this.f748v3);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void reset$animation_core_release() {
        this.f746v1 = 0.0f;
        this.f747v2 = 0.0f;
        this.f748v3 = 0.0f;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void set$animation_core_release(int i10, float f10) {
        if (i10 == 0) {
            this.f746v1 = f10;
        } else if (i10 == 1) {
            this.f747v2 = f10;
        } else {
            if (i10 != 2) {
                return;
            }
            this.f748v3 = f10;
        }
    }

    public final void setV1$animation_core_release(float f10) {
        this.f746v1 = f10;
    }

    public final void setV2$animation_core_release(float f10) {
        this.f747v2 = f10;
    }

    public final void setV3$animation_core_release(float f10) {
        this.f748v3 = f10;
    }

    @NotNull
    public String toString() {
        return "AnimationVector3D: v1 = " + this.f746v1 + ", v2 = " + this.f747v2 + ", v3 = " + this.f748v3;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    @NotNull
    public AnimationVector3D newVector$animation_core_release() {
        return new AnimationVector3D(0.0f, 0.0f, 0.0f);
    }
}
