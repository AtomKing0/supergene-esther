package androidx.compose.animation.core;

import androidx.compose.runtime.Immutable;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Easing.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class CubicBezierEasing implements Easing {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f756d;

    public CubicBezierEasing(float f10, float f11, float f12, float f13) {
        this.f753a = f10;
        this.f754b = f11;
        this.f755c = f12;
        this.f756d = f13;
    }

    private final float evaluateCubic(float f10, float f11, float f12) {
        float f13 = 3;
        float f14 = 1 - f12;
        return (f10 * f13 * f14 * f14 * f12) + (f13 * f11 * f14 * f12 * f12) + (f12 * f12 * f12);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof CubicBezierEasing)) {
            return false;
        }
        CubicBezierEasing cubicBezierEasing = (CubicBezierEasing) obj;
        if (!(this.f753a == cubicBezierEasing.f753a)) {
            return false;
        }
        if (!(this.f754b == cubicBezierEasing.f754b)) {
            return false;
        }
        if (this.f755c == cubicBezierEasing.f755c) {
            return (this.f756d > cubicBezierEasing.f756d ? 1 : (this.f756d == cubicBezierEasing.f756d ? 0 : -1)) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f753a) * 31) + Float.floatToIntBits(this.f754b)) * 31) + Float.floatToIntBits(this.f755c)) * 31) + Float.floatToIntBits(this.f756d);
    }

    @Override // androidx.compose.animation.core.Easing
    public float transform(float f10) {
        float f11 = 0.0f;
        if (f10 > 0.0f) {
            float f12 = 1.0f;
            if (f10 < 1.0f) {
                while (true) {
                    float f13 = (f11 + f12) / 2;
                    float fEvaluateCubic = evaluateCubic(this.f753a, this.f755c, f13);
                    if (Math.abs(f10 - fEvaluateCubic) < 0.001f) {
                        return evaluateCubic(this.f754b, this.f756d, f13);
                    }
                    if (fEvaluateCubic < f10) {
                        f11 = f13;
                    } else {
                        f12 = f13;
                    }
                }
            }
        }
        return f10;
    }
}
