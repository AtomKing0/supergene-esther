package com.google.android.material.bottomappbar;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import x4.f;
import x4.m;

/* JADX INFO: compiled from: BottomAppBarTopEdgeTreatment.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends f implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f8856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f8857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f8858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f8859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f8860e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f8861f;

    @Override // x4.f
    public void c(float f10, float f11, float f12, @NonNull m mVar) {
        float f13;
        float f14;
        float f15 = this.f8858c;
        if (f15 == 0.0f) {
            mVar.m(f10, 0.0f);
            return;
        }
        float f16 = ((this.f8857b * 2.0f) + f15) / 2.0f;
        float f17 = f12 * this.f8856a;
        float f18 = f11 + this.f8860e;
        float f19 = (this.f8859d * f12) + ((1.0f - f12) * f16);
        if (f19 / f16 >= 1.0f) {
            mVar.m(f10, 0.0f);
            return;
        }
        float f20 = this.f8861f;
        float f21 = f20 * f12;
        boolean z10 = f20 == -1.0f || Math.abs((f20 * 2.0f) - f15) < 0.1f;
        if (z10) {
            f13 = f19;
            f14 = 0.0f;
        } else {
            f14 = 1.75f;
            f13 = 0.0f;
        }
        float f22 = f16 + f17;
        float f23 = f13 + f17;
        float fSqrt = (float) Math.sqrt((f22 * f22) - (f23 * f23));
        float f24 = f18 - fSqrt;
        float f25 = f18 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f23));
        float f26 = (90.0f - degrees) + f14;
        mVar.m(f24, 0.0f);
        float f27 = f17 * 2.0f;
        mVar.a(f24 - f17, 0.0f, f24 + f17, f27, 270.0f, degrees);
        if (z10) {
            mVar.a(f18 - f16, (-f16) - f13, f18 + f16, f16 - f13, 180.0f - f26, (f26 * 2.0f) - 180.0f);
        } else {
            float f28 = this.f8857b;
            float f29 = f21 * 2.0f;
            float f30 = f18 - f16;
            mVar.a(f30, -(f21 + f28), f30 + f28 + f29, f28 + f21, 180.0f - f26, ((f26 * 2.0f) - 180.0f) / 2.0f);
            float f31 = f18 + f16;
            float f32 = this.f8857b;
            mVar.m(f31 - ((f32 / 2.0f) + f21), f32 + f21);
            float f33 = this.f8857b;
            mVar.a(f31 - (f29 + f33), -(f21 + f33), f31, f33 + f21, 90.0f, f26 - 90.0f);
        }
        mVar.a(f25 - f17, 0.0f, f25 + f17, f27, 270.0f - degrees, degrees);
        mVar.m(f10, 0.0f);
    }

    float d() {
        return this.f8859d;
    }

    public float e() {
        return this.f8861f;
    }

    float f() {
        return this.f8857b;
    }

    float g() {
        return this.f8856a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float h() {
        return this.f8858c;
    }

    void i(@FloatRange(from = 0.0d) float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.f8859d = f10;
    }

    public void j(float f10) {
        this.f8861f = f10;
    }

    void k(float f10) {
        this.f8857b = f10;
    }

    void l(float f10) {
        this.f8856a = f10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void m(float f10) {
        this.f8858c = f10;
    }

    void o(float f10) {
        this.f8860e = f10;
    }
}
