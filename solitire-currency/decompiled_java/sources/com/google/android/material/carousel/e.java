package com.google.android.material.carousel;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.carousel.f;

/* JADX INFO: compiled from: CarouselStrategyHelper.java */
/* JADX INFO: loaded from: classes3.dex */
final class e {
    static float a(float f10, float f11, int i10) {
        return f10 + (Math.max(0, i10 - 1) * f11);
    }

    static float b(float f10, float f11, int i10) {
        return i10 > 0 ? f10 + (f11 / 2.0f) : f10;
    }

    static f c(@NonNull Context context, float f10, float f11, @NonNull a aVar) {
        float f12;
        float f13;
        float fMin = Math.min(f(context) + f10, aVar.f9040f);
        float f14 = fMin / 2.0f;
        float f15 = 0.0f - f14;
        float fB = b(0.0f, aVar.f9036b, aVar.f9037c);
        float fJ = j(0.0f, a(fB, aVar.f9036b, (int) Math.floor(aVar.f9037c / 2.0f)), aVar.f9036b, aVar.f9037c);
        float fB2 = b(fJ, aVar.f9039e, aVar.f9038d);
        float fJ2 = j(fJ, a(fB2, aVar.f9039e, (int) Math.floor(aVar.f9038d / 2.0f)), aVar.f9039e, aVar.f9038d);
        float fB3 = b(fJ2, aVar.f9040f, aVar.f9041g);
        float fJ3 = j(fJ2, a(fB3, aVar.f9040f, aVar.f9041g), aVar.f9040f, aVar.f9041g);
        float fB4 = b(fJ3, aVar.f9039e, aVar.f9038d);
        float fB5 = b(j(fJ3, a(fB4, aVar.f9039e, (int) Math.ceil(aVar.f9038d / 2.0f)), aVar.f9039e, aVar.f9038d), aVar.f9036b, aVar.f9037c);
        float f16 = f14 + f11;
        float fB6 = d.b(fMin, aVar.f9040f, f10);
        float fB7 = d.b(aVar.f9036b, aVar.f9040f, f10);
        float fB8 = d.b(aVar.f9039e, aVar.f9040f, f10);
        f.b bVarA = new f.b(aVar.f9040f, f11).a(f15, fB6, fMin);
        if (aVar.f9037c > 0) {
            f12 = f16;
            bVarA.g(fB, fB7, aVar.f9036b, (int) Math.floor(r7 / 2.0f));
        } else {
            f12 = f16;
        }
        if (aVar.f9038d > 0) {
            bVarA.g(fB2, fB8, aVar.f9039e, (int) Math.floor(r4 / 2.0f));
        }
        bVarA.h(fB3, 0.0f, aVar.f9040f, aVar.f9041g, true);
        if (aVar.f9038d > 0) {
            f13 = 2.0f;
            bVarA.g(fB4, fB8, aVar.f9039e, (int) Math.ceil(r4 / 2.0f));
        } else {
            f13 = 2.0f;
        }
        if (aVar.f9037c > 0) {
            bVarA.g(fB5, fB7, aVar.f9036b, (int) Math.ceil(r0 / f13));
        }
        bVarA.a(f12, fB6, fMin);
        return bVarA.i();
    }

    static f d(@NonNull Context context, float f10, float f11, @NonNull a aVar, int i10) {
        return i10 == 1 ? c(context, f10, f11, aVar) : e(context, f10, f11, aVar);
    }

    static f e(@NonNull Context context, float f10, float f11, @NonNull a aVar) {
        float fMin = Math.min(f(context) + f10, aVar.f9040f);
        float f12 = fMin / 2.0f;
        float f13 = 0.0f - f12;
        float fB = b(0.0f, aVar.f9040f, aVar.f9041g);
        float fJ = j(0.0f, a(fB, aVar.f9040f, aVar.f9041g), aVar.f9040f, aVar.f9041g);
        float fB2 = b(fJ, aVar.f9039e, aVar.f9038d);
        float fB3 = b(j(fJ, fB2, aVar.f9039e, aVar.f9038d), aVar.f9036b, aVar.f9037c);
        float f14 = f12 + f11;
        float fB4 = d.b(fMin, aVar.f9040f, f10);
        float fB5 = d.b(aVar.f9036b, aVar.f9040f, f10);
        float fB6 = d.b(aVar.f9039e, aVar.f9040f, f10);
        f.b bVarH = new f.b(aVar.f9040f, f11).a(f13, fB4, fMin).h(fB, 0.0f, aVar.f9040f, aVar.f9041g, true);
        if (aVar.f9038d > 0) {
            bVarH.b(fB2, fB6, aVar.f9039e);
        }
        int i10 = aVar.f9037c;
        if (i10 > 0) {
            bVarH.g(fB3, fB5, aVar.f9036b, i10);
        }
        bVarH.a(f14, fB4, fMin);
        return bVarH.i();
    }

    static float f(@NonNull Context context) {
        return context.getResources().getDimension(e4.d.f24796o);
    }

    static float g(@NonNull Context context) {
        return context.getResources().getDimension(e4.d.f24797p);
    }

    static float h(@NonNull Context context) {
        return context.getResources().getDimension(e4.d.f24798q);
    }

    static int i(int[] iArr) {
        int i10 = Integer.MIN_VALUE;
        for (int i11 : iArr) {
            if (i11 > i10) {
                i10 = i11;
            }
        }
        return i10;
    }

    static float j(float f10, float f11, float f12, int i10) {
        return i10 > 0 ? f11 + (f12 / 2.0f) : f10;
    }
}
