package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: CarouselStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f9046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f9047b;

    static int[] a(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr2[i10] = iArr[i10] * 2;
        }
        return iArr2;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    static float b(float f10, float f11, float f12) {
        return 1.0f - ((f10 - f12) / (f11 - f12));
    }

    public float c() {
        return this.f9047b;
    }

    public float d() {
        return this.f9046a;
    }

    void e(Context context) {
        float fH = this.f9046a;
        if (fH <= 0.0f) {
            fH = e.h(context);
        }
        this.f9046a = fH;
        float fG = this.f9047b;
        if (fG <= 0.0f) {
            fG = e.g(context);
        }
        this.f9047b = fG;
    }

    boolean f() {
        return true;
    }

    abstract f g(@NonNull b bVar, @NonNull View view);

    abstract boolean h(b bVar, int i10);
}
