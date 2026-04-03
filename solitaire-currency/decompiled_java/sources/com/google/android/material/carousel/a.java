package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import com.ironsource.v8;

/* JADX INFO: compiled from: Arrangement.java */
/* JADX INFO: loaded from: classes3.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f9035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    float f9036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f9037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f9038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f9039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    float f9040f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f9041g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final float f9042h;

    a(int i10, float f10, float f11, float f12, int i11, float f13, int i12, float f14, int i13, float f15) {
        this.f9035a = i10;
        this.f9036b = MathUtils.clamp(f10, f11, f12);
        this.f9037c = i11;
        this.f9039e = f13;
        this.f9038d = i12;
        this.f9040f = f14;
        this.f9041g = i13;
        d(f15, f11, f12, f14);
        this.f9042h = b(f14);
    }

    private float a(float f10, int i10, float f11, int i11, int i12) {
        if (i10 <= 0) {
            f11 = 0.0f;
        }
        float f12 = i11 / 2.0f;
        return (f10 - ((i10 + f12) * f11)) / (i12 + f12);
    }

    private float b(float f10) {
        if (g()) {
            return Math.abs(f10 - this.f9040f) * this.f9035a;
        }
        return Float.MAX_VALUE;
    }

    static a c(float f10, float f11, float f12, float f13, int[] iArr, float f14, int[] iArr2, float f15, int[] iArr3) {
        a aVar = null;
        int i10 = 1;
        for (int i11 : iArr3) {
            int length = iArr2.length;
            int i12 = 0;
            while (i12 < length) {
                int i13 = iArr2[i12];
                int length2 = iArr.length;
                int i14 = 0;
                while (i14 < length2) {
                    int i15 = i14;
                    int i16 = length2;
                    int i17 = i12;
                    int i18 = length;
                    a aVar2 = new a(i10, f11, f12, f13, iArr[i14], f14, i13, f15, i11, f10);
                    if (aVar == null || aVar2.f9042h < aVar.f9042h) {
                        if (aVar2.f9042h == 0.0f) {
                            return aVar2;
                        }
                        aVar = aVar2;
                    }
                    i10++;
                    i14 = i15 + 1;
                    length2 = i16;
                    i12 = i17;
                    length = i18;
                }
                i12++;
            }
        }
        return aVar;
    }

    private void d(float f10, float f11, float f12, float f13) {
        float f14 = f10 - f();
        int i10 = this.f9037c;
        if (i10 > 0 && f14 > 0.0f) {
            float f15 = this.f9036b;
            this.f9036b = f15 + Math.min(f14 / i10, f12 - f15);
        } else if (i10 > 0 && f14 < 0.0f) {
            float f16 = this.f9036b;
            this.f9036b = f16 + Math.max(f14 / i10, f11 - f16);
        }
        int i11 = this.f9037c;
        float f17 = i11 > 0 ? this.f9036b : 0.0f;
        this.f9036b = f17;
        float fA = a(f10, i11, f17, this.f9038d, this.f9041g);
        this.f9040f = fA;
        float f18 = (this.f9036b + fA) / 2.0f;
        this.f9039e = f18;
        int i12 = this.f9038d;
        if (i12 <= 0 || fA == f13) {
            return;
        }
        float f19 = (f13 - fA) * this.f9041g;
        float fMin = Math.min(Math.abs(f19), f18 * 0.1f * i12);
        if (f19 > 0.0f) {
            this.f9039e -= fMin / this.f9038d;
            this.f9040f += fMin / this.f9041g;
        } else {
            this.f9039e += fMin / this.f9038d;
            this.f9040f -= fMin / this.f9041g;
        }
    }

    private float f() {
        return (this.f9040f * this.f9041g) + (this.f9039e * this.f9038d) + (this.f9036b * this.f9037c);
    }

    private boolean g() {
        int i10 = this.f9041g;
        if (i10 <= 0 || this.f9037c <= 0 || this.f9038d <= 0) {
            return i10 <= 0 || this.f9037c <= 0 || this.f9040f > this.f9036b;
        }
        float f10 = this.f9040f;
        float f11 = this.f9039e;
        return f10 > f11 && f11 > this.f9036b;
    }

    int e() {
        return this.f9037c + this.f9038d + this.f9041g;
    }

    @NonNull
    public String toString() {
        return "Arrangement [priority=" + this.f9035a + ", smallCount=" + this.f9037c + ", smallSize=" + this.f9036b + ", mediumCount=" + this.f9038d + ", mediumSize=" + this.f9039e + ", largeCount=" + this.f9041g + ", largeSize=" + this.f9040f + ", cost=" + this.f9042h + v8.i.f15839e;
    }
}
